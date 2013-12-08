package CAS.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class Instructor {

    private String name;
    private String phoneNumber;
    private HashMap<String, Integer> seniorities;
    private ArrayList<Course> courses;
    private TAF taf;

    public Instructor(TAF taf, String ame, String phoneNumber) {
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

    public ArrayDeque<String> getPreferredCourses() {
        return taf.getPreferredCourses();
    }
    
    public TAF getTAF() {
        return taf;
    }

    public int compareTo(Instructor instructor, Course course) {
        String workArea = course.getWorkArea();
        int seniorityComparison = instructor.getSeniorities().get(workArea) - seniorities.get(workArea);
        if (seniorityComparison != 0) {
            return seniorityComparison;
        }
        else {
            int dateComparison = instructor.getTAF().getDateOfSubmission().compareTo(taf.getDateOfSubmission());
            return dateComparison;
        }
    }
}