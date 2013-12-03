/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CAS.DataIO;

/**
 *
 * @author Justin
 */
import java.io.*;
import java.util.HashMap;
import CAS.Data.Course;
import java.util.Scanner;


public class CourseReader extends FileReader
{
    public CourseReader(String filename) throws FileNotFoundException
    {
        super(filename);
    }
    
    public HashMap<String, Course> loadCourses()
    {
        Scanner scan = new Scanner(getFile());
        HashMap<String, Course> courseList = new HashMap<String, Course>();
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            // Waiting on Course class to be finished to finalize this part
            Course course = new Course(tba);
            String key = course.getSubject() + course.getNumber() + course.getSection();
            courseList.add(key, course);
        }
        return courseList;
    }
}
