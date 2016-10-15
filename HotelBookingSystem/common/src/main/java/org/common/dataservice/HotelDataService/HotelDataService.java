package org.common.dataservice.HotelDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.common.po.AreaPO;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;

public interface HotelDataService extends Remote
{
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException;
	//在数据库中插入一个po
	
	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException;
	//在数据库中更新一个po
	
	public ResultMessage getHotelInfo(String hotelAddress) throws RemoteException;
	//在数据库中增加订单的流转信息
	
	public RoomPO getRooms(String hotelAddress) throws RemoteException;
	
	public ResultMessage modifyRooms(String hotelAddress, RoomPO po) throws RemoteException;
	
	public ResultMessage findHotels(HotelFilter filter) throws RemoteException;
	//在数据库中增加订单的流转信息
	
	public ArrayList<CityPO> getCitys() throws RemoteException;
	//在数据库中获得所有CityPO
	
	public ArrayList<AreaPO> getAreas(CityPO po) throws RemoteException;
	//根据CityPO返回所有AreaPO

	public void finish() throws RemoteException;
	//结束持久化数据库的使用

}
