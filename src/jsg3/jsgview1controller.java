package jsg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class jsgview1controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblName1;

    @FXML
    private Label lblName2;

    @FXML
    private TextField txtName1;

    @FXML
    private TextField txtName2;

    @FXML
    private TextField lblName3;

    @FXML
    private Button btnJoin;

    @FXML
    void doJoin(ActionEvent event) {
    	String name1=txtName1.getText();
    	String name2=txtName2.getText();
    	String name3=name1.concat(name2);
    	System.out.println("Full Name: "+name3);
    	lblName3.setText(name3);
    	
    }

    @FXML
    void initialize() {
        assert lblName1 != null : "fx:id=\"lblName1\" was not injected: check your FXML file 'jsgview1.fxml'.";
        assert lblName2 != null : "fx:id=\"lblName2\" was not injected: check your FXML file 'jsgview1.fxml'.";
        assert txtName1 != null : "fx:id=\"txtName1\" was not injected: check your FXML file 'jsgview1.fxml'.";
        assert txtName2 != null : "fx:id=\"txtName2\" was not injected: check your FXML file 'jsgview1.fxml'.";
        assert lblName3 != null : "fx:id=\"lblName3\" was not injected: check your FXML file 'jsgview1.fxml'.";
        assert btnJoin != null : "fx:id=\"btnJoin\" was not injected: check your FXML file 'jsgview1.fxml'.";

    }
}
