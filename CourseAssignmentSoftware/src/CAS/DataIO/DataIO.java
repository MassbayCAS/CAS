package CAS.DataIO;

import CAS.Data.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
        // TODO
        return sb.toString ();
    }
    
     /** Gets a sorted and formatted unfulfilled request report
     *  @param instructors - The map of instructors.
     *  @return Returns a formatted unfulfilled assignment report.
     */
    public static String GetunfulfilledRequests (HashMap <String, Instructor> instructors)
    {
        StringBuilder sb = new StringBuilder ();
        // TODO
        return sb.toString ();
    }
}
