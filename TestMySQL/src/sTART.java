import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sTART {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rst = null;
		String sql = "";
		try {
//			 String mDatabaseName = "qcVSehiNrxHjtARTkXci";
//			 String mHost = "sqld.duapp.com";
//			 String mPort = "4050";
//			 String mUserName = "T9U36g2FmOnaFStUE3EdVvA4";
//			 String mPassword = "sc8jqzfBgDmQmveGUqlHjPoQqs9zTlHO";
			String mDatabaseName = "test";
			String mHost = "localhost";
			String mPort = "3306";
			String mUserName = "root";
			String mPassword = "";
			String mDriverName = "com.mysql.jdbc.Driver";
			String mDatabaseUrl = "jdbc:mysql://";
			String mServerName = mHost + ":" + mPort + "/";
			String mConnName = mDatabaseUrl + mServerName + mDatabaseName;
			Class.forName(mDriverName);
			System.out.println("开始连接...\r\n" + mConnName);
			conn = DriverManager.getConnection(mConnName, mUserName, mPassword);
			System.out.println("连接完成...");
			stmt = conn.createStatement();
			sql = "Select * From MyTest";
			rst = stmt.executeQuery(sql);

			int mID = 0;
			String mName = "";
			while (rst.next()) {
				mID = rst.getInt("ID");
				mName = rst.getString("FName");
				System.out.println("ID:" + mID + " | Name:" + mName);
			}
			System.out.println("----打印结束----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
