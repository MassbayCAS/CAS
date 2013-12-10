package CAS.GUI;

/*
 * File
 */
/*
 * Jyoti Sharma 
 * Save and Print Class for GUI
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.print.PrinterException;

public class PrintWindow extends JPanel {

    private JButton saveFile;
    private JButton printFile;
    private JTextArea textArea;
    private String theValue;

    public PrintWindow(String nf) {
        super();
        buildPanel();
        theValue = nf;
    }

    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.add(new PrintWindow("testing"));
        test.setVisible(true);
        test.setSize(400, 400);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildPanel() {
        saveFile = new JButton("Save File");
        printFile = new JButton("Printing file ");
        textArea = new JTextArea(" Printing text to the Paper");
        add(textArea);

        saveFile.addActionListener(new ButtonListener());
        add(saveFile);
        printFile.addActionListener(new ButtonListener());
        add(printFile);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == saveFile) {
                BufferedWriter bfWrite = null;
                try {
                    bfWrite = new BufferedWriter(new FileWriter("name.txt"));
                    bfWrite.write(theValue);
                } catch (IOException x) {
                } finally {
                    try {
                        if (bfWrite != null) {
                            bfWrite.close();
                        }
                    } catch (IOException x) {
                    }
                }
            }
            if (e.getSource() == printFile) {
                try {
                    System.out.println("trying to print: " + textArea);
                    textArea.print();
                } catch (PrinterException x) {
                    // Print job did not complete.
                }
            }
        }
    }
}