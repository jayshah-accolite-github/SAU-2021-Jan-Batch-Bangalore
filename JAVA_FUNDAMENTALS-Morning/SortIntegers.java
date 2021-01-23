import java.io.*;
import java.util.*;

public class SortIntegers {

    public static void main(String args[]) throws Exception{

        List<Integer> list= new ArrayList<>(Arrays.asList(1,10,4,77,33,24,6,2,7,9,39));
        System.out.println("Before Sorting :\n"+list.toString());
        Collections.sort(list);
        System.out.println("After Sorting :\n"+list);

    }
}
