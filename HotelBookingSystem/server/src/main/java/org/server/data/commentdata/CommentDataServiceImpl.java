package org.server.data.commentdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.common.dataservice.CommentDataService.CommentDataService;
import org.common.po.CommentPO;
import org.common.utility.ResultMessage;
import org.server.mysql.DatabaseCommunicator;

public class CommentDataServiceImpl extends UnicastRemoteObject implements CommentDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5618743255476533176L;

	public CommentDataServiceImpl() throws RemoteException {
		System.out.println("comment start");
	}

	/**
	 * 如果出现SQLException，此方法可能返回null
	 */
	public List<CommentPO> find(String hotelID) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"select * from comment where hotelid = " + hotelID);
			ResultSet resultSet = preparedStatement.executeQuery();
			return getCommentPO(resultSet);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ResultMessage insert(CommentPO po) throws RemoteException {
		try {
			PreparedStatement preparedStatement = DatabaseCommunicator.getConnectionInstance().prepareStatement(
					"insert into comment(username, hotelid, orderid, commentdate, rank, comment) values ('" + po.userName +
					"','" + po.hotelID + "','" + po.orderID + "','" + getSQLDate(po.date) + "','" + po.rank + "','" + DatabaseCommunicator.getStorableQuote(po.comment) + "')");
			preparedStatement.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.CONNECTION_FAIL;
	}
	
	/**
	 * 打包成PO列表的私有方法
	 * @throws RemoteException
	 */
	private ArrayList<CommentPO> getCommentPO(ResultSet resultSet) {
		ArrayList<CommentPO> poList = new ArrayList<>();
		try {
			while (resultSet.next()) {
				CommentPO commentPO = new CommentPO(resultSet.getString("username"), resultSet.getString("hotelid"), resultSet.getString("orderid"), resultSet.getDate("commentdate"), resultSet.getDouble("rank"), DatabaseCommunicator.getReadableQuote(resultSet.getString("comment")));
				poList.add(commentPO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poList;
	}
	
	private Date getSQLDate(java.util.Date rawDate) {
		return new Date(rawDate.getTime());
	}


}
