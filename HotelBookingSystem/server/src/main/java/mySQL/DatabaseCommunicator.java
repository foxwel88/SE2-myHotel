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
		}
	}
	
	public static Connection getConnectionInstance() {
		return connection;
	}
	
	public static ResultSet excute(PreparedStatement command) {
		try {
			ResultSet result = command.executeQuery();
			return result;
		} catch (Exception ex) {
			System.out.println("Statement excute error!!!");
		}
		return null;
	}
	
//	/*
//	 * 我过会还要把下面的东西抄到promotiondata里，所以过一阵子再删。。。
//	 */
//	
//	/**
//	 * 此方法获得Level表的LevelNum属性字段
//	 * @return Integer List
//	 */
//	public List<Integer> getLevel_LevelNum() {
//		ArrayList<Integer> levelNumList = new ArrayList<>();
//		try {
//			preparedStatement = connection.prepareStatement("select LevelNum from Level");
//			ResultSet levelNumSet = preparedStatement.executeQuery();
//			while (levelNumSet.next()) {
//				levelNumList.add(levelNumSet.getInt(1));
//			}
//			preparedStatement.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return levelNumList;
//	}
//	
//	/*
//	 * 下面的方法能够分别获得所有数据库表的所有列
//	 */
//	
//	/**
//	 * 此方法获得Level表的LevelNum属性字段
//	 * @return Double List
//	 */
//	public List<Double> getLevel_Credits() {
//		ArrayList<Double> creditsList = new ArrayList<>();
//		try {
//			preparedStatement = connection.prepareStatement("select Credits from Level");
//			ResultSet creditsSet = preparedStatement.executeQuery();
//			while (creditsSet.next()) {
//				creditsList.add(creditsSet.getDouble(1));
//			}
//			preparedStatement.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return creditsList;
//	}
}
