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
  //private CoursePanel coursePanel;
  private JPanel instructorPanel;
  //private InstructorPanel instructorPanel;
  
  private JPanel reportPanel;
  private JPanel detailsPanel;
  
  private JPanel topPanel;
  private JPanel middlePanel;
  private JPanel middleLeftPanel;
  private JPanel middleRightPanel;
  private JPanel bottomPanel;
  
  private JButton detailsButton;
  private JButton assignButton;
  private JButton toggleButton;
  private JButton reportButton;
  private JButton printButton;
 
  public MainWindow()
  {
    super();
    setSize(640,480);
    setMaximumSize(new Dimension(640, 480));
    setMinimumSize(new Dimension(640, 480));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    
    buildPanels();

    setVisible(true);
  }
  
  public void buildPanels() {
//    GridBagConstraints constraints = new GridBagConstraints();
    
    courseReportPanel = new JPanel();
    courseReportPanel.add(new JLabel("CourseReportPanel"));
    courseReportPanel.setBackground(Color.GRAY);
                          
    instructorReportPanel = new JPanel();
    instructorReportPanel.add(new JLabel("InstructorReportPanel"));
    instructorReportPanel.setBackground(Color.GRAY);
                              
    coursePanel = new JPanel();
    //coursePanel = new CoursePanel();
    coursePanel.setLayout(new BorderLayout());
    coursePanel.add(new JLabel("Details Area"), BorderLayout.NORTH);
    JTextArea details = new JTextArea("This is the area where all the details" +
            " of a selected instructor or course would be displayed once the" +
            " \"details\" button was pressed.");
    details.setEditable(false);
    details.setLineWrap(true);
    details.setWrapStyleWord(true);
    coursePanel.add(details, BorderLayout.CENTER);
    coursePanel.setBackground(Color.LIGHT_GRAY);
                    
    instructorPanel = new JPanel();
    //instructorPanel = new InstructorPanel();
    instructorPanel.add(new JLabel("InstructorPanel"));
    instructorPanel.setBackground(Color.LIGHT_GRAY);
    
    reportPanel = courseReportPanel;
    detailsPanel = coursePanel;
    
    topPanel = new JPanel();
    topPanel.setSize(640, 30);
    topPanel.setLocation(0, 0);
    topPanel.setLayout(null);
    detailsButton = new JButton("Details");
    detailsButton.setSize(100, 30);
    detailsButton.setLocation(220, 0);
    detailsButton.addActionListener(new ButtonListener());
    topPanel.add(detailsButton);
    topPanel.add(new JPanel());
    
    middleRightPanel = new JPanel();
    middleRightPanel.setSize(220, 300);
    middleRightPanel.setLocation(370, 0);
    middleRightPanel.setLayout(new BorderLayout());
    middleRightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    middleRightPanel.add(detailsPanel);
    
    middleLeftPanel = new JPanel();
    middleLeftPanel.setSize(300, 350);
    middleLeftPanel.setLocation(20, 0);
    middleLeftPanel.setLayout(new BorderLayout());
    middleLeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
    middleLeftPanel.add(reportPanel);
    
    middlePanel = new JPanel();
    middlePanel.setSize(640, 375);
    middlePanel.setLocation(0, 30);
    middlePanel.setLayout(null);
    middlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
    middlePanel.add(middleLeftPanel);
    middlePanel.add(middleRightPanel);
                 
    bottomPanel = new JPanel();
    bottomPanel.setSize(640, 40);
    bottomPanel.setLocation(0, 405);
    bottomPanel.setLayout(null);
    assignButton = new JButton("Assign");
    assignButton.setSize(100, 30);
    assignButton.setLocation(85, 5);
    toggleButton = new JButton("Instructors");
    toggleButton.setSize(100, 30);
    toggleButton.setLocation(270, 5);
    reportButton = new JButton("Report");
    reportButton.setSize(100, 30);
    reportButton.setLocation(455, 5);
//    printButton = new JButton("Print");
//    printButton.setSize(100, 30);
//    printButton.setLocation(540, 20);
    assignButton.addActionListener(new ButtonListener());
    toggleButton.addActionListener(new ButtonListener());
    reportButton.addActionListener(new ButtonListener());
//    printButton.addActionListener(new ButtonListener());
    bottomPanel.add(assignButton);
    bottomPanel.add(toggleButton);
    bottomPanel.add(reportButton);
//    bottomPanel.add(printButton);
    
//    constraints.anchor = GridBagConstraints.FIRST_LINE_START;
//    constraints.fill = GridBagConstraints.BOTH;
//    constraints.gridx = 0;
//    constraints.gridy = 0;
//    constraints.weightx = 1.0;
//    constraints.weighty = 0.1;
    
    add(topPanel);
    
//    constraints.fill = GridBagConstraints.BOTH;
//    constraints.gridy = 1;
//    constraints.weighty = 0.7;
    
    add(middlePanel);
    
//    constraints.fill = GridBagConstraints.BOTH;
//    constraints.gridy = 2;
//    constraints.weighty = 0.2;
    
    add(bottomPanel);
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
          middleLeftPanel.remove(reportPanel);
          reportPanel = instructorReportPanel;
          middleLeftPanel.add(reportPanel);
          middleLeftPanel.revalidate();
          toggleButton.setText("Courses");
          repaint();
        }
        else {
          middleLeftPanel.remove(reportPanel);
          reportPanel = courseReportPanel;
          middleLeftPanel.add(reportPanel);
          middleLeftPanel.revalidate();
          toggleButton.setText("Instructors");
          repaint();
        }
      }
      if (e.getSource() == reportButton) {
          JFrame jf = new JFrame();
          jf.setLayout(null);
          jf.setSize(300,300);
          JButton p = new JButton("Print");
          p.setSize(100, 30);
          p.setLocation(185, 230);
          JButton s = new JButton("Save");
          s.setSize(100, 30);
          s.setLocation(0, 230);
          JTextArea t = new JTextArea("This is the area where the report" +
                  " would go, and the buttons below would allow you to save" +
                  " the report to a file or to print it.");
          t.setEditable(false);
          t.setLineWrap(true);
          t.setWrapStyleWord(true);
          t.setSize(225, 200);
          t.setLocation(25, 0);
          t.setBorder(BorderFactory.createLineBorder(Color.black));
          jf.add(p);
          jf.add(s);
          jf.add(t);
          jf.setVisible(true);   
      }
      if (e.getSource() == detailsButton) {
          JOptionPane.showMessageDialog(null, "Clicking this would send the" +
                  " details of the currently selected instructor or course to" +
                  " the details box on the right.");
      }
      if (e.getSource() == assignButton) {
          JOptionPane.showMessageDialog(null, "Clicking this would use the backend" +
                  " methods to run the next round of the course assignment process.");
      }
    }
  }
}