	package application;
	
import java.io.IOException;

import college_data.Lecture;
import college_data.iiitdelhi;
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
			s.setResizable(false);
			s.setTitle("IIIT Delhi Application");
			iiitdelhi.deserialize();
			

			
			FXMLLoader loader=new FXMLLoader(getClass().getResource("first.fxml"));
			Parent root=loader.load();
			Scene scene = new Scene(root,765,528);
			
			Button btn = (Button) loader.getNamespace().get("login");
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

		        public void run() {
		            try {
		            	
		            	
						iiitdelhi.serialize();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    }));
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * For loading login page
	 * @throws IOException
	 */
	public static void loginpage() throws IOException
	{
		
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("loginpage.fxml"));
		Parent root=loader.load();
		
		s.setTitle("LOGIN");
		Scene scene = new Scene(root,762,538);
		s.setScene(scene);
		
	}
	/**
	 * For loading student menu
	 * @throws IOException
	 */
	public static void student_login()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("menu_student.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Menu");
		Scene scene = new Scene(root,788,570);
		s.setScene(scene);
		
	}
	/**
	 * For loading faculty menu
	 * @throws IOException
	 */
	public static void faculty_login()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("menu_faculty.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Menu");
		Scene scene = new Scene(root,788,505);
		s.setScene(scene);
		
	}
	/**
	 * For loading admin menu
	 * @throws IOException
	 */
	public static void admin_login()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("menu_admin.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Menu");
		Scene scene = new Scene(root,719,523);
		s.setScene(scene);
		
	}
	/**
	 * For loading signup page for creating new account
	 * @throws IOException
	 */
	public static void signuppage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("signup.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Sign Up");
		Scene scene = new Scene(root,779,538);
		s.setScene(scene);
		
	}
	/**
	 * For viewing booking requests sent by the student 
	 * @throws IOException
	 */
	public static void view_cancel_requestpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("view_cancel_request.fxml"));
		Parent root=loader.load();
		
		s.setTitle("View/Cancel Booking Request");
		Scene scene = new Scene(root,900,500);
		s.setScene(scene);
		
	}
	/**
	 * Loading page for searching and adding courses courses
	 * @throws IOException
	 */
	public static void search_coursepage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("search_course.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Search Courses");
		Scene scene = new Scene(root,1024,645);
		s.setScene(scene);
		
	}
	/**
	 * For viewing student profile 
	 * @throws IOException
	 */
	public static void st_profilepage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("profile_student.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Profile");
		Scene scene = new Scene(root,845,531);
		s.setScene(scene);
		
	}
	/**
	 * For viewing faculty profile
	 * @throws IOException
	 */
	public static void fac_profilepage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("profile_faculty.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Profile");
		Scene scene = new Scene(root,741,531);
		s.setScene(scene);
		
	}
	/**
	 * For viewing courses taught by the faculty member
	 * @throws IOException
	 */
	public static void view_coursespage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("view_course.fxml"));
		Parent root=loader.load();
		
		s.setTitle("My Courses");
		Scene scene = new Scene(root,1300,500);
		s.setScene(scene);
		
	}
	/**
	 * Form for booking the room for faculty
	 * @throws IOException
	 */
	public static void room_bookpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("room_book.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Room Booking");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
		
	}
	/**
	 * Form for sending booking request - for student
	 * @throws IOException
	 */
	public static void send_requestpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("send_request.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Room Booking Request");
		Scene scene = new Scene(root,676,484);
		scene.getRoot().requestFocus();
		s.setScene(scene);
	}
	/**
	 * Form for checking availability of a room for student
	 * @throws IOException
	 */
	public static void st_check_availpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("st_check_avail.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Check Room Availability");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
	}
	/**
	 * Form for checking availability of a room for faculty
	 * @throws IOException
	 */
	public static void fac_check_availpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("fac_check_avail.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Check Room Availability");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
	}
	/**
	 * Viewing timetable of the student
	 * @throws IOException
	 */
	public static void viewttpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("viewtt.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Timetable");
		Scene scene = new Scene(root,1300,500);
		s.setScene(scene);
	}
	/**
	 * For selecting and canceling booking done by the faculty
	 * @throws IOException
	 */
	public static void cancel_bookingpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("cancel_booking.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Cancel Booking");
		Scene scene = new Scene(root,805,599);
		s.setScene(scene);
	}
	/**
	 * For selecting and canceling booking done by anyone
	 * @throws IOException
	 */
	public static void admin_cancel_bookingpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("admin_cancel_booking.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Cancel Booking");
		Scene scene = new Scene(root,805,599);
		s.setScene(scene);
	}
	/**
	 * Form for booking the room for admin
	 * @throws IOException
	 */
	public static void admin_room_bookpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("admin_room_book.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Room Booking");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
	}
	
	/**
	 * Form for checking availability of a room for faculty
	 * @throws IOException
	 */
	public static void admin_check_availpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("admin_check_avail.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Check Availability");
		Scene scene = new Scene(root,600,400);
		s.setScene(scene);
	}
	/**
	 * Accepting and rejecting students' room booking requests
	 * 
	 * @throws IOException
	 */
	
	public static void admin_acc_rej_requestpage()throws IOException
	{
		FXMLLoader loader=new FXMLLoader(Main.class.getResource("admin_acc_rej_request.fxml"));
		Parent root=loader.load();
		
		s.setTitle("Accept/Reject Requests");
		Scene scene = new Scene(root,987,500);
		s.setScene(scene);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
