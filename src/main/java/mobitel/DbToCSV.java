package mobitel;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbToCSV {

    public static void main(String[] args) {
        String filename ="test.csv";
        try {
            String url="jdbc:mysql://127.0.0.1:3306/esms?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";

            FileWriter fw = new FileWriter(filename);
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection conn=DriverManager.getConnection(
                    "jdbc:mysql://192.168.93.220:3306/enterprisesms_test","difna","difna!123");

           /* Connection conn=DriverManager.getConnection(
                    url,"difna","difna!123");*/

            String query = "select * from alias where id< 10";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            conn.close();
            System.out.println("CSV File is created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}