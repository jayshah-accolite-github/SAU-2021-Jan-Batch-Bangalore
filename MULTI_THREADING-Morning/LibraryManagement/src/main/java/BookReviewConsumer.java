import models.Book;
import models.Student;

public class BookReviewConsumer implements Runnable {
    private BlockingQueueBook blockingQueueBook;
    private Student student;
    private int bookId;

    public BookReviewConsumer(BlockingQueueBook blockingQueueBook, Student student, int bookId) {
        this.blockingQueueBook = blockingQueueBook;
        this.student = student;
        this.bookId = bookId;
    }


    @Override
    public void run() {
        try {
            blockingQueueBook.review(student,bookId);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
