package org.server.data.OrderData;

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

import mySQL.DatabaseCommunicator;

public class OrderDataServiceImpl extends UnicastRemoteObject implements OrderDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511666908358074048L;

	public OrderDataServiceImpl() throws RemoteException {
		System.out.println("order start");
		// TODO Auto-generated constructor stub
	}
	
	String transtime(Date date) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return timeFormat.format(date);
	}
	
	OrderPO getPOfromSet(ResultSet resultSet) {
		OrderPO po = null;
		try {
			OrderType type = OrderType.getType((resultSet.getString("type")));
			String userId = resultSet.getString("userId");
			Date generatedDate = resultSet.getDate("generatedDate");
			Date schFrom = resultSet.getDate("schFrom");
			Date schTo = resultSet.getDate("schTo");
			Date actFrom = resultSet.getDate("actFrom");
			Date actTo = resultSet.getDate("actTo");
			Date latestTime = resultSet.getDate("latestTime");
			Date cancelTime = resultSet.getDate("cancelTime");
			String hotelAddress = resultSet.getString("hotelAddress");
			String hotelID = resultSet.getString("hotelID");
			String hotelName = resultSet.getString("hotelName");
			RoomType roomType = RoomType.getType(resultSet.getString("roomType"));
			String orderID = resultSet.getString("orderID");
			double totalPrice = resultSet.getDouble("totalPrice");
			int roomNum = resultSet.getInt("totalPrice");
			int numOfPeople = resultSet.getInt("numOfPeople");
			boolean existsChild = resultSet.getBoolean("existsChildren");
			String customerName = resultSet.getString("customerName");
			String phoneNumber = resultSet.getString("phoneNumber");
			po = new OrderPO(type,generatedDate,schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelID,hotelName,orderID,hotelAddress,
					roomType,totalPrice,roomNum,numOfPeople,existsChild,customerName,userId,phoneNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public OrderPO getOrderPO(String orderID) throws RemoteException {
		OrderPO po = null;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select type,userId,generatedDate,"
					+ "schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelid,hotelAddress,orderID,hotelName,roomType,totalPrice,roomNum,numOfPeople,"
					+ "existsChildren,customerName,phoneNumber from `Order` where orderID=" + orderID);
			
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				po = getPOfromSet(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public List<OrderPO> getUserOrderPO(String userID, OrderType type) throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select type,userId,generatedDate,"
					+ "schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelid,hotelAddress,orderID,hotelName,roomType,totalPrice,roomNum,numOfPeople,"
					+ "existsChildren,customerName,phoneNumber from `Order` where userId='" + userID + "' and type='" + type.getString() + "'");
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public List<OrderPO> getHotelOrderPO(String hotelID, OrderType type) throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select type,userId,generatedDate,"
					+ "schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelid,hotelAddress,orderID,hotelName,roomType,totalPrice,roomNum,numOfPeople,"
					+ "existsChildren,customerName,phoneNumber from `Order` where hotelid='" + hotelID + "' and type='" + type.getString() + "'");
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public List<OrderPO> getAbnormalOrderPO() throws RemoteException {
		List<OrderPO> res = new ArrayList<OrderPO>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select type,userId,generatedDate,"
					+ "schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelid,hotelAddress,orderID,hotelName,roomType,totalPrice,roomNum,numOfPeople,"
					+ "existsChildren,customerName,phoneNumber from `Order` where type='" + OrderType.ABNORMAL.getString() + "'");
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			while (resultSet.next()) {
				res.add(getPOfromSet(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public ResultMessage add(OrderPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("select * from `Order` where OrderID='" + po.orderID + "'");
			ResultSet resultSet = DatabaseCommunicator.execute(preparedStatement);
			if (!resultSet.next()) {
				preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement("insert into `Order`(type,userId,generatedDate,"
								+ "schFrom,schTo,actFrom,actTo,latestTime,cancelTime,hotelAddress,hotelname,orderID,hotelID,roomType,totalPrice,roomNum,numOfPeople,"
								+ "existsChildren,customerName,phoneNumber) values('" + po.type.getString() + "','" + po.userId + "','" + transtime(po.generatedDate)
								+ "','" + transtime(po.schFrom) + "','" + transtime(po.schTo) + "','" + transtime(po.actFrom) + "','" + transtime(po.actTo)
								+ "','" + transtime(po.latestTime) + "','" + transtime(po.cancelTime) + "','" + po.hotelAddress + "','" + po.hotelName + "','" + po.orderID + "','" + po.hotelID
								+ "','" + po.roomType.getString() + "'," + po.totalPrice + "," + po.roomNum + "," + po.numOfPeople + "," + po.existsChild + ",'" 
								+ po.customerName + "','" + po.phoneNumber + "')");
				//DatabaseCommunicator.execute(preparedStatement);
				preparedStatement.execute();
				return ResultMessage.SUCCESS;
			} else {
				return ResultMessage.EXIST;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(OrderPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"delete from `Order` where orderID='" + po.orderID + "'");
			//DatabaseCommunicator.execute(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(po);
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public void print(List<OrderPO> polist) {
		for (int i = 0; i < polist.size(); ++i) {
			OrderPO po = polist.get(i);
			System.out.println("'" + po.type.getString() + "','" + po.userId + "','" + transtime(po.generatedDate)
								+ "','" + transtime(po.schFrom) + "','" + transtime(po.schTo) + "','" + transtime(po.actFrom) + "','" + transtime(po.actTo)
								+ "','" + transtime(po.latestTime) + "','" + transtime(po.cancelTime) + "','" + po.hotelID + "','" + po.hotelName + "','" + po.orderID + "','" + po.hotelID
								+ "','" + po.roomType.getString() + "'," + po.totalPrice + "," + po.roomNum + "," + po.numOfPeople + "," + po.existsChild + ",'" 
								+ po.customerName + "','" + po.phoneNumber);
		}
	}
	
	/*
	public static void main(String[] args) throws RemoteException {
		OrderDataServiceImpl mywork = new OrderDataServiceImpl();
		DatabaseCommunicator.databaseInit();
		System.out.println("aaaaa");
		OrderPO po1 = new OrderPO(OrderType.UNEXECUTED,new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),new Date(),
				"00001","aaaaa某某某大酒店","000000000120161122112209","111111仙林大道168号栖霞大酒店",RoomType.BIG,100,1,2,false, "foxwel","0000000001","13919191919");
		//mywork.modify(po1);
		
		mywork.print(mywork.getAbnormalOrderPO());
		System.out.println("aaaaa");
		//mywork.getOrderPO("123456789020080606143055");
	}
	*/
}
