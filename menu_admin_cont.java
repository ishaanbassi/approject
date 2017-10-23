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

public class menu_admin_cont implements javafx.fxml.Initializable {

	@FXML
	AnchorPane pane00;
	@FXML
	AnchorPane pane01;
	@FXML
	AnchorPane pane10;
	@FXML
	AnchorPane pane11;
	@FXML
	Hyperlink logout;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
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
		
		//PANE00
		
				pane00.setBackground(new Background(new BackgroundFill(Color.web("#F377BF"), CornerRadii.EMPTY, Insets.EMPTY)));
				pane00.setOnMouseEntered(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane00.setBackground(new Background(new BackgroundFill(Color.web("#F2ABCE"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				pane00.setOnMouseExited(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane00.setBackground(new Background(new BackgroundFill(Color.web("F377B5"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				//PANE01
				
				pane01.setBackground(new Background(new BackgroundFill(Color.web("#B095F4"), CornerRadii.EMPTY, Insets.EMPTY)));
				pane01.setOnMouseEntered(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane01.setBackground(new Background(new BackgroundFill(Color.web("#E0D7F4"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				pane01.setOnMouseExited(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane01.setBackground(new Background(new BackgroundFill(Color.web("#B095F4"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				//PANE10
				
				pane10.setBackground(new Background(new BackgroundFill(Color.web("#F5C741"), CornerRadii.EMPTY, Insets.EMPTY)));
				pane10.setOnMouseEntered(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane10.setBackground(new Background(new BackgroundFill(Color.web("#F6DB8C"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				pane10.setOnMouseExited(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane10.setBackground(new Background(new BackgroundFill(Color.web("#F5C741"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				
				//PANE11
				
				pane11.setBackground(new Background(new BackgroundFill(Color.web("#2DE9BF"), CornerRadii.EMPTY, Insets.EMPTY)));
				pane11.setOnMouseEntered(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane11.setBackground(new Background(new BackgroundFill(Color.web("#B9F2E5"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });
				pane11.setOnMouseExited(new EventHandler<MouseEvent>() {

			        @Override
			        public void handle(MouseEvent t) {
			           pane11.setBackground(new Background(new BackgroundFill(Color.web("#2DE9BF"), CornerRadii.EMPTY, Insets.EMPTY)));
			        }
			    });

		
		
		
		
		

	}

}
