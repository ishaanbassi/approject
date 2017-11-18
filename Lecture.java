package college_data;
import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author PRATYUSH KAUSHAL 
 * @version 1.0
 * 
 * THIS CLASS REPRESENTS A SINGLE LECTURE, TUTORIAL OR LAB WITH ITS TIME , ROOMS AND THE COURSE WHICH IT IS PART OF
 */


public class Lecture implements Serializable
{
Time _time;
ArrayList<Room> _room;
Course _Course;


public Lecture( Time _time, ArrayList<Room> _room, Course _Course)
{
this._time= _time;
this._room= _room;
this._Course= _Course;
}

public Time getTimeObject()
{
return _time;
}

public ArrayList<Room> getRoomObject()
{
return _room;
}

public Course getCourseObject()
{
return _Course;
}

public void setTimeObject( Time _time)
{
this._time= _time;
}

public void setRoomObject(ArrayList<Room> _room)
{
this._room= _room;
}

public void setCourseObject(Course _Course)
{
this._Course= _Course;
}

}
