package org.client.presentation.webmarketer;

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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller
 * 网站营销人员-浏览促销策略
 * @author gyue
 * @version 2016/11/27 gyue
 */
public class WebMarketerCheckPromotion {
	/**
	 * 起始页码
	 */
	private static final int FIRST_PAGE_NUM = 1;
	
	/**
	 * 每个页面上的促销策略数量
	 */
	private static final int NUM_OF_PROMOTION_PER_PAGE = 5;
	
	@FXML
    private ResourceBundle resources;

	@FXML
    private URL location;
	
	@FXML
    private GridPane contentGridPane;

	@FXML
    private Button addButton;

	@FXML
    private Label prevPage;

	@FXML
    private Label pageNumLabel;

	@FXML
    private Label nextPage;

	@FXML
    private TextField jumpField;
	
	private WebMarketerController controller;
	
	/**
	 * 当前页码
	 */
	private int pageNum;
	
	/**
	 * 导航界面的GridPane
	 */
	private GridPane parentPane;
	
	/**
	 * 促销策略VO的list
	 */
	private List<PromotionVO> promotionList;
	
	/**
	 * 当前页面中的PromotionPane的list
	 */
	private ArrayList<PromotionPane> currentPromotionPanes;
	
	@FXML
    void initialize() {
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
		assert prevPage != null : "fx:id=\"prevPage\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
		assert pageNumLabel != null : "fx:id=\"pageNumLabel\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
		assert nextPage != null : "fx:id=\"nextPage\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
		assert jumpField != null : "fx:id=\"jumpField\" was not injected: check your FXML file '管理促销策略界面.fxml'.";
		
		controller = WebMarketerController.getInstance();
		promotionList = controller.getPromotions();
		
		// show first page
		switchCurrentPage(FIRST_PAGE_NUM);
	}
	
	/**
	 * 获得导航界面GridPane的引用以完成到编辑界面的跳转
	 * @param pane
	 */
	void setParentGridPane(GridPane pane) {
		parentPane = pane;
	}
	
