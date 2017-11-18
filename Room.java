package college_data;
import java.io.Serializable;
import java.util.*;

public class Room implements Serializable
{
	/**
	 * 
	 * @author PRATYUSH KAUSHAL 
	 * @version 1.0
	 * 
	 * THIS CLASS REPRESENTS A SINGLE ROOM IN THE IIITD COLLEGE WITH ITS CAPACITY , ROOM NO. AND A LIST OF TIMINGS DURING WHICH IT IS OCCUPIED
	 */

private static final long serialVersionUID = -749748721700635097L;
String roomName;
int capacity;
public ArrayList<Time> sessions;

public Room(String roomName, int capacity)
{
this.roomName= roomName;
this.capacity= capacity;
sessions=new ArrayList<Time>();
}
public ArrayList<Time> getSessions() {
	return sessions;
}
public void setSessions(ArrayList<Time> sessions) {
	this.sessions = sessions;
}
public void addsession(Time t)
{
	sessions.add(t);
}
public void removesession(Time t)
{
	sessions.remove(t);
}
public void setcapacity(int capacity)
{
this.capacity=capacity;
}

public int getcapacity()
{
return capacity;
}

public void setRoomName( String roomName)
{
this.roomName= roomName;
}

public String getRoomName()
{
return roomName;
}

public String toString()
{
	return roomName;
}

}
