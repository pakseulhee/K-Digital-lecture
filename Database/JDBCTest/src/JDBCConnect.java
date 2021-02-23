import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; //select만 리턴타입이 리절트 셋임
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from t_member");
			while(rset.next()) {
				String id = rset.getString("id"); //한 행을 가르킨다.
				String name = rset.getString("name");
				System.out.println("id:"+id+", name: "+name);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(stmt != null) conn.close();
				if(rset != null) conn.close();

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
