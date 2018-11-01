import java.sql.*;
import java.util.ArrayList;

public class SqlConnection {
    private static Connection connect() {
        //check connection is null
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:Apartment.db";
            connection = DriverManager.getConnection(dbURL);
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


    public static void createAllTable(){
        createApartmentTable();
        createDebtTable();
        createReservationTable();
        createRoomTable();
        createTypeRoomTable();


    }

    public static void createApartmentTable(){
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

                    c.close();
                    System.out.println("create Apartment table");
                }
            }
        } catch (SQLException e) {

            System.out.println(e);
        }

    }
    public static void createDebtTable(){
        Connection c = connect();

        try {
            if (!checkTableExist(c,"Debt")) {
                if (c != null) {
                    String query = "CREATE TABLE `Debt` (\n" +
                            "\t`id_debt`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`id_reserve`\tINTEGER,\n" +
                            "\t`date_pay_debt`\tTEXT,\n" +
                            "\t`debt_balance`\tNUMERIC,\n" +
                            "\t`status`\tTEXT\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                    System.out.println("create Debt table");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void createReservationTable(){
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
                    System.out.println("create Reservation table");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void createRoomTable(){
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
                            "\tFOREIGN KEY(`id_type_room`) REFERENCES `Room`\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                    System.out.println("create Room table");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void createTypeRoomTable(){
        Connection c = connect();

        try {
            if (!checkTableExist(c,"TypeRoom")) {
                if (c != null) {
                    String query = "CREATE TABLE `TypeRoom` (\n" +
                            "\t`id_type_room`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                            "\t`type_room`\tTEXT,\n" +
                            "\t`rent_per_month`\tNUMERIC,\n" +
                            "\t`rent_per_day`\tNUMERIC,\n" +
                            "\t`status`\tTEXT,\n" +
                            "\tFOREIGN KEY(`id_type_room`) REFERENCES `Room`\n" +
                            ");";
                    Statement s = c.createStatement();
                    s.execute(query);

                    c.close();
                    System.out.println("create TypeRoom table");
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }


    public static String selectSubjectName(){
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
