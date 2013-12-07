/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAS.DataIO;
import java.util.*;
import java.io.*;
import CAS.Data.*;
/**
 *
 * @author Eric Sullivan
 */

public class SeniorityListReader extends FileReader
{
    private Scanner scan;
    private String workArea;
    private int senior;
    private String name;
    private String input;
    
    public SeniorityListReader() throws IOException {
        super("FakeSeniority.txt");
        scan = new Scanner(super.getFile());
        workArea = "";
        senior =0;
        name ="";
        input = "";
    }
    public HashMap<String,Instructor> loadSeniorityList(HashMap<String,Instructor> theMap){
        StringBuilder snip;
        StringTokenizer st;
        while(scan.hasNextLine()){
            input = scan.nextLine();
            if(!input.equals("")){
            if(input.charAt(0)=='-'&&input.charAt(1)=='-'){
                snip = new StringBuilder(input);
                workArea = snip.substring(2);
                
            }
            else{
                st = new StringTokenizer(input,"\r\n\t\f ");
                name = st.nextToken();
                senior =Integer.parseInt(st.nextToken());
                theMap.get(name).getSeniorities().put(workArea,senior);
            }
            }
        }
        return theMap;
    }
}