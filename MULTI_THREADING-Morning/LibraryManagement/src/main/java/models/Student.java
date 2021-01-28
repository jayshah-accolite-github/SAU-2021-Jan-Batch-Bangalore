package models;

import java.util.ArrayList;

public class Student {

    private String name;
    private int id;
    private ArrayList<Book> booksIssued=new ArrayList<>();
    private ArrayList<Book> booksInsideMyCart=new ArrayList<>();
    private ArrayList<Book> booksUnderMyReview=new ArrayList<>();

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(ArrayList<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }



    public void setBooksUnderMyReview(ArrayList<Book> booksUnderMyReview) {

        this.booksUnderMyReview = booksUnderMyReview;
    }

    public ArrayList<Book> getBooksInsideMyCart() {
        return booksInsideMyCart;
    }

    public void setBooksInsideMyCart(ArrayList<Book> booksInsideMyCart) {
        this.booksInsideMyCart = booksInsideMyCart;
    }

    public ArrayList<Book> getBooksUnderMyReview() {
        return booksUnderMyReview;
    }

    public void addInBooksIssued(Book book){

        this.booksIssued.add(book);
    }
    public void addInBooksCart(Book book){

        this.booksInsideMyCart.add(book);
    }
    public void removeFromBooksCart(int id){

        for(int i=0;i<booksInsideMyCart.size();i++)
        {
            if(booksInsideMyCart.get(i).getId()==id){
                booksInsideMyCart.remove(i);
                break;
            }
        }

    }
    public void addInBooksReview(Book book){
        this.booksUnderMyReview.add(book);
    }

    public boolean containsBookIdInReview(int id)
    {
        for(int i=0;i<booksUnderMyReview.size();i++)
        {
            if(booksUnderMyReview.get(i).getId()==id)
            {
                return true;
            }
        }
        return false;
    }
    public boolean containsBookIdInCart(int id)
    {
        for(int i=0;i<booksInsideMyCart.size();i++)
        {
            if(booksInsideMyCart.get(i).getId()==id)
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", booksIssued=" + booksIssued +
                ", booksInsideMyCart=" + booksInsideMyCart +
                ", booksUnderMyReview=" + booksUnderMyReview +
                '}';
    }
}
