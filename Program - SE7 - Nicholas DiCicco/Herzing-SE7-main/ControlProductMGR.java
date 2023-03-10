package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControlProductMGR implements Initializable {
	
	@FXML
	private AnchorPane AnchorPane_Product;

	@FXML
	private Button homeBtn, refreshBtn, saveBtn, editBtn, delBtn;
	
	@FXML
	private Label Main_Label, Footer_Label, Header_Label, ID_Label; 
	
	@FXML
	private Label Count_Label;

	@FXML
	private MenuItem new_file;

	@FXML
	private MenuItem open, save, settings, exit, about;
	
	@FXML
	private MenuItem ProductManager, FoodManager, FrontService, TableManager;
	
	@FXML
	private TableColumn<Product, Integer> ID_Column;

	@FXML
	private TableColumn<Product, String> Name_Column;
	
	@FXML
	private TableColumn<Product, String> Sku_Column;
	
	@FXML
	private TableColumn<Product, Integer> Quantity_Column;
	
	@FXML
	private TableColumn<Product, Double> Price_Column;
	
	@FXML
	private TableView<Product> Product_Table;

	@FXML
	private TextField nameTextField, skuTextField, quantityTextField, priceTextField;
	
	private Parent root;	
	private Stage stage;
	private Scene scene;
	private Product Selected_Product;
	private ArrayList<Product> product_list = new ArrayList<>();
	private String name, sku;
	private int product_count, quantity, current_productID;
	private Double price;

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// load & count paychecks
		product_list = JDBC.loadProducts();
		product_count = JDBC.countProducts();
		
		
		
		Count_Label.setText("Product Count: " + product_count);
		
		Name_Column.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		Sku_Column.setCellValueFactory(new PropertyValueFactory<Product, String>("sku"));
		Quantity_Column.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
		Price_Column.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		Name_Column.setStyle( "-fx-alignment: CENTER-LEFT;");
		Sku_Column.setStyle( "-fx-alignment: CENTER-LEFT;");
		Quantity_Column.setStyle( "-fx-alignment: CENTER-LEFT;");
		Price_Column.setStyle( "-fx-alignment: CENTER-LEFT;");
		
		Product_Table.getItems().addAll(product_list);
		
		
		Product_Table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Product>() {
			@Override
			public void changed(ObservableValue<? extends Product> arg0, Product arg1, Product arg2) {
				Selected_Product = Product_Table.getSelectionModel().getSelectedItem();
				Header_Label.setText("Edit Product");
				saveBtn.setDisable(true);
				editBtn.setDisable(false);
				delBtn.setDisable(false);
				current_productID = Selected_Product.getID();
				ID_Label.setText("Product ID: " + Selected_Product.getID());
				nameTextField.setText(Selected_Product.getName());
				skuTextField.setText(Selected_Product.getSku());
				quantityTextField.setText(String.valueOf(Selected_Product.getQuantity()));
				priceTextField.setText(String.valueOf(Selected_Product.getPrice()));
			}
		});//end method ChangeListener

		
	}//end method initialize

	
	
	@FXML
	private void handleButtonAction(ActionEvent event) throws IOException {
		
		if (event.getSource() == exit) {
			System.out.println(" Goodbye & Locked!");
			JDBC.close();
			System.exit(0);
		}//end IF condition
		else if (event.getSource() == about) {
			System.out.println(" ABOUT ITEM");
		}//end ELSE IF
		else if (event.getSource() == new_file) {
			System.out.println(" NEW ITEM");
		}//end ELSE IF
		else if (event.getSource() == open) {
			System.out.println(" OPEN ITEM");
		}//end ELSE IF
		//else if (event.getSource() == save) {
			//System.out.println(" SAVE ITEM");
		//}//end ELSE IF
		else if(event.getSource() == ProductManager || event.getSource() == refreshBtn){
			System.out.println(" PRODUCT MANAGER ITEM");
			Header_Label.setText("Add Product");
			root = FXMLLoader.load(getClass().getResource("Product.fxml"));
			stage = (Stage) AnchorPane_Product.getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF
		else if (event.getSource() == ProductManager){
			System.out.println(" PRODUCT MANAGER");
			root = FXMLLoader.load(getClass().getResource("Product.fxml"));
			stage = (Stage) AnchorPane_Product.getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF
		else if (event.getSource() == FoodManager){
			System.out.println(" FOOD MANAGER");
			root = FXMLLoader.load(getClass().getResource("Product.fxml"));
			stage = (Stage) AnchorPane_Product.getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF
		else if (event.getSource() == homeBtn){
			System.out.println(" HOME");
			root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			stage = (Stage) AnchorPane_Product.getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF
		
		else if(event.getSource() == saveBtn || event.getSource() == save) {
			System.out.println(" SAVE PRODUCT");
			name = nameTextField.getText();
			sku = skuTextField.getText();
			quantity = Integer.parseInt(quantityTextField.getText());
			price = Double.parseDouble(priceTextField.getText());
			try {
				//cycle = Integer.parseInt(addCycleTextField.getText());
				//cycleErrorLabel.setText("");
			}//end TRY
			catch(java.lang.RuntimeException runTimeExcpt) {
				//cycleErrorLabel.setText("Billing Cycle Not Valid!");
			}//end CATCH block
			
			if (name.isEmpty()) {
				System.out.println(" NAME IS EMPTY!");
				//nameErrorLabel.setText("Please Enter Name!");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else if (sku.isEmpty()) {
				System.out.println(" SKU IS EMPTY!");
				//accountErrorLabel.setText("Please Enter Account Number!");
				//nameErrorLabel.setText("");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else if (quantity == 0) {
				System.out.println(" QUANTITY IS 0!");
				//phoneErrorLabel.setText("Please Enter Phone Number!");
				//accountErrorLabel.setText("");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else if (price == 0.0) {
				System.out.println(" PRICE IS 0!");
				//cycleErrorLabel.setText("Please Enter Billing Cycle!");
				//phoneErrorLabel.setText("");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else {
				//resultLabel.setText("");
				//nameTextField.setText("");
				//skuTextField.setText("");
				//quantityTextField.setText("");
				//priceTextField.setText("");
				Product product = new Product(name, sku, quantity, price);
				int lastID = JDBC.addProduct(product);
				product.setID(lastID);
				System.out.println(" Last ID Added: " + lastID);
				refreshPage();
				//resultLabel.setText("Success! Profile Added");
			}//end ELSE
						
		}//end ELSE IF
		
		
		else if(event.getSource() == editBtn) {
			System.out.println(" EDIT PRODUCT");
			name = nameTextField.getText();
			sku = skuTextField.getText();
			quantity = Integer.parseInt(quantityTextField.getText());
			price = Double.parseDouble(priceTextField.getText());
			try {
				//cycle = Integer.parseInt(addCycleTextField.getText());
				//cycleErrorLabel.setText("");
			}//end TRY
			catch(java.lang.RuntimeException runTimeExcpt) {
				//cycleErrorLabel.setText("Billing Cycle Not Valid!");
			}//end CATCH block
			
			if (name.isEmpty()) {
				System.out.println(" NAME IS EMPTY!");
				//nameErrorLabel.setText("Please Enter Name!");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else if (sku.isEmpty()) {
				System.out.println(" SKU IS EMPTY!");
				//accountErrorLabel.setText("Please Enter Account Number!");
				//nameErrorLabel.setText("");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else if (quantity == 0) {
				System.out.println(" QUANTITY IS 0!");
				//phoneErrorLabel.setText("Please Enter Phone Number!");
				//accountErrorLabel.setText("");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else if (price == 0.0) {
				System.out.println(" PRICE IS 0!");
				//cycleErrorLabel.setText("Please Enter Billing Cycle!");
				//phoneErrorLabel.setText("");
				//resultLabel.setText("All Fields Required!");
			}//end IF condition
			else {
				//resultLabel.setText("");
				//addNameTextField.setText("");
				//addAccountTextField.setText("");
				//addPhoneTextField.setText("");
				//addCycleTextField.setText("");
				
				Product Original_Product = new Product();
				Product Edited_Product = new Product(current_productID, name, sku, quantity, price);
				
				for (Product current_product : product_list) {
					if (current_product.getID() == current_productID) {
						Original_Product = current_product;
					}//end IF condition
				}//end FOREACH loop
				
				if (Original_Product.equals(Edited_Product)) {
					System.out.println(" Updated Failed! Likely Duplicate Data");
					//resultLabel.setText("Updated Failed");
					//nameTextField.setText(name);
					//addAccountTextField.setText(account);
					//addPhoneTextField.setText(phone);
					//addCycleTextField.setText(String.valueOf(cycle));
				}//end IF condition
				else {
					String sql = "UPDATE product SET name = '" + name + "', sku = '" + sku + 
											"', quantity = '" + quantity + "', price = '" + price +
											"' WHERE id = " + Edited_Product.getID();
					JDBC.updateProduct(sql);
					System.out.println(" PRODUCT Updated Successfully!");
					refreshPage();
					//resultLabel.setText("Success! Profile Updated");
				}//end ELSE
				
			}//end ELSE
					
		}//end ELSE IF
		
		
		else if(event.getSource() == delBtn){
			System.out.println(" DELETE PRODUCT");
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductDelete.fxml"));
			root = loader.load();
			ControlProductDel controlDel = loader.getController();
			controlDel.setProductToBeDeleted(Selected_Product);
			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}//end ELSE IF




	}//end handleButtonAction method
	
	@FXML
	public void refreshPage() throws IOException{
		System.out.println(" PRODUCT MANAGER REFRESH METHOD");
		Header_Label.setText("Add Product");
		root = FXMLLoader.load(getClass().getResource("Product.fxml"));
		stage = (Stage) AnchorPane_Product.getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}//end method refreshPage

}//end class ControllerProduct
