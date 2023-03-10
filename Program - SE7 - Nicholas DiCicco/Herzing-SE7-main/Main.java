package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon = new Image("globe04.jpg");
			
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(icon);
			primaryStage.setTitle("Restaurant Order Management System");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}//end try/catch block
	}//end start method
	
	public static void main(String[] args) {
		launch(args);
	}//end main method
}//end Main class
