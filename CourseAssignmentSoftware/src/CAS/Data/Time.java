package CAS.Data;

public class Time{
	private int hour;
	private int min;

	public Time(int hour, int min) {
		if(hour < 0 || hour > 23 || min < 0 || min > 59) {
			throw new IllegalArgumentException();
		}
		this.hour = hour;
		this.min = min;
	}

	public int getHour() {
		return hour;
	}
        
        public int getMin() {
            return min;
        }

	// convert to String in universal-time format (HH:MM)
	public String toUniversalString(){
		return String.format( "%02d:%02d", hour, min);
	}

	// convert to String in standard-time format (H:MM AM PM)
        @Override
	public String toString(){
            if (hour == 0 && min == 0) {
                return " ";
            }
            else {
		return String.format( "%d:%02d",(( hour == 0 || hour == 12) ? 12 : hour % 12),min,(hour< 12?"AM":"PM"));
            }
	}
        
        @Override
        public boolean equals(Object object) {
            if (object == null) {                return false;            }
            if (object == this) {                return true;            }
            if (object instanceof Time) {
                Time time = (Time)object;
                return (this.hour == time.getHour() && this.min == time.getMin());
            }
            else {
                return false;
            }
        }
}