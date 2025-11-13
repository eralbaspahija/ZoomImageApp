package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader firstLoader =new FXMLLoader(getClass().getResource("DritareImazhi.fxml"));
			AnchorPane firstRoot = firstLoader.load();
			Scene firstScene = new Scene(firstRoot);
			primaryStage.setTitle("Stage i pare");
			primaryStage.setScene(firstScene);
			primaryStage.setX(400);
			primaryStage.setY(3);
			primaryStage.show();
			
			FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("Dark_Light.fxml"));
			AnchorPane secondRoot = secondLoader.load();
			Scene secondScene = new Scene(secondRoot);
			Stage secondStage = new Stage();
			secondStage.setTitle("Stage i dyte");
			secondStage.setScene(secondScene);
			secondStage.setX(1010);
			secondStage.setY(20);
			secondStage.show();
			
			//marrja e kontroller per secilin stage
			Controller controller_obj1 = firstLoader.getController();
			Controller_Dite_Nate  controller_obj_DN = secondLoader.getController();
			
			//caktojme vleren e textfield nga stage 1 per te qene vlera fillestare e textfiled
			String text = controller_obj1.getTxtstage1().getText();
			controller_obj_DN.getTxtstage2().setText(text);
			
			//listeners
			controller_obj1.getTxtstage1().textProperty().addListener((observable, oldValue, newValue)->{
				controller_obj_DN.getChck_neRregull().setSelected(false);
				controller_obj_DN.getTxtstage2().setText(newValue);
			});
			
			controller_obj_DN.getTxtstage2().textProperty().addListener((observable, oldValue, newValue) -> {
				controller_obj_DN.getChck_neRregull().setSelected(false);
				controller_obj1.getTxtstage1().setText(newValue);
			});
			
			// listener checkbox
			controller_obj_DN.getChck_neRregull().setOnAction((veprim) ->{
				if(controller_obj_DN.getTxtstage2().getText().equals("Dite")) {
					controller_obj1.switchDite();
				}else if(controller_obj_DN.getTxtstage2().getText().equals("Nate")) {
					controller_obj1.switchNate();
				}
				
			});
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
