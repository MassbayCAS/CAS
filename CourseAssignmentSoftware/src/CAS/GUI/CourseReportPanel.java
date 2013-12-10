package CAS.GUI;

import java.awt.*;
import javax.swing.*;
import CAS.CourseAssignment;
import CAS.Data.Course;
import java.awt.event.*;

/**
 *
 * @author Pat
 */
public class CourseReportPanel extends JPanel {

    private JList<Course> list;
    private JLabel label1;
    private DefaultListModel<Course> listModel;
    private JScrollPane listScroller;
    private CourseAssignment courseAssignment;
    private Course course;

    public CourseReportPanel(CourseAssignment courseAssignment) {
        this.courseAssignment = courseAssignment;

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setBackground(Color.GRAY);

        label1 = new JLabel("CourseReportPanel");
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.05;
        add(label1, c);

        listModel = new DefaultListModel<>();
        updateList();
        list = new JList<>(listModel);
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    course = list.getSelectedValue();
                }
            }
        };
        list.addMouseListener(mouseListener);


        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);

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

    public Course getCourse() {
        return course;
    }

    public void updateList() {
        listModel.clear();
        for (Course co : courseAssignment.getCourses().values()) {
            listModel.addElement(co);
        }
    }
}
