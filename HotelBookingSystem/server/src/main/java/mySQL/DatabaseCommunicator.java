package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类用于实现和数据库的connection，理论上是唯一能够理解sql语句的类
 * @author fraliphsoft
 * @version fraliphsoft 11/28
 */
public class DatabaseCommunicator {
	private static final String driver = "com.mysql.jdbc.Driver";
	
	private static final String url = "jdbc:MySQL://localhost/HotelBookingSystemDataBase?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "123";
	
	private static Connection connection;
	
	public static void databaseInit() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
		} catch (Exception ex) {
			// ? I don't know and don't care and don't have to care how to deal relative Exception......
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnectionInstance() {
		return connection;
	}
	
	public static ResultSet execute(PreparedStatement command) {
		try {
			return command.executeQuery();
		} catch (Exception ex) {
			System.out.println("Statement excute error!!!");
			ex.printStackTrace();
		}
		return null;
	}
}
