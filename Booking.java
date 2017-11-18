package college_data;

import java.io.Serializable;


public class Booking implements Serializable {
	/**
	 *  @author PRATYUSH KAUSHAL
	 *  @version 1.0
	 *  
	 * THIS CLASS STORES THE BOOKING RECORD WITH ROOM,DATE,DURATION, STATUS AND SERIAL NO. DETAILS
	 * 
	 */
	private static final long serialVersionUID = -4284199535701935853L;
	
	private String room;
	private String date;
	private Time duration;
	private int sno;
	private int status=0;
	public Booking(String r,String d,Time dur)
	{
		room=r;
		date=d;
		duration=dur;
		
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

}
