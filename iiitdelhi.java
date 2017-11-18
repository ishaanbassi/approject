package college_data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import Users.Admin;
import Users.User;
import database.read_data2;

public class iiitdelhi implements Serializable{
	
	
	/**
	 * @author Ishaan Bassi, PRATYUSH KAUSHAL
	 * @version 1.0
	 * 
	 * THIS CLASS CONTAINS ALL THE BASIC INFORMATION OF THE COLLEGE,USERS OF THIS APPLICATION, LECTURES, COURSES AND ROOMS 
	 * 
	 */
	private static final long serialVersionUID = -7518692578223943826L;
	private static ArrayList<Room> rooms=new ArrayList<Room>();
	private static ArrayList<Course> courses=new ArrayList<Course>();
	private static ArrayList<Lecture> lectures=new ArrayList<Lecture>();
	private static Admin admin=new Admin();
	private static User currentuser;
	private static ArrayList<User> accounts=new ArrayList<User>();
	

	public static Admin getAdmin()
	{
		return admin;
	}
	public static void setdata() throws IOException, ClassNotFoundException
	{
		read_data2.initialize();
	}
	public static ArrayList<Room> getRooms() {
		return rooms;
	}
	public static void setRooms(ArrayList<Room> rooms) {
		iiitdelhi.rooms = rooms;
	}
	public static ArrayList<Course> getCourses() {
		return courses;
	}
	public static void setCourses(ArrayList<Course> courses) {
		iiitdelhi.courses = courses;
	}
	public static boolean isRoom(String x)
	{
		x=x.toUpperCase();
		for(int i=0;i<rooms.size();i++)
		{
			if(rooms.get(i).getRoomName().equals(x))
			{
				return true;
			}
		}
		return false;
	}
	public static void serialize() throws IOException
	{	
		ObjectOutputStream out1	=	null;	
		ObjectOutputStream out2 = null;
		ObjectOutputStream out3=  null;
		ObjectOutputStream out4 = null;
		ObjectOutputStream out5 = null;
		
		try	{	
			System.out.println("yes"+" "+admin.getlist().size());
			out1	=	new	ObjectOutputStream	(new FileOutputStream("rooms.txt"));	
			out1.writeObject(rooms);	
			out2  =  new	ObjectOutputStream	(new FileOutputStream("courses.txt"));	
			out2.writeObject(courses);
			out3  =  new ObjectOutputStream  (new FileOutputStream("admin.txt"));
			out3.writeObject(admin);
			out4 = new ObjectOutputStream (new FileOutputStream("accounts.txt"));
			out4.writeObject(accounts);
			out5=new ObjectOutputStream(new FileOutputStream("lectures.txt"));
			out5.writeObject(lectures);
			
		}finally	{
		out1.close();
		out2.close();
		out3.close();
		out4.close();
		out5.close();
		}	
		
	}
	public	static	void	deserialize()		throws	IOException,	ClassNotFoundException {	
	ObjectInputStream	in1	=	null;	
	ObjectInputStream   in2=	null;
	ObjectInputStream 	in3= null;
	ObjectInputStream in4=null;
	ObjectInputStream in5=null;
	try	{	
		
			in1 = new ObjectInputStream	(new FileInputStream("rooms.txt"));	
			in2 =new ObjectInputStream(new FileInputStream("courses.txt"));
			in3 =new ObjectInputStream(new FileInputStream("admin.txt"));
			in4 = new ObjectInputStream(new FileInputStream("accounts.txt"));
			in5=new ObjectInputStream(new FileInputStream("lectures.txt"));
			rooms = (ArrayList<Room>) in1.readObject();	
			courses = (ArrayList<Course>) in2.readObject();
			admin =(Admin) in3.readObject();
			accounts=(ArrayList<User>) in4.readObject();
			lectures=(ArrayList<Lecture>) in5.readObject();
	}	
	finally	{	
		in1.close();	
		in2.close();
		in3.close();
		in4.close();
		in5.close();
	}	
}
	public static ArrayList<User> getAccounts() {
		return accounts;
	}
	public static void setAccounts(ArrayList<User> accounts) {
		iiitdelhi.accounts = accounts;
	}
	public static User getCurrentuser() {
		return currentuser;
	}
	public static void setCurrentuser(User currentuser) {
		iiitdelhi.currentuser = currentuser;
	}
	/**
	 * @author PRATYUSH KAUSHAL
	 * @param email
	 * @param password
	 * @return boolean, true and false for right and wrong credentials respectively
	 */
	public static boolean checkcredentials(String email,String password)
	{
		for(User u: accounts)
		{
			System.out.println(u.getEmail()+" "+u.getPassword());
			if(u.getEmail().equals(email) && u.getPassword().equals(password))
			{
				currentuser=u;
				return true;
			}
		}
		return false;
	}
	/**
	 * @author PRATYUSH KAUSHAL
	 * @param r  - Room name
	 * @param date - Booking date
	 * @param t   - Booking time
	 * @return boolean, true for available and false for unavailable
	 * @throws ParseException
	 */
	public static boolean checkAvailability(String r,String date,Time t) throws ParseException
	{
		SimpleDateFormat tf = new SimpleDateFormat("h:mm a");
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		Date starttime =tf.parse(t.getStartTime());
		Date endtime = tf.parse(t.getEndTime());
		Date bookdate= df.parse(dateconvert(date));
		
		// checking lectures 
		System.out.println("CHECKING LECTURES!!");
		
		System.out.println("Booking day - "+t.getDay());
		
		for(Lecture l: lectures)
		{
			System.out.println("LOOP STARTED");
			System.out.println(l.getTimeObject().getDay());
			if(l.getTimeObject().getDay().equals(t.getDay()))
			{
				System.out.println("YES DAY FOUND!");
			Date st= tf.parse(l.getTimeObject().getStartTime());
			Date et=tf.parse(l.getTimeObject().getEndTime());
			ArrayList<Room> rooms=l.getRoomObject();
			for(Room room: rooms)
			{
				if(room.getRoomName().equals(r))
				{
					
					System.out.println("Room "+room.getRoomName()+" found!");
					System.out.println(starttime+" "+endtime);
					System.out.println(st+" "+et);
					 if(((starttime.before(st) || starttime.equals(st)) && endtime.after(st)) || (starttime.before(et)&& (endtime.equals(et) ||endtime.after(et))))
					 {
						 return false;
					 }
				}
			}
			
			}
		}
		// checking room bookings 
		
		ArrayList<Booking> bookings=admin.getbookings();
		
		for(Booking b: bookings)
		{
			Date st= tf.parse(b.getDuration().getStartTime());
			Date et=tf.parse(b.getDuration().getEndTime());
			Date d = df.parse(dateconvert(b.getDate()));
			if(d.equals(bookdate) && b.getRoom().equals(r))
			{
				if(((starttime.before(st) || starttime.equals(st)) && endtime.after(st)) || (starttime.before(et)&& (endtime.equals(et) ||endtime.after(et))))
				 {
					 return false;
				 }
			}
		}
		
		return true;
	
	}
	/**
	 * 
	 * @param cap  - Size of room required
	 * @param date - Booking date
	 * @param t - Booking Time
	 * @param r - Preferred room
	 * @return finalroom - Room booked if booking is possible , else null is returned
	 * @throws ParseException
	 */
	public static String checkbycap(int cap,String date,Time t,String r) throws ParseException
	{
		SimpleDateFormat tf = new SimpleDateFormat("h:mm a");
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		Date starttime =tf.parse(t.getStartTime());
		Date endtime = tf.parse(t.getEndTime());
		Date bookdate= df.parse(dateconvert(date));
		
		ArrayList<String> shortlisted=new ArrayList<String>();
	
		
		for(Room room: rooms)
		{
			
			boolean available=true;
			if(room.getcapacity()>=cap)
			{
				ArrayList<Time> times=room.getSessions();
			
				for(Time session:times)
				{
					
					Date st= tf.parse(session.getStartTime());
					Date et=tf.parse(session.getEndTime());
					if(session.getDay().equals(t.getDay()))
					{
						System.out.println(st+" "+et);
						if(((starttime.before(st) || starttime.equals(st)) && endtime.after(st)) || (starttime.before(et)&& (endtime.equals(et) ||endtime.after(et))))
						{
							available=false;
							break;
						 }
					}
					
				}
				if(available==true)
				{
					
					shortlisted.add(room.getRoomName());
				}
				
			}
		}
		
		
		for(String shortlist:shortlisted)
		{
			System.out.println(shortlist);
		}
		
		ArrayList<Booking> bookings=admin.getbookings();
		for(Booking b: bookings)
		{
			
		System.out.println(b.getRoom() +" "+b.getDuration().getStartTime()+" "+b.getDuration().getEndTime());	
		
		Room room=null;
				
			for(Room temp:iiitdelhi.getRooms())
			{
				if(temp.roomName.equals(b.getRoom()))
				{
					room=temp;
				}
			}
			
			
			if(room.getcapacity()>=cap)
			{
				
							Date st= tf.parse(b.getDuration().getStartTime());
							Date et=tf.parse(b.getDuration().getEndTime());
							Date d = df.parse(dateconvert(b.getDate()));
							if(d.equals(bookdate) && b.getRoom().equals(r))
							{
								if(!(((starttime.before(st) || starttime.equals(st)) && endtime.after(st)) || (starttime.before(et)&& (endtime.equals(et) ||endtime.after(et)))))
								 {
									 shortlisted.add(b.getRoom());
								 }
								else if(shortlisted.contains(b.getRoom()))
								{
									shortlisted.remove(b.getRoom());
								}
							}
							
			}
		}
		

		String finalroom=null;
		for(String shortlist:shortlisted)
		{
			
			if(shortlist.equals(r))
			{
				finalroom=shortlist;
				break;
			}
			else
			{
				finalroom=shortlist;
			}
		}
		return finalroom;
		
	}
	
	/**
	 * 
	 * @param d - Date in the initial format
	 * @return Corrected format
	 */
	
	public static String dateconvert(String d)
	{
		String[] parts=d.split("/");
		return parts[2]+"-"+parts[1]+"-"+parts[0];
	}
	public static ArrayList<Lecture> getLectures() {
		return lectures;
	}
	public static void setLectures(ArrayList<Lecture> lectures) {
		iiitdelhi.lectures = lectures;
	}
	

}
