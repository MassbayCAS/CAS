/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CAS.DataIO;

/**
 *
 * @author Eric Sullivan
 */
import java.io.File;
import CAS.Data.*;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.io.*;
import java.util.StringTokenizer;
public class TAFReader extends FileReader
{
    private Scanner scan;
    private String name;
    private String number;
    private Date admission;
    private ArrayList<Day> preferredDays;
    private ArrayList<TimeSchedule> prefTimes;
    private ArrayDeque<String> preferredCourse;
    private HashMap<String, Instructor> theMap;
    /* Constructor Takes in a name of a file as an parameter and sends it to
    the super and intializes the data sturctures
    */
    public TAFReader(String name) throws FileNotFoundException
    {
        super(name);
        scan = new Scanner(super.getFile());
        preferredDays = new ArrayList<Day>();
        prefTimes = new ArrayList<>();
        preferredCourse = new ArrayDeque<String>();
        theMap = new HashMap<>();
    }
    // Takes info from the file and parses it in a HashMap of <String,Instructor>
    public HashMap<String,Instructor> loadInstructor()
    {
        StringTokenizer st;
        String info = "";
        String temp;
        while(scan.hasNextLine()) //checks if we are at the end of file if not continues
        {
            info = scan.nextLine(); // gets first line which has a name followed by a phone number
            if(!info.equals("")){ // check to see if the file is at a "" string
                st = new StringTokenizer(info,"\t"); //tokenizes the first line into name and phone number
                name = st.nextToken(); // saves name
                number = st.nextToken(); // saves number
                info = scan.nextLine(); // gets next line which has preferred day and times
                st = new StringTokenizer(info,",\t"); // tokenizes using , and tab as delimiters
                while(st.hasMoreTokens()){ // check to see if there is more on the line
                    temp = st.nextToken();  //temp gets the token for checking
                    switch(temp){ // switch using the temp check if it a m,t,w,th,f or it will create a timeSchelede obj
                        case "m":
                            preferredDays.add(Day.MONDAY);
                            break;
                        case "t":
                            preferredDays.add(Day.TUESDAY);
                            break;
                        case "w":
                            preferredDays.add(Day.WEDNESDAY);
                            break;
                        case "th":
                            preferredDays.add(Day.THURSDAY);
                            break;
                        case "f":
                            preferredDays.add(Day.FRIDAY);
                            break;
                        default:
                            StringTokenizer temp2 = new StringTokenizer(temp,"-");
                            prefTimes.add(new TimeSchedule(Integer.parseInt(temp2.nextToken()),Integer.parseInt(temp2.nextToken())));
                            break;
                    }
                }
                while(!info.equals("")) { // check that if falls we know we are at the end of the TAF.
                        info = scan.nextLine();
                        if(!info.equals(""))
                        preferredCourse.offerLast(info); // adds the preferred course using fifo
                }
                theMap.put(name, new Instructor(new TAF(preferredDays,prefTimes,preferredCourse),name,number));//Instructor and Taf have no Constructor???
                prefTimes.clear(); //clears arrays for new info
                preferredCourse.clear();
                preferredDays.clear();
            }
            
        }
        return theMap;
    }
}