package CAS.DataIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    
    
    public DataIO ()
    {
    }
    
    public void LoadCourses ()
    {
        // TODO
        throw new UnsupportedOperationException ();
    }   
   
    public void LoadInstructors ()
    {
        // TODO
        throw new UnsupportedOperationException ();
    }
   
    public void LoadSeniorityList ()
    {
        // TODO
        throw new UnsupportedOperationException ();
    }
    
     /** Writes formatted data to a file, if the file
     *  already exists we overwrite it.
     *  @param formattedData - The data to write
     *  @param fullReportPathName - The fully qualified path name
     *  @return whether or not writing succeeded
     *  of the file being written
     */
    public boolean WriteReport (String formattedData, String fullReportPathName)
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
    
    public void PrintReport (String filePath)
    {
        // TODO
        throw new UnsupportedOperationException ();
    }
}
