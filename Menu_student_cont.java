package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menu_student_cont implements javafx.fxml.Initializable{

	@FXML
	AnchorPane pane00;
	@FXML
	AnchorPane pane01;
	@FXML
	AnchorPane pane10;
	@FXML
	AnchorPane pane11;
	@FXML
	AnchorPane pane20;
	@FXML
	AnchorPane pane21;
	@FXML
	Hyperlink logout;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//pane00.setStyle("-fx-background-color: #B095F4");
		
		
		
		
		logout.setBorder(Border.EMPTY);
		logout.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
		    	try {
					Main.loginpage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});	
		
		
		
		
		
		
		
		
		pane00.setBackground(new Background(new BackgroundFill(Color.web("#B095F4"), CornerRadii.EMPTY, Insets.EMPTY)));
		pane00.setOnMouseClicked(e -> {
			try {
				clicked00();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		pane00.setOnMouseEntered(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane00.setBackground(new Background(new BackgroundFill(Color.web("#E0D7F4"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		pane00.setOnMouseExited(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane00.setBackground(new Background(new BackgroundFill(Color.web("#B095F4"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		
		// PANE01
		
		pane01.setBackground(new Background(new BackgroundFill(Color.web("#A5F587"), CornerRadii.EMPTY, Insets.EMPTY)));
		pane01.setOnMouseClicked(e -> {
			try {
				clicked01();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		pane01.setOnMouseEntered(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane01.setBackground(new Background(new BackgroundFill(Color.web("#C7F1B7"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		pane01.setOnMouseExited(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane01.setBackground(new Background(new BackgroundFill(Color.web("#A5F587"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		
		
		// PANE10
		
		pane10.setBackground(new Background(new BackgroundFill(Color.web("#2DE9BF"), CornerRadii.EMPTY, Insets.EMPTY)));
		pane10.setOnMouseClicked(e -> {
			try {
				clicked10();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane10.setOnMouseEntered(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane10.setBackground(new Background(new BackgroundFill(Color.web("#B9F2E5"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		pane10.setOnMouseExited(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane10.setBackground(new Background(new BackgroundFill(Color.web("#2DE9BF"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		
		// PANE11
		
		pane11.setBackground(new Background(new BackgroundFill(Color.web("#F5C741"), CornerRadii.EMPTY, Insets.EMPTY)));
		pane11.setOnMouseClicked(e -> {
			try {
				clicked11();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane11.setOnMouseEntered(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane11.setBackground(new Background(new BackgroundFill(Color.web("#F6DB8C"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		pane11.setOnMouseExited(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane11.setBackground(new Background(new BackgroundFill(Color.web("#F5C741"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		
		
		// PANE 20
		
		pane20.setBackground(new Background(new BackgroundFill(Color.web("#F377BF"), CornerRadii.EMPTY, Insets.EMPTY)));
		pane20.setOnMouseClicked(e -> {
			try {
				clicked20();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane20.setOnMouseClicked(e -> {
			try {
				clicked20();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane20.setOnMouseEntered(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane20.setBackground(new Background(new BackgroundFill(Color.web("#F2ABCE"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		pane20.setOnMouseExited(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane20.setBackground(new Background(new BackgroundFill(Color.web("F377BF"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		
		// PANE21
		
		pane21.setBackground(new Background(new BackgroundFill(Color.web("#F36E5B"), CornerRadii.EMPTY, Insets.EMPTY)));
		pane21.setOnMouseClicked(e -> {
			try {
				clicked21();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane21.setOnMouseEntered(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane21.setBackground(new Background(new BackgroundFill(Color.web("#F7A599"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
		pane21.setOnMouseExited(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent t) {
	           pane21.setBackground(new Background(new BackgroundFill(Color.web("F36E5B"), CornerRadii.EMPTY, Insets.EMPTY)));
	        }
	    });
	
	}
	public void clicked20() throws IOException
	{
		Main.view_cancel_requestpage();
		
	}
	public void clicked21() throws IOException
	{
		Main.search_coursepage();
		
	}
	public void clicked00() throws IOException
	{
		Main.profilepage();
		
	}
	public void clicked10() throws IOException
	{
		Main.send_requestpage();
		
	}
	public void clicked11() throws IOException
	{
		Main.check_availpage();
		
	}
	public void clicked01() throws IOException
	{
		Main.viewttpage();
		
	}

	
}
