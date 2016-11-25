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
			"aaaaa","010000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13919191919");

	OrderVO vo2 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(),new Date(),new Date(),new Date()
			,new Date(),new Date(),new Date(),
			"aaaaa","020000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo1 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel1","030000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo2 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel2","040000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo3 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel3","050000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo4 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel4","060000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo5 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel5","070000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	
	OrderVO fvo6 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel6","080000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo7 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel7","090000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO fvo8 = new OrderVO("i'm a userid",OrderType.EXECUTED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"fhotel8","100000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo1 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel1","110000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo2 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel2","120000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo3 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel3","130000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo4 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel4","140000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo5 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel5","150000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo6 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel6","160000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo7 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel7","170000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO cvo8 = new OrderVO("i'm a userid",OrderType.CANCELED.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"chotel8","180000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo1 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel1","190000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo2 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel2","200000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo3 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel3","210000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo4 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel4","220000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo5 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel5","230000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo6 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel6","240000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo7 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel7","250000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO avo8 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"ahotel8","260000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo1 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel1","270000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo2 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel2","280000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo3 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel3","290000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo4 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel4","300000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo5 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel5","310000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo6 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel6","320000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo7 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel7","330000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo8 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel8","340000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo9 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel9","350000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo10 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel10","360000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo11 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel11","370000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");
	
	OrderVO uvo12 = new OrderVO("i'm a userid",OrderType.ABNORMAL.getString(),
			new Date(100000000),new Date(100000000),new Date(100000000),new Date(100000000)
			,new Date(100000000),new Date(100000000),new Date(100000000),
			"uhotel12","380000000120161122112233","lalala",RoomType.BIG.getString(),100,2,2,true, null,"13671717171");

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
		vo = new ArrayList<>();
		
		vo.add(fvo1);
		vo.add(fvo2);
		vo.add(fvo3);
		vo.add(fvo4);
		vo.add(fvo5);
		vo.add(fvo6);
		vo.add(fvo7);
		vo.add(fvo8);
		
		vo.add(cvo1);
		vo.add(cvo2);
		vo.add(cvo3);
		vo.add(cvo4);
		vo.add(cvo5);
		vo.add(cvo6);
		vo.add(cvo7);
		vo.add(cvo8);
		
		vo.add(avo1);
		vo.add(avo2);
		vo.add(avo3);
		vo.add(avo4);
		vo.add(avo5);
		vo.add(avo6);
		vo.add(avo7);
		vo.add(avo8);
		
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
		
		for (int i = 0; i < vo.size(); i++) {
			if (vo.get(i).orderID == ID) {
				return vo.get(i);
			}
		}
		return null;
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
