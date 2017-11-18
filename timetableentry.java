package college_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 
 * @author ISHAAN BASSI 
 * @version 1.0
 * 
 * THIS CLASS IS USED FOR CONSTRUCTION OF STUDENT'S TIMETABLE OUT OF THE LECTURES THAT THE STUDENT HAS.
 * EACH ENTRY CONSISTS OF THE COURSE CODE , COURSE NAME AND AN ARRAY OF STRINGS (LENGTH=5)
 */



public class timetableentry
{
	private String CourseCode;
	private String CourseName;
	String[] days={"Mon","Tue","Wed","Thu","Fri"};
	List<String> listofdays=Arrays.asList(days);
	public timetableentry()
	{
		for(int i=0;i<5;i++)
		{
			timings[i]="";
		}
	}
	public String getCourseCode() {
		return CourseCode;
	}
	public void setCourseCode(String courseCode) {
		CourseCode = courseCode;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String[] getTimings() {
		return timings;
	}
	public void setTimings(String[] timings) {
		this.timings = timings;
	}
	String[] timings=new String[5];

	/** 
	 * 
	 * @param index - NUMERICAL VALUE FOR CORRESPONDING DAY OF THE LECTURE
	 * @param st - START TIME OF THE LECTURE
	 * @param et - END TIME OF THE LECTURE
	 * @param type - TYPE OF CLASS (LECTURE/LAB/TUT)
	 * @param rooms - ROOMS IN WHICH THE CLASS WILL TAKE PLACE
	 */
	public void addlecture(int index,String st,String et,String type,String rooms)
	{
		//System.out.println("Adding the lecture ");
		
		System.out.println(index );
		
		String content = timings[index]+gettype(type)+" "+st+" - "+et+" "+"\n"+rooms+"\n";
		//System.out.println(index+" "+content);
		timings[index]=content;
		
	}
	public String gettype(String s){
		
		if(s.equals("L"))
		{
			return "Lab";
		}
		else if(s.equals("Le"))
		{
			return "Lecture";
		}
		else if(s.equals("T"))
		{
			return "Tutorial";
		}
		return null;
	}
}
