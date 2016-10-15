package org.common.dataservice.PromotionDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.common.po.LevelPO;
import org.common.po.PromotionPO;
import org.common.utility.ResultMessage;

public interface PromotionDataService extends Remote
{
	public ResultMessage add(PromotionPO po) throws RemoteException;
	//在数据库中增加一个PromotionPO记录
	
	public ResultMessage modify(PromotionPO po) throws RemoteException;
	//更新一个PO
	
	public ArrayList<PromotionPO>  showHotelPromotion(String hotelAddress) throws RemoteException;
	//按hotelAddress进行查找返回该酒店的PromotionPO记录
	
	public ArrayList<PromotionPO> showWebsitePromotion() throws RemoteException;
	//返回网站策略的PromotionPO记录
	
	public ResultMessage delete(PromotionPO po) throws RemoteException;
	//删除一个PO
	
	public LevelPO showLevel() throws RemoteException;
	//返回LevelPO记录
	
	public ResultMessage modifyLevel(LevelPO po) throws RemoteException;
	//更新一个PO
	
	public void init() throws RemoteException;
	//初始化持久化数据库
	
	public void finish() throws RemoteException;
	//结束持久化数据库的使用

}
