package org.client.blservice.promotionblservice;

import java.util.List;

import org.client.vo.LevelVO;
import org.client.vo.PromotionVO;
import org.common.utility.ResultMessage;

/**
 * Promotion模块在logic层的接口
 * @author fraphisoft
 */
public interface PromotionBlService {

	/**
	 * 添加一个酒店或网站促销策略
	 * @param vo
	 * @return
	 */
	public ResultMessage add(PromotionVO vo);

	/**
	 * 获得符合条件的最佳的酒店促销策略和最佳的网站促销策略
	 * @param hotelID
	 * @param userID
	 * @param roomNum
	 * @return promotionList, size <= 2
	 */
	public List<PromotionVO> getPromotion(String hotelID, String userID, int roomNum);

	/**
	 * 获得该酒店制定的全部促销策略
	 * @param hotelAddress
	 * @return
	 */
	public List<PromotionVO> showHotelPromotion(String hotelAddress);

	/**
	 * 获得所有网站促销策略
	 * @return
	 */
	public List<PromotionVO> showWebsitePromotion();

	/**
	 * 修改一个网站或酒店促销策略
	 * @param vo
	 * @return
	 */
	public ResultMessage modify(PromotionVO vo);

	/**
	 * 删除一个促销策略
	 * @param promotionID
	 * @return
	 */
	public ResultMessage delete(String promotionID);

	/**
	 * 获得会员等级制度的一个VO对象
	 * @return
	 */
	public LevelVO showLevel();

	/**
	 * 修改当前会员等级制度
	 * @param vo
	 * @return
	 */
	public ResultMessage modifyLevel(LevelVO vo);

	/**
	 * 根据指定条件获得最终现价
	 * @param userID
	 * @param hotelID
	 * @param roomNum
	 * @param rawPrice
	 * @return
	 */
	public double getPrice (String userID, String hotelID, int roomNum, double rawPrice);

	/**
	 * 获得信用值对应的会员等级
	 * @param credit
	 * @return
	 */
	public int calculateLevel(double credit);

	/**
	 * 获得广告位酒店的ID
	 * @return
	 */
	public List<String> getAdvertisedHotels();
}
