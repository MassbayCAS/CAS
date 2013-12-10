package CAS.Data;

import java.util.ArrayList;

public class Course{
	private int id;
	private String classCode;
	private String section;
	private String title;
	private String campus;
	private ArrayList<Day> days;
	private Time start;
	private Time end;
        private String workArea;
        private Instructor instructor;

	public Course(int id, String classCode, String section, String title,
                String campus, ArrayList<Day> days, Time start, Time end, String workArea) {
		this.id = id;
		this.classCode = classCode;
		this.section = section;
		this.title = title;
		this.setCampus(campus);
		this.days = days;
                this.start = start;
                this.end = end;
                this.workArea = workArea;
                instructor = null;
	}

	@Override
	public int hashCode(){
		String hash = classCode + section;
		return hash.hashCode();
		
		/*String hash = id + section;
		return hash.hashCode();*/
	}

	@Override
	public boolean equals(Object object){
                if (object == null)
                        return false;
                if (object == this)
                        return true;
		Course course = (Course)object;
		if(!classCode.equals(course.getClassCode()))
			return false;
		if(!section.equals(course.getSection()))
			return false;
		return true;		
		/*if(number != course.getNumber())
			return false;
		if(!subject.equals(course.getSubject()))
			return false;
		if(!title.equals(course.getTitle()))
			return false;
		if(credits != course.getCredits())
			return false;
		return true;*/
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	
	public String getClassCode() {
		return classCode;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	public String getSection() {
		return section;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getCampus() {
		return campus;
	}

	public void setDays(ArrayList<Day> days) {
		this.days = days;
	}

	public ArrayList<Day> getDays() {
		return days;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getStart() {
		return start;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public Time getEnd() {
		return end;
	}
        
        public void setWorkArea(String workArea) {
                this.workArea = workArea;
        }
        
        public String getWorkArea() {
                return workArea;
        }
        
        public void setInstructor(Instructor instructor) {
                this.instructor = instructor;
        }
        
        public Instructor getInstructor() {
                return instructor;
        }
	
	public String toString(){
		return "nbr: " + getId() + " course: " + getClassCode() + "\n" + 
                        "section: " + getSection() + " title: " + getTitle() + "\n" +
                        "campus: " + getCampus() + " days: " + getDays() + "\n" +
                        "start: " + getStart() + " end: " + getEnd() + "\n" +
                        "work area: " + getWorkArea() + " instructor: " + getInstructor() + "\n";
	}
}