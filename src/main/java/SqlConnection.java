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

    public static String selectSubjectName(){
        Connection c = connect();
        String subName ="";
        try {
            if (c != null) {
                //can't run now because no db need to change to apartment db
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
