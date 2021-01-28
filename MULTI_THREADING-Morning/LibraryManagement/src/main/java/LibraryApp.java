import models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LibraryApp {


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        BlockingQueueBook blockingQueueBook =new BlockingQueueBook();


        //Making Students for testing
        generateStudents(students);

        //Producing first 6 Books
        produceFirst6Books(blockingQueueBook);

        //Student id 1 tries to place book id 1 in his review
        new Thread(new BookReviewConsumer(blockingQueueBook, getStudentbyId(students,1), 1)).run();

        //Student id 2 tries to place same book id 1 in his review but fails
        // No two student can review same book
        System.out.println();
        new Thread(new BookReviewConsumer(blockingQueueBook,getStudentbyId(students,2),1)).run();

        //Student id 2 tries to place  book id 2 in his review and succeeds as no one is reviewing it
        // No two student can review other books which arent yet in review
        System.out.println();
        new Thread(new BookReviewConsumer(blockingQueueBook,getStudentbyId(students,2),2)).run();


        System.out.println("\nBooks Status\n");
        blockingQueueBook.listBooks();

        //Assuming Book needs to be in review to be added into the cart
        //and Book needs to be in cart to be checkout

        //Student 1 tries to add book id 3 to cart without adding it in review
        // hence fails
        new Thread(new BookAddToCartConsumer(blockingQueueBook,getStudentbyId(students,1),3)).run();
        System.out.println();

        //Student 1 tries to add book id 1 to cart which is already in his review
        // hence succeeds
        new Thread(new BookAddToCartConsumer(blockingQueueBook,getStudentbyId(students,1),1)).run();
        System.out.println();


        //Cart of student 1 which has book id 1 in
        System.out.println( getStudentbyId(students,1).getBooksInsideMyCart().toString());
        System.out.println();

        //Student 1 checksOut book id 1 which is in his card
        new Thread(new BookCheckoutConsumer(blockingQueueBook,getStudentbyId(students,1),1)).run();
        System.out.println( getStudentbyId(students,1).getBooksIssued().toString());
        System.out.println();
        //after issuing or buying the book it is removed from the queue and is present in the
        // students issued books list


        System.out.println("\nBooks Status\n");
        blockingQueueBook.listBooks();
        System.out.println();


        //Student id 2 adds book id 2 in cart which was already under his review
        new Thread(new BookAddToCartConsumer(blockingQueueBook,getStudentbyId(students,2),2)).run();
        System.out.println();

        //But doesnot check the book out that is does not issue the book
        //So after 5 minutes book is agin availabe for everyone to review and adding in cart

        // for illustration purposes the timer is of only 30 seconds

        //See the console for a message stating it has been removed from the cart


        //Adding new books meanwhile
        produceNew6Books(blockingQueueBook);
        System.out.println();







    }

    private static void produceFirst6Books(BlockingQueueBook blockingQueueBook) {
        String[] titles = {"Title1","Title2","Title3","Title1","Title2","Title4"};
        String[] authors = {"Author1","Author2","Author3","Author1","Author2","Author4"};
        int[] ids = 	{ 1 , 2 , 3 , 4 , 5 , 6};
        String[] isbns={"ISBN1","ISBN2","ISBN3","ISBN1","ISBN2","ISBN4"};

        new Thread(new BookProducer(blockingQueueBook,titles,authors,ids,isbns))
                .run();
        System.out.println("Count of Books in library........"+blockingQueueBook.getBkCount());
        System.out.println("Details of Books in library..........................");
        blockingQueueBook.listBooks();
        System.out.println();
    }
    private static void produceNew6Books(BlockingQueueBook blockingQueueBook) {
        String[] titles = {"Title5","Title6","Title7","Title6","Title8","Title8"};
        String[] authors = {"Author5","Author6","Author7","Author6","Author8","Author8"};
        int[] ids = 	{ 7 , 8 , 9 , 10 , 11 , 12};
        String[] isbns={"ISBN5","ISBN6","ISBN7","ISBN6","ISBN8","ISBN8"};

        new Thread(new BookProducer(blockingQueueBook,titles,authors,ids,isbns))
                .run();
        System.out.println("Count of Books in library........"+blockingQueueBook.getBkCount());
        System.out.println("Details of Books in library..........................");
        blockingQueueBook.listBooks();
    }

    public static void generateStudents(List<Student> students) {
        String[] name = {"Jay1","Jay2","Jay3","Jay4","Jay5","Jay6"};
        int[] id = 		{ 1 , 2 , 3 , 4 , 5 , 6 };
        for(int i=0;i<name.length;i++) {
            Student student=new Student();
            student.setName(name[i]);
            student.setId(id[i]);
            students.add(student);
        }
        System.out.println("Students generated");

    }
    public static Student getStudentbyId(List<Student> studentList,int id){

        for(int i=0;i<studentList.size();i++)
        {
            if(studentList.get(i).getId()==id)
            {
                return studentList.get(i);
            }
        }

        return null;
    }


}
