package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class TAF {
	private Date dateOfSubmission;
	private ArrayList<Day> preferredDays;
	private ArrayList<TimeSchedule> preferredTimes;
	private ArrayDeque<String> preferredCourses;
	
	public Date getDateOfSubmission(){
		return dateOfSubmission;
	}
	public ArrayList<Day> getPreferredDays(){
		return preferredDays;
	}
	public ArrayList<TimeSchedule> getPreferredTimes(){
		return preferredTimes;
	}
	public ArrayDeque<String> getPreferredCourses(){
		return preferredCourses;
	}
}
