package prob2;

public class GreenMartianTest {

	public static void main(String[] args) {
		testSpeakAndTeleportAndToString();
		testEquals_Success();
		testEquals_Fail();
		testEqualsRedAndGreen_Success();
		testCompareToRedAndGreenSuccess();
	}
	public static void testSpeakAndTeleportAndToString() {
		GreenMartian gm = new GreenMartian(8, 3);
		System.out.println("Expected: id=xxx, Grobldy Grock");
		System.out.println("  Actual: " + gm.speak());
		System.out.println("Expected: Green Martian - id=8, vol=3");
		System.out.println("  Actual: " + gm.toString());
		System.out.println("Expected: id=xxx teleporting to dest");
		System.out.println("  Actual: " + gm.teleport("china"));
	}
	
	public static void testEquals_Success() {
		GreenMartian gm = new GreenMartian(8, 3);
		GreenMartian gm2 = new GreenMartian(8, 3);
		System.out.println("Expected: true same");
		System.out.println("  Actual: " + gm.equals(gm2));
	}
	
	public static void testEquals_Fail() {
		GreenMartian gm = new GreenMartian(8, 3);
		GreenMartian gm2 = new GreenMartian(2, 2);
		System.out.println("Expected: false not same");
		System.out.println("  Actual: " + gm.equals(gm2));
	}
	
	public static void testEqualsRedAndGreen_Success() {
		GreenMartian gm = new GreenMartian(8, 3);
		RedMartian rm = new RedMartian(8, 3);
		System.out.println("Expected: true same");
		System.out.println("  Actual: " + gm.equals(rm));
	}
	
	public static void testCompareToRedAndGreenSuccess() {
		GreenMartian gm = new GreenMartian(8, 3);
		RedMartian rm = new RedMartian(8, 3);
		GreenMartian gm1 = new GreenMartian(2, 3);
		RedMartian rm1 = new RedMartian(8, 3);
		System.out.println("Expected: 0 same");
		System.out.println("  Actual: " + gm.compareTo(rm));
		System.out.println("Expected: -1 not same");
		System.out.println("  Actual: " + gm1.compareTo(rm1));
	}
}
