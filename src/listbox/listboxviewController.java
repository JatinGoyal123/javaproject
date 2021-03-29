package listbox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class listboxviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> txtcombo;

    @FXML
    private ListView<String> txtlist;

    @FXML
    private Button btnshow;

    @FXML
    private Button btnclear;

    @FXML
    private Button btndelete;

    @FXML
    private Label txtlabel;
   
    
    @FXML
    void doselect(ActionEvent event) {
    	ArrayList<String>mob=new ArrayList<String>(Arrays.asList("Apple","One Plus","Samsung","Redmi"));
    	ArrayList<String>lap=new ArrayList<String>(Arrays.asList("MacBook","HP","DELL","Asus"));
    	String item=txtcombo.getSelectionModel().getSelectedItem();
    	txtlist.getItems().clear();
    	if(item.equals("Mobile"))
    	{
    		//ArrayList<String>bok=new ArrayList<String>(Arrays.asList("Real jAva","Let us C","Robert LAfore"));
    		txtlist.getItems().addAll(mob);
    	}
    	else if(item.equals("Laptop"))
    	{
    		//ArrayList<String>mob=new ArrayList<String>(Arrays.asList("One Plus","Iphone11","Samsung"));
    		txtlist.getItems().addAll(lap);
    	}
    	else
    	{
    		
    	}
    }


    @FXML
    void doclear(ActionEvent event) {
    	txtlist.getItems().clear();

    }

    @FXML
    void dodelete(ActionEvent event) {
    	//String name=txtlist.getSelectionModel().getSelectedItem();
    	
    	//txtlist.getItems().removeAll(name);
    	ObservableList<String>item=txtlist.getSelectionModel().getSelectedItems();
    	for(String s:item)
    	{
    		txtlist.getItems().removeAll(s);
    	}
    	
    	
    }

    @FXML
    void doshow(ActionEvent event) {
    	String all="";
    	String all2="";
    	ObservableList<String>sname=txtlist.getSelectionModel().getSelectedItems();
    	ObservableList<Integer>indx=txtlist.getSelectionModel().getSelectedIndices();
    	for(String str:sname)
    	{
    		all=all+str+",";
    	}
    	for(int i:indx)
    	{
    		all2=all2+i+",";
    		
    	}
    	txtlabel.setText(all+"      "+all2);
    	
    }

    @FXML
    void initialize() {
    	ArrayList<String>lst=new ArrayList<String>(Arrays.asList("Select","Mobile","Laptop"));
    	txtcombo.getItems().addAll(lst);
    	txtcombo.getSelectionModel().select(0);
    	txtlist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
        assert txtcombo != null : "fx:id=\"txtcombo\" was not injected: check your FXML file 'listboxview.fxml'.";
        assert txtlist != null : "fx:id=\"txtlist\" was not injected: check your FXML file 'listboxview.fxml'.";
        assert btnshow != null : "fx:id=\"btnshow\" was not injected: check your FXML file 'listboxview.fxml'.";
        assert btnclear != null : "fx:id=\"btnclear\" was not injected: check your FXML file 'listboxview.fxml'.";
        assert btndelete != null : "fx:id=\"btndelete\" was not injected: check your FXML file 'listboxview.fxml'.";
        assert txtlabel != null : "fx:id=\"txtlabel\" was not injected: check your FXML file 'listboxview.fxml'.";

    }
}
