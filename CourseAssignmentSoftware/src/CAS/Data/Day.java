package CAS.Data;


/**
 * @author Sarah Ben-Kiki
 *
 */
public enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	THURSDAY, FRIDAY, SATURDAY, ANY;

/** (non-Javadoc)
 * @see java.lang.Enum#toString()
 */
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