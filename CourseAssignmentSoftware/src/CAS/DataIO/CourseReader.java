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
import CAS.Data.Day;
import CAS.Data.Time;
import java.util.ArrayList;
import java.util.Scanner;


public class CourseReader extends FileReader
{
    public CourseReader(String filename) throws FileNotFoundException
    {
        super(filename);
    }
    
    public HashMap<String, Course> loadCourses() throws FileNotFoundException
    {
        Scanner scan = new Scanner(getFile());
        HashMap<String, Course> courseList = new HashMap<String, Course>();
        scan.nextLine();
        while(scan.hasNext())
        {
            String line = scan.nextLine();
            String[] splitline = line.split("\\t");
            
            int id = Integer.parseInt(splitline[0]);
            String workArea = null;
            ArrayList<Day> days;
            Time start;
            Time end;
            
            if(splitline.length > 5)
            {
                days = new ArrayList<Day>();
                if(splitline[5].contains("M"))
                    days.add(Day.MONDAY);
                if(splitline[5].contains("T"))
                    days.add(Day.TUESDAY);
                if(splitline[5].contains("W"))
                    days.add(Day.WEDNESDAY);
                if(splitline[5].contains("R"))
                    days.add(Day.THURSDAY);
                if(splitline[5].contains("F"))
                    days.add(Day.FRIDAY);
                if(splitline[5].contains("Sa"))
                    days.add(Day.SATURDAY);
                if(splitline[5].contains("Su"))
                    days.add(Day.SUNDAY);

                String[] startTime = splitline[6].split(":");
                int hour = Integer.parseInt(startTime[0].trim());
                char[] startMin = startTime[1].toCharArray();
                String minString = String.valueOf(startMin[0]) + String.valueOf(startMin[1]);
                int min = Integer.parseInt(minString);
                if(startMin[2] == 'p')
                    hour += 12;
                start = new Time(hour, min);
                String[] endTime = splitline[7].split(":");
                hour = Integer.parseInt(endTime[0].trim());
                char[] endMin = endTime[1].toCharArray();
                minString = String.valueOf(endMin[0]) + String.valueOf(endMin[1]);
                min = Integer.parseInt(minString);
                if(endMin[2] == 'p')
                    hour += 12;
                end = new Time(hour, min);
            }
            else
            {
                days = null;
                start = null;
                end = null;
            }
            
            String[] subjectNumber = splitline[1].split("\\s");
            String subject = subjectNumber[0];
            String number = subjectNumber[1];
            String section = splitline[2];
            int session = 0;
            String title = splitline[3];
            int credits = 0;
            String campus = splitline[4];
            String room = null;
            
            Course course = new Course(id, workArea, days, start, end, subject, 
                    number, section, session, title, credits, campus, room);
            String key = course.getSubject() + course.getNumber() + course.getSection();
            courseList.put(key, course);
        }
        return courseList;
    }
}
