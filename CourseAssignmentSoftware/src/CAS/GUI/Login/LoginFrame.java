package CAS.GUI.Login;
import CAS.GUI.FileSelectorWindow;
import web.FileDownload;
/*
 Tauseef Pirzada
 06122013
 LoginFrame will be the first class to be instantiate when the application launches
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

public class LoginFrame extends JFrame
{
  
  private UserBase ub;
  private JFrame thisFrame;
  private LoginPanel loginPanel;
  
  private final int WIDTH = 500;
  private final int HEIGHT = 400;
  /*
   * Constructor
   * Instantiates UserBase class 
   * Instantiates fields through buildThatNotAsAwesomeAsTheLoginPanelLoginFrameYo method
   * */
  public LoginFrame()
  {
    super("User Login");
    ub = new UserBase();
    buildThatNotAsAwesomeAsTheLoginPanelLoginFrameYo();
    thisFrame = this;
    setLocationRelativeTo(null);
  }
  /*
   * buildThatNotAsAwesomeAsTheLoginPanelLoginFrameYo
   * Instantiates LoginPanel 
   * Adds ActionListener to buttons retreived from LoginPanel
   * Adds login panel to the frame
   * */
  private void buildThatNotAsAwesomeAsTheLoginPanelLoginFrameYo()
  {
    loginPanel = new LoginPanel();
    setSize(WIDTH,HEIGHT);
    OnAction onAction = new OnAction();
    loginPanel.getLoginButton().addActionListener(onAction);
    loginPanel.getRegisterButton().addActionListener(onAction);
    loginPanel.getRecoveryButton().addActionListener(onAction);
    add(loginPanel);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);
  }
  /*
   * ActionListener class
   * Will check three buttons
   * Register, Login, Recover
   * */
  private class OnAction implements ActionListener
  {
    /*
     * Implemented method from ActionListener
     * Will handle messages passed by Java's Message Loop
     * Method will be called when an event occurs
     * ae.getSource() == loginButton
     *   Checks if username and passcode fields are emptz
     *   Authenticates username and passcode with UserBase class
     *   On Success FileSelectorWindow is intantiated to begin the CourseAssignmentSoftware
     *   On Failure Error is given
     * ae.getSource() == register
     *   Instantiates RegisterFrame to create new account
     *   Hides itself
     * ae.getSource() == recover
     *   Instantiates RecoverFrame in case user has lost passcode
     *   hides itself
     * @argument ActionEvent holds information about the event
     * */
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource() == loginPanel.getLoginButton())
      {
        String szUsername = loginPanel.getUsernameField();
        String szPasscode = loginPanel.getPasscodeField();
        if(!(szUsername.isEmpty() || szPasscode.isEmpty()))
        {
          try
          {
            
            if(ub.authenticate(szUsername,szPasscode))
            {
              setVisible(false);
              try
              {
                  
                FileDownload.download("http://Eignh.com/webform3/TAF2014.csv",
                        System.getProperty("user.dir"));
                new FileSelectorWindow();
              }
              catch(IOException e)
              {
                  JOptionPane.showMessageDialog(null,e.getMessage());
              }
              dispose();
            }
            else
              JOptionPane.showMessageDialog(null,"Incorrect username or password.",
                                            "Invalid Login",
                                            JOptionPane.ERROR_MESSAGE);
          }
          catch(IOException ioe)
          {
            //JOptionPane.showMessageDialog(null,ioe.getMessage());
            JOptionPane.showMessageDialog(null,"Incorrect username or password.",
                                          "Invalid Login",
                                          JOptionPane.ERROR_MESSAGE);
          }
        }
        else
          JOptionPane.showMessageDialog(null,"Please enter a username and password.", "Incomplete Login", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (ae.getSource() == loginPanel.getRegisterButton())
      {
        setVisible(false);
        new RegisterFrame(thisFrame,ub);
      }
      else if (ae.getSource() == loginPanel.getRecoveryButton())
      {
        setVisible(false);
        new RecoverFrame(thisFrame,ub);
      }
    }
  }
}