import java.io.*;
import java.util.*;

public class ArithmeticExceptionHandling {

    public static void main(String args[]) {

        try{
            System.out.println("Quotient is :"+division(5,0));
        }catch(ArithmeticException e){
            System.out.println("Exception :"+e);
        }

        drinkingAge(22);

    }
    public static int  division(int dividend,int divisor) throws ArithmeticException{
        int quotient=(dividend/divisor);
        return quotient;
    }
    public static void drinkingAge(int age){
        if(age<25)
        {
            throw new ArithmeticException("Exception : Not Valid drinking age should be less than 25");
        }else{
            System.out.println("Enjoy your drinks");
        }
    }

}
