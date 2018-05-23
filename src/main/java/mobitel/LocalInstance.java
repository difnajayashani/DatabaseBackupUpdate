package mobitel;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class LocalInstance {


    public static void main(String[] args)  {
        //args= new String[]{"backupStartDate", "backupEndDate"};
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the backup Start Date");
        String startDate=sc.next();
        System.out.println("Enter the backup End Date");
        String endDate=sc.next();
        System.out.println(endDate);

        removeUpdateDatabase(startDate,endDate);

    }

    //can input the backup time period as an argument
    public static void removeUpdateDatabase(String fromDate , String toDate){

        String filename ="backup_" +fromDate+"-"+toDate+".csv";
        try (Connection connection = createConnection()) {

            boolean dataCopy = copyToFile(connection,filename,fromDate,toDate);
            System.out.println(dataCopy);

            if (dataCopy) {
                //delete the record from the database
                int deletedRows=deleteRecord(connection,fromDate,toDate);
                System.out.println(deletedRows);

            } else {
                //no record deletion
                System.out.println("Delete Operation failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Connection createConnection(){
        Connection conn=null;
        //String url="jdbc:mysql://127.0.0.1:3306/esms?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";

        String remoteUrl= "jdbc:mysql://192.168.93.220:3306/enterprisesms_test";

        try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        conn=DriverManager.getConnection(remoteUrl,"difna","difna!123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;

    }


    private static boolean copyToFile(Connection connection,String filename,String fromDate,String toDate) throws IOException, SQLException {


        FileWriter fw = new FileWriter(filename);
        //String date="'2015-08-24' ";

        String query = "select * from test_messages where time_sent <"+toDate +"&& time_sent >="+fromDate;
        //String query = "select * from test_messages where time_sent <= "+date;

        Statement stmt = null;

            stmt = connection.createStatement();

            fw.append("id");fw.append(" |");
            fw.append("alias");fw.append(" |");
            fw.append("customer");fw.append(" |");
            fw.append("message");fw.append(" |");
            fw.append("msgsegment");fw.append(" |");
            fw.append("message_id");fw.append(" |");
            fw.append("recipient");fw.append(" |");
            fw.append("status");fw.append(" |");
            fw.append("time_sent");fw.append(" |");
            fw.append("time_submitted");fw.append(" |");
            fw.append("type");fw.append(" |");
            fw.append("user");fw.append(" |");
            fw.append("esm_class");fw.append(" |");
            fw.append('\n');
            fw.append(" ========================================================================================" +
                    "====================================");fw.append('\n');
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(" |");
                fw.append(rs.getString(2));
                fw.append(" |");
                fw.append(rs.getString(3));
                fw.append(" |");
                fw.append(rs.getString(4));
                fw.append(" |");
                fw.append(rs.getString(5));
                fw.append(" |");
                fw.append(rs.getString(6));
                fw.append(" |");
                fw.append(rs.getString(7));
                fw.append(" |");
                fw.append(rs.getString(8));
                fw.append(" |");
                fw.append(rs.getString(9));
                fw.append(" |");
                fw.append(rs.getString(10));
                fw.append(" |");
                fw.append(rs.getString(11));
                fw.append(" |");
                fw.append(rs.getString(12));
                fw.append(" |");
                fw.append(rs.getString(13));
                fw.append('\n');

            }
        if(fw != null){
            fw.flush();
            fw.close();
            return  true;

        }
        else {
            fw.flush();
            fw.close();
            return false;
        }
    }
    private static int deleteRecord(Connection connection,String fromDate,String toDate) throws SQLException {

        //String query = "delete from test_messages where time_sent <= '2015-07-24'";
        String query = "delete from test_messages where time_sent <= "+toDate + "&& time_sent >="+fromDate;
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        //preparedStmt.setInt(1, 3);

        // execute the preparedstatement
        int rowsDeleted =preparedStmt.executeUpdate();
        if(rowsDeleted >0 ){
            return 1;
        }else {
            return  0;
        }
    }
    public static void createExelFile(){
/*
        HSSFWorkbook hwb=new HSSFWorkbook();
        HSSFSheet sheet =  hwb.createSheet("new sheet");

        HSSFRow rowhead=   sheet.createRow((short)0);
        rowhead.createCell((short) 0).setCellValue("SNo");
        rowhead.createCell((short) 1).setCellValue("Name");
        rowhead.createCell((short) 2).setCellValue("Address");
        rowhead.createCell((short) 3).setCellValue("Contact No");
        rowhead.createCell((short) 4).setCellValue("E-mail");*/
    }



}
