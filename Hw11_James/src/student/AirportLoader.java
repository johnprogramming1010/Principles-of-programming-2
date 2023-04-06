package student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AirportLoader {
public Map<String, Airport> getAirportMap(File airportFile){
	Map<String, Airport> airportMap = new HashMap<>();
	Scanner scnr;
	try {
		scnr = new Scanner(airportFile);
		while(scnr.hasNext()) {

		}
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
		}

	return null;
}
}
