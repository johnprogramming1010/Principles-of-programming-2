package prob1;

public class WarehouseTest {

	public static void main(String[] args) {
		testAddItem();
		testAddItem_Multiple();
		testGetItem_WithIndex();
		testGetItem_WithName();
		testGetAverageTemp();
		testGetRefrigeratedItems();
		testGetTotalCost();
		testGetTotalCostRefrigerated();
		testRemoveItem_WithIndex();
		testRemoveItem_WithName();
		testToString();
	}
	
	/**
	 * Add one item and check the number of items to verify.
	 */
	public static void testAddItem() {
		System.out.println("\n-->testAddItem"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		W.addItem(I);
		
		System.out.println("Expected: NumItems=1");
		System.out.println("  Actual: NumItems=" + W.getNumItems());
	}
	
	/**
	 * Add three items and check the number of items to verify. At least one should be a refrigerated item.
	 */
	public static void testAddItem_Multiple() {
		System.out.println("\n-->testAddItem_Multiple"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		
		System.out.println("Expected: NumItems=3");
		System.out.println("  Actual: NumItems=" + W.getNumItems());
	}
	
	/**
	 * Add three items and retrieve the one at index 1.
	 */
	public static void testGetItem_WithIndex() {
		System.out.println("\n-->testGetItem_WithIndex"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		
		System.out.println("Expected: name=Bill, cost=$20.00, weight=10.00");
		System.out.println("  Actual: " + W.getItem(1));
	}

	/**
	 * Add three items and try to find one with a name that exists.
	 */
	public static void testGetItem_WithName() {
		System.out.println("\n-->testGetItem_WithName"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		
		System.out.println("Expected: name=Billy, cost=$20.00, weight=10.00");
		System.out.println("  Actual: " + W.getItem("Billy"));
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the average temperature.
	 */
	public static void testGetAverageTemp() {
		System.out.println("\n-->testGetAverageTemp"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 40.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 60.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		
		System.out.println("Expected: 240.0");
		System.out.println("  Actual: " + W.getAverageTemp());
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify that the 3 are returned in array.
	 */
	public static void testGetRefrigeratedItems() {
		System.out.println("\n-->testGetRefrigeratedItems");

		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 80.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		System.out.println("Expected: \nname=Billy, cost=$22.00, weight=10.00, temp=80.00 degrees\r\n"
				+ "name=Bill, cost=$22.00, weight=10.00, temp=80.00 degrees\r\n"
				+ "name=Bob, cost=$22.00, weight=10.00, temp=80.00 degrees\n");
		RefrigeratedItem[] items = W.getRefrigeratedItems();
		System.out.println("Actual: ");
		for(int i = 0; i<items.length; i++) {
		System.out.println(items[i]);
		}
	}
	
	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost.
	 */
	public static void testGetTotalCost() {
		System.out.println("\n-->testGetTotalCostRefrigerated"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 80.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		
		System.out.println("Expected: 106.0");
		
		System.out.println("  Actual: " + W.getTotalCost());
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Verify the total cost of the 3 refrigerated items
	 */
	public static void testGetTotalCostRefrigerated() {
		System.out.println("\n-->testGetTotalCostRefrigerated"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 80.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		
		System.out.println("Expected: 66.0");
		System.out.println("  Actual: " + W.getTotalCostRefrigerated());
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove the one at position 2 and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithIndex() {
		System.out.println("\n-->testRemoveItem_WithIndex"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 80.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		
		System.out.println("Expected: name=Bill, cost=$20.00, weight=10.00");
		System.out.println("  Actual: " + W.removeItem(1));
	}

	/**
	 * Add 5 items, 3 of which are refrigerated. Remove one with a name that exists and 
	 * verify: the item is returned, and the number of items is decremented.
	 */
	public static void testRemoveItem_WithName() {
		System.out.println("\n-->testRemoveItem_WithName"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 80.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		
		System.out.println("Expected: name=Bob, cost=$20.00, weight=10.00");
		System.out.println("  Actual: " + W.removeItem("Bob"));
	}

	/**
	 * Verify that the toString method produces a string exactly
	 * as specified in the assignment document. 
	 */
	public static void testToString() {
		System.out.println("\n-->testToString"); 
		Warehouse W = new Warehouse();
		Item I = new Item("Billy", 10.0);
		Item I2 = new Item("Bill", 10.0);
		RefrigeratedItem RI = new RefrigeratedItem("Billy", 10.0, 80.0);
		RefrigeratedItem RI1 = new RefrigeratedItem("Bill", 10.0, 80.0);
		RefrigeratedItem RI2 = new RefrigeratedItem("Bob", 10.0, 80.0);
		W.addItem(I);
		W.addItem(I2);
		W.addItem(RI);
		W.addItem(RI1);
		W.addItem(RI2);
		
		System.out.println("Expected: name=Billy, cost=$20.00, weight=10.00\r\n"
				+ "name=Bill, cost=$20.00, weight=10.00\r\n"
				+ "name=Billy, cost=$22.00, weight=10.00, temp=80.00 degrees\r\n"
				+ "name=Bill, cost=$22.00, weight=10.00, temp=80.00 degrees\r\n"
				+ "name=Bob, cost=$22.00, weight=10.00, temp=80.00 degrees");
		System.out.println("Actual: " + W.toString());
	}

}
