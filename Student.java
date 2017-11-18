package Users;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import college_data.Lecture;
import college_data.Lecture;
import college_data.Request;
import college_data.Time;


/**
 * 
 * @author ISHAAN BASSI
 * @version 1.0
 * 
 *  IN EXTENDED CLASS TO USER THAT STORES STUDENT SPECIFIC DETAILS LIKE HIS/HER REQUESTS FOR
 *  ROOM BOOKING AND TIMETABLE
 *
 *
 */


public class Student extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261104224221969613L;
	ArrayList<Request> requests=new ArrayList<Request>();
	ArrayList<Lecture> timetable=new ArrayList<Lecture>();
	public ArrayList<Lecture> getTimetable() {
		return timetable;
	}

	public void setTimetable(ArrayList<Lecture> timetable) {
		this.timetable = timetable;
	}

	public ArrayList<Request> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<Request> requests) {
		this.requests = requests;
	}
	public Student(String name,String email,String type,String password)
	{
		super(name,email,type,password);

	}
	/**
	 * 
	 * @param t - TIMING OF LECTURE OF COURSE BEING ADDED 
	 * @return boolean - true for clash , false for no clash 
	 * @throws ParseException
	 */
	public boolean checkclash(Time t) throws ParseException
	{
		SimpleDateFormat tf = new SimpleDateFormat("h:mm a");
		Date starttime =tf.parse(t.getStartTime());
		Date endtime = tf.parse(t.getEndTime());
		for(Lecture l: timetable )
		{
			Date st= tf.parse(l.getTimeObject().getStartTime());
			Date et=tf.parse(l.getTimeObject().getEndTime());
			if(l.getTimeObject().getDay().equals(t.getDay()))
			{
				
			if(((starttime.before(st) || starttime.equals(st)) && endtime.after(st)) || (starttime.before(et)&& (endtime.equals(et) ||endtime.after(et))))
			 {
				 return true;
			 }
			}
		}
		return false;
	}

}
