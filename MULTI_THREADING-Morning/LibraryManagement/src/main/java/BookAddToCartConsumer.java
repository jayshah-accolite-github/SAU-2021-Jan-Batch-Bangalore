import models.Book;
import models.Student;

import java.util.Timer;

public class BookAddToCartConsumer implements Runnable{
    private BlockingQueueBook blockingQueueBook;
    private Student student;
    private int bookId;

    public BookAddToCartConsumer(BlockingQueueBook blockingQueueBook, Student student, int bookId) {
        this.blockingQueueBook = blockingQueueBook;
        this.student = student;
        this.bookId = bookId;
    }


    @Override
    public void run() {
        try {
            blockingQueueBook.addInCart(student,bookId);
            Timer t = new java.util.Timer();
            t.schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {

                            if(student.containsBookIdInCart(bookId)){
                                Book book=blockingQueueBook.getBookById(bookId);
                                book.setInsideCart(false);
                                book.setUnderReview(false);
                                book.setReviewer("");
                                student.removeFromBooksCart(bookId);
                                System.out.println("After 30 seconds  book is not yet checked out hence removed from cart and made available to others");
                                System.out.println(blockingQueueBook.getBookById(bookId).toString());
                            }

                            t.cancel();
                        }
                    },

                    1000*5
            );
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
