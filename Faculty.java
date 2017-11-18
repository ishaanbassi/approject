package Users;

import java.io.Serializable;
import java.util.ArrayList;

import college_data.Booking;
import college_data.Lecture;


/**
 * 
 * @author ISHAAN BASSI
 * @version 1.0
 * 
 *  IN EXTENDED CLASS TO USER THAT STORES FACULTY SPECIFIC DETAILS LIKE HIS/HER
 *  ROOM BOOKINGS AND TIMETABLE OF COURSES THE PERSON TEACHES
 *
 *
 */
public class Faculty extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -940626832084196375L;
	public ArrayList<Booking> bookings=new ArrayList<Booking>();
	public ArrayList<Lecture> courses =new ArrayList<Lecture>();
	public ArrayList<Lecture> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Lecture> courses) {
		this.courses = courses;
	}
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	public Faculty(String name,String email,String type,String password)
	{
		super(name,email,type,password);
	
//		this.name=name;
//		this.email=email;
//		this.type=type;
//		this.password=password;
	}

}
