/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CAS.DataIO;

/**
 * TAFReader reads in a file and creates a taf and instructor and adds it to a hashmap
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
public class TAFReader
{
    /*
     private Scanner scan;
     private String name;
     private String number;
     private Date admission;
     private ArrayList<Day> preferredDays;
     private ArrayList<TimeSchedule> prefTimes;
     private ArrayDeque<String> preferredCourse;
     private HashMap<String, Instructor> theMap;
     * */
    /* Constructor Takes in a name of a file as an parameter and sends it to
     the super and intializes the data sturctures
     */
    /*
     public TAFReader(String name) throws FileNotFoundException
     {
     super(name);
     
     }
     * */
    private static void addDaysToList(ArrayList<Day> preferredDays,String day)
    {
        switch(day)
        {
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
            case "sa":
                preferredDays.add(Day.SATURDAY);
                break;
            case "su":
                preferredDays.add(Day.SUNDAY);
                break;
            default:
                break;
        }
    }
    private static void addTimeToList(ArrayList<TimeSchedule> prefTimes,String startTime,String endTime)
    {
        int start = Integer.parseInt(startTime);
        int end = Integer.parseInt(endTime);
        TimeSchedule ts = new TimeSchedule(start,end);
        prefTimes.add(ts);
    }
    public static HashMap<String,Instructor> loadInstructors(String filename) throws FileNotFoundException, IncorrectFormatException {
        return loadInstructors(new File(filename));
    }
    public static HashMap<String,Instructor> loadInstructors(File file) throws FileNotFoundException, IncorrectFormatException
    {
        HashMap<String, Instructor> theMap = new HashMap<String, Instructor>();
        ArrayList<Day> preferredDays = null;
        ArrayList<TimeSchedule> prefTimes = null;
        ArrayDeque<String> preferredCourse = null;
        Scanner scan = new Scanner(file);
        String name = null;
        String number = null;
        String info;
        String[] tok;
        while(scan.hasNextLine())
        {
            info = scan.nextLine();
            //Empty line indicates a new instructor
            //We submit the old data into the hashmap, and prepare for new incoming data
            if(info.equals(""))
                theMap.put(name, new Instructor(new TAF(preferredDays,prefTimes,preferredCourse),name,number));
            else
            {
                tok = info.split(",");
                if(!tok[0].equals(""))//check if the line contains full instructor information
                {
                    //tok[0] = lastname
                    //tok[1] = firstname
                    //tok[2] = number
                    //tok[3] = preferred day
                    //tok[4] = preferred time
                    //tok[5] = preferred course
                    //tok[6] = course number
                    prefTimes = new ArrayList<TimeSchedule>();
                    preferredCourse = new ArrayDeque<String>();
                    preferredDays = new ArrayList<Day>();
                    name = tok[0] + ", " + tok[1];
                    number = tok[2];
                    addDaysToList(preferredDays,tok[3]);
                    String[] time = tok[4].split("-");
                    //time[0] = start time
                    //time[1] = end time
                    addTimeToList(prefTimes,time[1],time[1]);
                    preferredCourse.offer(tok[5]+","+tok[6]);
                }
                else
                {
                    //check if they prefer other days as well
                    if(!tok[3].equals(""))
                    {
                        addDaysToList(preferredDays,tok[3]);
                    }
                    //check if they want other times as well
                    if(!tok[4].equals(""))
                    {
                        String[] time = tok[4].split("-");
                        addTimeToList(prefTimes,time[1],time[1]);
                    }
                    //check if they want other courses as well
                    if(!tok[5].equals(""))
                    {
                        preferredCourse.offer(tok[5]+","+tok[6]);
                    }
                }
            }
        }
        return theMap;
    }
    
    //
    //    // Takes info from the file and parses it in a HashMap of <String,Instructor>
    //    public static HashMap<String,Instructor> loadInstructors(File file) throws FileNotFoundException, IncorrectFormatException
    //    {
    //        Scanner scan = new Scanner(file);
    //        String name;
    //        String number;
    //        ArrayList<Day> preferredDays = new ArrayList<Day>();
    //        ArrayList<TimeSchedule> prefTimes = new ArrayList<TimeSchedule>();
    //        ArrayDeque<String> preferredCourse = new ArrayDeque<String>();
    //        HashMap<String, Instructor> theMap = new HashMap<String, Instructor>();
    //        StringTokenizer st;
    //        String info = "";
    //        String temp;
    //        while(scan.hasNextLine()) //checks if we are at the end of file if not continues
    //        {
    //
    //            prefTimes = new ArrayList<TimeSchedule>();
    //            preferredCourse = new ArrayDeque<String>();
    //            preferredDays = new ArrayList<Day>();
    //            //scan.nextLine();
    //            info = scan.nextLine(); // gets first line which has a name followed by a phone number
    //            //System.out.println("info: " + info);
    //            if(!info.equals(""))
    //            { // check to see if the file is at a "" string
    //                //System.out.println("info: " + info);
    //                st = new StringTokenizer(info,"\t"); //tokenizes the first line into name and phone number
    //                name = st.nextToken(); // saves name
    //                //System.out.println("name: " + name);
    //                if(!st.hasMoreTokens())
    //                { // Check if there is a phone number if not throws format exception
    //                    throw new IncorrectFormatException("There is no phone number after "+name);
    //                }
    //                number = st.nextToken(); // saves number
    //                if(number.length()!=12)
    //                { //Checks if number is 012-345-6789 if not throws format exception
    //                    throw new IncorrectFormatException("Incorrect format too short or long. Phone must be 012-345-6789: not "+number);
    //                }
    //                else if(number.charAt(10)==' ')
    //                { //Checks length of phone number
    //                    throw new IncorrectFormatException("Incorrect format space after the token: "+number);
    //                }
    //                for(int i =0;i<number.length();i++)
    //                { // checks the format of the number (maybe unneeded)
    //                    if(i!=3&&i!=7){
    //                        if(!Character.isDigit(number.charAt(i)))
    //                        {
    //                            //System.out.println(i);
    //                            throw new IncorrectFormatException("Only numbers in a phone number. Incorrect Phone must be 012-345-6789: not "+number);
    //                        }
    //                        else if(i==3||i==7&&number.charAt(i)!='-')
    //                        {
    //                                //System.out.println(i);
    //                                throw new IncorrectFormatException("Incorrect Phone must be 012-345-6789: not "+number);
    //                        }
    //                    }
    //                }
    //                if(st.hasMoreTokens())
    //                { // checks if there is too many tokens (maybe unneeded)
    //                    throw new IncorrectFormatException("Too many tokens in line 1");
    //                }
    //                //System.out.println("number: " + number);
    //                info = scan.nextLine(); // gets next line which has preferred day and times
    //                st = new StringTokenizer(info,",\t "); // tokenizes using , and tab as delimiters
    //                //System.out.println("st: " + info);
    //                temp = "";
    //                while(st.hasMoreTokens())
    //                { // check to see if there is more on the line
    //                    temp = st.nextToken();  //temp gets the token for checking
    //                    switch(temp){ // switch using the temp check if it a m,t,w,th,f or it will create a timeSchelede obj
    //                        case "m":
    //                            preferredDays.add(Day.MONDAY);
    //                            break;
    //                        case "t":
    //                            preferredDays.add(Day.TUESDAY);
    //                            break;
    //                        case "w":
    //                            preferredDays.add(Day.WEDNESDAY);
    //                            break;
    //                        case "th":
    //                            preferredDays.add(Day.THURSDAY);
    //                            break;
    //                        case "f":
    //                            preferredDays.add(Day.FRIDAY);
    //                            break;
    //                        case "sa":
    //                            preferredDays.add(Day.SATURDAY);
    //                            break;
    //                        case "su":
    //                            preferredDays.add(Day.SUNDAY);
    //                            break;
    //                        default:
    //                            //System.out.println("temp: " + temp);
    //                            StringTokenizer temp2 = new StringTokenizer(temp,"- ");
    //                            //System.out.println("" + Integer.parseInt(temp2.nextToken() + Integer.parseInt(temp2.nextToken())));
    //                            prefTimes.add(new TimeSchedule(Integer.parseInt(temp2.nextToken()),Integer.parseInt(temp2.nextToken())));
    //                            break;
    //                    }
    //                }
    //                while(!info.equals("") && scan.hasNextLine())
    //                { // check that if falls we know we are at the end of the TAF.
    //                        info = scan.nextLine();
    //                        //System.out.println(info);
    //                        if(!info.equals(""))
    //                        {
    //                            if(info.charAt(info.length()-1)==' ')
    //                            {
    //                                throw new IncorrectFormatException("Space after token: "+info);
    //                            }
    //                        preferredCourse.offerLast(info); // adds the preferred course using fifo
    //                        //System.out.println("courses: " + info);
    //                        }
    //                }
    //                if(preferredCourse.isEmpty())
    //                {
    //                    throw new IncorrectFormatException("No Courses added");
    //                }
    //                //System.out.println("testing: " + preferredDays);
    //                theMap.put(name, new Instructor(new TAF(preferredDays,prefTimes,preferredCourse),name,number));//Instructor and Taf have no Constructor???
    //                /*
    //                prefTimes.clear(); //clears arrays for new info
    //                preferredCourse.clear();
    //                preferredDays.clear();
    //                * */
    //            }
    //            
    //        }
    //        //System.out.println("INSIDE THE MAP: " + theMap);
    //        return theMap;
    //    }
}