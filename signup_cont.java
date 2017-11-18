package application;

import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Admin;
import Users.Faculty;
import Users.Student;
import Users.User;
import college_data.Request;
import college_data.Time;
import college_data.iiitdelhi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class signup_cont  implements javafx.fxml.Initializable {
	

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private ChoiceBox<String> type;
    @FXML
    private JFXButton back;
    @FXML
    private JFXButton create;
    @FXML
    private PasswordField pass;
    @FXML
    private PasswordField cpass;
    
    boolean b1,b2,b3,b4;
	
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
		ObservableList<String> types= FXCollections.observableArrayList("Faculty","Student");
		type.setValue("Student");
		
		type.setItems(types);
		
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
		
		
		name.textProperty().addListener((observable, oldValue, newValue) -> {
            
			if(newValue.length()>0)
			{
				System.out.println(newValue);
				b1=true;
			}
			if(newValue.equals(""))
			{
				b1=false;
				create.setDisable(true);
			}
			if (b1==true && b2==true && b3==true && b4==true )
		    {
		    	create.setDisable(false);
		    }
			
			
        });
		
		email.textProperty().addListener((observable, oldValue, newValue) -> {
            
			if(newValue.length()>0)
			{
				System.out.println(newValue);
				b2=true;
			}
			if(newValue.equals(""))
			{
				b2=false;
				create.setDisable(true);
			}
			if (b1==true && b2==true && b3==true && b4==true )
		    {
		    	create.setDisable(false);
		    }
			
			
        });
		
		pass.textProperty().addListener((observable, oldValue, newValue) -> {
            
			if(newValue.length()>0)
			{
				System.out.println(newValue);
				b3=true;
			}
			if(newValue.equals(""))
			{
				b3=false;
				create.setDisable(true);
			}
			if (b1==true && b2==true && b3==true && b4==true )
		    {
		    	create.setDisable(false);
		    }
			
			
        });
		
		cpass.textProperty().addListener((observable, oldValue, newValue) -> {
            
			if(newValue.length()>0)
			{
				System.out.println(newValue);
				b4=true;
			}
			if(newValue.equals(""))
			{
				b4=false;
				create.setDisable(true);
			}
			if (b1==true && b2==true && b3==true && b4==true)
		    {
		    	create.setDisable(false);
		    }
        });
		create.setOnAction(   new EventHandler<ActionEvent>(){
			@Override
			/**
			 * 
			 * Checks whether both the password fields have same string
			 * Checks whether the account already exists or not
			 * then creates an account
			 */
			public void handle(ActionEvent e)
			{
				if(exists(email.getText()))
				{
					Alert a =new Alert(AlertType.ERROR);
					a.setContentText("An account with same email id already exists!");
					a.showAndWait();
				}
				
				else
				{
				
				boolean b=checkemail();
			
				if(b==false || !(pass.getText().equals(cpass.getText())))
				{
					Alert a =new Alert(AlertType.ERROR);
					String content="";
					if(b==false)content+="The E-mail entered is not a IIIT Delhi E-mail\n";
					if(!(pass.getText().equals(cpass.getText()))) content+="The password fields do not match. Kindly re-enter the passwords to continue";
					a.setContentText(content);
					a.showAndWait();
//					if(a.isShowing()==false)
//					{
//						name.setText(null);
//						email.setText(null);
//						type.setValue("Student");
//						password
//					}
				}
				else
				{
					if(type.getValue().equals("Student"))
					{
						String nam=name.getText();
						String mail=email.getText();
						String typ=type.getValue();
						String password=pass.getText();
						Student s =new Student (nam,mail,typ,password);
						ArrayList<User> accounts=iiitdelhi.getAccounts();
						accounts.add(s);
						
					}
					else
					{
						String nam=name.getText();
						String mail=email.getText();
						String typ=type.getValue();
						String password=pass.getText();
						Faculty f =new Faculty (nam,mail,typ,password);
						ArrayList<User> accounts=iiitdelhi.getAccounts();
						accounts.add(f);
						
						
					}
					Alert a =new Alert(AlertType.INFORMATION);
					a.setContentText("Account created successfully!");
					a.showAndWait();
					
					if(a.isShowing()==false)
					{
						name.setText(null);
						email.setText(null);
						pass.setText(null);
						cpass.setText(null);
						type.setValue("Student");
						
					}
						
				}
				
				}	
			}
			
		});
		
		
		
		
	}
	/**
	 * 
	 * @param email - email to check
	 * 
	 * Checks whether there is already an account with given email
	 * @return 
	 */
	public boolean exists(String email)
	{
		for(User u:iiitdelhi.getAccounts())
		{
			if(u.getEmail().equals(email))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks whether entered email id is a valid iiit email
	 * @return boolean, true for correct email , false for incorrect
	 */
	
	public boolean checkemail()
	{
		String text=email.getText();
		if(!text.contains("@iiitd.ac.in"))
		{
			return false;
		}
		return true;
	}
	

}
