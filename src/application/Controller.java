package application;

import java.io.File;


import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.application.HostServices;
import javafx.application.*;

public class Controller extends Application {

    @FXML
    private ImageView imgview;
    
    @FXML
    private ImageView imgviewMoon;

    @FXML
    private Slider slider;
    
    @FXML
    private Hyperlink linkKetu;
    
    @FXML
    private AnchorPane anchor1;
    
    @FXML
    private TextField txtstage1;
    


    
    public TextField getTxtstage1() {
		return txtstage1;
	}



	Image noor_dite = new Image(getClass().getResourceAsStream("Noor_Dite.jpg"));
	Image moon  =  new Image(getClass().getResourceAsStream("moon.png"));
	Image noor_nate  =  new Image(getClass().getResourceAsStream("Noor_Nate.jpg"));


	public void switchDite() {
    	imgview.setImage(noor_dite);
    	anchor1.setStyle("-fx-background-color: #fcfcfc; ");
    	imgviewMoon.setImage(null);
    	
    }
    public void switchNate() {
    	imgview.setImage(noor_nate);
    	imgviewMoon.setImage(moon);
    	anchor1.setStyle("-fx-background-color: #9ab3b7; ");
    }
    
    public void initialize() {
    	    	
    	double gjeresi1 = imgview.getFitWidth();
    	double gjatesi1 = imgview.getFitHeight();
    	
    	double gjeresi2 = imgviewMoon.getFitWidth();
    	double gjatesi2 = imgviewMoon.getFitHeight();
    	
    	slider.valueProperty().addListener((o, oldV, newV) ->{
    		imgview.setFitWidth(gjeresi1 + (newV.intValue()*6));
    		imgview.setFitHeight(gjatesi1 + (newV.intValue()*6));
    		
    		imgviewMoon.setFitWidth(gjeresi2 + (newV.intValue()));
    		imgviewMoon.setFitHeight(gjatesi2 + (newV.intValue()));
    		
    		System.out.println(imgview.getFitWidth() );
        	System.out.println(imgview.getFitHeight() );
    		
    	}
    	);
    	
    	linkKetu.setOnAction((veprim) -> {
    		try {
        		Stage stage = new Stage();
        		
        		FileChooser fileChooser = new FileChooser();
        		System.out.println(System.getProperty("user.home"));
        		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+"\\Downloads\\Manual Historik"));
        		
        		File file = fileChooser.showOpenDialog(stage);
        		
        		//shfaq dokumentin
                HostServices hs =  getHostServices();
                hs.showDocument(file.getAbsolutePath());
      
        		
        	
    		}catch(Exception e) {
    			
    		}

    	});

    }



	@Override
	public void start(Stage arg0) throws Exception {
	}




}
