
package CAS.Data;

public class Time{
 private int hour;
 private int min;

 public Time(int hour, int min){
 }
 
 public void setTime(int h, int m){
     hour =((h >= 0&& h < 24) ? h :0);
     min = ((m >= 0 && m < 60) ? m :0);
}
 
// convert to String in universal-time format (HH:MM:SS)
 public String toUniversalString(){
     return String.format( "%02d:%02d:%02d", hour, min);
 }
    
 // convert to String in standard-time format (H:MM:SS AM PM)
 public String toString(){ 
     return String.format( "%d:%02d:%02d %s",(( hour == 0 || hour == 12) ? 12 : hour %12),min,(hour< 12?"AM":"PM"));
 }
}