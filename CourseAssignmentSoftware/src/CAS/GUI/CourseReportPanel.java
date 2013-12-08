
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Pat
 */
public class CourseReportPanel extends JPanel {
    private JList list;
    private JLabel label1;
    private DefaultListModel listModel;
    private JScrollPane listScroller;
    
    public CourseReportPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        setBackground(Color.LIGHT_GRAY);
        
        label1 = new JLabel("CourseReportPanel");
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.05;
        add(label1, c);
        
        listModel = new DefaultListModel();
        for ( int i = 0; i< 100; i ++) {
            listModel.addElement("Course " + i + ": Instructor " + i);
        }
        
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);

        listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1;
        c.weightx = 0.5;
        
        add(listScroller, c);
        setVisible(true);
    }

}
