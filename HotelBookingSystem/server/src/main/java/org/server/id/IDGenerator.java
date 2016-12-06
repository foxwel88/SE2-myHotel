package org.server.id;

import mySQL.DatabaseCommunicator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用来生成新的ID
 * @author Hirico
 * @version 2016/12/06 Hirico
 */
public class IDGenerator {

	private static final int MAX_HOTELID_Length = 5;

	public static String generateNewHotelID() {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT count(*) FROM Hotel ");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			int count = 0;
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			count += 1;
			String value = String.valueOf(count);
			for (int i = value.length(); i < MAX_HOTELID_Length; i++) {
				value = "0" + value;
			}
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
