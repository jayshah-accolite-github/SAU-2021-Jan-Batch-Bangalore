import models.Book;

import java.util.ArrayList;
import java.util.Random;

public class BookProducer implements Runnable{

    private BlockingQueueBook blockingQueueBook;
    private String[] title;
    private String[] author;
    private int[] id;
    private String[] ISBN;

    public BookProducer(BlockingQueueBook blockingQueueBook, String[] title, String[] author, int[] id, String[] ISBN) {
        this.blockingQueueBook = blockingQueueBook;
        this.title = title;
        this.author = author;
        this.id = id;
        this.ISBN = ISBN;
    }

    @Override
    public void run() {

        for(int i=0;i<title.length;i++){
            try {
                //As the book is being generated the details like reviewer is empty,
                //isInCart , isUnderReview, isIssued are all false
                // which is set in constructor
                Book book = new Book(this.title[i], this.author[i], this.id[i], this.ISBN[i]);
                blockingQueueBook.addBook(book);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
