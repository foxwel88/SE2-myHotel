package org.server.id;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.common.utility.IDService;
import org.server.mySQL.DatabaseCommunicator;

/**
 * 用来生成新的ID
 * @author Hirico
 * @version 2016/12/09 Foxwel
 */
public class IDUtil extends UnicastRemoteObject implements IDService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4877647629896169296L;


	public IDUtil() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private final int MAX_HOTELID_LENGTH = 5;
	
	private final int MAX_USERID_LENGTH = 10;

	public String getLastHotelID() {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT count(*) FROM Hotel ");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			int count = 0;
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			String value = String.valueOf(count);
			for (int i = value.length(); i < MAX_HOTELID_LENGTH; i++) {
				value = "0" + value;
			}
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String generateNewUserID() {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("SELECT count(*) FROM User ");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			int count = 0;
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			count += 1;
			String value = String.valueOf(count);
			for (int i = value.length(); i < MAX_USERID_LENGTH; i++) {
				value = "0" + value;
			}
			return value;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateNewHotelID() {
		String lastID = getLastHotelID();
		int count = Integer.parseInt(lastID);
		count += 1;
		String value = String.valueOf(count);
		for (int i = value.length(); i < MAX_HOTELID_LENGTH; i++) {
			value = "0" + value;
		}
		return value;
	}

}
