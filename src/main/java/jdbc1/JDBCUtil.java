package jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    final static String driver = "com.mysql.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8";
    final static String user  = "root";
    final static String password = "111111";

    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    /**获取连接*/
    public static Connection getConnection() throws SQLException  {
        Connection    conn = null;
        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**关闭资源1：closeResourse（conn,st,rs）*/
    public static void closeResourse(Connection conn,Statement st,ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
            }else {
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(st!=null) {
                st.close();
            }else {
                st = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }else {
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**关闭资源2：closeResourse（conn,ps,rs）*/
    public static void closeResourse(Connection conn,PreparedStatement ps,ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
            }else {
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null) {
                ps.close();
            }else {
                ps = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }else {
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
