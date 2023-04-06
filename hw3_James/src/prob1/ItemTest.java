package prob1;

public class ItemTest {

	public static void main(String[] args) {
		testConstructor();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name & weight are initialized with the constructor.
	 */
	public static void testConstructor() {
		System.out.println("-->testConstructor"); 
		
		Item I = new Item("billy", 95.0);
		
		System.out.println("Expected: name=billy weight=95.0");
		System.out.println("  Actual: name=" + I.getName() + " weight=" + I.getWeight());
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		Item I = new Item("billy", 95.0);
		
		System.out.println("Expected: cost=95.0*2 = 190.0");
		System.out.println("  Actual: cost=" + I.cost());
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		Item I = new Item("billy", 95.0);
		
		System.out.println("Expected: cost=name=billy, cost=$190.00, weight=95.00");
		System.out.println("  Actual: cost=" + I.toString());
	}

}
