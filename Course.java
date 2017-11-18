package college_data;
import java.io.Serializable;
import java.util.*;

public class Course implements Serializable
{
	/**
	 *  @author PRATYUSH KAUSHAL
	 *  @version 1.0
	 *  
	 * THIS CLASS STORES THE DETAILS FOR A COURSE WITH FOLLOWING DETAILS -
	 * COURSE NAME
	 * INSTRUCTOR NAME
	 * COURSE CODE
	 * WHETHER IT IS MANDATORY OR ELECTIVE COURSE
	 * ACRONYM
	 * CREDITS GIVEN FOR COMPLETION OF THE COURSE
	 * 
	 */
	private static final long serialVersionUID = 4399822373312276393L;
String instructorName;
String CourseName;
String mandatoryOrElective;
String acronym;
String CourseCode;
String intendedAudience;
String credit;
int sno;
public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}
ArrayList<String> PostCond;

public Course(String  mandatoryOrElective, String CourseName, String CourseCode, String instructorName, String credits, String acronym, String intendedAudience,ArrayList<String> pc, String credit)
{
	this.mandatoryOrElective= mandatoryOrElective;
	this.CourseName= CourseName;
	this.CourseCode= CourseCode;
	this.instructorName= instructorName;
	this.credit= credit;
	this.acronym= acronym;
	this.intendedAudience= intendedAudience;
	this.PostCond=pc;
}

public String getAcronym() {
	return acronym;
}

public void setAcronym(String acronym) {
	this.acronym = acronym;
}

public ArrayList<String> getPostCond() {
	return PostCond;
}

public void setPostCond(ArrayList<String> postCond) {
	PostCond = postCond;
}

public String getInstructorName() {
	return instructorName;
}

public String getMandatoryOrElective() {
	return mandatoryOrElective;
}

public void setCredit(String credit)
{
this.credit= credit;
}

public String getCredit()
{
return credit;
}

public void setInstructorName( String instructorName)
{
this.instructorName= instructorName;
}

public String getCourseName()
{
	return CourseName;
}
public String getCourseCode()
{
	return CourseCode;
}
public void setCourseName(String CourseName)
{
this.CourseName= CourseName;
}

public void setCourseCode(String CourseCode)
{
this.CourseCode= CourseCode;
}

public void setMandatoryOrElective(String mandatoryOrElective)
{
this.mandatoryOrElective= mandatoryOrElective;
}

public void setIntendedAudience(String intendedAudience)
{
this.intendedAudience= intendedAudience;
}

public String getIntendedAudience()
{
return intendedAudience;
}
public ArrayList<String> getpostConditions()
{
	return PostCond;
}

}
