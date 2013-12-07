package CAS.DataIO;

import CAS.Data.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author Peter Collins - Final Project CS208
 * DataIO is responsible for reading our data into classes / data structures,
 * and writing formatted reports to a file for printing.
 */
public class DataIO
{
    //private CourseReader courseReader = new CourseReader ();
    //private TafReader tafReader = new TafReader ();
    //private SeniorityListReader slistReader = new SeniorityListReader ();
    
    /** Determines Operating System at runtime.
     *  @return whether or not the current OS is windows, false if OSX (assumed)
     */
    public static boolean isWindows () {
       String os = System.getProperty ("os.name").toLowerCase ();
       return os.contains ("win");
    };
    
    /** The OS specific directory that holds reports
     *  @return returns an OS specific file path for writing and 
     *  retrieving reports for printing
     */
    public static String BaseReportPath () {
        if (isWindows ()) {
            return System.getenv ("LOCALAPPDATA");
        } else {
            return System.getenv ("HOME") + "/Library/Caches/";
        }
    };
    
    public static void LoadCourses ()
    {
        // TODO
        throw new UnsupportedOperationException ();
    }   
   
    public static void LoadInstructors ()
    {
        // TODO
        throw new UnsupportedOperationException ();
    }
   
    public static void LoadSeniorityList ()
    {
        // TODO
        throw new UnsupportedOperationException ();
    }
    
     /** Writes formatted data to a file, if the file
     *  already exists we overwrite it.
     *  @param formattedData - The data to write.
     *  @param fullReportPathName - The fully qualified path name.
     *  @return Returns whether or not writing succeeded.
     */
    public static boolean WriteReportToFile (String formattedData, String fullReportPathName)
    {
        try {
            FileWriter fw = new FileWriter (fullReportPathName + ".log", false);
            BufferedWriter writer = new BufferedWriter (fw);   
            writer.write(formattedData);
            writer.close ();
            return true;
        } catch (IOException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    /** Gets a sorted and formatted course report.
     *  This method should be used to fetch both the assigned, 
     *  and unassigned course reports.
     *  @param courses - The map of courses.
     *  @param isAssigned - True if the report should be of assigned courses,
     *  false if the report should be of unassigned courses.
     *  @return Returns a formatted course report.
     */
    public static String GetCourseReport (HashMap <String, Course> courses, boolean isAssigned)
    {
        StringBuilder sb = new StringBuilder (); 
        PriorityQueue<Course> coursePQ = GetSortedCourses (courses, isAssigned);
        
        // the following can be modified to retreieve whatever course fields
        // are desireable for the report
        sb.append ("Work Area"); sb.append ("\t");
        sb.append ("ID"); sb.append ("\t");
        sb.append ("Section"); sb.append ("\t");
        sb.append ("Course Name"); sb.append ("\t");
        sb.append ("Instructor"); sb.append ("\n");
        sb.append ("------------------------------------------------------------------------------------------\n");
        while (!coursePQ.isEmpty() && coursePQ.peek() != null) {
            Course c = coursePQ.poll();
            String profName = "";
            
            if (c.getInstructor() != null)
                profName = c.getInstructor().getName();
            
    
            sb.append (c.getWorkarea()); sb.append ("\t");
            sb.append (c.getId()); sb.append ("\t");
            sb.append (c.getSection()); sb.append ("\t");
            sb.append (c.getTitle()); sb.append ("\t");
            sb.append (profName); sb.append ("\n");
        }
        return sb.toString ();
    }
    
    /** Gets a sorted priority queue of courses
     *  This method can  be used to fetch both the assigned, 
     *  and unassigned courses.
     *  @param courses - The map of courses.
     *  @param isAssigned - True if the report should be of assigned courses,
     *  false if the report should be of unassigned courses.
     *  @return Returns a sorted queue of courses
     */
    public static PriorityQueue<Course> GetSortedCourses (HashMap <String, Course> courses, boolean isAssigned)
    {
        PriorityQueue<Course> coursePQ = new PriorityQueue (100, new CourseComparator());
        
        // sort courses by desired reporting qualities
        for (Course c : courses.values()) {
            // only add assigned or unassigned courses
            if (isAssigned == (c.getInstructor() != null)) {
                coursePQ.offer (c);
            }
        }
        return coursePQ;
    }
    
     /** Gets a sorted and formatted unfulfilled request report
     *  @param instructors - The map of instructors.
     *  @return Returns a formatted unfulfilled assignment report.
     */
    public static String GetUnfulfilledRequestReport (HashMap <String, Instructor> instructors)
    {
        StringBuilder sb = new StringBuilder ();
        // TODO
        return sb.toString ();
    }
    
    static class CourseComparator implements Comparator<Course>
    {
      @Override
      public int compare (Course c1, Course c2)
      {
          // Sort courses alphabetically by course area first,
          // and then by course ID
          return (c1.getWorkarea().equals(c2.getWorkarea())
                  ? c1.getId() - c2.getId()
                  : c1.getWorkarea().compareTo(c2.getWorkarea()));
      }
    }
}
