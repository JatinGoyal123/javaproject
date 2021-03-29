package jsg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class jsgviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnshow;

    @FXML
    private Label showentered;

    @FXML
    private ImageView txtpic;
    
    List<String>lst;
    
    @FXML
    void showname(ActionEvent event) {
    	FileChooser fc=new FileChooser();
    	fc.getExtensionFilters().add(new ExtensionFilter("Images",lst));
    	File img=fc.showOpenDialog(null);
    	Image pic=null;
    	try {
			pic=new Image(new FileInputStream(img));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(img!=null)
    	{
    		 txtpic.setImage(pic);
    		 showentered.setText(img.getAbsolutePath());
    	}
    }

    @FXML
    void initialize() {
    	lst=new ArrayList<>();
    	lst.add("*.jpg");
    	lst.add("*.png");
    	lst.add("*.jpeg");
    	lst.add("*.");
    	assert btnshow != null : "fx:id=\"btnshow\" was not injected: check your FXML file 'jsgview.fxml'.";
        assert showentered != null : "fx:id=\"showentered\" was not injected: check your FXML file 'jsgview.fxml'.";
        assert txtpic != null : "fx:id=\"txtpic\" was not injected: check your FXML file 'jsgview.fxml'.";

    }
}
