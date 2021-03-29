package hawkerdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import jdbcc.ConnectToDatabase;

public class hawkerdataviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> txtlist;

    @FXML
    private ImageView prevpic;

    @FXML
    private TextField txtsalary;

    @FXML
    private TextField txtmobile;

    @FXML
    private TextField txtadress;

    @FXML
    private Label txtmsg;
    

    @FXML
    private Label lblareas;

    @FXML
    private ComboBox<String> comboname;
    
    List<String>lst;
    File img;
   
    @FXML
    void dochoose(ActionEvent event) {
    	FileChooser fc=new FileChooser();
    	fc.getExtensionFilters().add(new ExtensionFilter("Images",lst));
    	img=fc.showOpenDialog(null);
    	Image pic=null;
    	try {
			pic=new Image(new FileInputStream(img));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(img!=null)
    	{
    		 prevpic.setImage(pic);
    		 
    		 
    	}
    }



    

    @FXML
    void doclear(ActionEvent event) {
    	txtmobile.setText("");
    	txtadress.setText("");
    	txtsalary.setText(String.valueOf(""));
    	lblareas.setText("");
    	comboname.getEditor().setText("");
    }

    @FXML
    void doremove(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from hawkerdata where hname=?");
			pst.setString(1,(comboname.getEditor().getText()));
			int count=pst.executeUpdate();
			System.out.println(count + "Record deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    String all="";
    @FXML
    void dosave(ActionEvent event) {
    	ObservableList<String>sname=txtlist.getSelectionModel().getSelectedItems();
    	
    	for(String str:sname)
    	{
    		all=all+str+",";
    	}
    	 if(comboname.getEditor().getText() == "" || txtmobile.getText() =="" ||txtadress.getText()==""||all==""||img.getAbsolutePath()==""||txtsalary.getText()=="")
		  {
    		 txtmsg.setText("No field should be Empty");
		  }
    	 else
    	 {
		  try {
			  //pst=con.prepareStatement("insert into hawkerdata (hname,mobile,address,areas,apic,salary) values (?,?,?,?,?,?)");
			  pst=con.prepareStatement("insert into hawkerdata values (?,?,?,?,?,?)");
		  pst.setString(1,(comboname.getEditor().getText()));
		  pst.setString(2,txtmobile.getText());
		  pst.setString(3,txtadress.getText());
		 
	    
	    
	    	pst.setString(4, all);	
		  pst.setString(5,img.getAbsolutePath());
		  pst.setFloat(6,Float.parseFloat(txtsalary.getText()));
		   
		  pst.executeUpdate();
		  System.out.println("Record Saved Successfully");
		 txtmsg.setText("Record Saved SuccessFully"); 
		  
		  } catch (SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		
		  }
    } 
		  @FXML 
		  void dosearch(ActionEvent event) {  
			  try
			  {
				  
		  pst=con.prepareStatement("select * from hawkerdata where hname=?");
		  pst.setString(1,comboname.getEditor().getText());
		  ResultSet table=pst.executeQuery(); 
		  if(table.next()) { 
			  String mob=table.getString("mobile"); 
			  txtmobile.setText(mob); 
			  String adr=table.getString("address"); 
			  txtadress.setText(adr);
			  String area=table.getString("areas"); 
			  lblareas.setText(area);
			  String path=table.getString("apic"); 
			  float sal=table.getFloat("salary"); 
			  txtsalary.setText(String.valueOf(sal));
			  Image pic=null;
		    	try {
					pic=new Image(new FileInputStream(path));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(pic!=null)
		    	{
		    		 prevpic.setImage(pic);
		    		 
		    		 
		    	}
			  
		  txtmsg.setText("Successfully Fetched");
		  
		  } else 
		  { 
			  txtmsg.setText("No PaperName");
			  Alert alert=new Alert(AlertType.ERROR);
			  alert.setTitle("Invalid Name");
			  alert.setContentText("No record Found");
			  alert.show();
		  }
		 
		
		  } catch (SQLException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		
    }

    @FXML
    void doupdate(ActionEvent event) {
    	if(comboname.getEditor().getText() == "" || txtmobile.getText() =="" ||txtadress.getText()==""||all==""||img.getAbsolutePath()==""||txtsalary.getText()=="")
		  {
  		 txtmsg.setText("No field should be Empty");
		  }
    	else
    	{
    	try {
    		
			pst=con.prepareStatement("update hawkerdata set mobile=?,address=?,areas=?,apic=?,salary=? where hname=?");
			  
			
			pst.setString(1,txtmobile.getText());
			pst.setString(2,txtadress.getText());
			pst.setString(3,all);
			pst.setString(4,img.getAbsolutePath());
			pst.setFloat(5,Float.parseFloat(txtsalary.getText()));
			pst.setString(6,(comboname.getEditor().getText()));
			int count=pst.executeUpdate();
			System.out.println(count + "Record Updated Successfully");
			txtmsg.setText(count + "Record Updated Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    }
    PreparedStatement pst;
    Connection con;
    @FXML
    void initialize() {
    	con=ConnectToDatabase.getConnection();
    	lst=new ArrayList<>();
    	lst.add("*.jpg");
    	lst.add("*.png");
    	lst.add("*.jpeg");
    	lst.add("*.");
    	try {
			pst=con.prepareStatement("select * from hawkerdata");
			ResultSet tbl=pst.executeQuery();
			while(tbl.next())
			{
				String name=tbl.getString("hname");
				comboname.getItems().add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ArrayList<String>lst=new ArrayList<String>(Arrays.asList("GEETA BHAWAN","40 FEET STREET","Sadar Bazzar","Pinki Market","Ajit Road"));
    	txtlist.getItems().addAll(lst);
    	txtlist.getSelectionModel().select(0);
    	txtlist.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
        assert txtlist != null : "fx:id=\"txtlist\" was not injected: check your FXML file 'hawkerdataview.fxml'.";
        assert prevpic != null : "fx:id=\"prevpic\" was not injected: check your FXML file 'hawkerdataview.fxml'.";
        assert txtsalary != null : "fx:id=\"txtsalary\" was not injected: check your FXML file 'hawkerdataview.fxml'.";
        assert txtmobile != null : "fx:id=\"txtmobile\" was not injected: check your FXML file 'hawkerdataview.fxml'.";
        assert txtadress != null : "fx:id=\"txtadress\" was not injected: check your FXML file 'hawkerdataview.fxml'.";
        assert txtmsg != null : "fx:id=\"txtmsg\" was not injected: check your FXML file 'hawkerdataview.fxml'.";
        assert comboname != null : "fx:id=\"comboname\" was not injected: check your FXML file 'hawkerdataview.fxml'.";

    }
}
