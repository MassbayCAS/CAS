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
        return 0;
    }
    
    public boolean equals(Object object){
        // todo
        return true;
    }
}