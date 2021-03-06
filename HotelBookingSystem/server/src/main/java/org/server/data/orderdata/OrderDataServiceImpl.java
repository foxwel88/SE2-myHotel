package org.server.data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.common.dataservice.OrderDataService.OrderDataService;
import org.common.po.OrderPO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;
import org.server.util.mysql.DatabaseCommunicator;

/**
 * Order模块在data层的实现类
 */
public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511666908358074048L;

	public OrderDataServiceImpl() throws RemoteException {
		System.out.println("order start");
	}
	
	String transtime(Date date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date == null) {
			return ("1970-01-01 00:00:00");
		}
		return timeFormat.format(date);
	}
	
	String transdate(Date date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (date == null) {
			return ("1970-01-01");
		}
		return timeFormat.format(date);
	}
	
	OrderPO getPOfromSet(ResultSet resultSet) {
		OrderPO po = null;
		try {
			OrderType type = OrderType.getType((resultSet.getString("type")));
			String userId = resultSet.getString("userId");
			Date generatedDate = resultSet.getTimestamp("generatedDate");
			Date schFrom = resultSet.getDate("schFrom");
			Date schTo = resultSet.getDate("schTo");
			Date actFrom = resultSet.getTimestamp("actFrom");
			Date actTo = resultSet.getTimestamp("actTo");
			Date latestTime = resultSet.getTimestamp("latestTime");
			Date cancelTime = resultSet.getTimestamp("cancelTime");
			String hotelAddress = resultSet.getString("hotelAddress");
			String hotelID = resultSet.getString("hotelID");
			String hotelName = resultSet.getString("hotelName");
			RoomType roomType = RoomType.getType(resultSet.getString("roomType"));
			String orderID = resultSet.getString("orderID");
			double totalPrice = resultSet.getDouble("totalPrice");
			int roomNum = resultSet.getInt("roomnum");
			int numOfPeople = resultSet.getInt("numOfPeople");
			boolean existsChild = resultSet.getBoolean("existsChildren");
			String customerName = resultSet.getString("customerName");
			String phoneNumber = resultSet.getString("phoneNumber");
			boolean isCommented = resultSet.getBoolean("isCommented");
			boolean isCheckedOut = resultSet.getBoolean("isCheckedOut");
			po = new OrderPO(type,generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,hotelName,orderID,hotelAddress,
					roomType,totalPrice,roomNum,numOfPeople,existsChild,customerName,userId,phoneNumber,isCommented,isCheckedOut);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public OrderPO getOrderPO(String orderID) throws RemoteException {
		OrderPO po = null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where orderID='" + orderID + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				po = getPOfromSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public List<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where userId='" + userID + "' and type='" + type.getString() + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where hotelid='" + hotelID + "' and type='" + type.getString() + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<OrderPO> getAbnormalOrderPO() throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where type='" + OrderType.ABNORMAL.getString() + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public ResultMessage add(OrderPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where OrderID='" + po.orderID + "'");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			if (!resultSet.next()) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("insert into `Order`(type,userId,generatedDate,"
								+ "schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelAddress,hotelname,orderID,hotelID,roomType,totalPrice,roomNum,numOfPeople,"
								+ "existsChildren,customerName,phoneNumber,isCommented,isCheckedOut) values('" + po.type.getString() + "','" + po.userId + "','" + transtime(po.generatedDate)
								+ "','" + transtime(po.schFrom) + "','" + transtime(po.schTo) + "','" + transtime(po.actFrom) + "','" + transtime(po.actTo)
								+ "','" + transtime(po.latestTime) + "','" + transtime(po.cancelTime) + "','" + po.hotelAddress + "','" + po.hotelName + "','" + po.orderID + "','" + po.hotelID
								+ "','" + po.roomType.getString() + "'," + po.totalPrice + "," + po.roomNum + "," + po.numOfPeople + "," + po.existsChild + ",'" 
								+ po.customerName + "','" + po.phoneNumber + "'," + po.isCommented + "," + po.isCheckedOut + ")");
				//DatabaseCommunicator.execute(preparedStatement);
				preparedStatement.execute();
				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.EXIST;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modify(OrderPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"delete from `Order` where orderID='" + po.orderID + "'");
			//DatabaseCommunicator.execute(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		add(po);
		return ResultMessage.SUCCESS;
	}

	@Override
	public void updateAbnormalOrders(Date date) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement
					("update `order` set type='异常订单' where type='未执行订单' and latesttime between '1980-03-03 00:00:00' and '" + transtime(date) + "'");
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderPO> getDateOrderPO(String hotelID, Date date) throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where hotelid='" + hotelID + "' and type<>'已撤销订单' and '"  
					+ transdate(date) + "' >= schfrom and '" + transdate(date) + "' < schto");
			ResultSet resultSet = DatabaseCommunicator.executeQuery(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
