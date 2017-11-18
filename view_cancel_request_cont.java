package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Student;
import college_data.Course;
import college_data.Request;
import college_data.iiitdelhi;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;




public class view_cancel_request_cont implements javafx.fxml.Initializable {

	@FXML
	TableView<Request> requests;
	@FXML
	TableColumn<Request,Integer> sno;
	@FXML
	TableColumn<Request,String> room;
	@FXML
	TableColumn<Request,String> duration;
	@FXML
	TableColumn<Request,String> date;
	@FXML
	TableColumn<Request,String> reason;
	@FXML
	TableColumn<Request,String> status;
//	@FXML
//	TableColumn<Request,Boolean> select;
	@FXML
	JFXButton cancel;
	@FXML
	CheckBox c;
	@FXML
	JFXButton back;
	
	Request selected=null;
	
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
					Main.student_login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		
				
		Student s=(Student) iiitdelhi.getCurrentuser();
		ArrayList<Request> request_list=s.getRequests();
		ObservableList<Request> data= FXCollections.observableArrayList();
		for(int i=0;i<request_list.size();i++)
		{
			request_list.get(i).setSno(i+1);
			
			System.out.println(request_list.get(i).getStatus()+" "+request_list.get(i).getDone().getStatus());
			data.add(request_list.get(i));
		}
		int count=0;
		count++;
		
		
		//s.setChoice(true);
		sno.setCellValueFactory(new PropertyValueFactory<Request,Integer>("sno"));
		room.setCellValueFactory(new PropertyValueFactory<Request,String>("pref_room"));
		duration.setCellValueFactory(new Callback<CellDataFeatures<Request, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Request, String> c) {
	            return new SimpleStringProperty(c.getValue().getDuration().getStartTime()+" - "+c.getValue().getDuration().getEndTime());                
	        }
	}); 
		date.setCellValueFactory(new PropertyValueFactory<Request,String>("date"));
		reason.setCellValueFactory(new PropertyValueFactory<Request,String>("reason"));
		status.setCellValueFactory(new Callback<CellDataFeatures<Request, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Request, String> c) {
	            
	            String result="";
	            if( c.getValue().getDone()!=null && c.getValue().getDone().getStatus()==-1)
	            {
	            	result="Cancelled by admin";
	            }
	            else if(c.getValue().getStatus()==0)
	            {
	            	
	            	result="Pending";
	            }
	            else if(c.getValue().getStatus()==1)
	            {
	            	result="Accepted";
	            }
	            else if(c.getValue().getStatus()==-1)
	            {
	            	result="Rejected";
	            }
	            
	            
	        	return new SimpleStringProperty(result);                
	        }
	});
		
		

	      
		
		requests.setItems(data); // assign the data to the table

		
		cancel.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			
			/**
			 * Removes the selected booking request from records
			 */
			public void handle(ActionEvent e)
			{
				requests.getItems().remove(selected);
				s.getRequests().remove(selected);
				iiitdelhi.getAdmin().getlist().remove(selected);
				
				ObservableList<Request> newdata= FXCollections.observableArrayList();
				requests.getItems().remove(selected);
				int count=1;
				for(Request r: requests.getItems())
				{
					r.setSno(count);
					count++;
					newdata.add(r);
				}
				
				
				iiitdelhi.getAdmin().getbookings().remove(selected.getDone());
			}
		});
		
		
		
		requests.setRowFactory(tv -> {
		    TableRow<Request> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
		            Request  rowData = row.getItem();

//		            System.out.println(rowData.getChoice());
//		            rowData.setChoice(true);
		        
		            //requests.getItems().set(0, rowData);
		            //System.out.println("yes");
		            selected=rowData;
		            cancel.setDisable(false);
		            
		            
//		            System.out.println(rowData.getchoice());
		        }
		    });
		    return row ;
		});
		
		
		
	}
	
	
}
