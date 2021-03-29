package chkrad;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class chkradioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox chkall;

    @FXML
    private CheckBox chkbook;

    @FXML
    private CheckBox chkmob;

    @FXML
    private CheckBox chklap;

    @FXML
    private RadioButton radio10;

    @FXML
    private ToggleGroup discount;

    @FXML
    private RadioButton radio20;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtTotal;

    @FXML
    private TextField txtBill;

    @FXML
    private Button getBill;

    @FXML
    void doBill(ActionEvent event) {
    	int total=0;
    	if(chkbook.isSelected()==true)
    	{
    		total+=500;
    	}
    	if(chkmob.isSelected()==true)
    	{	total+=25000;}
    	if(chklap.isSelected()==true)
    		{total+=70000;}
    	if(total==0)
    	{
    		txtBill.setText("No amount selected");
    	}
    	if(total!=0)
    	{
    		int dis=0;
    		if(radio10.isSelected()==true)
    			{dis=10;}
    		else
    			{dis=20;}
    		int bill=(total*dis)/100;
    		int net=total-bill;
    		txtTotal.setText(String.valueOf(total));
    		txtDiscount.setText(String.valueOf(bill));
    		txtBill.setText(String.valueOf(net));
    	}
    	
    	
    }

    @FXML
    void doBook(ActionEvent event) {
    		if(chkbook.isSelected()==false)
    		{
    			chkall.setSelected(false);
    		}
    }

    @FXML
    void doLap(ActionEvent event) {
    	if(chklap.isSelected()==false)
		{
			chkall.setSelected(false);
		}
    }

    @FXML
    void doMob(ActionEvent event) {
    	if(chkmob.isSelected()==false)
		{
			chkall.setSelected(false);
		}
    }

    @FXML
    void dochkall(ActionEvent event) {
    	chkbook.setSelected(chkall.isSelected());
    	chkmob.setSelected(chkall.isSelected());
    	chklap.setSelected(chkall.isSelected());
    	
    }

    @FXML
    void initialize() {
        assert chkall != null : "fx:id=\"chkall\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert chkbook != null : "fx:id=\"chkbook\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert chkmob != null : "fx:id=\"chkmob\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert chklap != null : "fx:id=\"chklap\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert radio10 != null : "fx:id=\"radio10\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert discount != null : "fx:id=\"discount\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert radio20 != null : "fx:id=\"radio20\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert txtDiscount != null : "fx:id=\"txtDiscount\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert txtTotal != null : "fx:id=\"txtTotal\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert txtBill != null : "fx:id=\"txtBill\" was not injected: check your FXML file 'chkradio.fxml'.";
        assert getBill != null : "fx:id=\"getBill\" was not injected: check your FXML file 'chkradio.fxml'.";

    }
}
