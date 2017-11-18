package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import college_data.Booking;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class admin_cancel_booking_cont implements javafx.fxml.Initializable{
	
	
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
						Main.admin_login();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
				ObservableList<Booking> data= FXCollections.observableArrayList();
				ArrayList<Booking> booked_rooms=iiitdelhi.getAdmin().getbookings();
				
				for(int i=0;i<booked_rooms.size();i++)
				{ 
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
			
				
				
				
				
				
			bookings.setItems(data);
			
			
			bookings.setRowFactory(tv -> {
			    TableRow<Booking> row = new TableRow<>();
			    row.setOnMouseClicked(event -> {
			        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
			           selected = row.getItem();
	
//			            System.out.println(rowData.getChoice());
//			            rowData.setChoice(true);
			        
			            //requests.getItems().set(0, rowData);
			           
			            System.out.println("yes");
			            cancel.setDisable(false);
			            
			            
			            //System.out.println(rowData.getchoice());
			        }
			    });
			    return row ;
			});
			
			cancel.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				/**
				 * Cancels the selected booking, sets cancelled status and removes it from admin records 
				 */
				
				
				public void handle(ActionEvent e)
				{
					selected.setStatus(-1);
					iiitdelhi.getAdmin().getbookings().remove(selected);
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
