package student;

public class AirportTest {
public static void testGetters() {
	Airport LAX = new Airport("ABC",15.0,1.0,"Los Angeles","California");
	System.out.println("     Expected Code: ABC");
	System.out.println("       Actual Code: "+LAX.getCode());
	System.out.println(" Expected Latitude: 15.0");
	System.out.println("   Actual Latitude: "+LAX.getLatitude());
	System.out.println("Expected Longitude: 1.0");
	System.out.println("  Actual Longitude: "+LAX.getLongitude());
	System.out.println("     Expected City: Los Angeles");
	System.out.println("       Actual City: "+LAX.getCity());
	System.out.println("    Expected State: California");
	System.out.println("      Actual State: "+LAX.getState());
	System.out.println("Expected ABC-Los Angeles, California: 15.00, 1.00");
	System.out.println("Actual = "+LAX.toString());
}
public static void testEquals() {
	Airport LAX = new Airport("ABC",15.00,1.00,"Los Angeles","California");
	Airport JAX = new Airport("DEF",10.00,20.00,"Jacksonville","Florida");
	Airport LAX2 = LAX;
	System.out.println("\n  Expected: false");
	System.out.println("    Actual: "+LAX.equals(JAX));
	System.out.println("  Expected: true");
	System.out.println("    Actual: "+LAX.equals(LAX2));
}
public static void main(String[] args) {
	testGetters();
	testEquals();
}
}
