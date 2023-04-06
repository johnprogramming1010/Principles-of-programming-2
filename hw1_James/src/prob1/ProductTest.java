package prob1;

public class ProductTest {

	/***
	 * YOU SHOULD WRITE THESE TEST METHODS.
	 * 
	 */
	public static void main(String[] args) {
		testProductConstructor_Plant_3chars_Batch_2chars();
		testProductConstructor_Plant_3chars_Batch_1chars();
		testProductConstructor_Plant_2chars_Batch_2chars();
		testProductConstructor_Plant_2chars_Batch_1chars();
		testIsAfter2000Test_True_Year2019();
		testIsAfter2000Test_True_Year2000();
		testIsAfter2000Test_False_Year1994();
		testIsMonthEqual_True();
		testIsMonthEqual_False();
	}
	
	/***
	 * Construct a product where the plant has 3 characters, and the batch has 2.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_3chars_Batch_2chars() {
		System.out.println("-->testProductConstructor_Plant_3chars_Batch_2chars()");
		
		Product p = new Product("Val0404193693");
		System.out.println("Expected: Code:Val0404193693\r\n"
				+ "plant:Val\r\n"
				+ "date:04/04/1936\r\n"
				+ "batch:93\n");
		System.out.println("Actual: Code:" + p.getCode() + "\nplant:" + p.getPlant() + "\ndate:" + p.getDate() + "\nbatch:" + p.getBatch());
	}

	/***
	 * Construct a product where the plant has 3 characters, and the batch has 1.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_3chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_3chars_Batch_1chars()");
		
		
		Product p = new Product("Val040419369");
		System.out.println("Expected: Code:Val040419369\r\n"
				+ "plant:Val\r\n"
				+ "date:04/04/1936\r\n"
				+ "batch:9\n");
		System.out.println("Actual: Code:" + p.getCode() + "\nplant:" + p.getPlant() + "\ndate:" + p.getDate() + "\nbatch:" + p.getBatch());
	}

	/***
	 * Construct a product where the plant has 2 characters, and the batch has 2.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_2chars_Batch_2chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_2chars()");
		
		Product p = new Product("Va0404193693");
		System.out.println("Expected: Code:Va0404193693\r\n"
				+ "plant:Va\r\n"
				+ "date:04/04/1936\r\n"
				+ "batch:93\n");
		System.out.println("Actual: Code:" + p.getCode() + "\nplant:" + p.getPlant() + "\ndate:" + p.getDate() + "\nbatch:" + p.getBatch());
	}

	/***
	 * Construct a product where the plant has 2 characters, and the batch has 1.
	 * Should show that code, plant, date, and batch are correct.
	 */
	public static void testProductConstructor_Plant_2chars_Batch_1chars() {
		System.out.println("\n-->testProductConstructor_Plant_2chars_Batch_1chars()");
		
		Product p = new Product("Va040419369");
		System.out.println("Expected: Code:Va040419369\r\n"
				+ "plant:Va\r\n"
				+ "date:04/04/1936\r\n"
				+ "batch:9\n");
		System.out.println("Actual: Code:" + p.getCode() + "\nplant:" + p.getPlant() + "\ndate:" + p.getDate() + "\nbatch:" + p.getBatch());
	}

	/***
	 * Construct a product where the year is 2019 and then call isAfter2000() which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_True_Year2019() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2019()");
		Product p = new Product("Val0404201993");
		System.out.println("Expected: true " + p.getDate());
		System.out.println("Actual: " + p.isAfter2000());
	}

	/***
	 * Construct a product where the year is 2000 and then call isAfter2000() which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_True_Year2000() {
		System.out.println("\n-->testIsAfter2000Test_True_Year2000()");
		Product p = new Product("Val0404200093");
		System.out.println("Expected: true " + p.getDate());
		System.out.println("Actual: " + p.isAfter2000());
	}

	/***
	 * Construct a product where the year is 1994 and then call isAfter2000() which should return false.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsAfter2000Test_False_Year1994() {
		System.out.println("\n-->testIsAfter2000Test_False_Year1994()");
		Product p = new Product("Val0404199493");
		System.out.println("Expected: false " + p.getDate());
		System.out.println("Actual: " + p.isAfter2000());
	}

	/***
	 * Construct a product where the month is say, Feb, and then call isMonthEqual(2) which should return true.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsMonthEqual_True() {
		System.out.println("\n-->testIsMonthEqual_True()");
		Product p = new Product("Val0202199493");
		System.out.println("Expected: true " + p.getDate());
		System.out.println("Actual: " + p.isMonthEqual(2));
	}

	/***
	 * Construct a product where the month is say, Feb, and then call isMonthEqual(3) which should return false.
	 * Show values to illustrate that return is correct.
	 */
	public static void testIsMonthEqual_False() {
		System.out.println("\n-->testIsMonthEqual_False()");
		Product p = new Product("Val0202199493");
		System.out.println("Expected: false " + p.getDate());
		System.out.println("Actual: " + p.isMonthEqual(3));
	}

}
