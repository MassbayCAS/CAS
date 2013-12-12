/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.GUI;

import CAS.Data.Instructor;
import CAS.Data.Day;
import CAS.Data.Course;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayDeque;

/**
 *
 * @author Dan
 */
public class InstructorPanel extends JPanel
{
    
 private JPanel northPanel;
 private JLabel name, phoneNumber, dateOfSubmission, preferredDays, preferredCoursesLabel,preferredTimes,  courses ; 
 private String dayList;
 private ArrayDeque<Course> preferredCoursesArray;
 private Instructor thisInstructor;
 
  public InstructorPanel()
  {
   name = new JLabel("Name: ");
   phoneNumber = new JLabel("Phone: 555-555-5555");
   dateOfSubmission = new JLabel("Submitted: ");
   preferredDays = new JLabel("Preferred Days: ");
   preferredCoursesLabel = new JLabel("Preferred Courses: ");
  }
   
   
   
  
  public InstructorPanel(Instructor in)
  { 
    thisInstructor = in;
    setFields();
    buildPanel();
    
  }
  public void setInstructor(Instructor in)
  {
   thisInstructor = in;
   setFields();
  }
  private void setFields()
  {
      
   name = new JLabel("Name: " + thisInstructor.getName());
   phoneNumber = new JLabel("Phone: " + thisInstructor.getPhoneNumber());
   dateOfSubmission = new JLabel("Submitted: " + thisInstructor.getDateOfSubmission());
   preferredDays = new JLabel("Preferred Days: " + thisInstructor.getPreferredDays());
   courses = new JLabel("Courses: "+ thisInstructor.getCourses());
   preferredTimes = new JLabel("Preferred Time: " + thisInstructor.getPreferredTimes()); 
   preferredCoursesLabel = new JLabel("Preferred Courses: ");
   
   
  }
  private void buildPanel()
  {
    
    setLayout(new BorderLayout());
    
    northPanel = new JPanel();
    
    northPanel.add(name);
    northPanel.add(phoneNumber);
    northPanel.add(dateOfSubmission);
    northPanel.add(preferredDays);
    northPanel.add(preferredTimes);
    northPanel.add(courses);
    
    add(northPanel, BorderLayout.CENTER);// BorderLayout.NORTH));
    
  }
}
