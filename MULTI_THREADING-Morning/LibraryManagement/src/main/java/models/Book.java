package models;

public class Book {

    private String title;
    private String author;
    private int id;
    private String ISBN;
    private Boolean isUnderReview;
    private String Reviewer;
    private Boolean isInsideCart;
    private Boolean isIssued;


    public Book(String title, String author, int id, String ISBN, Boolean isUnderReview, String reviewer, Boolean isInsideCart, Boolean isIssued) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.ISBN = ISBN;
        this.isUnderReview = isUnderReview;
        this.Reviewer = reviewer;
        this.isInsideCart = isInsideCart;
        this.isIssued = isIssued;
    }
    public Book(String title, String author, int id, String ISBN) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.ISBN = ISBN;
        this.isUnderReview = false;
        this.Reviewer = "";
        this.isInsideCart = false;
        this.isIssued = false;
    }

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Boolean getUnderReview() {
        return isUnderReview;
    }

    public void setUnderReview(Boolean underReview) {
        isUnderReview = underReview;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String reviewer) {
        Reviewer = reviewer;
    }

    public Boolean getInsideCart() {
        return isInsideCart;
    }

    public void setInsideCart(Boolean insideCart) {
        isInsideCart = insideCart;
    }

    public Boolean getIssued() {
        return isIssued;
    }

    public void setIssued(Boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", isUnderReview=" + isUnderReview +
                ", Reviewer='" + Reviewer + '\'' +
                ", isInsideCart=" + isInsideCart +
                ", isIssued=" + isIssued +
                '}';
    }
}
