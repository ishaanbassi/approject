package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

//import com.gluonhq.charm.glisten.control.TextArea;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import com.gluonhq.charm.glisten.control.TextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import Users.Admin;
import Users.Student;
import college_data.Request;
import college_data.Time;
import college_data.iiitdelhi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.DialogPane;

public class send_request_cont implements javafx.fxml.Initializable{

	
	Alert a;
	@FXML
	JFXButton back;
	@FXML
	JFXButton send;
	@FXML
	JFXTimePicker from;
	@FXML
	JFXTimePicker to;
	@FXML
	JFXDatePicker date;
	@FXML
	TextArea reason;
	@FXML
	TextField cap;
	@FXML
	TextField room;
	@FXML
	DialogPane error;
	boolean b1,b2,b3,b4,b5;
	Request r;
	@FXML
	Pane pane;
	
	
	
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
		
		
		
		cap.textProperty().addListener((observable, oldValue, newValue) -> {
            
			if(newValue.length()>0)
			{
				System.out.println(newValue);
				b1=true;
			}
			if(newValue.equals(""))
			{
				b1=false;
				send.setDisable(true);
			}
			if (b1==true && b2==true && b3==true && b4==true && b5==true)
		    {
		    	send.setDisable(false);
		    }
			
			
			
        });
		date.valueProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null)
			{
				b2=true;
			
			}
			
			if (b1==true && b2==true && b3==true && b4==true && b5==true)
		    {
		    	
		    	send.setDisable(false);
		    }
			
		});
		from.valueProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null)
			{
				b3=true;
				
			}
			if (b1==true && b2==true && b3==true && b4==true && b5==true)
		    {
		    	
		    	send.setDisable(false);
		    }
		});
		to.valueProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null)
			{
				b4=true;	
			}
			if (b1==true && b2==true && b3==true && b4==true && b5==true)
		    {
		    	
		    	send.setDisable(false);
		    }
		});
		reason.textProperty().addListener((observable,oldValue,newValue)->
		{
			if(newValue!=null || !newValue.equals(""))
			{
				b5=true;	
			}
			if(newValue.equals(""))
			{
				b5=false;
				send.setDisable(true);
			}
			if (b1==true && b2==true && b3==true && b4==true && b5==true)
		    {
		    	
		    	send.setDisable(false);
		    }
		});
		
		
		
		
		
		
		
		send.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			/**
			 * Sends the booking request to the admin after validating the details
			 */
			public void handle(ActionEvent e)
			{
				Alert a=new Alert(AlertType.ERROR);
				String s=room.getText();
				boolean b1=false,b2,b3=false;
				if(s!=null && !s.equals(""))
				{
					System.out.println("YES!!");
					b3=true;
					b1=check_roomno();
				}
				b2=check_cap();
				if((b3==true && b1==false) || b2==false)
				{
					String content="";
					if(b2==false)content=content+"The room capacity must be an integer!\n";
					if(b3==true && b1==false)content=content+"The entered room no. is invalid!";
					a.setContentText(content);
					a.showAndWait();
				}
				else
				{
					String in=cap.getText();
					int capacity=Integer.parseInt(in);
					System.out.println(capacity);
					String roo;
					if(b3==true)
					{
						roo=room.getText();
					}
					else
					{
						roo=null;
					}
					String d= date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-EEE"));
					String[] dateparts=d.split("-");
					String dd,mm,yy,day;
					day=dateparts[3];
					dd=dateparts[2];
					mm=dateparts[1];
					yy=dateparts[0];
					String d_final=dd+"/"+mm+"/"+yy;
					System.out.println(d_final);
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a");
					
					LocalTime t=from.getValue();
					String fr=t.format(dtf);
					System.out.println(fr);
					
					LocalTime t1=to.getValue();
					String endtime=t1.format(dtf);
					System.out.println(endtime);
					
					String re=reason.getText();
					System.out.println(re);
					Time interval=new Time(day,fr,endtime);
					
					
					//GENERATED REQUEST
					
				
					
					Request r=new Request(capacity,roo,d_final,interval,re);
					r.setSenddate(LocalDate.now());
					r.setStatus(0); // --> PENDING REQUEST
					Admin admin =iiitdelhi.getAdmin();
					ArrayList<Request> req_list=admin.getlist();
					req_list.add(r);
					Student stud=(Student) iiitdelhi.getCurrentuser();
					stud.getRequests().add(r);
					Alert reqsent=new Alert(AlertType.INFORMATION);
					String content="Your request for room booking has been sent for approval\nYou can check the booking status from Menu > view/cancel request";
					reqsent.setContentText(content);
					reqsent.showAndWait();
					if(reqsent.isShowing()==false)
					{
						cap.setText(null);
						room.setText(null);
						date.setValue(null);
						from.setValue(null);
						to.setValue(null);
						reason.setText(null);
						
					}
				}
			}
		});
		
		
	}
	boolean check_cap()
	{
		String input=cap.getText();
		if(!(input.matches("[0-9]+")))
		{
			return false;
		}
		return true;
	}
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
