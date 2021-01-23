import java.io.*;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class FileAndJdbc {
    public static void main(String args[]) throws IOException, SQLException {

        writeToFile();

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static void writeToFile() throws FileNotFoundException, IOException {

        FileInputStream in;
        FileOutputStream out;

        in = new FileInputStream("numbers.txt");
        out = new FileOutputStream("numbers.txt");
        while (true) {
            int num = getRandomNumber(1, 100);
            System.out.println(num);

            out.write(num);
            if (num % 5 == 0) {
                break;
            }

        }
        int num = 0;
        while (true) {
            num = in.read();
            if (num % 5 == 0) {
                break;
            }
        }

        addInDB(String.valueOf(num * 2));

        in.close();
        out.close();
    }

    public static void addInDB(String id) {
        try {
            String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";

            String username = "sMkXvyYxZM";
            String passowrd = "8h9tWhCKws";
            Connection connection = DriverManager.getConnection(url, username, passowrd);


            Statement statement = connection.createStatement();
            String sql = "insert into test values (" + id + ",'Jay Shah')";
          //  String sql2="delete from test where name = 'Jay Shah'";
            statement.executeUpdate(sql);
            connection.close();

        } catch (Exception e) {
            System.out.println("EXCEPTIONNNN: " + e.fillInStackTrace());
        }

    }
}
