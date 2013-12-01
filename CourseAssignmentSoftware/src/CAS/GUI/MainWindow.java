/* Richard Hayes
 * CS208 Final Program
 * 11/30/2013
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
  
  private JPanel courseReportPanel;
  private JPanel instructorReportPanel;
  private JPanel coursePanel;
  private JPanel instructorPanel;
  
  private JPanel reportPanel;
  private JPanel detailsPanel;
  
  private JPanel topPanel;
  private JPanel middlePanel;
  private JPanel bottomPanel;
  
  private JButton detailsButton;
  private JButton assignButton;
  private JButton toggleButton;
  private JButton reportButton;
  private JButton printButton;
 
  public MainWindow()
  {
    super();
    setSize(600,480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridBagLayout());
    setResizable(false);
    
    buildPanels();

    setVisible(true);
  }
  
  public void buildPanels() {
    GridBagConstraints constraints = new GridBagConstraints();
    
    courseReportPanel = new JPanel();
    courseReportPanel.add(new JLabel("CourseReportPanel"));
    courseReportPanel.setBackground(Color.GRAY);
                          
    instructorReportPanel = new JPanel();
    instructorReportPanel.add(new JLabel("InstructorReportPanel"));
    instructorReportPanel.setBackground(Color.GRAY);
                              
    coursePanel = new JPanel();
    coursePanel.add(new JLabel("CoursePanel"));
    coursePanel.setBackground(Color.LIGHT_GRAY);
                    
    instructorPanel = new JPanel();
    instructorPanel.add(new JLabel("InstructorPanel"));
    instructorPanel.setBackground(Color.LIGHT_GRAY);
    
    reportPanel = courseReportPanel;
    detailsPanel = coursePanel;
    
    topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(1,2));
    detailsButton = new JButton("Details");
    detailsButton.addActionListener(new ButtonListener());
    topPanel.add(detailsButton);
    topPanel.add(new JPanel());
    
    middlePanel = new JPanel();
    middlePanel.setLayout(new GridLayout(1,2));
    middlePanel.add(reportPanel);
    middlePanel.add(detailsPanel);
                 
    bottomPanel = new JPanel();
    bottomPanel.setLayout(new GridLayout(1,4));
    assignButton = new JButton("Assign");
    toggleButton = new JButton("Instructors");
    reportButton = new JButton("Report");
    printButton = new JButton("Print");
    assignButton.addActionListener(new ButtonListener());
    toggleButton.addActionListener(new ButtonListener());
    reportButton.addActionListener(new ButtonListener());
    printButton.addActionListener(new ButtonListener());
    bottomPanel.add(assignButton);
    bottomPanel.add(toggleButton);
    bottomPanel.add(reportButton);
    bottomPanel.add(printButton);
    
    constraints.anchor = GridBagConstraints.FIRST_LINE_START;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1.0;
    constraints.weighty = 0.1;
    
    add(topPanel, constraints);
    
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridy = 1;
    constraints.weighty = 0.7;
    
    add(middlePanel, constraints);
    
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridy = 2;
    constraints.weighty = 0.2;
    
    add(bottomPanel, constraints);
  }
  
  public static void main(String[] args)
  {
    new MainWindow();
  }
  
   private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      if (e.getSource() == toggleButton)
      {
        if(reportPanel.equals(courseReportPanel)) {
          middlePanel.remove(reportPanel);
          middlePanel.remove(detailsPanel);
          reportPanel = instructorReportPanel;
          detailsPanel = instructorPanel;
          middlePanel.add(reportPanel);
          middlePanel.add(detailsPanel);
          middlePanel.revalidate();
          toggleButton.setText("Courses");
          repaint();
        }
        else {
          middlePanel.remove(reportPanel);
          middlePanel.remove(detailsPanel);
          reportPanel = courseReportPanel;
          detailsPanel = coursePanel;
          middlePanel.add(reportPanel);
          middlePanel.add(detailsPanel);
          middlePanel.revalidate();
          toggleButton.setText("Instructors");
          repaint();
        }
      }
    }
  }
}