package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;


public class Instructor {
	  private String name;
	  private String phoneNumber;
	  private HashMap<String, Integer> seniorities= new HashMap<String, Integer>();
	  private ArrayList<Course> courses= new ArrayList<Course>();
	  public TAF taf= new TAF();
	  
	  public Instructor(TAF taf){
		  this.taf=taf;
	  }
	  public String getName(){
		  return name;
	  }
	  public String getPhoneNumber(){
		  return phoneNumber;
	  }
	  public HashMap<String,Integer> getSeniorities(){
		  return seniorities;
	  }
	  public ArrayList<Course> getCourses(){
		  return courses;
	  }
	  public Date getDateOfSubmission(){
		  return taf.getDateOfSubmission();
	  }
	  public ArrayList<Day> getPreferredDays(){
		  return taf.getPreferredDays();
	  }
	  public ArrayList<TimeSchedule> getPreferredTimes(){
		  return taf.getPreferredTimes();
	  }
	  public ArrayDeque<String> getPreferredCourses(){
		  return taf.getPreferredCourses();
	  }
	  public int compareTo(Instructor instructor, Course course){
		 return 0; 
	  }
}