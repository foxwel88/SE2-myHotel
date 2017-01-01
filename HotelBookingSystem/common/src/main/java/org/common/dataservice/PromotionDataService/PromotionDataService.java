package org.common.dataservice.PromotionDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

public interface PromotionDataService extends Remote {
	public ResultMessage add(PromotionPO po) throws RemoteException;
	//在数据库中增加一个PromotionPO记录
	
	public ResultMessage modify(PromotionPO po) throws RemoteException;
	//更新一个PO
	
	public ResultMessage delete(String promotionID) throws RemoteException;
	//删除一条促销策略
	
	public List<PromotionPO> showHotelPromotion(String hotelID) throws RemoteException;
	//按hotelID进行查找返回该酒店的PromotionPO记录
	
	public List<PromotionPO> showWebsitePromotion() throws RemoteException;
	//返回网站策略的PromotionPO记录
	
	public LevelPO showLevel() throws RemoteException;
	//返回LevelPO记录
	
	public ResultMessage modifyLevel(LevelPO po) throws RemoteException;
	//更新一个POs

}
