package jsg2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class jsgviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnHello;

    @FXML
    private Label lblName;

    @FXML
    private TextField txtName;

    @FXML
    void doHello(ActionEvent event) {
    	String name=txtName.getText();
    	System.out.println("Hello "+name);
    	//lblName.setText("Hello:"+name);
    }

    @FXML
    void initialize() {
        assert btnHello != null : "fx:id=\"btnHello\" was not injected: check your FXML file 'jsgview.fxml'.";
        assert lblName != null : "fx:id=\"lblName\" was not injected: check your FXML file 'jsgview.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'jsgview.fxml'.";

    }
}
