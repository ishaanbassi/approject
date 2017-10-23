package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Border;
import javafx.stage.Stage;

public class login_cont implements javafx.fxml.Initializable {
	
	@FXML
	private ChoiceBox<String> type;
	@FXML
	private Hyperlink forgot;
	@FXML
	private Button exit;
	@FXML
	private Button loginbtn;
	
	@Override
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		ObservableList<String> types= FXCollections.observableArrayList("Admin","Faculty","Student");
		type.setValue("Student");
		
		type.setItems(types);
	
		forgot.setBorder(Border.EMPTY);
		
		exit.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				Stage stage = (Stage) exit.getScene().getWindow();
			    stage.close();
			}
		});
		
		loginbtn.setOnAction(new EventHandler<ActionEvent>()
			{
				@Override
				public void handle(ActionEvent e)
				{
					if(type.getValue().equals("Student"))
					{
						try {
							Main.student_login();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(type.getValue().equals("Faculty"))
					{
						try {
							Main.faculty_login();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(type.getValue().equals("Admin"))
					{
						try {
							Main.admin_login();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			
			
			});
	}
	
}
