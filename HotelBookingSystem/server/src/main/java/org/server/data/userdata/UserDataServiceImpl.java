package org.server.data.userdata;

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
import org.server.ServerUtil;
import org.server.data.datafactory.DataFactory;
import org.server.mysql.DatabaseCommunicator;
import org.server.security.EncryptUtil;

/**
 * user模块数据层
 * @author gyue
 * @version gyue 2016/12/7
 */
public class UserDataServiceImpl extends UnicastRemoteObject implements UserDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2823256785769392090L;
	
	public UserDataServiceImpl() throws RemoteException {
		System.out.println("user start");
	}
	
	/**
	 * 将date对象贵转换成特定格式的字符串
	 * @param date
	 * @return
	 */
	private String transTime(Date date) {
		if (date == null) {
			return "1970-01-01 00:00:00";
		}
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return timeFormat.format(date);
	}
	
	/**
	 * 将User表的resultSet转换成PO
	 * @param resultSet
	 * @return
	 */
	private UserPO getUserPOfromSet(ResultSet resultSet) {
		UserPO po = null;
		try {
			UserType type = UserType.getType(resultSet.getString("Type"));
			String userName = EncryptUtil.decrypt(resultSet.getString("UserName"));
			String name = EncryptUtil.decrypt(resultSet.getString("Name"));
			String id = resultSet.getString("ID");
			String passWord = EncryptUtil.decrypt(resultSet.getString("PassWord"));
			String phoneNumber = EncryptUtil.decrypt(resultSet.getString("PhoneNumber"));
			double credit = resultSet.getDouble("Credit");
			Date birthday = resultSet.getDate("Birthday");
			String companyName = resultSet.getString("companyName");
			String hotelAdress = resultSet.getString("HotelAddress");
			String hotelID = resultSet.getString("HotelID");
			po = new UserPO(type, userName, name, id, passWord, phoneNumber, credit, birthday, companyName, hotelID, hotelAdress);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (po == null) {
		}
		return po;
	}
	
	/**
	 * 将creditRecord表的resultSet转换成PO
	 * @param resultSet
	 * @return
	 */
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
			if (po.ID == null) {
				po.ID = DataFactory.getInstance().getIDUtil().generateNewUserID();
			}
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("SELECT * FROM User WHERE userName='" + EncryptUtil.encrypt(po.userName) + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			if (!resultSet.next()) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance()
						.prepareStatement("INSERT INTO User(Type,UserName,Name,ID,"
								+ "PassWord,PhoneNumber,Credit,Birthday,CompanyName,HotelAddress,HotelID)"
								+ " VALUES ('" + po.type.getString() + "','" + EncryptUtil.encrypt(po.userName) + "','"
								+ EncryptUtil.encrypt(po.name) + "','" + po.ID + "','"
								+ EncryptUtil.encrypt(po.passWord) + "','" + EncryptUtil.encrypt(po.phoneNumber) + "','"
								+ po.credit + "','" + transTime(po.birthday) + "','" + po.companyName + "','"
								+ po.hotelAddress + "','" + po.hotelID + "')");
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
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("SELECT * FROM User WHERE UserName='" + EncryptUtil.encrypt(userName) + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			if (resultSet.next()) {
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
			// 如果修改了用户名，检查用户名是否重复
			if (!po.userName.equals(temp.userName)) {
				temp = findbyUserName(po.userName);
				if (temp != null) {
					return ResultMessage.WRONG_USERNAME;
				}
			}
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"delete from User where ID='" + po.ID + "'");
			DatabaseCommunicator.execute(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		add(po);
		return ResultMessage.SUCCESS;
	}

	public ResultMessage Check(String userName, String password) throws RemoteException {
		if (userName.equals("") || password.equals("")) {
			return ResultMessage.WRONG_VALUE;
		}
		ResultMessage info = ResultMessage.WRONG_PASSWORD;
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("SELECT * FROM User WHERE UserName='" + EncryptUtil.encrypt(userName) + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			String toCheck = "";
			if (resultSet.next()) {
				toCheck = EncryptUtil.decrypt(resultSet.getString("PassWord"));
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
							+ "','" + po.result + "','" + po.op.getString() + "')");
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

	@Override
	public ResultMessage deleteUser(String userName) throws RemoteException {
		UserPO po = findbyUserName(userName);
		if (po == null) {
			return ResultMessage.NOT_EXIST;
		}
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance()
					.prepareStatement("delete from User where userName='" + EncryptUtil.encrypt(userName) + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.CONNECTION_FAIL;
		}
		DatabaseCommunicator.execute(preparedStatement);
		return ResultMessage.SUCCESS;
	}

	@Override
	public void addNowUser(String userName) throws RemoteException {
		ServerUtil.getInstance().addNowUser(userName);
	}

	@Override
	public ResultMessage userIsExist(String userName) throws RemoteException {
		return ServerUtil.getInstance().userIsExist(userName);
	}

	@Override
	public ResultMessage deleteNowUser(String userName) throws RemoteException {
		return ServerUtil.getInstance().deleteNowUser(userName);
	}

}
