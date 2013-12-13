/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.GUI;

import CAS.CourseAssignment;
import CAS.DataIO.DataIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Richard Hayes
 */
public class ReportSelectionWindow extends JFrame{
    
    JButton unfulfilledRequestButton;
    JButton courseButton;
    CourseAssignment courseAssignment;
    
    private final int WIDTH = 400;
    private final int HEIGHT = 120;
    
    public ReportSelectionWindow(CourseAssignment courseAssignment) {
        super();
        setSize(WIDTH,HEIGHT);
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setResizable(false);
        setLayout(new GridLayout(2,1));
        this.courseAssignment = courseAssignment;
        buildPanels();
        pack();
        setVisible(true);
    }
    
    public void buildPanels() {
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(new EmptyBorder(0, 20, 10, 20));
        topPanel.setLayout(new GridLayout(3, 1));
        GridLayout bottomPanelLayout = new GridLayout(1, 0);
        bottomPanelLayout.setHgap(20);
        bottomPanelLayout.setVgap(50);
        bottomPanel.setLayout(bottomPanelLayout);
        
        JLabel selectLabel = new JLabel("Please select the report you would like to view:");
        selectLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(new JPanel());
        topPanel.add(selectLabel);
        topPanel.add(new JPanel());
        
        unfulfilledRequestButton = new JButton("Unfulfilled Request Report");
        unfulfilledRequestButton.addActionListener(new ButtonListener());
        courseButton = new JButton("Course Report");
        courseButton.addActionListener(new ButtonListener());
        
        bottomPanel.add(unfulfilledRequestButton);
        bottomPanel.add(courseButton);
        
        add(topPanel);
        add(bottomPanel);
    }
    
    private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == unfulfilledRequestButton)
      {
          JFrame jf = new JFrame();
          jf.setLayout(new BorderLayout());
          jf.setVisible(true);
          String unfulfilledData = DataIO.GetUnfulfilledRequestReport(courseAssignment.getCourses(), courseAssignment.getInstructors());
          System.out.println (unfulfilledData);
          PrintWindow printWindow = new PrintWindow(unfulfilledData);
          printWindow.setVisible(true);
          jf.add(printWindow);
          jf.pack();
      }
      else if (e.getSource() == courseButton)
      {
          JFrame jf = new JFrame();
          jf.setLayout(new BorderLayout());
          jf.setVisible(true);
          String courseData = DataIO.GetCourseReport(courseAssignment.getCourses(), true);
          System.out.println (courseData);
          PrintWindow printWindow = new PrintWindow(courseData);
          printWindow.setVisible(true);
          jf.add(printWindow);
          jf.pack();
      }
    }
    }
}
