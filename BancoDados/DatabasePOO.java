package BancoDados;

import java.sql.*;

public class DatabasePOO {
    private static Connection connection;

    public static void createConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "root");
            
        } catch (ClassNotFoundException c) {
            throw new RuntimeException(c);
        } catch (SQLException s) {
            throw new RuntimeException(s);
        }
    }

    public static ResultSet querrySelect(String sql) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = statement.executeQuery(sql);
        
        return result;
    }

    public static void querry(String sql) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.executeUpdate(sql);
    }
    
}