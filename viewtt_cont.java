package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Student;
import college_data.Course;
import college_data.Lecture;
import college_data.iiitdelhi;
import college_data.timetableentry;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


/**
 * 
 * Controller class for student's timetable
 *
 */


public class viewtt_cont implements javafx.fxml.Initializable{

	@FXML
	JFXButton back;
	
	@FXML
    private TableView<timetableentry> lectures;

    @FXML
    private TableColumn<timetableentry, String> ccode;

    @FXML
    private TableColumn<timetableentry, String> cname;

    @FXML
    private TableColumn<timetableentry,String> monday;

    @FXML
    private TableColumn<timetableentry, String> tuesday;

    @FXML
    private TableColumn<timetableentry,String> wednesday;

    @FXML
    private TableColumn<timetableentry, String> thursday;

    @FXML
    private TableColumn<timetableentry, String> friday;
    
    String[] days={"Mon","Tue","Wed","Thu","Fri"};
	List<String> listofdays=Arrays.asList(days);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		System.out.println("TIMETABLE ");

		
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
		
		ArrayList<Lecture> lecturelist=new ArrayList<Lecture>();
		Student s=(Student) iiitdelhi.getCurrentuser();
		lecturelist=s.getTimetable();
		
		
		ObservableList<timetableentry> data= FXCollections.observableArrayList();
		
		
		ArrayList<timetableentry> entry=new ArrayList<timetableentry>();
		System.out.println(lecturelist.size());
		int count=0;
		for(int i=0;i<lecturelist.size();i++)
		{
			int found=0;

			for(int j=0;j<entry.size();j++)
			{
				if(entry.get(j).getCourseName().equals(lecturelist.get(i).getCourseObject().getCourseName()))
				{
					
					found=1;
					String day=lecturelist.get(i).getTimeObject().getDay();
					String st=lecturelist.get(i).getTimeObject().getStartTime();
					String et=lecturelist.get(i).getTimeObject().getEndTime();
					String type=lecturelist.get(i).getTimeObject().getClasstype();
					String rooms=lecturelist.get(i).getRoomObject().toString().replace("[", "").replace("]", "").replace(",","");
					
					
					
					
					int index = listofdays.indexOf(day);
					System.out.print(day+" ");
					System.out.println(index);
					
					
					entry.get(j).addlecture(index, st, et, type,rooms);
					
					count++;
				}
			} 
			if(found==0)
			{
				
				
				timetableentry temp=new timetableentry();
				temp.setCourseCode(lecturelist.get(i).getCourseObject().getCourseCode());
				temp.setCourseName(lecturelist.get(i).getCourseObject().getCourseName());
				String day=lecturelist.get(i).getTimeObject().getDay();
				String st=lecturelist.get(i).getTimeObject().getStartTime();
				String et=lecturelist.get(i).getTimeObject().getEndTime();
				String type=lecturelist.get(i).getTimeObject().getClasstype();
				String rooms=lecturelist.get(i).getRoomObject().toString().replace("[", "").replace("]", "").replace(",","");
				
				System.out.println(day);
				int index = listofdays.indexOf(day);
				
				System.out.print(day+" ");
				System.out.println(index);
				
				//System.out.println(temp.getCourseName()+" "+day+" "+st+" - "+et+" "+type+" "+rooms);
				
				temp.addlecture(index, st, et, type,rooms);
				
				
				
				
				count++;
				entry.add(temp);
				
			}
			
			
			
		}
		//System.out.println("FINAL ENTRY");
		//System.out.println("No.of entries done - "+count+", "+"No. of lectures"+lecturelist.size() 	);
		for(timetableentry t: entry)
		{
			String timings = t.getTimings().toString().replace("[", "").replace("]", "").replace(",","");
			
			
			
			data.add(t);
		}

		ccode.setCellValueFactory(new PropertyValueFactory<timetableentry,String>("CourseCode"));
		cname.setCellValueFactory(new PropertyValueFactory<timetableentry,String>("CourseName"));
		monday.setCellValueFactory(new Callback<CellDataFeatures<timetableentry, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<timetableentry, String> c) {
	            
	        	String result;
	        	result = c.getValue().getTimings()[0];
	        	return new SimpleStringProperty(result);                
	        }
		});
		tuesday.setCellValueFactory(new Callback<CellDataFeatures<timetableentry, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<timetableentry, String> c) {
	            
	        	String result;
	        	result = c.getValue().getTimings()[1];
	        	return new SimpleStringProperty(result);                
	        }
		});
		wednesday.setCellValueFactory(new Callback<CellDataFeatures<timetableentry, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<timetableentry, String> c) {
	            
	        	String result;
	        	result = c.getValue().getTimings()[2];
	        	return new SimpleStringProperty(result);                
	        }
		});
		thursday.setCellValueFactory(new Callback<CellDataFeatures<timetableentry, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<timetableentry, String> c) {
	            
	        	String result;
	        	result = c.getValue().getTimings()[3];
	        	return new SimpleStringProperty(result);                
	        }
		});
		friday.setCellValueFactory(new Callback<CellDataFeatures<timetableentry, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<timetableentry, String> c) {
	            
	        	String result;
	        	result = c.getValue().getTimings()[4];
	        	return new SimpleStringProperty(result);                
	        }
		});
		
		lectures.setItems(data);
		
		
		
		
		
		
		
		
		
		
	}

}
