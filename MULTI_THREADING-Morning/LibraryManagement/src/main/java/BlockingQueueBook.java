import models.Book;
import models.Student;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueBook {

    private Lock lock=new ReentrantLock();
    private Condition addBookCondition=lock.newCondition();
    private Condition checkoutBookCondition=lock.newCondition();
    private static ArrayList<Book> bookQueue=new ArrayList<>();
    private int bkCount=0;

    public BlockingQueueBook() {
    }

    public int getBkCount() {
        return bkCount;
    }

    public void setBkCount(int bkCount) {
        this.bkCount = bkCount;
    }

    public Book getBookById(int bookId){
        for(int i=0;i<bookQueue.size();i++)
        {
            if(bookQueue.get(i).getId()==bookId)
            {
                return bookQueue.get(i);
            }
        }
        return null;
    }
    public void addBook(Book book) throws InterruptedException{
        lock.lock();
        try {
            bookQueue.add(book);
            bkCount++;
            checkoutBookCondition.signalAll();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }finally {
            lock.unlock();
        }
    }

    public void review(Student student, int bookId) throws InterruptedException{
        lock.lock();
        try {
            Book book=getBookById(bookId);
            if(book == null) {
                System.out.println("No Book exists");
                return;
            }
            while(bkCount == 0) {
                addBookCondition.await();
            }
            if(book.getUnderReview())
            {
                System.out.println("Sorry Book Already Under Review by :"+book.getReviewer());
                return;
            }else{
                book.setUnderReview(true);
                book.setReviewer("Name : "+student.getName()+" id :"+student.getId());
                student.addInBooksReview(book);
                System.out.println("Book is now under your review by :"+book.getReviewer());

            }

            addBookCondition.signalAll();

        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally{
            lock.unlock();
        }
    }

    public void addInCart(Student student, int bookId) throws InterruptedException{
        lock.lock();
        try {
            Book book=getBookById(bookId);
            if(book == null) {
                System.out.println("No Book exists");
                return ;
            }
            while(bkCount == 0) {
                addBookCondition.await();
            }
            if(student.containsBookIdInReview(bookId))
            {
             book.setInsideCart(true);
             student.addInBooksCart(book);
             System.out.println("Book has been added to you cart");
            }else{
                System.out.println("Book needs to be added in your review before adding in cart");
            }

            addBookCondition.signalAll();

        } catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally{
            lock.unlock();
        }
    }
    public void checkout(Student student, int bookId) throws InterruptedException{
        lock.lock();
        try {
            Book book=getBookById(bookId);
            if(book == null) {
                System.out.println("No Book exists");
                return ;
            }
            while(bkCount == 0) {
                addBookCondition.await();
            }
            if(student.containsBookIdInCart(bookId))
            {
                book.setIssued(true);
                book.setUnderReview(false);
                book.setInsideCart(false);
                student.removeFromBooksCart(bookId);
                student.addInBooksIssued(book);
                //Removing from queue
                bookQueue.remove(getBookById(bookId));
                System.out.println("Book has been issued by you The Book is now Yours");
            }else{
                System.out.println("Book needs to be added in your cart before Checking out");
            }
            addBookCondition.signalAll();

        } catch(Exception e){
            System.out.println(e.fillInStackTrace());
        }finally{
            lock.unlock();
        }
    }
    public void listBooks(){

        for(int i=0;i<this.bookQueue.size();i++)
        {
            System.out.println(this.bookQueue.get(i).toString());
        }
    }


}
