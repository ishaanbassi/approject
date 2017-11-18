package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Users.Admin;
import Users.Faculty;
import Users.Student;
import Users.User;
import college_data.Course;
import college_data.Lecture;
import college_data.Room;
import college_data.Time;
import college_data.iiitdelhi;



/** 
 * 
 * @author PRATYUSH KAUSHAL 
 * @version 1.0
 * 
 * THIS PROGRAM IS FOR READING DETAILS FROM THE TIMETABLE AND USE THE INFORMATION TO CREATE DATABASE FOR THE PROGRAM 
 * IT SERIALIZES THE USER ACCOUNTS, ROOM DETAILS, COURSE DETAILS AND LECTURES 
 * 
 *
 */
public class read_data2 {
	
	private static ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
	//public static void main(String[] args) throws IOException, ClassNotFoundException
	public static  void initialize() throws IOException, ClassNotFoundException
	{
		String path = (new File("").getAbsolutePath())+"/src/database/finalcoursedata.csv";
		BufferedReader br = null;
        String line = "" ;
        String cvsSplitBy = ",";
        
        int linecount=1;
        
        String[] postcondition;


        try {
       

            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
            	
            	postcondition=line.split(cvsSplitBy);
            	//System.out.println("NEW LINE!!!!!!!!!!!!");
            	if(linecount==1)
            	{
            		linecount++;
            		continue;
            	}
            	
            	
            	ArrayList<String> course_line=new ArrayList<String>();
            	
            	// THE FOLLOWING FOR LOOP ADDS THE ENTRIES OF THE POSTCONDITION ARRAY TO COURSE_LINE ARRAYLIST
            	for(int i=0;i<postcondition.length;i++)
            	{
            		postcondition[i]=postcondition[i].replace('^',',');
            		course_line.add(postcondition[i]);
            		System.out.println(postcondition[i]);
            	}
            	
            	
            	// THIS LOOP ADDS EMPTY STRINGS AS ENTRIES SO THAT EACH COURSE LINE IS OF EXACTLY 19 ELEMENTS. THIS HELPS IN MAINTAINING UNIFORMITY FOR ALL COURSE ENTRIES IN LIST VARIABLE
            	while(course_line.size()<19)
            	{
            		course_line.add("");
            	}
         
            	
            	list.add(course_line);
            	linecount++;
            	
            } 
        	}
        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
        System.out.println(list.size());
        
        // THE VARIABLE LIST CONTAINS ALL COURSES , WITH EACH COURSE RECORD ITSELF AS AN ARRAYLIST I.E THIS VARIABLE IS AN ARRAYLIST OF ARRAYLISTS
        //  ADD THE CODE HERE
        
        ArrayList <Course> course = new ArrayList <Course>();
        ArrayList <Room> room= new ArrayList <Room>();
        ArrayList <Time> time= new ArrayList <Time>();
        String[] days={"Mon","Tue","Wed","Thu","Fri"};
        
        //SETTING UP THE ROOMS
        //C01 C02 c03 c11 c12 c13 c21 c22 c23 c24 L21 L22 L23 LR1 LR2 LR3 s01 s02
        ArrayList<Room> rooms =new ArrayList<Room>(18);
        ArrayList<String> roomlist=new ArrayList<>(Arrays.asList("C01","C02","C03","C11","C12","C13","C21","C22","C23","C24","L21","L22","L23","LR1","LR2","LR3","S01","S02"));
        int[] capacities={150,50,50,150,50,50,150,50,50,50,30,30,30,50,50,50,30,30};
        Room temp;
        for(int i=0;i<roomlist.size();i++)
        {
        	temp=new Room(roomlist.get(i),capacities[i]);
        	rooms.add(temp);
        }
        
        
        for(int z=0;z<list.size();z++)
        {
        
        ArrayList <String> array= new ArrayList <String>();
        array= list.get(z);
        String intendedAudience=" B.Tech";
        String mandatoryOrElective=array.get(0);
        String courseName=array.get(1);
        String courseCode=array.get(2);
        String instructor=array.get(3);
        String credit=array.get(4);
        String acronym=array.get(5);
        ArrayList <String> array1= new ArrayList<String>();
        
        for(int y=11;y<array.size();y++)
        {
        	array1.add(array.get(y));
        }
        Course c= new Course(mandatoryOrElective,courseName, courseCode, instructor,credit, acronym,intendedAudience, array1,credit);
        course.add(c);
        
        for(int i=6;i<11;i++)
        {
        	String classes=array.get(i);
        	if(!classes.equals("-"))
        	{
        		
        	String[] lectures=classes.split(";");
        	int j=0;
        	while(j<lectures.length)
        	{
        		
        		String[] timeandroom=lectures[j].split("\\$");
        		String[] startandend=timeandroom[0].split("-");
        		System.out.println(startandend[1]+" "+startandend[2]);
        		System.out.println(days[i-6]);
        		
        		
        		Time duration=new Time(days[i-6],startandend[1],startandend[2]);
        		duration.setClasstype(startandend[0]);
        		String[] r=timeandroom[1].split(",");
        		int k=0;
        		
        		ArrayList<Room> venues=new ArrayList<Room>();
        		//System.out.println("Rooms-"+r[0]);
        		while(k<r.length)
        		{
        			//System.out.println(r[k]);
        			int index=roomlist.indexOf(r[k]);
        			
        			venues.add(rooms.get(index));
        			
        			System.out.println(duration);
        			
        			rooms.get(index).addsession(duration);
        			k++;
        		}
        		j++;
        		Lecture l=new Lecture(duration,venues,c);
        		iiitdelhi.getLectures().add(l);
        		
        	}
        	
        	}
        }
        
//        for(int y=11;y<array.size();y++)
//        {
//        	array1.add(array.get(y));
//        }
//        Course c= new Course(mandatoryOrElective,courseName, courseCode, instructor,credit, acronym,intendedAudience, array1,credit);
//        course.add(c);
        
        
        
        }
        
//        for(int i=0;i<18;i++)
//        {
//        	ArrayList<Time> timings=rooms.get(i).sessions;
//        	System.out.print(rooms.get(i).getRoomName()+" ");
//        	for(int j=0;j<timings.size();j++)
//        	{
//        		System.out.println(timings.get(j).getDay()+" "+timings.get(j).getStartTime()+"-"+timings.get(j).getEndTime());
//        	}
//        }
        	
     iiitdelhi.setRooms(rooms);
     iiitdelhi.setCourses(course);
     ArrayList<User> accounts=new ArrayList<User>();
     accounts.add(new Student("Ishaan Bassi","ishaan16238@iiitd.ac.in","Student","yobassi"));
     Faculty f=new Faculty("Vivek Kumar","vivekk@iiitd.ac.in","Faculty","faculty");
     accounts.add(f);
     for(Lecture l:iiitdelhi.getLectures())
     {
    	 if(l.getCourseObject().getCourseCode().equals("CSE201"))
    	 {
    		 f.getCourses().add(l);
    	 }
     }
     
     accounts.add(Admin.admingen());
     iiitdelhi.setAccounts(accounts);
     iiitdelhi.serialize();
//     iiitdelhi.deserialize();
//     ArrayList<User> accounts=iiitdelhi.getAccounts();
//     System.out.println(accounts.size());
//     for(int i=0;i<accounts.size();i++)
//     {
//    	 System.out.println(accounts.get(i).getEmail());
//     }
     
     
        
	}
	
}
