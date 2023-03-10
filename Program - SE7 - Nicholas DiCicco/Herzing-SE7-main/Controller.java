package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {
	
	@FXML
	private AnchorPane AnchorPane_Main;
	
	@FXML
	private Button productMGRBtn, foodMGRBtn, frontSRVBtn, tableSRVBtn, OMSBtn;
	
	@FXML
	private Label Main_Label, Footer_Label;

	@FXML
	private MenuItem new_file, open, save, settings, exit, about;
	
	@FXML
	private MenuItem ProductManager, FoodManager, FrontService, TableManager;
	
	private Parent root;	
	private Stage stage;
	private Scene scene;
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		
		if (event.getSource() == about) {
			System.out.println(" ABOUT ITEM");
		}//end IF condition
		else if (event.getSource() == exit) {
			System.out.println(" Goodbye & Locked!");
			JDBC.close();
			System.exit(0);
		}//end ELSE IF
		else if (event.getSource() == new_file) {
			System.out.println(" NEW ITEM");
		}//end ELSE IF
		else if (event.getSource() == open) {
			System.out.println(" OPEN ITEM");
		}//end ELSE IF
		else if (event.getSource() == save) {
			System.out.println(" SAVE ITEM");
		}//end ELSE IF
		else if (event.getSource() == settings) {
			System.out.println(" SAVE ITEM");
		}//end ELSE IF
		else if (event.getSource() == ProductManager || event.getSource() == productMGRBtn){
			System.out.println(" PRODUCT MANAGER");
			root = FXMLLoader.load(getClass().getResource("Product.fxml"));
			stage = (Stage) AnchorPane_Main.getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF
		else if (event.getSource() == FoodManager || event.getSource() == foodMGRBtn){
			System.out.println(" FOOD MANAGER");
			root = FXMLLoader.load(getClass().getResource("Product.fxml"));
			stage = (Stage) AnchorPane_Main.getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF

	}//end handleButtonAction method
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// open database
		JDBC.connect();
	}//end method initialize
		
}//end class Controller
