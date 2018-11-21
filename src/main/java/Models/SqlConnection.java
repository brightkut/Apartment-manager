package Models;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
//hi
public class SqlConnection {

    private static SqlConnection sqlConnection =null;




    public static SqlConnection getSqlConnection() {
        if (sqlConnection ==null){
            sqlConnection = new SqlConnection();
        }

        return sqlConnection;
    }

    private static Connection connect() {
        Connection connection =null;

        try {
            if (connection ==null) {
                Class.forName("org.sqlite.JDBC");
                String dbURL = "jdbc:sqlite:Apartment.db";
                connection = DriverManager.getConnection(dbURL);
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return connection;
    }



    public static boolean checkTableExist(Connection conn, String tableName) throws SQLException {
        boolean tExists = false;
        try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (tName != null && tName.equals(tableName)) {
                    tExists = true;
                    break;
                }
            }
        }
        return tExists;
    }


    public  void createAllTable(){
        createApartmentTable();
        createDebtTable();
        createReservationTable();
        createRoomTable();
        createTypeRoomTable();


    }

    public  void createApartmentTable(){
        Connection c = connect();

        try {
            if (!checkTableExist(c,"Apartment")) {
                if (c != null) {
                    String query = "CREATE TABLE `Apartment` (\n" +
                            "\t`id_apartment`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`name_apartment`\tTEXT,\n" +
                            "\t`date_pay_money`\tTEXT,\n" +
                            "\t`status`\tTEXT\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);
                    s.close();


                 //   System.out.println("create Apartment table");
                    String query2 = "Insert into Apartment(name_apartment,date_pay_money,status) values(?,?,?) ";
                    PreparedStatement test = c.prepareStatement(query2);
                    test.setString(1,"default_name");
                    test.setString(2,"1");
                    test.setString(3,"active");
                    test.executeUpdate();
                    test.close();
                    c.close();

                }
            }
        } catch (SQLException e) {

          //  System.out.println(e);
        }

    }
    public  void createDebtTable(){
        Connection c = connect();
        try {
            if (!checkTableExist(c,"Debt")) {
                if (c != null) {
                    String query = "CREATE TABLE `Debt` (\n" +
                            "\t`id_debt`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`id_reserve`\tINTEGER,\n" +
                            "\t`date_pay_debt`\tTEXT,\n" +
                            "\t`debt_balance`\tNUMERIC,\n" +
                            "\t`status`\tTEXT,\n" +
                            "\tFOREIGN KEY(`id_reserve`) REFERENCES `Reservation`(`id_reserve`)\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                  //  System.out.println("create Debt table");
                }
            }
        } catch (SQLException e) {
          //  System.out.println(e);
        }

    }
    public  void createReservationTable(){
        Connection c = connect();

        try {
            if (!checkTableExist(c,"Reservation")) {
                if (c != null) {
                    String query = "CREATE TABLE `Reservation` (\n" +
                            "\t`id_reserve`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`date_check_in`\tTEXT,\n" +
                            "\t`date_check_out`\tTEXT,\n" +
                            "\t`id_room`\tINTEGER,\n" +
                            "\t`type_reserve`\tTEXT,\n" +
                            "\t`name_guest`\tTEXT,\n" +
                            "\t`phone_number`\tTEXT,\n" +
                            "\t`status`\tTEXT,\n" +
                            "\tFOREIGN KEY(`id_room`) REFERENCES `Room`\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                   // System.out.println("create Reservation table");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public  void createRoomTable(){
        Connection c = connect();
        try {
            if (!checkTableExist(c,"Room")) {
                if (c != null) {
                    String query = "CREATE TABLE `Room` (\n" +
                            "\t`id_room`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`room_name`\tTEXT,\n" +
                            "\t`id_type_room`\tINTEGER,\n" +
                            "\t`floor`\tINTEGER,\n" +
                            "\t`status`\tTEXT,\n" +
                            "\tFOREIGN KEY(`id_type_room`) REFERENCES `TypeRoom`\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                  //  System.out.println("create Room table");
                }
            }
        } catch (SQLException e) {
           // System.out.println(e);
        }

    }
    public  void createTypeRoomTable(){
        Connection c = connect();
        try {
            if (!checkTableExist(c,"TypeRoom")) {
                if (c != null) {
                    String query = "CREATE TABLE `TypeRoom` (\n" +
                            "\t`id_type_room`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`type_room`\tTEXT,\n" +
                            "\t`rent_per_month`\tNUMERIC,\n" +
                            "\t`rent_per_day`\tNUMERIC,\n" +
                            "\t`status`\tTEXT\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                   // System.out.println("create TypeRoom table");
                }
            }
        } catch (SQLException e) {
          //  System.out.println(e);
        }

    }
    public  String selectNameOfApartment(){
        Connection c = connect();
        String nameApartment ="";
        try {
            System.out.println("aa");
            if (c != null) {
                String query = "Select name_apartment from Apartment where status = 'active' ";
                Statement s = c.createStatement();

                ResultSet rs = s.executeQuery(query);
                nameApartment = rs.getString(1);
                c.close();
            }
        }catch (SQLException e){
           // System.out.println("eerrrrr");
            System.out.println(e);
        }
        return nameApartment;
    }

    public  String selectDatePayMoney(){
        Connection c = connect();
        String datePayMoney ="";
        try {
            if (c != null) {
                String query = "Select date_pay_money from Apartment where status = 'active'";
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                datePayMoney = rs.getString(1);
                c.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return datePayMoney;

    }

    public  void updateApartmentNameAndDatePayMoney(String nameApart , String datePay){
        Connection c = connect();

        try {
            if (c != null) {
                String query = "Update Apartment Set status = ? Where status = ?";

                PreparedStatement ps = c.prepareStatement(query);
                ps.setString(1,"unactive");
                ps.setString(2,"active");
                ps.executeUpdate();
                ps.close();


                String query2 = "Insert into Apartment(name_apartment,date_pay_money,status) values(?,?,?) ";
                PreparedStatement s = c.prepareStatement(query2);
                s.setString(1,nameApart);
                s.setString(2,datePay);
                s.setString(3,"active");
                s.executeUpdate();
                s.close();


                c.close();



            }
        }catch (SQLException e){
            System.out.println(e);
        }

    }




    public String selectSubjectName(){
        Connection c = connect();
        String subName ="";
        try {
            if (c != null) {
                String query = "Select subjectName from Course";
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                subName = rs.getString(1);
                c.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return subName;
    }

    public ArrayList<Reservation> selectRoomThatReservationInRange(LocalDate date_in,LocalDate date_out){

        Connection c = connect();
        ArrayList<Reservation> r = new ArrayList<>();
        try {
            if (c != null) {
                String query = "Select * from Reservation where status = 'active'";
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                while (rs.next()){

                    String date_check_in_of_database = rs.getString(2);
                    String date_check_out_of_database = rs.getString(3);
                    //convert string in database to local date because in database we keep type date in string
                    LocalDate ld1 = LocalDate.parse(date_check_in_of_database);
                    LocalDate ld2 = LocalDate.parse(date_check_out_of_database);
                    if (ld1.compareTo(date_in)>=0&&ld2.compareTo(date_out)<=0){
                        r.add(new Reservation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));

                    }
                }
                c.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return r;



    }






/*
    public static ArrayList<Course> selectRow(){
        Connection c = connect();
        ArrayList<Course> h = new ArrayList<>();
        try {
            if (c != null) {
                String query = "Select * from Course";
                Statement s = c.createStatement();
                ResultSet rs = s.executeQuery(query);
                while (rs.next()){
                    h.add(new Course(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
                }
                c.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return h;

    }
    */














}
