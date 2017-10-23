package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Border;

public class welcome_cont implements javafx.fxml.Initializable  {
	
	@FXML
	private Hyperlink link2login;
	@FXML
	private Hyperlink newacc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		link2login.setBorder(Border.EMPTY);
		link2login.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
					Main.loginpage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		newacc.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
					Main.signuppage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		
		
	}
	
}
