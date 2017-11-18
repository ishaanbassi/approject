package college_data;
import java.io.Serializable;
import java.util.*;

public class Time implements Serializable
{
	/**
	 * 
	 * @author PRATYUSH KAUSHAL 
	 * @version 1.0
	 * 
	 * THIS CLASS REPRESENTS BOTH THE TIMING OF A LECTURE AND BOOKING
	 * TYPE OF CLASS IS STORED FOR REPRESENTATION IN STUDENT TIMETABLE
	 * IN BOOKING OR REQUEST THIS PART IS LEFT UNASSIGNED
	 */
	
	
private String day; 
private String classtype;
private String startTime;
private String endTime;


public Time(String day, String startTime, String endTime)
{
this.day=day;
this.startTime=startTime;
this.endTime=endTime;
}

public  void setDay( String day)
{
this.day=day;
}

public String getDay()
{
return day;
}

public void setStartTime(String startTime)
{
this.startTime=startTime;
}

public String getStartTime()
{
return startTime;
}

public void setEndTime(String endTime)
{
this.endTime=endTime;
}

public String getEndTime()
{
return endTime;
}
@Override
public String toString()
{
	return day+" "+classtype+" "+startTime+" - "+endTime;
}

public String getClasstype() {
	return classtype;
}

public void setClasstype(String classtype) {
	this.classtype = classtype;
}



}
