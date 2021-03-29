package papmaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jdbcc.ConnectToDatabase;

public class papmasterviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> combotitle;

    @FXML
    private TextField txtprice;
    @FXML
    private Label txtmsg;
    

    @FXML
    void dodelete(ActionEvent event) {
    	try {
			pst=con.prepareStatement("delete from papermaster where papername=?");
			pst.setString(1,(combotitle.getEditor().getText()));
			int count=pst.executeUpdate();
			System.out.println(count + "Record deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }

    @FXML
    void dofetch(ActionEvent event) {
    	try {
			pst=con.prepareStatement("select * from papermaster where papername=?");
			pst.setString(1,combotitle.getEditor().getText());
			ResultSet table=pst.executeQuery();
			if(table.next())
			{
				float prc=table.getFloat("price");
				txtprice.setText(String.valueOf(prc));
				txtmsg.setText("Successfully Fetched");
				
			}
			else
			{
				txtmsg.setText("No PaperName");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }

    @FXML
    void donew(ActionEvent event) {
    	txtprice.setText(String.valueOf(""));
    	
    	

    }

    @FXML
    void dosave(ActionEvent event) {
    	
    	try {
			pst=con.prepareStatement("insert into papermaster value(?,?)");
			pst.setString(1,(combotitle.getEditor().getText()));
			pst.setFloat(2,Float.parseFloat(txtprice.getText()));
			pst.executeUpdate();
			System.out.println("Record Saved Successfully");
			txtmsg.setText("Record Saved Successfully");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }

    @FXML
    void doupdate(ActionEvent event) {
    	try {
			pst=con.prepareStatement("update papermaster set price=? where papername=?");
			 pst.setString(2,(combotitle.getEditor().getText())); 
			
			pst.setFloat(1,Float.parseFloat(txtprice.getText()));
			int count=pst.executeUpdate();
			System.out.println(count + "Record Updated Successfully");
			txtmsg.setText( count  + " Record Updated Successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    PreparedStatement pst;
    Connection con;
    @FXML
    void initialize() {
    	con=ConnectToDatabase.getConnection();
    	try {
			pst=con.prepareStatement("select * from papermaster");
			ResultSet tbl=pst.executeQuery();
			while(tbl.next())
			{
				String name=tbl.getString("papername");
				combotitle.getItems().add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assert combotitle != null : "fx:id=\"combotitle\" was not injected: check your FXML file 'papmasterview.fxml'.";
        assert txtprice != null : "fx:id=\"txtprice\" was not injected: check your FXML file 'papmasterview.fxml'.";

    }
}
