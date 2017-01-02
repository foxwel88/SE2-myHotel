package org.server.util.id;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.common.utility.IDService;
import org.server.util.mysql.DatabaseCommunicator;

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
	}

	private final int MAX_HOTELID_LENGTH = 5;
	
	private final int MAX_USERID_LENGTH = 10;

	/**
	 * 获得上个酒店的ID，该ID也代表酒店个数
	 * 格式：“00000”
	 * @return
	 */
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

	/**
	 * 为一个新的User生成ID
	 * @return
	 */
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

	/**
	 * 为一个新酒店生成ID，调用了getLastHotelID()方法
	 * @return
	 */
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
