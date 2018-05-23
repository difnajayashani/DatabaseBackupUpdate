package mobitel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class MysqlCon {

    public static void main(String args[]) throws SQLException, IOException {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Path file = Paths.get("the-file-name.txt");

            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://192.168.93.220:3306/enterprisesms_test","difna","difna!123");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
           // ResultSet rs=stmt.executeQuery("select * from alias");
            ResultSet rs=stmt.executeQuery("LOAD DATA INTO LOCAL OUTFILE 'result.csv' FROM user_test FIELDS TERMINATED BY ', ' LINES TERMINATED BY '\n' ");

            //ResultSet rs=stmt.executeQuery("select * from user_test into outfile 'result.csv' " +
                   // "FIELDS TERMINATED BY ',' " +
                   // "LINES TERMINATED BY '\n' ");

            //while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            con.close();
        }catch(Exception e){
            System.out.println(e);
        }

       // List<String> lines = Arrays.asList("The first line", "The second line");
    }
}
