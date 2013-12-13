package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Instructor implements Comparable<Instructor> {

    private String name;
    private String phoneNumber;
    private HashMap<String, Integer> seniorities;
    private ArrayList<Course> courses;
    private TAF taf;

    public Instructor(TAF taf, String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.taf = taf;
        seniorities = new HashMap<String, Integer>();
        courses = new ArrayList<Course>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public HashMap<String, Integer> getSeniorities() {
        return seniorities;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Date getDateOfSubmission() {
        return taf.getDateOfSubmission();
    }

    public ArrayList<Day> getPreferredDays() {
        return taf.getPreferredDays();
    }

    public ArrayList<TimeSchedule> getPreferredTimes() {
        return taf.getPreferredTimes();
    }

    public ArrayList<Course> getUnfulfilledCourseRequests (HashMap<String, Course> cs) {
        ArrayDeque<String> prefCourseNames = taf.GetPreferredCourseNames();
        ArrayList<Course> prefCourses = new ArrayList();            
            
        // add equivalent course objects to preferredList
        while(!prefCourseNames.isEmpty() && prefCourseNames.peek() != null) {
            prefCourses.add (cs.get(prefCourseNames.poll()));
        }
        
        for (Course c1 : prefCourses) {
            for (Course c2 : courses) {
                if (c1.equals(c2)) {
                    prefCourses.remove(c2);
                }
            }
        }
        
        return prefCourses;
    }
    
    public TAF getTAF() {
        return taf;
    }

    public int compareSeniorities(Instructor instructor, Course course) {
        String workArea = course.getWorkArea();
        int thisSeniority = (seniorities.get(workArea) == null) ? 0 : seniorities.get(workArea);
        int thatSeniority = (instructor.getSeniorities().get(workArea) == null) ? 0 : instructor.getSeniorities().get(workArea);
        int seniorityComparison = thatSeniority - thisSeniority;
        if (seniorityComparison != 0) {
            return seniorityComparison;
        }
        else {
            int dateComparison = instructor.getTAF().getDateOfSubmission().compareTo(taf.getDateOfSubmission());
            return dateComparison;
        }
    }
    
    @Override
    public int compareTo(Instructor instructor) {
        return 1;
    }
    
    @Override
    public int hashCode() {
        String hash = name;
        return hash.hashCode();
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {            return false;        }
        if (object == this) {            return true;        }
        if (object instanceof Instructor) {
            Instructor other = (Instructor)object;
            return name.equals(other.getName()) && phoneNumber.equals(other.getPhoneNumber());
        }
        return false;
    }
    
    @Override
    public String toString(){
		  return "name: "+name+"phoneNumber"+phoneNumber + courses;
    }
}