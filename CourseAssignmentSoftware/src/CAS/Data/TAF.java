package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;


public class TAF {
	private Date dateOfSubmission;
	private ArrayList<Date> preferredDays;
	private boolean[] preferredTimes;
	private ArrayDeque<String> preferredCourses;
	
	public Date getDateOfSubmission(){
		return dateOfSubmission;
	}
	public ArrayList<Date> getPreferredDays(){
		return preferredDays;
	}
	public boolean[] getPreferredTimes(){
		return preferredTimes;
	}
	public ArrayDeque<String> getPreferredCourses(){
		return preferredCourses;
	}
}
