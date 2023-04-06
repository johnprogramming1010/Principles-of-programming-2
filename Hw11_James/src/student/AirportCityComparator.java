package student;

import java.util.Comparator;

public class AirportCityComparator implements Comparator<Airport>{

	public AirportCityComparator() {

	}

	public int compare(Airport a1, Airport a2) {
		if (a1.getCity().equals(a2.getCity())){
			return 1;
		}
		else {
			return -1;
		}
	}
}
