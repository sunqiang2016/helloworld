package jdbc1;


import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//jdbc插入数据
public class JDBCInsertData {
    @Test
    public void insertData() {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = "insert into user values(?,?)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, 01);
            pst.setString(2, "hjh");
            int i  = pst.executeUpdate();
            System.out.println("插入数据成功,影响了"+i+"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
//            JDBCUtil.closeResourse(conn, pst);
        }
    }
}