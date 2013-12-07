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

    private final String COURSE_DIALOG_TITLE = "Select the Course file...";
    private final String WORK_DIALOG_TITLE = "Select the Work Area file...";
    private final String TAF_DIALOG_TITLE = "Select the TAF file...";
    private final String SENIORITY_DIALOG_TITLE = "Select the Seniority file...";

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
        chooseWorkFile();
        //}

        //try {
        // try to open file automatically
        //}
        //catch (FileNotFoundException e) {
        chooseTAFFile();
        //}
        //try {
        // try to open file automatically
        //}
        //catch (FileNotFoundException e) {
        chooseSeniorityFile();
        //}
        new MainWindow();
    }

    private void chooseCourseFile() {
        chooseFile(COURSE_DIALOG_TITLE);
    }

    private void chooseWorkFile() {
        chooseFile(WORK_DIALOG_TITLE);
    }

    private void chooseTAFFile() {
        chooseFile(TAF_DIALOG_TITLE);
    }

    private void chooseSeniorityFile() {
        chooseFile(SENIORITY_DIALOG_TITLE);
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
        } else {
            // dialog saying if you cancel, the program will return to log in
            System.exit(0);
            return null;
        }
    }
}