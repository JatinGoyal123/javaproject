package combobox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class comboboxviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combotext;

    @FXML
    private Button btnselected;
    @FXML
    private ListView<String> txtlist;

    @FXML
    private ComboBox<String> combobox2;

    @FXML
    void doselect(ActionEvent event) {
    	String item=combotext.getSelectionModel().getSelectedItem();
    	combobox2.getItems().clear();
    	txtlist.getItems().clear();
    	if(item.equals("Books"))
    	{
    		ArrayList<String>bok=new ArrayList<String>(Arrays.asList("Real jAva","Let us C","Robert LAfore"));
    		combobox2.getItems().addAll(bok);
    		txtlist.getItems().addAll(bok);
    	}
    	else if(item=="Mobiles")
    	{
    		ArrayList<String>mob=new ArrayList<String>(Arrays.asList("One Plus","Iphone11","Samsung"));
    		combobox2.getItems().addAll(mob);
    		txtlist.getItems().addAll(mob);
    	}
    	else if(item=="Laptop")
    	{
    			ArrayList<String>lap=new ArrayList<String>(Arrays.asList("MAcBook","Hp","Dell"));
        		combobox2.getItems().addAll(lap);
        		txtlist.getItems().addAll(lap);
        	
    	}
    	else
    	{
    		
    	}
    	
    		showMsg(item);
    }
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Items");
    	alert.setContentText(msg);
    	alert.show();
    }
    @FXML
    void doselectcombo(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	ArrayList<String>ls=new ArrayList<String>(Arrays.asList("Select","Book","Mobiles","Laptop"));
    	combotext.getItems().addAll(ls);
        assert combotext != null : "fx:id=\"combotext\" was not injected: check your FXML file 'comboboxview.fxml'.";
        assert btnselected != null : "fx:id=\"btnselected\" was not injected: check your FXML file 'comboboxview.fxml'.";
        assert combobox2 != null : "fx:id=\"combobox2\" was not injected: check your FXML file 'comboboxview.fxml'.";

    }
}
