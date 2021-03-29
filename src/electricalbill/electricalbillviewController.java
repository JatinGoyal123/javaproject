package electricalbill;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class electricalbillviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField unitconsumed;

    @FXML
    private CheckBox chkac;

    @FXML
    private CheckBox chkcooler;

    @FXML
    private TextField txtac;

    @FXML
    private TextField txtcooler;

    @FXML
    private RadioButton rad10;

    @FXML
    private ToggleGroup discount;

    @FXML
    private RadioButton rad20;

    @FXML
    private Button btntot;

    @FXML
    private Button btndis;

    @FXML
    private Button btnnet;

    @FXML
    private TextField txtacbill;

    @FXML
    private TextField txtdiscount;

    @FXML
    private TextField txttotalbill;

    @FXML
    private TextField txtcoolerbill;

    @FXML
    private TextField txtnetbill;

    @FXML
    int doFetch()
    {
    	String unit=unitconsumed.getText();
    	int un=Integer.parseInt(unit);
    	String acunit=txtac.getText();
    	int acun;
    	String coolerunit=txtcooler.getText();
    	int coun;
    	if(chkac.isSelected()==false)
    	{
    		acun=0;
    	}
    	else
    	{
    		acun=Integer.parseInt(acunit);
    	}
    	if(chkcooler.isSelected()==false)
    	{
    		coun=0;
    	}
    	else
    	{
    		coun=Integer.parseInt(coolerunit);
    	}
    	int bill=un*acun+un*coun;
    	return bill;
    }
    int doFetchdis()
    {
    	int dis=0;
    	if(rad10.isSelected())
    	{
    		dis=10;
    	}
    	else
    	{
    		dis=20;
    	}
    	return dis;
    }

    @FXML
    void doac(ActionEvent event) {
    	txtac.setDisable(false);

    }

    @FXML
    void docooler(ActionEvent event) {
    	txtcooler.setDisable(false);
    }

    @FXML
    void dodis(ActionEvent event) {
    	int dis=0;
    	if(rad10.isSelected())
    	{
    		dis=10;
    	}
    	else
    	{
    		dis=20;
    	}
    	int bill=doFetch();
    	int d=(bill*dis)/100;
    	txtdiscount.setText(String.valueOf(d));
    	txtdiscount.setDisable(false);
    }

    @FXML
    void donet(ActionEvent event) {
    	int bill1=doFetch();
    	int dis1=doFetchdis();
    	int net=bill1-(bill1*dis1)/100;
    	txtnetbill.setText(String.valueOf(net));
    	txtnetbill.setDisable(false);
    	
    }

    @FXML
    void dotot(ActionEvent event) {
    	String unit=unitconsumed.getText();
    	int un=Integer.parseInt(unit);
    	String acunit=txtac.getText();
    	int acun;
    	String coolerunit=txtcooler.getText();
    	int coun;
    	if(chkac.isSelected()==false)
    	{
    		acun=0;
    	}
    	else
    	{
    		acun=Integer.parseInt(acunit);
    	}
    	if(chkcooler.isSelected()==false)
    	{
    		coun=0;
    	}
    	else
    	{
    		coun=Integer.parseInt(coolerunit);
    	}
    	int bill=un*acun+un*coun;
    	
    
    	
    	txtacbill.setText(String.valueOf(acun*un));
    	txtacbill.setDisable(false);
    	txtcoolerbill.setText(String.valueOf(coun*un));
    	txtcoolerbill.setDisable(false);
    	txttotalbill.setText(String.valueOf(bill));
    	txttotalbill.setDisable(false);
    	
    }

    @FXML
    void initialize() {
        assert unitconsumed != null : "fx:id=\"unitconsumed\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert chkac != null : "fx:id=\"chkac\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert chkcooler != null : "fx:id=\"chkcooler\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txtac != null : "fx:id=\"txtac\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txtcooler != null : "fx:id=\"txtcooler\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert rad10 != null : "fx:id=\"rad10\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert discount != null : "fx:id=\"discount\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert rad20 != null : "fx:id=\"rad20\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert btntot != null : "fx:id=\"btntot\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert btndis != null : "fx:id=\"btndis\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert btnnet != null : "fx:id=\"btnnet\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txtacbill != null : "fx:id=\"txtacbill\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txtdiscount != null : "fx:id=\"txtdiscount\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txttotalbill != null : "fx:id=\"txttotalbill\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txtcoolerbill != null : "fx:id=\"txtcoolerbill\" was not injected: check your FXML file 'electricalbillview.fxml'.";
        assert txtnetbill != null : "fx:id=\"txtnetbill\" was not injected: check your FXML file 'electricalbillview.fxml'.";

    }
}
