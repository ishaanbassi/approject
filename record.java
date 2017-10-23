package application;

import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ObservableValue;

public class record {
	private int sno;
	String room;
	String date;
	String from;
	String to;
	String reason;
	String status;
	private BooleanProperty choice;
	public BooleanProperty getChoiceprop()
	{
		return choice;
	}
	public boolean getchoice()
	{
		return choice.get();
	}
	public void setChoice(boolean b)
	{
		choice.set(b);
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
