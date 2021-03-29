package jdbccsqll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import jdbcc.ConnectToDatabase;

public class jdbccsqllviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboroll;

    @FXML
    private Label txtlabel;

    @FXML
    private ImageView picprev;

    @FXML
    private Button btndel;

    @FXML
    private Button btnupd;

    @FXML
    private Button btnchoose;

    @FXML
    private Button btnsave;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtper;

    @FXML
    private DatePicker txtdob;
    
  
    List<String>list;
    
    @FXML
    void dobtnchoose(ActionEvent event) {
    	FileChooser fc=new FileChooser();
    	fc.getExtensionFilters().add(new ExtensionFilter("Images",list));
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
    		 picprev.setImage(pic);
    		 txtlabel.setText(img.getAbsolutePath());
    	}
    }

    

    @FXML
    void dodel(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from trainees where rollno=?");
			pst.setInt(1,Integer.parseInt(comboroll.getEditor().getText()));
			int count=pst.executeUpdate();
			System.out.println(count + "Record deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void dosave(ActionEvent event) {
    	try {
			pst=con.prepareStatement("insert into trainees value(?,?,?,?,?)");
			pst.setInt(1,Integer.parseInt(comboroll.getEditor().getText()));
			pst.setString(2,txtname.getText());
			pst.setFloat(3,Float.parseFloat(txtper.getText()));
			LocalDate db=txtdob.getValue();
			java.sql.Date dd=java.sql.Date.valueOf(db);
			pst.setDate(4,dd);
			pst.setString(5,txtlabel.getText());
			pst.executeUpdate();
			System.out.println("Record Saved Successfully");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void doupdate(ActionEvent event) {
    	try {
			pst=con.prepareStatement("update trainees set name=?,per=?,dob=?,path=? where rollno=?");
			 pst.setInt(5,Integer.parseInt(comboroll.getEditor().getText())); 
			pst.setString(1,txtname.getText());
			pst.setFloat(2,Float.parseFloat(txtper.getText()));
			LocalDate db=txtdob.getValue();
			java.sql.Date dd=java.sql.Date.valueOf(db);
			pst.setDate(3,dd);
			pst.setString(4,txtlabel.getText());
			int count=pst.executeUpdate();
			System.out.println(count + "Record Updated Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	

    }
    
    Connection con;
    PreparedStatement pst;
    
    @FXML
    void initialize() {
    	con=ConnectToDatabase.getConnection();
    	
    	list=new ArrayList<>();
    	list.add("*.jpg");
    	list.add("*.png");
    	list.add("*.jpeg");
    	list.add("*.");
        assert comboroll != null : "fx:id=\"comboroll\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert txtlabel != null : "fx:id=\"txtlabel\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert picprev != null : "fx:id=\"picprev\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert btndel != null : "fx:id=\"btndel\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert btnupd != null : "fx:id=\"btnupd\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert btnchoose != null : "fx:id=\"btnchoose\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert btnsave != null : "fx:id=\"btnsave\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert txtname != null : "fx:id=\"txtname\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert txtper != null : "fx:id=\"txtper\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";
        assert txtdob != null : "fx:id=\"txtdob\" was not injected: check your FXML file 'jdbccsqllview.fxml'.";

    }
}
