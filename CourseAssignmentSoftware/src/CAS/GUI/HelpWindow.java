package CAS.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextArea;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Calvin Wong
 */
public class HelpWindow extends JFrame {
    
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private Font helpFont = new Font("SANS_SERIF",Font.PLAIN, 14);
    private JButton closeButton;
        
    public HelpWindow() {
        
        setTitle("Help");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        
        buildPanel();
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public void buildPanel() {
        
        JTextArea helpText = new JTextArea();   
        closeButton = new JButton("Close");
        
        try {
            FileReader file = new FileReader("Help.txt");
            helpText.read(file, "Help.txt");
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        helpText.setEditable(false);
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setFont(helpFont);
        
        closeButton.addActionListener(new CloseListener());
        
        add(helpText, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);
        
    }

    private class CloseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == closeButton) {
                dispose();
            }
        }
    }
}

