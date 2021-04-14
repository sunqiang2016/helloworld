package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class Test {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "111111");
            String sql = "select * from user";
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery();
//            rs.next();
            //rs.deleteRow();
//			rs.last();
//			System.out.println(rs.getRow());
//			rs.beforeFirst();
			while(rs.next()){
				System.out.println(rs.getInt("id")+"::"+rs.getString("name")+"---"+rs.getByte(1));
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("列数："+rsmd.getColumnCount());
            System.out.println("列名："+rsmd.getColumnName(1)+"----"+rsmd.getColumnType(1)+"----"+rsmd.getColumnTypeName(1));
            System.out.println("列名："+rsmd.getColumnName(2)+"----"+rsmd.getColumnType(2)+"----"+rsmd.getColumnTypeName(2));



        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
