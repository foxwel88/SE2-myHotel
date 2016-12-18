package org.client.presentation.webmarketer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.client.vo.PromotionVO;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
	
	@FXML
    void addPromotion(MouseEvent event) {
		Parent modifyRoot = null;
		FXMLLoader loader = new FXMLLoader();
		try {
			modifyRoot = loader.load(getClass().getResource("/网站营销人员/修改促销策略界面.fxml").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
	}
	
	private void modifyPromotion(PromotionVO promotionVO) {
		Parent modifyRoot = null;
		FXMLLoader loader = new FXMLLoader();
		try {
			modifyRoot = loader.load(getClass().getResource("/网站营销人员/修改促销策略界面.fxml").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentPane.getChildren().set(1, modifyRoot);
		GridPane.setConstraints(modifyRoot, 1, 0);
		
		((WebMarketerModifyPromotion)loader.getController()).setPromotionVO(promotionVO);
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
	 * 替换NamePane和DetailPane的内容，将其设为contentGridPane的子女显示 
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
		if ((promotionNums <= 0) && (toPageNum > FIRST_PAGE_NUM)) { //当前页面显示促销策略数量不小于0
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
			blackPane.setStyle("-fx-background-color:rgba(0,0,0,0.45)");
			contentGridPane.add(blackPane, 0, i * 2);
		}
		
		//修改pageNum
		pageNum = toPageNum;
		pageNumLabel.setText(String.valueOf(pageNum));
		jumpField.setText("");
		
	}
	
	class PromotionPane extends AnchorPane {
		Text name;
		
		Text type;
		
		Text discount;
		
		Button detail;
		
		PromotionPane(PromotionVO vo) {
			name = new Text(vo.name);
			type = new Text(vo.type);
			discount = new Text(String.valueOf(vo.discount));
			detail = new Button("详情");
			
			// set effect
			this.setStyle("-fx-background-color:rgba(0,0,0,0.45)");
			name.setFont(Font.font("Microsoft YaHei Light", 20));
			name.setStyle("-fx-fill: white");
			name.setWrappingWidth(183.0);
			name.setTextAlignment(TextAlignment.CENTER);
			type.setFont(Font.font("Microsoft YaHei Light", 20));
			type.setStyle("-fx-fill: white");
			type.setWrappingWidth(183.0);
			type.setTextAlignment(TextAlignment.CENTER);
			discount.setFont(Font.font("Microsoft YaHei Light", 20));
			discount.setStyle("-fx-fill: white");
			discount.setWrappingWidth(110.0);
			discount.setTextAlignment(TextAlignment.CENTER);
			detail.setFont(Font.font("Microsoft YaHei", 15));
			detail.setStyle("-fx-background-color:rgba(0,0,0,0.2); -fx-text-fill: white");
			
			// add node
			this.getChildren().add(name);
			this.getChildren().add(type);
			this.getChildren().add(discount);
			this.getChildren().add(detail);
			
			// set location
			AnchorPane.setBottomAnchor(name, 10.0);
			AnchorPane.setTopAnchor(name, 10.0);
			AnchorPane.setLeftAnchor(name, 0.0);
			AnchorPane.setRightAnchor(name, 540.0);
			
			AnchorPane.setBottomAnchor(type, 10.0);
			AnchorPane.setTopAnchor(type, 10.0);
			AnchorPane.setLeftAnchor(discount, 222.0);
			AnchorPane.setRightAnchor(type, 319.0);
			
			AnchorPane.setBottomAnchor(discount, 10.0);
			AnchorPane.setTopAnchor(discount, 10.0);
			AnchorPane.setLeftAnchor(discount, 426.0);
			AnchorPane.setRightAnchor(discount, 189.0);
			
			AnchorPane.setBottomAnchor(detail, 11.0);
			AnchorPane.setTopAnchor(detail, 10.0);
			AnchorPane.setLeftAnchor(detail, 633.0);
			AnchorPane.setRightAnchor(detail, 23.0);
			
			// add listener
			detail.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					modifyPromotion(vo);
				}
			});
		}
		
	}

}
