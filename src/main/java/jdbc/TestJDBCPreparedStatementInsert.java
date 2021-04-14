package jdbc;

import java.sql.*;
import java.util.Scanner;

    public class TestJDBCPreparedStatementInsert {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner scan=new Scanner(System.in);
            System.out.println("请输入要插入的id、姓名：");

            int id=scan.nextInt();
            String name=scan.next();

            Connection con=null;
            PreparedStatement stmt=null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","111111");
                String sql="insert into user(id,name ) "+"values (?,?)";
                stmt=con.prepareStatement(sql);
                stmt.setInt(1,id);
                stmt.setString(2,name);
                int res=stmt.executeUpdate();
                if(res!=0)
                    System.out.println("插入成功");


                stmt = con.prepareStatement("select * from user");
                ResultSet resultSet = stmt.executeQuery();
//                resultSet.

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                if(con!=null)
                    try {
                        con.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                if(stmt!=null)
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
        }
}
