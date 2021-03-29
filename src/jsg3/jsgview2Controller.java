package jsg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class jsgview2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName1;

    @FXML
    private TextField txtName2;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSub;

    @FXML
    private Button btnMulti;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnClear;

    @FXML
    private TextField sum;

    @FXML
    private TextField product;

    @FXML
    private TextField divide;

    @FXML
    private TextField subtract;

    @FXML
    void doAdd(ActionEvent event) {
    	
    	String n1=txtName1.getText();	
    	String n2=txtName2.getText();
    Integer add=Integer.parseInt(n1)+Integer.parseInt(n2);
    sum.setText(String.valueOf(add));
    System.out.println(add);
    
    	
  

    }

    @FXML
    void doClear(ActionEvent event) {
    	txtName1.setText("");
    	txtName2.setText("");
    	sum.setText("");
    	product.setText("");
    	divide.setText("");
    	subtract.setText("");

    }

    @FXML
    void doDivide(ActionEvent event) {
      	String n1=txtName1.getText();	
    	String n2=txtName2.getText();
    Integer add=Integer.parseInt(n1)/Integer.parseInt(n2);
    divide.setText(String.valueOf(add));
    System.out.println(add);
    
    	
  

    }

    @FXML
    void doMulti(ActionEvent event) {
      	String n1=txtName1.getText();	
    	String n2=txtName2.getText();
    Integer add=Integer.parseInt(n1)*Integer.parseInt(n2);
    product.setText(String.valueOf(add));
    System.out.println(add);
    
    	
  

    }

    @FXML
    void doSub(ActionEvent event) {
      	String n1=txtName1.getText();	
    	String n2=txtName2.getText();
    Integer add=Integer.parseInt(n1)-Integer.parseInt(n2);
    subtract.setText(String.valueOf(add));
    System.out.println(add);
    
    	
  

    }

    @FXML
    void initialize() {
        assert txtName1 != null : "fx:id=\"txtName1\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert txtName2 != null : "fx:id=\"txtName2\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert btnSub != null : "fx:id=\"btnSub\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert btnMulti != null : "fx:id=\"btnMulti\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert sum != null : "fx:id=\"sum\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert product != null : "fx:id=\"product\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert divide != null : "fx:id=\"divide\" was not injected: check your FXML file 'jsgview2.fxml'.";
        assert subtract != null : "fx:id=\"subtract\" was not injected: check your FXML file 'jsgview2.fxml'.";

    }
}
