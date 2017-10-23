package application;
	
import javafx.event.EventHandler;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	public static Stage s;
	@Override
	
	public void start(Stage primaryStage) {
		try {
			s= primaryStage;
			s.setTitle("IIIT Delhi Application");
			
			FXMLLoader loader=new FXMLLoader(getClass().getResource("first.fxml"));
			Parent root=loader.load();
			Scene scene = new Scene(root,779,538);
			
			Button btn = (Button) loader.getNamespace().get("login");
			
		
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void loginpage() throws IOException
	{
		
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("loginpage.fxml"));
		Parent root=loader.load();
		
		s.setTitle("LOGIN");
		Scene scene = new Scene(root,779,538);
		s.setScene(scene);
		
	}
	public static void student_login()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("menu_student.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Menu");
		Scene scene = new Scene(root,500,490);
		s.setScene(scene);
		
	}
	public static void faculty_login()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("menu_faculty.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Menu");
		Scene scene = new Scene(root,500,365);
		s.setScene(scene);
		
	}
	public static void admin_login()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("menu_admin.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Menu");
		Scene scene = new Scene(root,500,373);
		s.setScene(scene);
		
	}
	public static void signuppage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("signup.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Sign Up");
		Scene scene = new Scene(root,779,538);
		s.setScene(scene);
		
	}
	public static void view_cancel_requestpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("view_cancel_request.fxml"));
		Parent root=loader.load();
		
		s.setTitle("View/Cancel Booking Request");
		Scene scene = new Scene(root,900,500);
		s.setScene(scene);
		
	}
	public static void search_coursepage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("search_course.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Search Courses");
		Scene scene = new Scene(root,1000,600);
		s.setScene(scene);
		
	}
	public static void profilepage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("profile_student.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Profile");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
		
	}
	public static void view_coursespage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("view_course.fxml"));
		Parent root=loader.load();
		
		s.setTitle("My Courses");
		Scene scene = new Scene(root,900,500);
		s.setScene(scene);
		
	}
	public static void room_bookpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("room_book.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Room Booking");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
		
	}
	public static void send_requestpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("send_request.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Room Booking Request");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
	}
	public static void check_availpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("check_avail.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Check Room Availability");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
	}
	public static void viewttpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("viewtt.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Timetable");
		Scene scene = new Scene(root,900,500);
		s.setScene(scene);
	}
	public static void cancel_bookingpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("cancel_booking.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Cancel Booking");
		Scene scene = new Scene(root,649,511);
		s.setScene(scene);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
