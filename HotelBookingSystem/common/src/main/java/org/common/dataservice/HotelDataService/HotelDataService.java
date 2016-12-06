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
	
	//初始化持久化数据库
	public void init() throws RemoteException;

	//在数据库中插入一个po
	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException;

	//在数据库中更新一个po
	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException;

	//返回一个酒店po
	public HotelPO getHotelInfo(String hotelID) throws RemoteException;
	
	//返回房间信息
	public List<RoomPO> getRooms(String hotelID) throws RemoteException;

	//在数据库中更新房间po
	public ResultMessage modifyRooms(String hotelID, List<RoomPO> po) throws RemoteException;

	//返回多个酒店po
	public List<HotelPO> findHotels(HotelFilter filter) throws RemoteException;

	//在数据库中获得所有CityPO
	public List<CityPO> getCitys() throws RemoteException;

	//根据CityPO返回所有AreaPO
	public List<AreaPO> getAreas(CityPO po) throws RemoteException;

	//结束持久化数据库的使用
	public void finish() throws RemoteException;

	//增加一个某类型可用房间
	public void increaseAvailableRoom(RoomType type, String hotelID) throws RemoteException;

	//减少一个某类型可用房间
	public ResultMessage decreaseAvailableRoom(RoomType type, String hotelID) throws RemoteException;

}
