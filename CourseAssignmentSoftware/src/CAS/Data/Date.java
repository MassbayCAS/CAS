package CAS.Data;

public class Date {
	int day;
	int month;
	int year;
	
	public Date(int day, int month, int year){
		this.year=year;
		this.month=month;
		this.day=day;
	}
	
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
}
