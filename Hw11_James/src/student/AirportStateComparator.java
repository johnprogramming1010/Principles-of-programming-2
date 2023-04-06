package student;

public class AirportStateComparator {

	public AirportStateComparator() {
	}

	public int compare(Airport a1, Airport a2) {
		if (a1.getState().equals(a2.getState())){
			return 1;
		}
		else {
			return -1;
		}
	}
}