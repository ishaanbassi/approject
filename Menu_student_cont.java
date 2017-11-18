package application;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.User;
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
import javafx.stage.Stage;

public class Menu_student_cont implements javafx.fxml.Initializable{

	@FXML
	private Text currentdate;
	 @FXML
	    private JFXButton profile;

	    @FXML
	    private JFXButton viewtimetable;

	    @FXML
	    private JFXButton sendrequest;

	    @FXML
	    private JFXButton checkavailability;

	    @FXML
	    private JFXButton viewcancelrequest;

	    @FXML
	    private JFXButton searchcourse;
	@FXML
	private JFXButton logout;
	@FXML
	private Text user;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//pane00.setStyle("-fx-background-color: #B095F4");
		
		String current = iiitdelhi.getCurrentuser().getName();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-EEEEEEEEE");
		Date date=new Date();
		String[] dateparts=dateFormat.format(date).split("-");
		String parsed=dateparts[3]+", "+dateparts[2]+"-"+dateparts[1]+"-"+dateparts[0];
		currentdate.setText(parsed);
		
		
		user.setText(current);
	
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
		 * Goes to profile page of the  user
		 */
		profile.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.st_profilepage();
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		
		/**
		 * For viewing lecture timings of courses the student has
		 */
		
		viewtimetable.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.viewttpage();
		    		
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
		    		Main.st_check_availpage();
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		/**
		 * Goes to search course page for adding courses by their postconditions
		 */
		searchcourse.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.search_coursepage();
		    		
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		/**
		 * For viewing and canceling booking requests
		 */
		viewcancelrequest.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.view_cancel_requestpage();
		    		
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		/**
		 *  For sending booking request
		 */
		sendrequest.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
		    		Main.send_requestpage();
		    		
		    		
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		

	}

	
}
