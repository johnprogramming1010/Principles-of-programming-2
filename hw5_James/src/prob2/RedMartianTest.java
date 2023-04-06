package prob2;

public class RedMartianTest {

	public static void main(String[] args) {
		testSpeakAndToString();
		testEquals_Success();
		testEquals_Fail();
		testCompareTo_Negative();
		testCompareTo_Positive();
		testCompareTo_Zero();
	}

	public static void testSpeakAndToString() {
		RedMartian rm = new RedMartian(8, 3);
		System.out.println("Expected: id=xxx, Rubldy Rock");
		System.out.println("  Actual: " + rm.speak());
		System.out.println("Expected: Red Martian - id=8, vol=1, ten=3");
		System.out.println("  Actual: " + rm.toString());
	}
	
	public static void testEquals_Success() {
		RedMartian rm = new RedMartian(8, 3);
		RedMartian rm2 = new RedMartian(8, 3);
		System.out.println("Expected: true");
		System.out.println("  Actual: " + rm.equals(rm2));
	}
	
	public static void testEquals_Fail() {
		RedMartian rm = new RedMartian(7, 2);
		RedMartian rm2 = new RedMartian(8, 3);
		System.out.println("Expected: false");
		System.out.println("  Actual: " + rm.equals(rm2));
	}
	
	public static void testCompareTo_Negative() {
	RedMartian rm = new RedMartian(7, 2);
	RedMartian rm2 = new RedMartian(8, 3);
	System.out.println("Expected: -1");
	System.out.println("  Actual: " + rm.compareTo(rm2));
}
	
	public static void testCompareTo_Positive() {
	RedMartian rm = new RedMartian(9, 4);
	RedMartian rm2 = new RedMartian(8, 3);
	System.out.println("Expected: 1");
	System.out.println("  Actual: " + rm.compareTo(rm2));
	}

	public static void testCompareTo_Zero() {
	RedMartian rm = new RedMartian(8, 3);
	RedMartian rm2 = new RedMartian(8, 3);
	System.out.println("Expected: 0");
	System.out.println("  Actual: " + rm.compareTo(rm2));
	}
}
