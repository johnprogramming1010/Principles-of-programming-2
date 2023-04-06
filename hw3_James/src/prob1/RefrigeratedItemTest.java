package prob1;

public class RefrigeratedItemTest {

	public static void main(String[] args) {
		testConstructorMain();
		testConstructorAcceptsItem();
		testItemCost();
		testToString();
	}
	
	/**
	 * Verify that the name, weight, & temp are initialized with the main constructor.
	 */
	public static void testConstructorMain() {
		System.out.println("-->testConstructorMain"); 
		RefrigeratedItem RI = new RefrigeratedItem("billy", 95.0, 10);
		System.out.println("Expected: name=billy weight=95.0 temperature=10.0");
		System.out.println("  Actual: name=" + RI.getName() + " weight=" + RI.getWeight() + " temperature=" + RI.getTemperature());
	}

	/**
	 * Verify that the name, weight, & temp are initialized with the second constructor.
	 */
	public static void testConstructorAcceptsItem() {
		System.out.println("-->testConstructorAcceptsItem"); 
		Item I = new Item("billy", 95.0);
		RefrigeratedItem RI = new RefrigeratedItem(I, 10);
		System.out.println("Expected: name=billy weight=95.0 temperature=10.0");
		System.out.println("  Actual: name=" + RI.getName() + " weight=" + RI.getWeight() + " temperature=" + RI.getTemperature());
	}

	/**
	 * Verify that the cost method works correctly.
	 */
	public static void testItemCost() {
		System.out.println("-->testItemCost"); 
		RefrigeratedItem RI = new RefrigeratedItem("billy", 95.0, 10);
		System.out.println("Expected: cost=199.0");
		System.out.println("  Actual: cost=" + RI.cost());
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("-->testToString"); 
		RefrigeratedItem RI = new RefrigeratedItem("billy", 95.0, 10);
		System.out.println("Expected: cost=name=billy, cost=$190.00, weight=95.00, temp=10.00 degrees");
		System.out.println("  Actual: cost=" + RI.toString());
	}

}
