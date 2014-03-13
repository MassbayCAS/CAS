package CAS.GUI;

import javax.swing.*;
/**
 *
 * @author Calvin Wong
 */
public class HelpWindow extends JFrame {

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;


    public HelpWindow() {

        super("Help");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        buildPanels();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void buildPanels() {

        JTextArea helpText = new JTextArea();

        add(helpText);

        //helpText.setEditable(false);

    }
}
