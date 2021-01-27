package org.example;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {

        Configuration c = new Configuration().configure("hibernate.cgf.xml").addAnnotatedClass(Book.class);
        SessionFactory s = c.buildSessionFactory();
        Session session = s.openSession();
        Transaction tx = session.beginTransaction();

        //CREATE 5
        // createBooks(session);

        //READ ALL BOOKS
        // readAll(session);

        //Update a Book
        // updateBookId(session,1,"PHY_HCV","hcv","IRODOV");

        //DELETE a Book
        // deleteBookById(session,3);

       //Count
        // getCount(session);

        tx.commit();
    }



    public static void createBooks(Session session){

        String[] titles = {"PHYSICS", "CHEMISTRY", "BIOLOGY", "MATHS", "COMPUTER"};
        String[] authors = {"HCVerma", "CHEM TEACHER", "BIO TEACHER", "MATH TEACHER", "COMP TEACHER"};
        String[] publication = {"IRODOV", "NCERT", "NCERT", "OXFORD", "ORACLE"};

        for(int i=0;i<5;i++)
        {
            Book book=new Book();
            book.setTitle(titles[i]);
            book.setAuthor(authors[i]);
            book.setPubliction(publication[i]);

            session.save(book);
        }
    }
    public static void readAll(Session session){
        String hql = "from Book";
        Query query = session.createQuery(hql);
        List<Book> bookEntries = query.list();
        if(bookEntries.size()!=0) {
         for(int i=0;i<bookEntries.size();i++) {
             System.out.println(bookEntries.get(i).toString());
                }
            }else {
            System.out.println("No Entries Available");
        }
    }
    public static void updateBookId(Session session,Integer id,String tittle,String author,String publication){

        Book book=new Book();
        book.setId(id);
        book.setTitle(tittle);
        book.setAuthor(author);
        book.setPubliction(publication);

        session.update(book);
    }
    private static void deleteBookById(Session session,Integer id) {
        session.delete(session.get(Book.class,id));
    }
    private static void getCount(Session session) {


    Query query=session.createSQLQuery("select count(*) from Book");
    System.out.println(query.uniqueResult());
    }


}
