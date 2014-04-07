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
        switch(day){ // switch using the temp check if it a m,t,w,th,f or it will create a timeSchelede obj
            case "Monday":
                preferredDays.add(Day.MONDAY);
                break;
            case "Tuesday":
                preferredDays.add(Day.TUESDAY);
                break;
            case "Wednesday":
                preferredDays.add(Day.WEDNESDAY);
                break;
            case "Thursday":
                preferredDays.add(Day.THURSDAY);
                break;
            case "Friday":
                preferredDays.add(Day.FRIDAY);
                break;
            case "Saturday":
                preferredDays.add(Day.SATURDAY);
                break;
            case "Sunday":
                preferredDays.add(Day.SUNDAY);
                break;
            default:
                break;
        }
    }
    private static void addTimesToList(ArrayList<TimeSchedule> prefTimes, String startTime,String endTime)
    {
        //seperate the time into an array of chars
        //the hour is the first two elements
        //the minute is the last two elements
        int startHour;
        int startMinute;
        int endMinute;
        int endHour;
        char[] start = startTime.toCharArray();
        char[] end = endTime.toCharArray();
        if(start.length==4){
            startHour = Integer.parseInt(String.valueOf(start[0])+String.valueOf(start[1]));
            startMinute = Integer.parseInt(String.valueOf(start[2])+String.valueOf(start[3]));
        } else {
             startHour = Integer.parseInt(String.valueOf(start[0]));
            startMinute = Integer.parseInt(String.valueOf(start[1])+String.valueOf(start[2]));   
        }
        if(end.length==4){
            endHour = Integer.parseInt(String.valueOf(end[0])+String.valueOf(end[1]));
            endMinute = Integer.parseInt(String.valueOf(end[2])+String.valueOf(end[3]));
        }
        else{
            endHour = Integer.parseInt(String.valueOf(end[0]));
            endMinute = Integer.parseInt(String.valueOf(end[1])+String.valueOf(end[2]));
        }
        /*
        int start = Integer.parseInt(startTime);
        int end = Integer.parseInt(endTime);
       */
        TimeSchedule ts = new TimeSchedule(startHour,startMinute,endHour,endMinute);
        prefTimes.add(ts);
    }
    public static HashMap<String,Instructor> loadInstructors(String filename) throws FileNotFoundException, IncorrectFormatException {
        return loadInstructors(new File(filename));
    }
    public static HashMap<String,Instructor> loadInstructors(File file) throws FileNotFoundException, IncorrectFormatException
    {
        HashMap<String,Instructor> theMap = new HashMap<String,Instructor>();
        Scanner scan = new Scanner(file);
        ArrayList<Day> preferredDays = null;
        ArrayList<TimeSchedule> prefTimes = null;
        ArrayDeque<String> preferredCourse = null;
        String info;
        String name = null;
        String number = null;
        String[] tok;
        int lineCount = 0;
        System.out.println("We are inside the loadinstructor method");
        while(scan.hasNextLine())
        {
            
            info = scan.nextLine();
            if(info.equals(""))
            {
                
                theMap.put(name,new Instructor(new TAF(preferredDays,prefTimes,preferredCourse),name,number));
                lineCount = 0;
            }
            else
            {
                tok = info.split(",");//begin by splitting each line by a ","
                //each token will then be parsed later in depth
                switch(lineCount)
                {
                    case 0:
                    {
                        //tok[3] == date == redundant
                        //email == tok[4] == redundant
                        System.out.println(tok[1]);
                        name = tok[0]+",";
                        if(tok[1].charAt(0) != ' ')
                            name+=" ";
                        name+=tok[1];
                        System.out.println(name);
                        number = tok[2];
                    }
                        break;
                    case 1:
                    {
                        preferredCourse = new ArrayDeque<String>();
                        String[] courseSplit;
                        String line;
                        for(int j = 0; j < tok.length; ++j)
                        {
                            line = tok[j].substring(1,tok[j].length()-1); //remove quotation marks
                            courseSplit = line.split(" ");
                            //remove quotation marks from courses
                            //extract the course number and section from entire name
                            //"CS248-300 Computer Science”
                            //will be added as
                            //CS248-300
                            preferredCourse.add(courseSplit[0]);
                        }
                    }
                        break;
                    case 2:
                    {
                        String[] split;
                        String line;
                        preferredDays = new ArrayList<Day>();
                        prefTimes = new ArrayList<TimeSchedule>();
                        for(int j = 0; j < tok.length;++j)
                        {
                            //line == "Monday-700-2130”,”Wednesday-900-2100”,”Friday-000-2145”
                            //split[0] == day
                            //split[1] == begin time
                            //split[2] == end time
                            //line = tok[j].substring(1,tok[j].length()-1);
                            line = tok[j];
                            //remove quotation marks
                            System.out.println(line);
                            split = line.split("-");//Monday
                            System.out.println(split[0]);
                            System.out.println(split[1]);
                            System.out.println(split[2]);
                            addDaysToList(preferredDays,split[0]);//700
                            addTimesToList(prefTimes,split[1],split[2]);//2130
                        }
                    }
                        break;
                    default:
                        break;
                }
                ++lineCount;
            }
            
            //At most we will have three lines per Instructor
            //Brilliant idea since it makes parsing each line much much easier
            //when we know what to expect
            //0 (first line) contains name, and number
            //1 (second line) contains courses
            //2 (third line) contains days and times
            
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
    //        Date admission;
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
    //            if(!info.equals("")){ // check to see if the file is at a "" string
    //                //System.out.println("info: " + info);
    //                st = new StringTokenizer(info,"\t"); //tokenizes the first line into name and phone number
    //                name = st.nextToken(); // saves name
    //                //System.out.println("name: " + name);
    //                if(!st.hasMoreTokens()){ // Check if there is a phone number if not throws format exception
    //                    throw new IncorrectFormatException("There is no phone number after "+name);
    //                }
    //                number = st.nextToken(); // saves number
    //                if(number.length()!=12){ //Checks if number is 012-345-6789 if not throws format exception
    //                    throw new IncorrectFormatException("Incorrect format too short or long. Phone must be 012-345-6789: not "+number);
    //                }
    //                else if(number.charAt(10)==' '){ //Checks length of phone number
    //                    throw new IncorrectFormatException("Incorrect format space after the token: "+number);
    //                }
    //                for(int i =0;i<number.length();i++){ // checks the format of the number (maybe unneeded)
    //                    if(i!=3&&i!=7){
    //                        if(!Character.isDigit(number.charAt(i))){
    //                            //System.out.println(i);
    //                            throw new IncorrectFormatException("Only numbers in a phone number. Incorrect Phone must be 012-345-6789: not "+number);
    //                        }
    //                        else if(i==3||i==7&&number.charAt(i)!='-'){
    //                                //System.out.println(i);
    //                                throw new IncorrectFormatException("Incorrect Phone must be 012-345-6789: not "+number);
    //                        }
    //                    }
    //                }
    //                if(st.hasMoreTokens()){ // checks if there is too many tokens (maybe unneeded)
    //                    throw new IncorrectFormatException("Too many tokens in line 1");
    //                }
    //                //System.out.println("number: " + number);
    //                info = scan.nextLine(); // gets next line which has preferred day and times
    //                st = new StringTokenizer(info,",\t "); // tokenizes using , and tab as delimiters
    //                //System.out.println("st: " + info);
    //                temp = "";
    //                while(st.hasMoreTokens()){ // check to see if there is more on the line
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
    //                while(!info.equals("") && scan.hasNextLine()) { // check that if falls we know we are at the end of the TAF.
    //                        info = scan.nextLine();
    //                        //System.out.println(info);
    //                        if(!info.equals("")) {
    //                            if(info.charAt(info.length()-1)==' '){
    //                            throw new IncorrectFormatException("Space after token: "+info);
    //                        }
    //                        preferredCourse.offerLast(info); // adds the preferred course using fifo
    //                        //System.out.println("courses: " + info);
    //                        }
    //                }
    //                if(preferredCourse.isEmpty()){
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