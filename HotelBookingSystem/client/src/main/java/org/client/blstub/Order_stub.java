package org.client.blstub;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.client.blservice.orderblservice.Orderblservice;
import org.client.vo.OrderVO;
import org.common.utility.OrderType;
import org.common.utility.ResultMessage;
import org.common.utility.RoomType;

public class Order_stub implements Orderblservice {

	OrderVO vo1 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString()
			,new Date(),new Date(),new Date(),new Date()
			,new Date(),new Date(),new Date(),
			"aaaaa","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13919191919");

	OrderVO vo2 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(),new Date(),new Date(),new Date()
			,new Date(),new Date(),new Date(),
			"aaaaa","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo1 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel1","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo2 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel2","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo3 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel3","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo4 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel4","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo5 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel5","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	
	OrderVO fvo6 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel6","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo7 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel7","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo8 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel8","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo1 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel1","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo2 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel2","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo3 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel3","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo4 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel4","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo5 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel5","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo6 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel6","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo7 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel7","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo8 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel8","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo1 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel1","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo2 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel2","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo3 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel3","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo4 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel4","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo5 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel5","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo6 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel6","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo7 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel7","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo8 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel8","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo1 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel1","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo2 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel2","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo3 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel3","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo4 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel4","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo5 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel5","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo6 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel6","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo7 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel7","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo8 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel8","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo9 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel9","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo10 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel10","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo11 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel11","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo12 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel12","11111","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");

	ArrayList<OrderVO> vo;
	
	public ResultMessage createOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage cancelOrder(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public OrderVO getOrder(String ID) {
		// TODO Auto-generated method stub
		return vo1;
	}

	public ArrayList<OrderVO> getAbnormalOrder() {
		// TODO Auto-generated method stub
		vo = new ArrayList<>();
		vo.add(avo1);
		vo.add(avo2);
		vo.add(avo3);
		vo.add(avo4);
		vo.add(avo5);
		vo.add(avo6);
		vo.add(avo7);
		vo.add(avo8);
		return vo;
	}

	public ArrayList<OrderVO> getUserOrderList(String userID, OrderType type) {
		// TODO Auto-generated method stub
		vo = new ArrayList<>();
		switch (type) {
			case ABNORMAL:
				vo = getAbnormalOrder();
				break;
			case EXECUTED:
				vo.add(fvo1);
				vo.add(fvo2);
				vo.add(fvo3);
				vo.add(fvo4);
				vo.add(fvo5);
				vo.add(fvo6);
				vo.add(fvo7);
				vo.add(fvo8);
				break;
			case CANCELED:
				vo.add(cvo1);
				vo.add(cvo2);
				vo.add(cvo3);
				vo.add(cvo4);
				vo.add(cvo5);
				vo.add(cvo6);
				vo.add(cvo7);
				vo.add(cvo8);
				break;
			case UNEXECUTED:
				vo.add(uvo1);
				vo.add(uvo2);
				vo.add(uvo3);
				vo.add(uvo4);
				vo.add(uvo5);
				vo.add(uvo6);
				vo.add(uvo7);
				vo.add(uvo8);
				vo.add(uvo9);
				vo.add(uvo10);
				vo.add(uvo11);
				vo.add(uvo12);
				break;
		}
		return vo;
	}

	public ArrayList<OrderVO> getHotelOrderList(String hotelID, OrderType type) {
		// TODO Auto-generated method stub
		vo = new ArrayList<>();
		return vo;
	}

	public ResultMessage executeOrder(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage cancelAbnormalOrder(String orderID, Boolean isHalf) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public List<String> getHistoryHotels(String userId) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("1号酒店");
		list.add("2号酒店");
		return list;
	}

	

}
