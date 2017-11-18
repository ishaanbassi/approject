package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Student;
import college_data.Course;
import college_data.Lecture;
import college_data.Request;
import college_data.iiitdelhi;
import database.read_data2;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Control;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class search_course_cont implements javafx.fxml.Initializable {

	@FXML
	TextArea postcond;
	@FXML
	JFXButton back;
	@FXML
	TableView<Course> courses;
	@FXML
	TableColumn<Course,String> ccode;
	@FXML
	TableColumn<Course,String> cname;
	@FXML
	TableColumn<Course,String> post;
	@FXML
	TableColumn<Course,String> mandatory;
	@FXML
	TableColumn<Course,String> credits;
	@FXML
	JFXButton add;
	
	Course selected;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Course> courselist=new ArrayList<Course>();
		courselist=iiitdelhi.getCourses();
		ObservableList<Course> data= FXCollections.observableArrayList();
		
		System.out.println(courselist.size());
		for(int i=0;i<courselist.size();i++)
		{
			
			System.out.println(courselist.get(i).getCourseName());
			System.out.println(courselist.get(i).getCourseCode());
			data.add(courselist.get(i));
			
		}
		//courses.setFixedCellSize(Region.USE_COMPUTED_SIZE);
		
		ccode.setCellValueFactory(new PropertyValueFactory<Course,String>("CourseCode"));
		cname.setCellValueFactory(new PropertyValueFactory<Course,String>("CourseName"));
		credits.setCellValueFactory(new PropertyValueFactory<Course,String>("credit"));
		mandatory.setCellValueFactory(new PropertyValueFactory<Course,String>("mandatoryOrElective"));
		

		
		
		
		post.setCellValueFactory(new Callback<CellDataFeatures<Course, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Course, String> c) {
	            ArrayList<String> postcond=c.getValue().getPostCond();
	            String result="";
	            for(String s : postcond)
	            {
	            	result=result+s+"\n";
	            }
	        	return new SimpleStringProperty(result);                
	        }
	}); 
		
		courses.setItems(data);
		
		
			postcond.textProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.length()>0)
			{
				ObservableList<Course> newData= FXCollections.observableArrayList();
				for(int i=0;i<data.size();i++)
				{
					
					Course temp=data.get(i);
					ArrayList<String> postconditions=temp.getpostConditions();
					String total="";
					for(int j=0;j<postconditions.size();j++)
					{
						total=total+postconditions.get(j);
					}
					total=total.toLowerCase();
					newValue=newValue.toLowerCase();
					if(total.contains(newValue))
					{
						newData.add(temp);
					}
				}
				courses.setItems(newData);
				
				//courses.getItems().set(0, null);
			}
			
        });
			
			
			courses.setRowFactory(tv -> {
			    TableRow<Course> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
			            Course  rowData = row.getItem();
	
//			            System.out.println(rowData.getChoice());
//			            rowData.setChoice(true);
			        
			            //requests.getItems().set(0, rowData);
			            System.out.println("yes");
			            add.setDisable(false);
			            selected=rowData;
			            
			            //System.out.println(rowData.getchoice());
			        }
			    });
			    return row ;
			    
			});
		
		

		
			/**
			 * Back button - to go the main menu
			 */
			
		
		back.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				try {
					Main.student_login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		add.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			
			/**
			 * Checks whether the selected course 
			 * 1) Is already there in the student's timetable
			 * 2) Can be added successfully to the timetable without clashes 
			 * 
			 */
			public void handle(ActionEvent e)
			{
				
				Student s=(Student) iiitdelhi.getCurrentuser();
				ArrayList<Lecture> lectures = iiitdelhi.getLectures();
				
				int found=0;
				ArrayList<Lecture> tt=s.getTimetable();
				for(Lecture l:tt)
				{
					if(l.getCourseObject().getCourseName().equals(selected.getCourseName()))
					{
						found=1;
						break;
					}
				}
				if(found==1)
				{
					Alert a =new Alert(AlertType.ERROR);
					a.setContentText("You already have this course!");
					a.showAndWait();
				}
				else
				{
					boolean clash=false;
					for(Lecture l : lectures)
					{
						try {
							if(l.getCourseObject().getCourseName().equals(selected.getCourseName()) && s.checkclash(l.getTimeObject()))
							{
								clash=true;
								break;
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(clash==true)
					{
						Alert a=new Alert(AlertType.ERROR);
						a.setContentText("The timings for this course clash with a course you already have!");
						a.showAndWait();
					}
					else
					{
						
					
					Alert a=new Alert(AlertType.INFORMATION);
					a.setContentText("Course successfully added! Timetable has been update accordingly!");
					a.showAndWait();
					
					
					
					
					
					for(Lecture l: lectures)
					{
					
					
							if(l.getCourseObject().getCourseName().equals(selected.getCourseName()))
							{
								
									System.out.println(l.getCourseObject().getCourseName()+" "+l.getTimeObject());
									s.getTimetable().add(l);
							}	
						
					}
					
					
					}
					
				}
				
				
			}
		});
	}
	

}
