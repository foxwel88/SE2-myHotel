package org.common.dataservice.PromotionDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

/**
 * Promotion模块在data的接口
 * @author Hirico
 */
public interface PromotionDataService extends Remote {

	/**
	 * 在数据库中增加一个PromotionPO记录
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage add(PromotionPO po) throws RemoteException;

	/**
	 * 更新一个PO
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modify(PromotionPO po) throws RemoteException;

	/**
	 * 删除一条促销策略
	 * @param promotionID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage delete(String promotionID) throws RemoteException;

	/**
	 * 按hotelID进行查找返回该酒店的PromotionPO记录
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public List<PromotionPO> showHotelPromotion(String hotelID) throws RemoteException;

	/**
	 * 返回网站策略的PromotionPO记录
	 * @return
	 * @throws RemoteException
	 */
	public List<PromotionPO> showWebsitePromotion() throws RemoteException;

	/**
	 * 返回LevelPO记录
	 * @return
	 * @throws RemoteException
	 */
	public LevelPO showLevel() throws RemoteException;

	/**
	 * 更新一个POs
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage modifyLevel(LevelPO po) throws RemoteException;

	/**
	 * 获得广告位酒店ID
	 * @return
	 * @throws RemoteException
	 */
	public List<String> getAdvertisedHotels() throws RemoteException;

}
