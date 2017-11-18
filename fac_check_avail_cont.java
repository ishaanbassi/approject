package application;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXTextField;

import college_data.Time;
import college_data.iiitdelhi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class fac_check_avail_cont implements javafx.fxml.Initializable  {

	@FXML
	JFXButton back;
	@FXML
	JFXButton check;
	@FXML
	JFXTextField room;
	@FXML
	JFXDatePicker date;
	@FXML
	JFXTimePicker from;
	@FXML
	JFXTimePicker to;
	
	boolean b1,b2,b3,b4;
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
		
		room.textProperty().addListener((observable,oldValue,newValue)->{
			if(newValue!=null)
			{
				b1=true;
				
			}
			if (b1==true && b2==true && b3==true && b4==true )
		    {
		    	
		    	check.setDisable(false);
		    }
		});
		
		
		from.valueProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null)
			{
				b3=true;
				
			}
			if (b1==true && b2==true && b3==true && b4==true )
		    {
		    	
		    	check.setDisable(false);
		    }
		});
		to.valueProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null)
			{
				b4=true;	
			}
			if (b1==true && b2==true && b3==true && b4==true )
		    {
		    	
		    	check.setDisable(false);
		    }
		});
		
		
		date.valueProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null)
			{
				b2=true;
			
			}
			
			if (b1==true && b2==true && b3==true && b4==true)
		    {
		    	
		    	check.setDisable(false);
		    }
			
		});
		
		check.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				/**
				 * Checks if the room is vacant in the given timings
				 * Gives an alert message accordingly
				 */
				boolean b=check_roomno();
				if(b==false)
				{
					Alert a=new Alert(AlertType.ERROR);
					a.setContentText("The given room number does not exist!");
					a.showAndWait();	
				}
				else
				{
					String d= date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-EEE"));
					String[] dateparts=d.split("-");
					String dd,mm,yy,day;
					day=dateparts[3];
					dd=dateparts[2];
					mm=dateparts[1];
					yy=dateparts[0];
					String d_final=dd+"/"+mm+"/"+yy;
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a");
					
					LocalTime t=from.getValue();
					String fr=t.format(dtf);
					System.out.println(fr);
					
					LocalTime t1=to.getValue();
					String endtime=t1.format(dtf);
					System.out.println(endtime);
					Time duration = new Time(day,fr,endtime);
					
					String r=room.getText();
					try {
						if(iiitdelhi.checkAvailability(r,d_final,duration))
						{
							Alert a =new Alert(AlertType.INFORMATION);
							a.setContentText("The given room is available in the above time slot");
							a.showAndWait();
							
						}
						else
						{
							Alert a =new Alert(AlertType.ERROR);
							a.setContentText("This room is unavailable in the above time slot");
							a.showAndWait();
							
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});	
		
		
		
	}
	/**
	 * For checking whether the given string is valid room or not
	 * @return
	 */
	boolean check_roomno()
	{
		String input=room.getText();
		if(iiitdelhi.isRoom(input))
		{
			System.out.println(input);
			return true;
		}
		return false;
	}

}
