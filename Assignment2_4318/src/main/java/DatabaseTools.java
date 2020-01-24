import java.sql.*;
import java.util.ArrayList;

public class DatabaseTools {

    //insert statement
    public static void insert(String fn, String ln, String un, String pw){

        Connection myCon = DatabaseTools.getConnected();
        PreparedStatement ps = null;

        try {
            String queryInsert = "INSERT INTO tbl_accounts(fnuser, lnuser, unuser, pwuser) VALUES(?,?,?,?)";
            ps = myCon.prepareStatement(queryInsert);
            ps.setString(1, fn);
            ps.setString(2,ln);
            ps.setString(3,un);
            ps.setString(4,pw);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseTools.closePreparedStatements(ps);
            DatabaseTools.closeConnection(myCon);
        }

    }

    //Update Statement
    public static void update(Integer id, String fn, String ln, String un, String pw){
        Connection myCon = DatabaseTools.getConnected();
        PreparedStatement updatePS = null;

        //May need to take the ID field out, but still allow it to accept the id field
        try {
            String updateQuery = "UPDATE tbl_accounts SET fnuser = ?, lnuser = ?, unuser = ?, pwuser = ? WHERE iduser = ?";
            updatePS = myCon.prepareStatement(updateQuery);
            updatePS.setString(1, fn);
            updatePS.setString(2,ln);
            updatePS.setString(3,un);
            updatePS.setString(4,pw);
            updatePS.setInt(5, id);
            updatePS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseTools.closePreparedStatements(updatePS);
            DatabaseTools.closeConnection(myCon);
        }
    }

    //Delete statement
    public static void delete(Integer id){
        Connection myCon = DatabaseTools.getConnected();
        PreparedStatement deletePS = null;

        try {
            String deleteQuery = "DELETE FROM tbl_accounts WHERE iduser = ?";
            deletePS = myCon.prepareStatement(deleteQuery);
            deletePS.setInt(1, id);
            deletePS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DatabaseTools.closePreparedStatements(deletePS);
            DatabaseTools.closeConnection(myCon);
        }

    }
    //Select statement for all users
    public static ArrayList<User> selectAllUsers() {
        Connection myCon = DatabaseTools.getConnected();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<User> myUserList = new ArrayList<User>();
        String selectQuery = "SELECT iduser, fnuser, lnuser, unuser, pwuser FROM tbl_accounts";

        try {
            ps = myCon.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                User aUser = new User();
                aUser.setUser_id(rs.getInt("iduser"));
                aUser.setUser_fn(rs.getString("fnuser"));
                aUser.setUser_ln(rs.getString("lnuser"));
                aUser.setUser_un(rs.getString("unuser"));
                aUser.setUser_pw(rs.getString("pwuser"));

                myUserList.add(aUser);
            }
            rs.close();
            return myUserList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DatabaseTools.closeResultSet(rs);
            DatabaseTools.closePStatements(ps);
            DatabaseTools.closeConnection(myCon);
        }

    }

    private static void closePreparedStatements(PreparedStatement ps) {
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeConnection(Connection myCon) {
        if(myCon != null){
            try {
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void closePStatements(Statement ps) {

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //connection
    public static Connection getConnected(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/useraccounts?useSSL=false";
            String userName = "root";
            String password = "mysql";
            connection = DriverManager.getConnection(dbURL, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return connection;
    }

}
