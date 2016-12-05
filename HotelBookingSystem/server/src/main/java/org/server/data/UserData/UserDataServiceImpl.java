package org.server.data.UserData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.common.dataservice.UserDataService.UserDataService;
import org.common.po.CreditRecordPO;
import org.common.po.UserPO;
import org.common.utility.CreditOperation;
import org.common.utility.ResultMessage;
import org.common.utility.UserType;

import mySQL.DatabaseCommunicator;

public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2823256785769392090L;

	public UserDataServiceImpl() throws RemoteException {
		System.out.println("user start");
	}
	
	private String transTime(Date date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return timeFormat.format(date);
	}
	
	private UserPO getUserPOfromSet(ResultSet resultSet) {
		UserPO po = null;
		try {
			UserType type = UserType.getType(resultSet.getString("Type"));
			String userName = resultSet.getString("UserName");
			String name = resultSet.getString("Name");
			String id = resultSet.getString("ID");
			String passWord = resultSet.getString("PassWord");
			String phoneNumber = resultSet.getString("PhoneNumber");
			double credit = resultSet.getDouble("Credit");
			Date birthday = resultSet.getDate("Birthday");
			String companyName = resultSet.getString("companyName");
			String hotelAdress = resultSet.getString("HotelAddress");
			String hotelID = resultSet.getString("HotelID");
			po = new UserPO(type, userName, name, id, passWord, phoneNumber, credit, birthday, companyName, hotelID, hotelAdress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
	
	private CreditRecordPO getCreditRecordPOfromSet(ResultSet resultSet) {
		CreditRecordPO po = null;
		try {
			Date date = resultSet.getDate("changeddate");
			String orderID = resultSet.getString("orderid");
			double change = resultSet.getDouble("changedvalue");
			double result = resultSet.getDouble("result");
			CreditOperation op = CreditOperation.getType(resultSet.getString("op"));
			String userID = resultSet.getString("userid");
			po = new CreditRecordPO(date, orderID, change, result, op, userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public ResultMessage add(UserPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("SELECT * FROM User WHERE ID='" + po.ID + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			if (!resultSet.next()) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance()
						.prepareStatement("INSERT INTO User(Type,UserName,Name,ID,"
								+ "PassWord,PhoneNumber,Credit,Birthday,CompanyName,HotelAddress,HotelID)"
								+ " VALUES ('" + po.type.getString() + "','" + po.userName + "','" + po.name + "','" + po.ID + "','"
								+ po.passWord + "','" + po.phoneNumber + "','" + po.credit + "','" + transTime(po.birthday) + "','"
								+ po.companyName + "','" + po.hotelAddress + "','" + po.hotelID + "')");
				DatabaseCommunicator.execute(preparedStatement);
				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.EXIST;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}

	public UserPO findbyID(String ID) throws RemoteException {
		UserPO po = null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("select * from User where ID='" + ID + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				po = getUserPOfromSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public UserPO findbyUserName(String userName) throws RemoteException {
		UserPO po = null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("select * from User where UserName='" + userName + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				po = getUserPOfromSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public ResultMessage modify(UserPO po) throws RemoteException {
		try {
			// 检查该用户是否存在
			UserPO temp = findbyID(po.ID);
			if (temp == null) {
				return ResultMessage.NOT_EXIST;
			}
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"delete from User where ID=" + po.ID);
			DatabaseCommunicator.execute(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		add(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage Check(String userName, String password) throws RemoteException {
		ResultMessage info = ResultMessage.WRONG_PASSWORD;
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("SELECT * FROM User WHERE UserName='" + userName + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			String toCheck = new String("");
			if (resultSet.next()) {
				toCheck = resultSet.getString("PassWord");
			} else {
				info = ResultMessage.WRONG_USERNAME;
			}
			if (toCheck.equals(password)) {
				info = ResultMessage.SUCCESS;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		return info;
	}

	public ResultMessage addCreditRecord(CreditRecordPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("INSERT INTO creditrecord(orderid,userid,changeddate,changedvalue,result,op)"
							+ " VALUES ('" + po.orderID + "','" + po.userId + "','" + transTime(po.date) + "','" + po.change
							+ "','" + po.result + "','" + po.op.toString() + "')");
			DatabaseCommunicator.execute(preparedStatement);
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
	}

	public void init() throws RemoteException {
		
	}

	public void finish() throws RemoteException {
		
	}

	public List<CreditRecordPO> findCreditRecords(String ID) throws RemoteException {
		List<CreditRecordPO> res = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("SELECT * FROM CreditRecord WHERE userid='" + ID + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				res.add(getCreditRecordPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public String getNewID() throws RemoteException {
		boolean canContinue = true;
		String id = generateIdRandom();
		while (canContinue) {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = DatabaseCommunicator.getConnectionInstance()
						.prepareStatement("select * from User where ID='" + id + "'");
				ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
				if (!resultSet.next()) {
					canContinue = false;
				} else {
					id = generateIdRandom();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}
	
	/**
	 * 随机产生一个10位的字符串
	 * @return
	 */
	private String generateIdRandom() {
		String res = "";
		for (int i = 0; i < 10; i ++) {
			res += (int)Math.random() * 10;
		}
		return res;
	}

}
