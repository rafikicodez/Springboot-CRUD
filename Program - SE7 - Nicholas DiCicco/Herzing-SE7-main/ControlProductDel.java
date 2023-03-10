package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


public class ControlProductDel {
	
	
	@FXML
	private AnchorPane AnchorPane_ProductDel;
	
	@FXML
	private Button deleteBtn;
		
	@FXML
	private Button closeBtn;
		
	@FXML
	private Label Focus_Label;

	@FXML
	private Label Result_Label, Question_Label;
	
	@FXML
	private RadioButton yesRadio, noRadio;
	
	@FXML
	private ToggleGroup Choice;


	private Product product;	

	
	
	// handle all button actions
	public void handleButtonAction(ActionEvent event) throws IOException {
		
		if(event.getSource() == deleteBtn) {
			System.out.println(" DELETE BUTTON");
			if (yesRadio.isSelected()) {
				
				System.out.println(" YES RADIO BUTTON");
				
				int rows_affected = JDBC.deleteProduct(product.getID());
				int profile_count = JDBC.countProducts();
				Result_Label.setText(product.getName() + " is Deleted. Rows Affected: " + rows_affected);
				Question_Label.setText("The Profile Count is: " + profile_count);
				Focus_Label.setText("");
								
			}//end IF condition
			else if (noRadio.isSelected()) {
				Result_Label.setText("Delete Product Failed");
				Question_Label.setText("CHANGED YOUR MIND?");
			}//end ELSE IF condition
			else {
				Result_Label.setText("PLEASE CHOOSE YES OR NO");
				//Question_Label.setText("Please Choose Yes or No!");
			}//end ELSE 

		}//end IF condition 1
		else if(event.getSource() == closeBtn) {
			System.out.println(" CLOSE DELETE PRODUCT STAGE");
			((Node)(event.getSource())).getScene().getWindow().hide();
		}//end ELSE IF condition 2
	}//end method handleButtonAction


	public void setProductToBeDeleted(Product product) {
		this.product = product;
		Focus_Label.setText(product.getName());
	}//end method displayProduct


}//end class ControlProductDel
