package org.client.presentation.hotelmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.launcher.Resources;
import org.client.vo.PromotionVO;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * FXML Controller
 * 酒店工作人员-管理酒店促销策略
 * @author Hirico
 * @version 2016/11/27 Hirico
 */
public class HotelManagerCheckPromotion {
	static final int NUM_OF_PROMOTION_PER_PAGE = 5;
	
	static final int FIRST_PAGE_NUM = 1;
	
	static final double PROMOTIONPANE_WIDTH = 727;
	
	static final double PROMOTIONPANE_HEIGHT = 55;
	
	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	private List<PromotionVO> promotionList;
	
	@FXML
    private Label prevPage;

	@FXML
    private Label nextPage;

	@FXML
    private Label pageNumLabel;
	
	@FXML
    private TextField jumpField;
	
	@FXML
    private AnchorPane contentPane;
	
	//当前页面序号，从FIRST_PAGE_NUM开始
	private int pageNum;
	
	//导航界面的GridPane
	private GridPane parentPane;
	
	private ArrayList<PromotionPane> currentPromotionPanes;

	@FXML
    void initialize() {
		assert contentPane != null : "fx:id=\"contentPane\" was not injected: check your FXML file '管理酒店促销策略界面.fxml'.";
		assert prevPage != null : "fx:id=\"prevPage\" was not injected: check your FXML file '管理酒店促销策略界面.fxml'.";
        assert nextPage != null : "fx:id=\"nextPage\" was not injected: check your FXML file '管理酒店促销策略界面.fxml'.";
        assert pageNumLabel != null : "fx:id=\"pageNum\" was not injected: check your FXML file '管理酒店促销策略界面.fxml'.";
        assert jumpField != null : "fx:id=\"jumpField\" was not injected: check your FXML file '管理酒店促销策略界面.fxml'.";
        
		promotionList = HotelManagerController.getInstance().getPromotions();
		
		//显示第一页
		switchCurrentPage(FIRST_PAGE_NUM);
		
	}
	
	/** 持有导航界面GridPane的引用，为了完成从浏览到编辑界面的跳转 */
	void setParentGridPane(GridPane parent) {
		parentPane = parent;
	}
	
	@FXML
	void addPromotion(ActionEvent event) {
		Parent modifyRoot = null;
		Resources resources = Resources.getInstance();
		try {
			modifyRoot = resources.load(resources.hotelManagerModifyPromotion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
	}
	
	void modifyPromotion(PromotionVO vo) {
		Parent modifyRoot = null;
		Resources resources = Resources.getInstance();
		try {
			modifyRoot = resources.load(resources.hotelManagerModifyPromotion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
		
		((HotelManagerModifyPromotion)resources.getCurrentController()).setPromotionVO(vo);
	}
	
	@FXML
	void toNextPage(MouseEvent event) {		
		switchCurrentPage(pageNum + 1);
	}
	
	@FXML
	void toPrevPage(MouseEvent event) {
		
		//检查是否有上一页
		if (pageNum > FIRST_PAGE_NUM) {			
			switchCurrentPage(pageNum - 1);
		}
	}
	
	/** 替换promotionPanes的内容，将其设为contentPane的子女显示，并更改pageNumLabel和pageNum */
	void switchCurrentPage(int toPageNum) {
		
		//修改currentPromotionPanes
		currentPromotionPanes = new ArrayList<PromotionPane>();
		for (int i = (toPageNum - 1) * NUM_OF_PROMOTION_PER_PAGE; i < (toPageNum - 1) * NUM_OF_PROMOTION_PER_PAGE + 
				Math.min(NUM_OF_PROMOTION_PER_PAGE, promotionList.size() - NUM_OF_PROMOTION_PER_PAGE * (toPageNum - 1)); i++) {
			currentPromotionPanes.add(new PromotionPane(promotionList.get(i)));
		}
		
		//修改contentPane
		contentPane.getChildren().clear();
		for (int i = 0; i < currentPromotionPanes.size(); i++) {
			PromotionPane tempPromotionPane = currentPromotionPanes.get(i);
			contentPane.getChildren().add(tempPromotionPane);
			tempPromotionPane.setLayoutY(73 * i);
		}
		
		//修改pageNum
		pageNum = toPageNum;
		pageNumLabel.setText(String.valueOf(pageNum));
	}
	
	@FXML
	void jumpPage(ActionEvent event) {
		int toPageNum = Integer.parseInt(jumpField.getText().trim());
		if (toPageNum >= FIRST_PAGE_NUM) {					
			switchCurrentPage(toPageNum);
		}
	} 
	
	class PromotionPane extends Pane {
		Label name;
		
		Label type;
		
		Label discount;
		
		Button edit;
		
		PromotionVO promotionVO;
		
		PromotionPane(PromotionVO vo) {
			super();
			name = new Label(vo.name);
			type = new Label(vo.type);
			discount = new Label(String.valueOf(vo.discount) + "折");
			edit = new Button("编辑");
			promotionVO = vo;
			
			this.getChildren().add(name);
			this.getChildren().add(type);
			this.getChildren().add(discount);
			this.getChildren().add(edit);
			
			edit.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					modifyPromotion(promotionVO);
				}
			});
			
			this.setPrefSize(PROMOTIONPANE_WIDTH, PROMOTIONPANE_HEIGHT);
			name.setPrefSize(241, 28);
			name.setFont(Font.font("Microsoft YaHei", 15));
			name.setStyle("-fx-text-fill: white");
			name.setLayoutX(10);
			name.setLayoutY(11);
			name.setAlignment(Pos.CENTER);
			
			type.setPrefSize(97, 28);
			type.setFont(Font.font("Microsoft YaHei", 15));
			type.setStyle("-fx-text-fill: white");
			type.setLayoutX(271);
			type.setLayoutY(11);
			type.setAlignment(Pos.CENTER);
			
			discount.setPrefSize(97, 28);
			discount.setFont(Font.font("Microsoft YaHei", 15));
			discount.setStyle("-fx-text-fill: white");
			discount.setLayoutX(462);
			discount.setLayoutY(11);
			discount.setAlignment(Pos.CENTER);
			
			edit.setLayoutX(648);
			edit.setLayoutY(11);
			edit.setAlignment(Pos.CENTER);
			edit.setFont(Font.font("Microsoft YaHei", 15));
			edit.setStyle("-fx-background-color:rgba(255,255,255,0.2); -fx-text-fill: white");
			
			this.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
		}
	}
	
}