	/**
	 * 跳转到增加促销策略界面
	 * @param event
	 */
	@FXML
    void addPromotion(MouseEvent event) {
		Parent modifyRoot = null;
		Resources resources = Resources.getInstance();
		try {
			modifyRoot = resources.load(resources.webMarketerModifyPromotion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
		((WebMarketerModifyPromotion)resources.getCurrentController()).setParentGridPane(parentPane);
	}
	
	/**
	 * 跳转到修改促销策略界面
	 * @param promotionVO
	 */
	private void modifyPromotion(PromotionVO promotionVO) {
		Parent modifyRoot = null;
		Resources resources = Resources.getInstance();
		try {
			modifyRoot = resources.load(resources.webMarketerModifyPromotion);
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
		((WebMarketerModifyPromotion)resources.getCurrentController()).setParentGridPane(parentPane);
		((WebMarketerModifyPromotion)resources.getCurrentController()).setPromotionVO(promotionVO);
	}
	
	private void deletePromotion(String promotionID) {
		controller.deletePromotion(promotionID);
		promotionList = controller.getPromotions();
		// 更新当前页面
		switchCurrentPage(pageNum);
	}

	@FXML
    void jumpPage(ActionEvent event) {
		int toPageNum = pageNum;
		try {
			toPageNum = Integer.parseInt(jumpField.getText().trim());
		} catch (RuntimeException e) {
			switchCurrentPage(pageNum);
		}
		if (toPageNum >= FIRST_PAGE_NUM) {					
			switchCurrentPage(toPageNum);
		}
	}

	@FXML
    void toNextPage(MouseEvent event) {
		switchCurrentPage(pageNum + 1);
	}

	@FXML
	void toPrevPage(MouseEvent event) {
		// 检查是否有上一页
		if (pageNum > FIRST_PAGE_NUM) {
			switchCurrentPage(pageNum - 1);
		}
	}
	
	/**
	 * 替换PromotionPane的内容，将其设为contentGridPane的子女显示 
	 * 并更改pageNumLabel和pageNum
	 * @param page
	 */
	private void switchCurrentPage(int toPageNum) {

		//修改currentNamePanes和currentDetailPanes
		currentPromotionPanes = new ArrayList<>();
		//当前页面要显示的第一个促销策略在list中的位置
		int fromNum = (toPageNum - 1) * NUM_OF_PROMOTION_PER_PAGE;
		//当前页面要显示的最后一个促销策略在list中的位置
		int toNum = (toPageNum - 1) * NUM_OF_PROMOTION_PER_PAGE + Math.min(NUM_OF_PROMOTION_PER_PAGE,
				promotionList.size() - NUM_OF_PROMOTION_PER_PAGE * (toPageNum - 1));
		//当前页面显示的促销策略总数
		int promotionNums = toNum - fromNum;
		//最大页码数
		int maxPageNum = (promotionList.size() + NUM_OF_PROMOTION_PER_PAGE - 1) / NUM_OF_PROMOTION_PER_PAGE;
		// 如果将要调到的页面上的促销策略数量不大于0并且不是第一页
		// 那么跳到最后一页
		if ((promotionNums <= 0) && (toPageNum > FIRST_PAGE_NUM)) {
			switchCurrentPage(maxPageNum);
			return;
		}
		for (int i = fromNum; i < toNum; i++) {
			currentPromotionPanes.add(new PromotionPane(promotionList.get(i)));
			
		}
		
		//修改contentGridPane
		int lastIndex = 0;
		contentGridPane.getChildren().clear();
		for (int i = 0; i < promotionNums; i++) {
			PromotionPane promotionPane = currentPromotionPanes.get(i);
			contentGridPane.add(promotionPane, 0, i * 2);
			lastIndex++;
		}
		for (int i = lastIndex; i < NUM_OF_PROMOTION_PER_PAGE; i++) {
			AnchorPane blackPane = new AnchorPane();
			blackPane.setStyle("-fx-background-color: rgba(0,20,81,0.45)");
			contentGridPane.add(blackPane, 0, i * 2);
		}
		
		//修改pageNum
		pageNum = toPageNum;
		pageNumLabel.setText(String.valueOf(pageNum));
		jumpField.setText("");
		
	}
	
	/**
	 * 内部类。每个页面上有若干个PromotionPane，每个PromotionPane上显示一个促销策略的信息
	 * @author gyue
	 */
	class PromotionPane extends AnchorPane {
		Text name;
		
		Text type;
		
		Text discount;
		
		Button detail;
		
		Button delete;
		
		PromotionPane(PromotionVO vo) {
			name = new Text(vo.name);
			type = new Text(vo.type);
			discount = new Text(String.valueOf(vo.discount) + "折");
			detail = new Button("详情");
			delete = new Button("删除");
			
			// set effect
			this.setStyle("-fx-background-color: rgba(0,20,81,0.45)");
			name.setFont(Font.font("Microsoft YaHei Light", 19));
			name.setStyle("-fx-fill: white");
			name.setWrappingWidth(183.0);
			name.setTextAlignment(TextAlignment.CENTER);
			type.setFont(Font.font("Microsoft YaHei Light", 19));
			type.setStyle("-fx-fill: white");
			type.setWrappingWidth(183.0);
			type.setTextAlignment(TextAlignment.CENTER);
			discount.setFont(Font.font("Microsoft YaHei Light", 19));
			discount.setStyle("-fx-fill: white");
			discount.setWrappingWidth(110.0);
			discount.setTextAlignment(TextAlignment.CENTER);
			detail.setFont(Font.font("Microsoft YaHei", 15));
			detail.setStyle("-fx-background-color: rgba(0,20,81,0.45); -fx-text-fill: white");
			delete.setFont(Font.font("Microsoft YaHei", 15));
			delete.setStyle("-fx-background-color: rgba(0,20,81,0.45); -fx-text-fill: white");
			
			// add node
			this.getChildren().add(name);
			this.getChildren().add(type);
			this.getChildren().add(discount);
			this.getChildren().add(detail);
			this.getChildren().add(delete);
			
			// set location
			AnchorPane.setBottomAnchor(name, 10.0);
			AnchorPane.setTopAnchor(name, 10.0);
			AnchorPane.setLeftAnchor(name, 0.0);
			AnchorPane.setRightAnchor(name, 540.0);
			
			AnchorPane.setBottomAnchor(type, 10.0);
			AnchorPane.setTopAnchor(type, 10.0);
			AnchorPane.setLeftAnchor(type, 183.0);
			AnchorPane.setRightAnchor(type, 360.0);
			
			AnchorPane.setBottomAnchor(discount, 10.0);
			AnchorPane.setTopAnchor(discount, 10.0);
			AnchorPane.setLeftAnchor(discount, 366.0);
			AnchorPane.setRightAnchor(discount, 250.0);
			
			AnchorPane.setBottomAnchor(detail, 11.0);
			AnchorPane.setTopAnchor(detail, 10.0);
			AnchorPane.setLeftAnchor(detail, 569.0);
			AnchorPane.setRightAnchor(detail, 87.0);
			
			AnchorPane.setBottomAnchor(delete, 11.0);
			AnchorPane.setTopAnchor(delete, 10.0);
			AnchorPane.setLeftAnchor(delete, 649.0);
			AnchorPane.setRightAnchor(delete, 7.0);
			
			// add listener
			detail.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					modifyPromotion(vo);
				}
			});
			delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					deletePromotion(vo.promotionID);
				}
				
			});
		}
		
	}

}
