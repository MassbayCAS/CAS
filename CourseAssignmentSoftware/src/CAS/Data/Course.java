package CAS.Data;

public class Course
{
    private int id;
    private String workarea;
    private Instructor instructor;
    private Day[] day;
    private Time start;
    private Time end;
    private String subject;
    private int number;
    private String section;
    private int session;
    private String title;
    private int credits;
    private String campus;
    private String room;
       
    public Course(){
       // todo complete constructor  
    }
    
    public int hashCode(){
        // todo
        return title.hashCode();
    }
    
    public boolean equals(Object object){
        // todo
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the workarea
     */
    public String getWorkarea() {
        return workarea;
    }

    /**
     * @param workarea the workarea to set
     */
    public void setWorkarea(String workarea) {
        this.workarea = workarea;
    }

    /**
     * @return the instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * @return the day
     */
    public Day[] getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(Day[] day) {
        this.day = day;
    }

    /**
     * @return the start
     */
    public Time getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Time start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public Time getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Time end) {
        this.end = end;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the session
     */
    public int getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(int session) {
        this.session = session;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * @return the campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }
}