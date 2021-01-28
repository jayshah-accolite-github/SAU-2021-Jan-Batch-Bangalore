import models.Book;

import java.util.ArrayList;

public class BooksDb {
    ArrayList<Book> books=new ArrayList<>();

    public BooksDb() {
        this.books.add(new Book("Phy","HCVerma","asdfghjklv"));
        this.books.add(new Book("Chem","Selena", "bsdfghjklv"));
        this.books.add(new Book("Bio","Rita", "csdfghjklv"));
        this.books.add(new Book("Math","Aryabhtatta", "dsdfghjklv"));
        this.books.add(new Book("CS","Oracle", "esdfghjklv"));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
