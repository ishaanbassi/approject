package Users;
import java.io.Serializable;
import java.util.ArrayList;

import college_data.Booking;
import college_data.Request;


/**
 * 
 * @author ISHAAN BASSI
 * @version 1.0
 * 
 *  STORES ADMIN SPECIFIC DETAILS LIKE REQUESTS RECIEVED AND BOOKING DONE BY ALL USERS
 *
 */
public class Admin extends User implements Serializable  {
	
	
	private static Admin admin=null;
	
	private ArrayList<Request> requests=new ArrayList<Request>();
	public ArrayList<Booking> bookings=new ArrayList<Booking>();
	
	public static Admin admingen()
	{
		if(admin==null)
		{
			admin=new Admin();
		}
		return admin;
	}
	public Admin() {
		
		
		super("admin","admin@iiitd.ac.in","Admin","xyz342");
//		this.name="admin";
//		this.email="admin@iiitd.ac.in";
//		this.type="Admin";
//		this.password="xyz342";
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8689229810779633594L;
	
	public ArrayList<Request> getlist()
	{
		return requests;
	}
	public ArrayList<Booking> getbookings()
	{
		return bookings;
	}
	

}
