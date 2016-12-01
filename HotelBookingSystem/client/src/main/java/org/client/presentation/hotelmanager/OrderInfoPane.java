package org.client.presentation.hotelmanager;

import java.io.IOException;

import org.client.launcher.Resources;
import org.client.vo.OrderVO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/** 
 * 在浏览订单列表时用到的单条订单的pane，包含了客户姓名、订单ID的label和详情button
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class OrderInfoPane extends Pane {
	Label customerNameLabel;
	
	Label orderIDLabel;
	
	Button specButton;
	
	OrderVO vo;
	
	GridPane parentGridPane;
	
	OrderInfoPane(OrderVO vo, GridPane gridPane) {
		super();
		this.vo = vo;
		parentGridPane = gridPane;
		
		customerNameLabel = new Label("姓名：" + vo.customerName);
		orderIDLabel = new Label("订单号：" + vo.orderID);
		specButton = new Button("详情");
		
		
		this.getChildren().add(customerNameLabel);
		this.getChildren().add(orderIDLabel);
		this.getChildren().add(specButton);
		
		this.setPrefSize(727, 55);
		this.setStyle("-fx-background-color: rgba(0,0,0,0.3)");
		
		customerNameLabel.setPrefSize(175,28);		
		customerNameLabel.setFont(Font.font("Microsoft YaHei", 15));
		customerNameLabel.setStyle("-fx-text-fill: white");
		customerNameLabel.setLayoutX(25);
		customerNameLabel.setLayoutY(13);
		
		orderIDLabel.setPrefSize(339, 28);
		orderIDLabel.setFont(Font.font("Microsoft YaHei", 15));
		orderIDLabel.setStyle("-fx-text-fill: white");
		orderIDLabel.setLayoutX(292);
		orderIDLabel.setLayoutY(13);
				
		specButton.setFont(Font.font("Microsoft YaHei", 15));
		specButton.setStyle("-fx-background-color:rgba(255,255,255,0.2); -fx-text-fill: white");
		specButton.setLayoutX(648);
		specButton.setLayoutY(13);
		
		specButton.setOnAction(e -> switchToSpec());
	}
	
	/*根据orderVO中orderType的不同跳转到不同类型的详情页面 */
	void switchToSpec() {
		Parent modifyRoot = null;
		Resources resources = Resources.getInstance();
		try {
			HotelManagerController.getInstance().currentOrder = vo;			
			switch(vo.type) {
				case "未执行订单":
					modifyRoot = resources.load(resources.hotelManagerUnexecutedOrder);
					break;
				case "已执行订单":
					modifyRoot = resources.load(resources.hotelManagerExecutedOrder);
					break;
				case "已撤销订单":
					modifyRoot = resources.load(resources.hotelManagerCancelledOrder);
					break;
				case "异常订单":
					modifyRoot = resources.load(resources.hotelManagerAbnormalOrder);
					break;					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentGridPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);	
	}

}
