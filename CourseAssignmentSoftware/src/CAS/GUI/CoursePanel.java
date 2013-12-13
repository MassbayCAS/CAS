/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.GUI;

/* @author Daniel Sherman
Class to handle a GUI panel for course details.
*/

import javax.swing.*;
import java.awt.*;

import CAS.Data.Course;
import CAS.Data.Day;

public class CoursePanel extends JPanel
{
 private JPanel panel;
 private JLabel id, workArea, instructor, day, start, end, subject, number, section, session, title, credits, campus, room; 
 private String dayList;
 private Course thisCourse;
 
  public CoursePanel()
  {
   id = new JLabel("ID: ");
   workArea = new JLabel("Work Area: ");
   instructor = new JLabel("Instructor: ");
   day = new JLabel("Days: ");
   start =  new JLabel("Start: ");
   end =  new JLabel("End: ");
   subject =  new JLabel("Subject: ");
   number =  new JLabel("Number: ");
   section =  new JLabel("Section: " );
  // session =  new JLabel("Session: ");
   title =  new JLabel("Title: ");
   //credits =  new JLabel("Credits: ");        
   campus =  new JLabel("Campus: ");
   
  }
  public CoursePanel(Course c)
  { 
    thisCourse = c;
    setFields();
    buildPanel();
    
  }
  public void setCourse(Course c)
  {
   thisCourse = c;
  }
  private void setFields()
  {
   id = new JLabel("ID: " + thisCourse.getId());
  
   workArea =  new JLabel("Workarea: " + thisCourse.getWorkArea());
   
   if(thisCourse.getInstructor() != null)
       instructor =  new JLabel("Instructor: " + thisCourse.getInstructor());      
   else 
       instructor = new JLabel("Instructor: N/A");
   
   dayList = "Days: ";
   if(thisCourse.getDays() != null) {
   for (Day d:thisCourse.getDays())
   {
     dayList.concat("" + d.toString());
   }
   }
   
   day =  new JLabel("Day: " + dayList);
   start =  new JLabel("Start: " + thisCourse.getStart());
   end =  new JLabel("End: " + thisCourse.getEnd());
   subject =  new JLabel("Work Area: " + thisCourse.getWorkArea());
   number =  new JLabel("Class Code: " + thisCourse.getClassCode().toString());
   section =  new JLabel("Section: " + thisCourse.getSection());
   title =  new JLabel("Title: " + thisCourse.getTitle());
   campus =  new JLabel("Campus: "+ thisCourse.getCampus());
   //session =  new JLabel("Session: " + thisCourse.getSession());
   //credits =  new JLabel("Credits: " + thisCourse.getCredits());        
   
  }
  private void buildPanel()
  {
    
    setLayout(new BorderLayout());
    
    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    
    northPanel.add(title);
    northPanel.add(subject);
    northPanel.add(section);
    northPanel.add(instructor);
    
    centerPanel.add(campus);
    centerPanel.add(number);
    //centerPanel.add(session);
    centerPanel.add(day);
    southPanel.add(start);
    southPanel.add(end);
    
    southPanel.add(workArea);
   // southPanel.add(credits);
   
    add(northPanel);// BorderLayout.NORTH));
    add(centerPanel);//,BorderLayout.CENTER));
    add(southPanel);//,BorderLayout.SOUTH));
    
  }
}
