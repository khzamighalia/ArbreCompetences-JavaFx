package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try { 
			//Parent root = FXMLLoader.load(getClass().getResource("Loginfxml.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("competences.fxml"));
			primaryStage.setTitle(" Arbre de compétences ");
			primaryStage.setScene(new Scene(root));
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}