package org.common.dataservice.HotelDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.common.po.AreaPO;
import org.common.po.CityPO;
import org.common.po.HotelPO;
import org.common.po.RoomPO;
import org.common.utility.HotelFilter;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public interface HotelDataService extends Remote {
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException;
	//在数据库中插入一个po
	
	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException;
	//在数据库中更新一个po
	
	public HotelPO getHotelInfo(String hotelAddress) throws RemoteException;
	//返回一个酒店po
	
	public List<RoomPO> getRooms(String hotelAddress) throws RemoteException;
	//返回房间信息
	
	public ResultMessage modifyRooms(String hotelAddress, List<RoomPO> po) throws RemoteException;
	//在数据库中更新房间po
	
	public ResultMessage changeRoom(RoomType type, int num, String hotelAddress) throws RemoteException;
	//在数据库中更新房间po
	
	public List<HotelPO> findHotels(HotelFilter filter) throws RemoteException;
	//返回多个酒店po
	
	public List<CityPO> getCitys() throws RemoteException;
	//在数据库中获得所有CityPO
	
	public List<AreaPO> getAreas(CityPO po) throws RemoteException;
	//根据CityPO返回所有AreaPO

	public void finish() throws RemoteException;
	//结束持久化数据库的使用

}
