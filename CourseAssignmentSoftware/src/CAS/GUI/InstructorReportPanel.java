/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.GUI;

import CAS.CourseAssignment;
import CAS.Data.Course;
import CAS.Data.Instructor;
import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Dailton Rabelo
 */
public class InstructorReportPanel extends JPanel {

    private JList list;
    private JLabel label1;
    private DefaultListModel listModel;
    private JScrollPane listScroller;
    private HashMap<String, Instructor> instructors;
    private HashMap<String, Course> courses;
    private CourseAssignment courseAssignment;
    private MouseListener mouseListener;

    public InstructorReportPanel(CourseAssignment courseAssignment, MouseListener mouseListener) {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        setBackground(Color.LIGHT_GRAY);

        this.courseAssignment = courseAssignment;
        this.mouseListener = mouseListener;
        instructors = courseAssignment.getInstructors();
        courses = courseAssignment.getCourses();

        label1 = new JLabel("InstructorPanel");
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.05;
        add(label1, c);

        listModel = new DefaultListModel();
        //Adds instructors to the list
        updateList();


        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.addMouseListener(mouseListener);

        listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 1;

        add(listScroller, c);
        setVisible(true);

    }
    /*
     * Returns the selected item using the getSelectedValue method that is
     * in JList
     */

    public Object getSelected() {
        if (list.getSelectedValue() != null) {
            String selected = ((String) list.getSelectedValue()).trim();
            System.out.println(selected);
            Instructor i = instructors.get(selected);
            Course c = courses.get(selected);
            if (i != null) {
                return i;
            } else {
                return c;
            }
        } else {
            return null;
        }
    }

    public void updateList() {
        listModel.clear();
        instructors = courseAssignment.getInstructors();
        for (Instructor instructor : instructors.values()) {
            listModel.addElement(instructor.getName());
            //If there is a course under that instructor, it adds to the list also.
            //Also If I add a new tab before courses, it will be harder to search for the course
            //because you will have to concatenate the course. Should I do that?
            for (Course course : instructor.getCourses())
                listModel.addElement("          " + course.getClassCode() + "," + course.getSection());
        }
    }
}