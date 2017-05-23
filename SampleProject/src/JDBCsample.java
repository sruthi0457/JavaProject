import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCsample {
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost/test";
	static final String USER="SRUTHI";
	static final String PASS="password";
		public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to selected database");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected");
			System.out.println("Execute Query");
			stmt=conn.createStatement();
			String sql="CREATE TABLE IF NOT EXISTS REGISTRATION"+
			            "(id INTEGER not NULL," +
					    "first VARCHAR(255)," +
			            "last VARCHAR(255)," +
					    "age INTEGER," +
			            "PRIMARY KEY(id))";
			stmt.executeUpdate(sql);
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
				
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	 System.out.println("Bye");
		}

		}




