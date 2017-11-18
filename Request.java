package college_data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Request implements Serializable{
	/**
	 *  @author PRATYUSH KAUSHAL
	 *  @version 1.0
	 *  
	 * THIS CLASS IS USED FOR STORING STUDENT REQUESTS WITH DETAILS OF PREFERRED ROOM , CAPACITY REQUIRED , REASON ,DATE AND DURATION DETAILS 
	 * ALONG WITH A REFERENCE TO THE BOOKING OBJECT ONCE THE REQUEST IS ACCEPTED
	 * 
	 */
	private static final long serialVersionUID = 2601125431319854645L;
	private int cap;
	private String pref_room;
	private String reason;
	private String date;
	private Time duration;
	private int status;
	private int sno;
	private Booking done;
	private LocalDate senddate;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public Request(int c, String r,String d,Time f,String re)
	{
		cap=c;
		pref_room=r;
		reason=re;
		date=d;
		duration=f;
		
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getPref_room() {
		return pref_room;
	}
	public void setPref_room(String pref_room) {
		this.pref_room = pref_room;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public void setFrom(Time dur) {
		this.duration = dur;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int x)
	{
		status=x;
	}
	public Booking getDone() {
		return done;
	}
	public void setDone(Booking done) {
		this.done = done;
	}
	public LocalDate getSenddate() {
		return senddate;
	}
	public void setSenddate(LocalDate senddate) {
		this.senddate = senddate;
	}
	

}
