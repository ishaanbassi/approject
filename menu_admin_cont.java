package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.User;
import college_data.Lecture;
import college_data.iiitdelhi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class menu_admin_cont implements javafx.fxml.Initializable {
	
	@FXML
	Text currentdate;
	
	
	@FXML
	    private JFXButton acceptrejectrequest;

	    @FXML
	    private JFXButton bookroom;

	    @FXML
	    private JFXButton checkavailability;

	    @FXML
	    private JFXButton cancelbooking;

	    @FXML
	    private JFXButton logout;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
String current = iiitdelhi.getCurrentuser().getName();
		
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-EEEEEEEEE");
Date date=new Date();
String[] dateparts=dateFormat.format(date).split("-");
String parsed=dateparts[3]+", "+dateparts[2]+"-"+dateparts[1]+"-"+dateparts[0];
currentdate.setText(parsed);


		
		for(Lecture l : iiitdelhi.getLectures())
		{
			System.out.println(l.getTimeObject().getStartTime());
		}
		
		/**
		 * Logout - Redirects user to login page
		 */
		
		logout.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
					Main.loginpage();
					User u=iiitdelhi.getCurrentuser();
					u=null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		
		/**
		 * Goes to room booking page
		 * 
		 */
		
		
		bookroom.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.admin_room_bookpage();
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		/**
		 * Opens form for checking availability of room
		 */
		checkavailability.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.admin_check_availpage();
		    		
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		/**
		 * For viewing the booking that have been done by the user and canceling them if required
		 */
		cancelbooking.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		
		    		Main.admin_cancel_bookingpage();
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		/**
		 * Accepting or rejecting student's booking requests 
		 */
		acceptrejectrequest.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		
		    		Main.admin_acc_rej_requestpage();
		    		
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		

	}
	

}
