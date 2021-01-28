import models.Book;
import models.Student;

public class BookCheckoutConsumer implements Runnable{
    private BlockingQueueBook blockingQueueBook;
    private Student student;
    private int bookId;

    public BookCheckoutConsumer(BlockingQueueBook blockingQueueBook, Student student, int bookId) {
        this.blockingQueueBook = blockingQueueBook;
        this.student = student;
        this.bookId = bookId;
    }


    @Override
    public void run() {
        try {


            blockingQueueBook.checkout(student,bookId);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
