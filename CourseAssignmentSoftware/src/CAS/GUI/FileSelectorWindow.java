package CAS.GUI;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julian Kuk
 */
public class FileSelectorWindow {
    
    private final String COURSE_DIALOG_TITLE = "Select the text file containing the Course list";
    private final String INSTRUCTOR_DIALOG_TITLE = "Select the text file containing the Instructor list";

    public FileSelectorWindow() {
        //try {
            // try to open file automatically
        //}
        //catch (FileNotFoundException e) {
            chooseCourseFile();
        //}
        
        //try {
            // try to open file automatically
        //}
        //catch (FileNotFoundException e) {
            chooseInstructorFile();
        //}
    }
    
    
    private void chooseCourseFile() {
        chooseFile(COURSE_DIALOG_TITLE);
    }
    
    private void chooseInstructorFile() {
        chooseFile(INSTRUCTOR_DIALOG_TITLE);
    }

    private File chooseFile(String dialogTitle) {
        // dialog explaining what file needs to be selected
        //
        //
        
        //JFrame frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(dialogTitle);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt file", "txt");
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        else {
            // dialog saying if you cancel, the program will return to log in
            System.exit(0);
            return null;
        }
    }
}