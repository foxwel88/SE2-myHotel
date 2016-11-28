package mySQL;

import java.util.ArrayList;

import org.common.dataservice.PromotionDataService.PromotionDataService;
import org.common.po.LevelPO;
import org.server.data.PromotionData.PromotionDataServiceImpl;

/**
 * Test-Class of sql
 * @author fraliphsoft
 * @version fraliphsoft 11/28
 * 
 * ATTENTION! ATTENTION! ATTENTION! you can only run it after installing and starting mysql service in cmd, or you will receive your most familiar output —— NullPointerException
 * 
 */
public class SQLTester {
	
	public static void main(String[] args) {
//		DatabaseCommunicator communicator = DatabaseCommunicator.getInstance();
//		ArrayList<Integer> levelNumList = new ArrayList<>(communicator.getLevel_LevelNum());
//		ArrayList<Double> creditsList = new ArrayList<>(communicator.getLevel_Credits());
//		for (int i = 0; i < levelNumList.size(); i++) {
//			System.out.print(levelNumList.get(i) + " ");
//			System.out.println(creditsList.get(i));
//		}
		
		try {
			PromotionDataService promotionTest = new PromotionDataServiceImpl();
			LevelPO po = promotionTest.showLevel();
			System.out.println(po.levelNum);
			System.out.println(po.credits);
		} catch (Exception ex) {
			// nothing to do
		}
		
	}
	
}
