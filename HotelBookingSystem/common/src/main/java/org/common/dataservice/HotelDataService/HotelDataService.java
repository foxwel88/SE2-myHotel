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

/**
 * Hotel模块在data的接口
 */
public interface HotelDataService extends Remote {

	/**
	 * 在数据库中插入一个po
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage addHotelInfo(HotelPO po) throws RemoteException;

	/**
	 * 在数据库中更新一个po
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyHotelInfo(HotelPO po) throws RemoteException;

	/**
	 * 返回一个酒店po
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelPO getHotelInfo(String hotelID) throws RemoteException;

	/**
	 * 返回房间信息
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public List<RoomPO> getRooms(String hotelID) throws RemoteException;

	/**
	 * 在数据库中更新房间po
	 * @param hotelID
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyRooms(String hotelID, List<RoomPO> po) throws RemoteException;

	/**
	 * 返回多个酒店po
	 * @param filter
	 * @return
	 * @throws RemoteException
	 */
	public List<HotelPO> findHotels(HotelFilter filter) throws RemoteException;

	/**
	 * 在数据库中获得所有CityPO
	 * @return
	 * @throws RemoteException
	 */
	public List<CityPO> getCitys() throws RemoteException;

	/**
	 * 根据CityPO返回所有AreaPO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public List<AreaPO> getAreas(CityPO po) throws RemoteException;

}
