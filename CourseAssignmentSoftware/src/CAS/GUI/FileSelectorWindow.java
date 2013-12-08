package CAS.GUI;

import CAS.CourseAssignment;
import CAS.GUI.Login.LoginFrame;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julian Kuk
 */
public class FileSelectorWindow {

    private final String COURSE_DIALOG_TITLE = "Select COURSE file...";
    private final String WORK_DIALOG_TITLE = "Select WORK AREA file...";
    private final String TAF_DIALOG_TITLE = "Select TAF file...";
    private final String SENIORITY_DIALOG_TITLE = "Select SENIORITY file...";
    private final String COURSE_EXTENSION = "crs";
    private final String WORK_EXTENSION = "wrk";
    private final String TAF_EXTENSION = "taf";
    private final String SENIORITY_EXTENSION = "snr";
    private final String DEFAULT_DIRECTORY = "user.dir";
    
    private final String INPUT_FOLDER = "/input";
    private final String COURSE_SCHEDULE = "CourseSchedule." + COURSE_EXTENSION;
    private final String TAF_LIST = "TAF_simple." + TAF_EXTENSION;
    private final String SENIORITY_LIST = "FakeSeniority." + SENIORITY_EXTENSION;
    
    private CourseAssignment courseAssignment;

    public FileSelectorWindow() {
        courseAssignment = new CourseAssignment();
        /*
         courseAssignment.loadData();
         new MainWindow(courseAssignment);
         System.out.println(courseAssignment.getCourses());
         System.out.println(courseAssignment.getInstructors());
         * */
        boolean ready = false;
        int entryPoint = 0;
        while (!ready) {
            //System.out.println(entryPoint);
            switch (entryPoint) {
                case 0:
                    try {
                        courseAssignment.loadCourses(new File("CourseSchedule.crs"));
                        entryPoint++;
                    } catch (FileNotFoundException e) {
                        entryPoint = chooseCourseFile(entryPoint);
                    }
                    break;
                /*
                 case 10:

                 try {
                 courseAssignment.loadWorkAreas();
                 } catch (FileNotFoundException e) {
                 entryPoint = chooseWorkFile(entryPoint);
                 }
                 break;*/

                case 1:
                    try {
                        courseAssignment.loadInstructors(new File("TAF_simple.taf"));
                        entryPoint++;
                    } catch (FileNotFoundException e) {
                        entryPoint = chooseTAFFile(entryPoint);
                    }
                    break;

                case 2:
                    try {
                        //System.out.println("instructors: " + courseAssignment.getInstructors());
                        courseAssignment.loadSeniorityList(new File("FakeSeniority.snr"));
                        entryPoint++;
                    } catch (FileNotFoundException e) {
                        entryPoint = chooseSeniorityFile(entryPoint);

                    }
                    break;
                case 3:
                    ready = true;
                    new MainWindow(courseAssignment);
                    System.out.println(courseAssignment);
                    System.out.println(courseAssignment.getCourses());
                    System.out.println(courseAssignment.getInstructors());
                    break;
                default:
                    ready = true;
                    new LoginFrame();
                    break;
            }
        }
    }

    private int chooseCourseFile(int entryPoint) {
        File file = chooseFile(COURSE_DIALOG_TITLE, COURSE_EXTENSION);
        if (file == null) {
            return entryPoint - 1;
        } else {
            try {
                courseAssignment.loadCourses(file);
            } catch (FileNotFoundException e) {
            }
            return entryPoint + 1;
        }
    }

    /*
     private int chooseWorkFile(int entryPoint) {
     if (chooseFile(WORK_DIALOG_TITLE, WORK_EXTENSION) == null) {
     return entryPoint - 1;
     } else {
     return entryPoint + 1;
     }
     }*/
    private int chooseTAFFile(int entryPoint) {
        File file = chooseFile(TAF_DIALOG_TITLE, TAF_EXTENSION);
        if (file == null) {
            return entryPoint - 1;
        } else {
            try {
                courseAssignment.loadInstructors(file);
            } catch (FileNotFoundException e) {
            }
            return entryPoint + 1;
        }
    }

    private int chooseSeniorityFile(int entryPoint) {
        File file = chooseFile(SENIORITY_DIALOG_TITLE, SENIORITY_EXTENSION);
        if (file == null) {
            return entryPoint - 1;
        } else {
            try {
                courseAssignment.loadSeniorityList(file);
            } catch (FileNotFoundException e) {
            }
            return entryPoint + 1;
        }
    }

    private File chooseFile(String dialogTitle, String fileExtension) {
        String directory = System.getProperty(DEFAULT_DIRECTORY);
        JFileChooser chooser = new JFileChooser(new File(directory + "/input"));

        chooser.setDialogTitle(dialogTitle);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(fileExtension + " file", fileExtension);
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        } else {
            return null;
        }
    }
}