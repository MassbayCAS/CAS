package CAS.Data;

public enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	THURSDAY, FRIDAY, SATURDAY, ANY;

	@Override
	public String toString() {
		switch (this) {
		case SUNDAY: return "Su";
		case MONDAY: return "M";
		case TUESDAY: return "T";
		case WEDNESDAY: return "W";
		case THURSDAY: return "R";
		case FRIDAY: return "F";
		case SATURDAY: return "Sa";
                case ANY: return " ";
		default: throw new IllegalArgumentException();
		}
	}
}