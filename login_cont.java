package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.User;
import college_data.Lecture;
import college_data.iiitdelhi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

public class login_cont implements javafx.fxml.Initializable {
	
	@FXML
	private ChoiceBox<String> type;
	
	@FXML
	private JFXButton exit;
	@FXML
	private JFXButton loginbtn;
	@FXML
	private JFXButton back;
	@FXML
	private TextField email;
	@FXML
	private PasswordField pass;
	
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	
		

		/**
		 * Back button - to go the main menu
		 */
		
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				
				Stage stage = (Stage) back.getScene().getWindow();
				Main main=new Main();
				main.start(stage);
			}
		
	});
		ArrayList<User> accounts=iiitdelhi.getAccounts();
		
		
//		System.out.println("yes "+accounts.size());
//		System.out.println(accounts.get(0).getEmail());
		
	/**
	 * Option for exiting the room booking application
	 */
		
		exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				Stage stage = (Stage) exit.getScene().getWindow();
			    stage.close();
			}
		});
	
		
		/**
		 * For logging in
		 */
		loginbtn.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
						String mail=email.getText();
						String password=pass.getText();
						
						if(iiitdelhi.checkcredentials(mail,password))
						{
							
							if(iiitdelhi.getCurrentuser().getType().equals("Student"))
							{
								try {
									Main.student_login();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							else if(iiitdelhi.getCurrentuser().getType().equals("Admin"))
							{
								try {
									Main.admin_login();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							
							else
							{
								try {
									Main.faculty_login();
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						}
						else
						{
							Alert a =new Alert(AlertType.ERROR);
							a.setContentText("The E-mail id or password is incorrect!");
							a.showAndWait();
						}
								
					
					
				}
			
			
			});
	}
	
}
