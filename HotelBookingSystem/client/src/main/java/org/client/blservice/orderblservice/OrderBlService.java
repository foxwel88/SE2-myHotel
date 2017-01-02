package org.client.blservice.orderblservice;

import java.util.Date;
import java.util.List;

import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

/**
 * Order模块的bl层接口
 * @author foxwel
 * @version Hirico 2017/01/01
 */
public interface OrderBlService {

	/**
	 * 由vo生成一个订单
	 * @param vo
	 * @return
	 */
	public ResultMessage createOrder(OrderVO vo);

	/**
	 * 撤销一个未执行订单
	 * @param orderID
	 * @return
	 */
	public ResultMessage cancelOrder(String orderID);

	/**
	 * 获得指定订单的VO
	 * @param orderID
	 * @return
	 */
	public OrderVO getOrder(String orderID);

	/**
	 * 获得全部异常订单
	 * @return
	 */
	public List<OrderVO> getAbnormalOrder();

	/**
	 * 获得用户某种类型的全部订单
	 * @param userID
	 * @param type
	 * @return
	 */
	public List<OrderVO> getUserOrderList(String userID, OrderType type);

	/**
	 * 获得酒店某种类型的全部订单
	 * @param hotelID
	 * @param type
	 * @return
	 */
	public List<OrderVO> getHotelOrderList(String hotelID, OrderType type);

	/**
	 * 执行一个未执行订单
	 * @param orderID
	 * @return
	 */
	public ResultMessage executeOrder (String orderID);

	/**
	 * 撤销一个异常订单
	 * @param orderID
	 * @param isHalf
	 * @return
	 */
	public ResultMessage cancelAbnormalOrder (String orderID, Boolean isHalf);

	/**
	 * 获得用户的所有已执行订单的酒店ID，即住过的酒店
	 * @param userId
	 * @return
	 */
	public List<String> getHistoryHotels(String userId);

	/**
	 * 将一个订单标记为已退房
	 * @param orderID
	 * @return
	 */
	public ResultMessage checkOut(String orderID);

	/**
	 * 评价一个订单
	 * @param orderID
	 * @return
	 */
	public ResultMessage comment(String orderID);

	/**
	 * 获得指定酒店在某日期范围内的某类型房间的可用数量
	 * @param hotelID
	 * @param roomType
	 * @param fromdate 预定入住时间
	 * @param todate 预定离开时间
	 * @return
	 */
	public int getBookedRoomNum(String hotelID, RoomType roomType, Date fromdate, Date todate);

	/**
	 * 产生一个线下订单
	 * @param vo
	 * @return
	 */
	public ResultMessage createOffLineOrder(OrderVO vo);
}
