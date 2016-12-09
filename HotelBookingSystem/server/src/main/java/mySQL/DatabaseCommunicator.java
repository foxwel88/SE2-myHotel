package mySQL;

import java.sql.*;

/**
 * 这个类用于实现和数据库的connection，理论上是唯一能够理解sql语句的类
 * @author fraliphsoft
 * @version fraliphsoft 11/28
 */
public class DatabaseCommunicator {
	private static final String driver = "com.mysql.jdbc.Driver";
	
	private static final String URL = "jdbc:MySQL://localhost/HotelBookingSystemDataBase?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";

	private static final String TEST_DATABASE_URL = "jdbc:MySQL://localhost/HotelBookingSystemForTest?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "1234";
	
	private static Connection connection;
	
	public static void databaseInit() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			// ? I don't know and don't care and don't have to care how to deal relative Exception......
			ex.printStackTrace();
		}
	}
	
	/**
	 * 切换至测试用的connection，在测试类启动时可以调用此方法
	 */
	public static void setTestConnection() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(TEST_DATABASE_URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			// ? I don't know and don't care and don't have to care how to deal relative Exception......
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnectionInstance() {
		return connection;
	}
	
	public static ResultSet executeQuery(PreparedStatement command) {
		try {
			return command.executeQuery();
		} catch (SQLException ex) {
			System.out.println("Statement execute error!!!");
			ex.printStackTrace();
		}
		return null;
	}

	public static boolean execute(PreparedStatement command) {
		try {
			return command.execute();
		} catch (SQLException ex) {
			System.out.println("Statement execute error!!!");
			ex.printStackTrace();
			return false;
		}
	}
	
	public static String getStorableQuote(String rawS) {
		char tempChar = 7;
		String specialString = String.valueOf(tempChar);
		String storableString = rawS.replaceAll("'", specialString);
		return storableString;
	}
	
	public static String getReadableQuete(String rawS) {
		char tempChar = 7;
		String specialString = String.valueOf(tempChar);
		String readableString = rawS.replaceAll(specialString, "'");
		return readableString;
	}
}
