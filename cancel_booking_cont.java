package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Users.Faculty;
import college_data.Booking;
import college_data.iiitdelhi;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class cancel_booking_cont implements javafx.fxml.Initializable{

	@FXML
	private JFXButton back;
	@FXML
	private JFXButton cancel;
	@FXML
    private TableView<Booking> bookings;

    @FXML
    private TableColumn<Booking,Integer> sno;

    @FXML
    private TableColumn<Booking,String> date;

    @FXML
    private TableColumn<Booking,String> room;
    
    @FXML 
    private TableColumn<Booking,String> status;

    @FXML
    private TableColumn<Booking,String> duration;
    
    Booking selected;
	
	
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
		
		
		ObservableList<Booking> data= FXCollections.observableArrayList();
		Faculty f=(Faculty) iiitdelhi.getCurrentuser();
		ArrayList<Booking> booked_rooms=f.getBookings();
		
		for(int i=0;i<booked_rooms.size();i++)
		{ 
			System.out.println(booked_rooms.get(i).getStatus());
			booked_rooms.get(i).setSno(i+1);
			data.add(booked_rooms.get(i));
		}
		
		sno.setCellValueFactory(new PropertyValueFactory<Booking,Integer>("sno"));
		room.setCellValueFactory(new PropertyValueFactory<Booking,String>("room"));
		date.setCellValueFactory(new PropertyValueFactory<Booking,String>("date"));
		duration.setCellValueFactory(new Callback<CellDataFeatures<Booking, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Booking, String> c) {
	            return new SimpleStringProperty(c.getValue().getDuration().getStartTime()+" - "+c.getValue().getDuration().getEndTime());                
	        }
	}); 
		
		
		status.setCellValueFactory(new Callback<CellDataFeatures<Booking, String>, ObservableValue<String>>() {
	        @Override
	        public ObservableValue<String> call(CellDataFeatures<Booking, String> c) {
	            
	            String result="";
	            if(c.getValue().getStatus()==1)
	            {
	            	result="Confirmed";
	            }
	            else if(c.getValue().getStatus()==-1)
	            {
	            	result="Cancelled by admin";
	            }
	        	return new SimpleStringProperty(result);                
	        }
	});	
		
	bookings.setItems(data);
	
	
	bookings.setRowFactory(tv -> {
	    TableRow<Booking> row = new TableRow<>();
	    row.setOnMouseClicked(event -> {
	        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
	           selected = row.getItem();

//	            System.out.println(rowData.getChoice());
//	            rowData.setChoice(true);
	        
	            //requests.getItems().set(0, rowData);
	           
	            System.out.println("yes");
	            cancel.setDisable(false);
	            
	            
	            //System.out.println(rowData.getchoice());
	        }
	    });
	    return row ;
	});
	
	/**
	 * Cancels the selected booking, sets cancelled status and removes it from admin records 
	 */
	
	
	cancel.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e)
		{
			iiitdelhi.getAdmin().getbookings().remove(selected);
			
			Faculty current=(Faculty) iiitdelhi.getCurrentuser();
			current.getBookings().remove(selected);
			
			ObservableList<Booking> newdata= FXCollections.observableArrayList();
			bookings.getItems().remove(selected);
			int count=1;
			for(Booking b: bookings.getItems())
			{
				b.setSno(count);
				count++;
				newdata.add(b);
			}
			bookings.setItems(newdata);
			
			
			
		
		}
	});
		
	}

}
