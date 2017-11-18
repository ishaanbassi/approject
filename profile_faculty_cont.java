package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Faculty;
import Users.Student;
import college_data.Course;
import college_data.Lecture;
import college_data.iiitdelhi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


public class profile_faculty_cont implements javafx.fxml.Initializable {

	@FXML
    private Text Name;

    @FXML
    private Text email;

    @FXML
    private JFXButton back;

    @FXML
    private TableView<Course> coursetable;

    @FXML
    private TableColumn<Course,String> sno;

    @FXML
    private TableColumn<Course,String> ccode;

    @FXML
    private TableColumn<Course,String> cname;

    @FXML
    private TableColumn<Course,String> acronym;

    @FXML
    private TableColumn<Course,String> credits;
	
	
	
	
	
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
				try {
					Main.faculty_login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		

		ObservableList<Course> data= FXCollections.observableArrayList();
		Faculty s=(Faculty) iiitdelhi.getCurrentuser();
		ArrayList<Lecture> lecture=s.getCourses();
		HashSet<Course> courses=new HashSet<Course>();
		for(Lecture l: lecture)
		{
			courses.add(l.getCourseObject());
		}
		Iterator<Course> itr=courses.iterator();
		int count=1;
		while(itr.hasNext())
		{
			Course temp=itr.next();
			temp.setSno(count);
			data.add(temp);
			count++;
		}
		
		
		Name.setText(iiitdelhi.getCurrentuser().getName());
		email.setText(iiitdelhi.getCurrentuser().getEmail());
		sno.setCellValueFactory(new PropertyValueFactory<Course,String>("sno"));
		ccode.setCellValueFactory(new PropertyValueFactory<Course,String>("CourseCode"));
		cname.setCellValueFactory(new PropertyValueFactory<Course,String>("CourseName"));
		credits.setCellValueFactory(new PropertyValueFactory<Course,String>("credit"));
		acronym.setCellValueFactory(new PropertyValueFactory<Course,String>("acronym"));

		coursetable.setItems(data);
		
		
	}

}
