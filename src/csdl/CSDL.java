package csdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSDL {
    private static final String DATABASE_NAME = "QLNhaHang";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=" + DATABASE_NAME + ";encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Tải driver của SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("Connect success!");
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connect failure!");
//            System.out.println(ex.getMessage());
            ex.printStackTrace(); 
        }
        return conn;
    }
}