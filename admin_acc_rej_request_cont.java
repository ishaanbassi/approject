package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Admin;
import college_data.Booking;
import college_data.Lecture;
import college_data.Request;
import college_data.Time;
import college_data.iiitdelhi;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class admin_acc_rej_request_cont implements javafx.fxml.Initializable {

	@FXML
	JFXButton back;
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
	@FXML
	JFXButton accept;
	@FXML
	JFXButton reject;
	Request selected;
	
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
						Main.admin_login();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		ArrayList<Request> request_list=iiitdelhi.getAdmin().getlist();
		ObservableList<Request> data= FXCollections.observableArrayList();
		LocalDate currenttime=LocalDate.now();
		
		if(request_list.size()>0)
		{
			for(int i=0;i<request_list.size();i++)
			{
				
				LocalDate sendingtime=request_list.get(i).getSenddate();
				if(sendingtime==null)
				{
					request_list.get(i).setSno(i+1);
					data.add(request_list.get(i));
				}
				
				else
				{
					Period diff=Period.between(sendingtime, currenttime);
					if(diff.getDays()<5)
					{
						request_list.get(i).setSno(i+1);
						data.add(request_list.get(i));
					}
				}
				
				
			}
		}
		
		sno.setCellValueFactory(new PropertyValueFactory<Request,Integer>("sno"));
		room.setCellValueFactory(new PropertyValueFactory<Request,String>("pref_room"));
		//duration.setCellValueFactory(new PropertyValueFactory<Request,String>("duration"));
		duration.setCellValueFactory(new Callback<CellDataFeatures<Request, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Request, String> c) {
	            return new SimpleStringProperty(c.getValue().getDuration().getStartTime()+" - "+c.getValue().getDuration().getEndTime());                
	        }
	}); 
		status.setCellValueFactory(new Callback<CellDataFeatures<Request, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Request, String> c) {
	            
	            String result="";
	            if(c.getValue().getStatus()==0)
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
		
		date.setCellValueFactory(new PropertyValueFactory<Request,String>("date"));
		reason.setCellValueFactory(new PropertyValueFactory<Request,String>("reason"));
		requests.setItems(data);
		
				
				requests.setRowFactory(tv -> {
			    TableRow<Request> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
			            Request  rowData = row.getItem();
	
//			            System.out.println(rowData.getChoice());
//			            rowData.setChoice(true);
			        
			            //requests.getItems().set(0, rowData);
			            System.out.println("yes");
			            selected =rowData;
			            accept.setDisable(false);
			            reject.setDisable(false);
			            
			            //System.out.println(rowData.getchoice());
			        }
			    });
			    return row ;
			});
				
				accept.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					/**
					 * Checks and accepts student request if the booking is possible
					 */
					public void handle(ActionEvent e)
					{
							try {
							
							
								String finalroom=iiitdelhi.checkbycap(selected.getCap(),selected.getDate(),selected.getDuration(),selected.getPref_room());
								if(finalroom!=null)
								{
									Booking temp=new Booking(finalroom,selected.getDate(),selected.getDuration());
									Alert a = new Alert(AlertType.INFORMATION);
									a.setContentText("Booking confirmed");
									a.showAndWait();
									
									ObservableList<Request> newdata= FXCollections.observableArrayList();
									requests.getItems().remove(selected);
									int count=1;
									for(Request r: requests.getItems())
									{
										r.setSno(count);
										count++;
										newdata.add(r);
									}
									
									requests.setItems(newdata);
									selected.setStatus(1);
									selected.setDone(temp);
									iiitdelhi.getAdmin().getlist().remove(selected);
									iiitdelhi.getAdmin().getbookings().add(temp);
								}
								else
								{
									Alert a = new Alert(AlertType.ERROR);
									a.setContentText("This booking is not possible!");
									a.showAndWait();
								}
							}
							
							
							
							catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					
				});
			/**
			 * Removes the request from admin's record and marks it as rejected
			 */
				reject.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent e)
					{
						selected.setStatus(-1);
						
						ObservableList<Request> newdata= FXCollections.observableArrayList();
						requests.getItems().remove(selected);
						int count=1;
						for(Request r: requests.getItems())
						{
							r.setSno(count);
							count++;
							newdata.add(r);
						}
						
						requests.setItems(newdata);
						
						
						iiitdelhi.getAdmin().getlist().remove(selected);
					}
				});	
			
		
}
		
}
