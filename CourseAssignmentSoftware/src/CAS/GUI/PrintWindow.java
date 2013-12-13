package CAS.GUI;

/*
 * Jyoti Sharma 
 * Save and Print Class for GUI
 */
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.print.PrinterException;
import java.awt.*;
import java.awt.Color;


public class PrintWindow extends JFrame
{
    private JPanel panelText;
    private JPanel panelButton;
    private JButton saveFile;
    private JButton printFile;
    private JTextArea textArea;
    private JFileChooser fileChooser; 
    
    public PrintWindow(String nf)
    {
        super();
        
        setSize(480,240);
        fileChooser = new JFileChooser();
        textArea = new JTextArea(nf);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        
        buildPanel();
        add(panelText, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
        
        setVisible(true);
        
    }
    
    /*public static void main(String[] args) 
     {
     JFrame test = new JFrame();
     test.add(new PrintWindow("testing"));
     test.setVisible(true);
     test.setSize(800, 800);
     test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     }
     */
    private void buildPanel()
    {
        saveFile = new JButton("Save File");
        printFile = new JButton("Printing file ");
        add(textArea);
        
        saveFile.addActionListener(new ButtonListener());
        add(saveFile);
        saveFile.setVisible(true);
        printFile.addActionListener(new ButtonListener());
        add(printFile);
        printFile.setVisible(true);
        
        panelButton = new JPanel();
        panelButton.add(saveFile);
        panelButton.add(printFile);
        
        panelButton.setLayout(new GridLayout(1,3));
        
        panelText = new JPanel();
        panelText.setLayout(new BorderLayout());
        textArea.setBorder(BorderFactory.createLineBorder(Color.white));
        panelText.add(textArea, BorderLayout.CENTER);
        
    }
    
    private class ButtonListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == saveFile) {
                int choice = fileChooser.showSaveDialog(PrintWindow.this);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String filename = file.getPath() + ".txt";
                    BufferedWriter bfWrite = null;
                    try {
                        bfWrite = new BufferedWriter(new FileWriter(filename));
                        bfWrite.write(textArea.getText());
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