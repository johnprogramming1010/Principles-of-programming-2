package prob2;

public class MartianManagerTest {

	public static void main(String[] args) {
//		addMartian_Red_Success();
//		addMartian_Green_Success();
//		addMartian_RedGreen_Failure();
//		addMartian_GreenRed_Failure();
		testContains_Success();
		testContains_Failure();
		testGetMartianAt_ValidIndex();
		testGetMartianAt_InvalidIndex_Low();
		testGetMartianAt_InvalidIndex_High();
		testGetMartianClosestTo_Index_LowerMatch();
		testGetMartianClosestTo_Index_LowerMatch1();
		testGetMartianClosestTo_Martian_LowerMatch();
		testGetMartianWithId_Success();
		testGetMartianWithId_Failure();
		testgetSortedMartians();
		testGetTeleporterAt_ValidIndex();
		testGetTeleporterAt_InvalidIndex_Low();
		testGetTeleporterAt_InvalidIndex_High();
		testGroupSpeak();
		testGroupTeleport();
		testObliterateTeleporters_One();
		testObliterateTeleporters_Many();
//		testRemoveMartianWithId_Success_Red();
//		testRemoveMartianWithId_Success_Red1();
//		testRemoveMartianWithId_Failure();
//		testToString();
//		testBattle_Small();
		testBattle_Larger();
	}

	//addMartian_Red_Success – add a red and verify only one martian, and no teleporters.
	public static void addMartian_Red_Success() {
		System.out.println("-->testaddMartian_Red_Success"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10);
		m.addMartian(r);
		String expected = "Red Martian - id=10, vol=1, ten=10";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m+'\n');
	}
	
	//addMartian_Green_Success – add a green and verify only one martian, and one teleporter.
	public static void addMartian_Green_Success() {
		System.out.println("-->testaddMartian_Red_Success"); 
		MartianManager m = new MartianManager();
		GreenMartian r = new GreenMartian(10,10);
		m.addMartian(r);
		String expected = "name=Dave, cost=$0.20, weight=0.10";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m+'\n');
	}
	
	//addMartian_RedGreen_Failure – add a red, add a green with same id,  and verify only one martian, and no teleporters.
	public static void addMartian_RedGreen_Failure() {
		System.out.println("-->testaddMartian_RedGreen_Failure"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10);
		GreenMartian g = new GreenMartian(10,10);
		m.addMartian(r);
		m.addMartian(g);
		String expected = "name=Dave, cost=$0.20, weight=0.10";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m+'\n');
	}
	
	//addMartian_GreenRed_Failure – add a green, add a red with same id,  and verify only one martian, and one teleporter.
	public static void addMartian_GreenRed_Failure() {
		System.out.println("-->testaddMartian_GreenRed_Failure()"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10);
		GreenMartian g = new GreenMartian(10,10);
		m.addMartian(g);
		m.addMartian(r);
		String expected = "name=Dave, cost=$0.20, weight=0.10";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m+'\n');
	}
	
	//testContains_Success – add a few, then ask if it contains a martian (red or green) with an id that does not exist.
	public static void testContains_Success() {
		System.out.println("-->testContains_Success"); 
		MartianManager m = new MartianManager();
		GreenMartian r = new GreenMartian(10,10);
		String expected = "contains";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m.contains(10)+'\n');
	}
	
	//testContains_Failure – add a few, then ask if it contains a martian (red or green) with an id that exists.
	public static void testContains_Failure() {
		System.out.println("-->testContains_Failure"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m.contains(10)+'\n');
	}
	
	//testGetMartianAt_ValidIndex – I’d suggest adding 4 martians, the call method with a valid index.
	public static void testGetMartianAt_ValidIndex() {
		System.out.println("-->testGetMartianAt_ValidIndex"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		Martian r1 = new RedMartian(10,10,10);
		Martian r2 = new RedMartian(10,10,10);
		Martian r3 = new RedMartian(10,10,10);
		m.addMartian(r);
		m.addMartian(r1);
		m.addMartian(r2);
		m.addMartian(r3);
		m.getMartianAt(0);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianAt_InvalidIndex_Low – Test with an index that is negative.
	public static void testGetMartianAt_InvalidIndex_Low() {
		System.out.println("-->testGetMartianAt_InvalidIndex_Low"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianAt_InvalidIndex_High – Test with an index that is >= size of list.
	public static void testGetMartianAt_InvalidIndex_High() {
		System.out.println("-->testGetMartianAt_InvalidIndex_High"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianClosestTo_Index_LowerMatch – I’d suggest: add 2 reds and 2 greens with id’s like: 1, 3, 8, 13. Then call method with id=4, expect to find martian with id=3
	public static void testGetMartianClosestTo_Index_LowerMatch() {
		System.out.println("-->testGetMartianClosestTo_Index_LowerMatch"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianClosestTo_Index_LowerMatch – I’d suggest: add 2 reds and 2 greens with id’s like: 1, 3, 8, 13. Then call method with id=6, expect to find martian with id=8
	public static void testGetMartianClosestTo_Index_LowerMatch1() {
		System.out.println("-->testGetMartianClosestTo_Index_LowerMatch"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianClosestTo_Martian_LowerMatch – I’d suggest: add 2 reds and 2 greens with id’s like: 1, 3, 8, 13. Then call method with a martian with id=6, expect to find martian with id=8. We’ll just do one test for this method.
	public static void 	testGetMartianClosestTo_Martian_LowerMatch() {
		System.out.println("-->	testGetMartianClosestTo_Martian_LowerMatch"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianWithId_Success – Add 4 martians, then call with an id that exists.
	public static void 	testGetMartianWithId_Success() {
		System.out.println("-->	testGetMartianWithId_Success"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetMartianWithId_Failure – Add 4 martians, then call with an id that does not exist.
	public static void 	testGetMartianWithId_Failure() {
		System.out.println("-->	testGetMartianWithId_Failure"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//getSortedMartians – Add 4 martians with ids (in this order): 4, 8, 1, 2. Verify that sorted order is correct AND that order is preserved in the internal arraylist.
	public static void 	testgetSortedMartians() {
		System.out.println("-->	testgetSortedMartians"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetTeleporterAt_ValidIndex – I’d suggest adding 6 martians with 4 being green, the call method with a valid index for teleporters.
	public static void 	testGetTeleporterAt_ValidIndex() {
		System.out.println("-->	testGetTeleporterAt_ValidIndex"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetTeleporterAt_InvalidIndex_Low – Test with an index that is negative.
	public static void 	testGetTeleporterAt_InvalidIndex_Low() {
		System.out.println("-->	testGetTeleporterAt_InvalidIndex_Low"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGetTeleporterAt_InvalidIndex_High – Test with an index that is >= size of teleporters list.
	public static void 	testGetTeleporterAt_InvalidIndex_High() {
		System.out.println("-->	testGetTeleporterAt_InvalidIndex_High"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGroupSpeak – I’d suggest, add 2 reds and a green and verify format of output is correct.
	public static void 	testGroupSpeak() {
		System.out.println("-->	testGroupSpeak"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testGroupTeleport – I’d suggest, add 1 reds and and 3 greens and verify format of output is correct.
	public static void 	testGroupTeleport() {
		System.out.println("-->	testGroupTeleport"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testObliterateTeleporters_One – I’d suggest: add 3 including exactly 1 green. 
	public static void 	testObliterateTeleporters_One() {
		System.out.println("-->	testObliterateTeleporters_One"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testObliterateTeleporters_Many – I’d suggest: add 6 including exactly 3 greens. 
	public static void 	testObliterateTeleporters_Many() {
		System.out.println("-->	testObliterateTeleporters_Many"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}
	
	//testRemoveMartianWithId_Success_Red – Add 2 reds and 2 greens, then call with an id that exists in a red
	public static void 	testRemoveMartianWithId_Success_Red() {
		System.out.println("-->	testRemoveMartianWithId_Success_Red"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10,10);
		RedMartian r1 = new RedMartian(5,10,10);
		GreenMartian g = new GreenMartian(4,10);
		GreenMartian g1 = new GreenMartian(3,10);
		m.addMartian(r);
		m.addMartian(r1);
		m.addMartian(g);
		m.addMartian(g1);
		String expected = "Green Martian - id=10, vol=8";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m.getMartianWithId(10) + '\n');
	}
	
	//testRemoveMartianWithId_Success_Red – Add 2 reds and 2 greens, then call with an id that exists in a green
	public static void 	testRemoveMartianWithId_Success_Red1() {
		System.out.println("-->	testRemoveMartianWithId_Success_Red"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10,10);
		RedMartian r1 = new RedMartian(5,10,10);
		GreenMartian g = new GreenMartian(4,10);
		GreenMartian g1 = new GreenMartian(3,10);
		m.addMartian(r);
		m.addMartian(r1);
		m.addMartian(g);
		m.addMartian(g1);
		String expected = "Green Martian - id=3, vol=8";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m.getMartianWithId(3) + '\n');
	}
		
	//testRemoveMartianWithId_Failure – Add 4 martians, then call with an id that does not exist.
	public static void 	testRemoveMartianWithId_Failure() {
		System.out.println("-->	testRemoveMartianWithId_Failure"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10,10);
		RedMartian r1 = new RedMartian(5,10,10);
		GreenMartian g = new GreenMartian(4,10);
		GreenMartian g1 = new GreenMartian(3,10);
		m.addMartian(r);
		m.addMartian(r1);
		m.addMartian(g);
		m.addMartian(g1);
		String expected = "null";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m.getMartianWithId(1) + '\n');
	}
	
	//testToString – I’d suggest: add 2 reds and 2 greens and verify output.
	public static void 	testToString() {
		System.out.println("-->	testToString"); 
		MartianManager m = new MartianManager();
		RedMartian r = new RedMartian(10,10,10);
		RedMartian r1 = new RedMartian(5,10,10);
		GreenMartian g = new GreenMartian(4,10);
		GreenMartian g1 = new GreenMartian(3,10);
		m.addMartian(r);
		m.addMartian(r1);
		m.addMartian(g);
		m.addMartian(g1);
		String expected = "Red Martian - id=10, vol=10, ten=10\r\n"
				+ "Red Martian - id=5, vol=10, ten=10\r\n"
				+ "Green Martian - id=4, vol=10\r\n"
				+ "Green Martian - id=3, vol=10";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m.toString());
	}
	
//  testBattle_Small – You’ll want to carefully construct this test. When you create the martians and invaders, I suggest putting a comment beside that tells what the power is (for easy reference). For example:
//
//	RedMartian r1 = new RedMartian(1,1,1); // power=2
//	RedMartian r2 = new RedMartian(2,2,2); // power=4
//	GreenMartian g1 = new GreenMartian(3); // power=1
//
//	I’d suggest something like this: a 2 reds and 2 greens to MM. Then create 2 invaders: 1 red and 1 green. Set their id’s such that one invader gets a kill, and the other doesn’t. Thus, only 1 kill. Need to verify that that both martians and “killed” lists are correct. You might just print the id’s of the martians and the ids of those killed.
//
//	Actually, for this method, I would have a bunch of tests: (a) 3 martians, 1 invader, get a kill, (b) 3 martians, 1 invader no kills, (c) then the one above, (d) 5 martians, 3 invaders, 2 kills, (e) 2 martians, 2 invaders, both killed, (f) 2 martians, 3 invaders, both killed.
//
//	However, you can just write one more if you like – the one next.
//	public static void 	testBattle_Small() {
//		System.out.println("-->	testBattle_Small"); 
//		MartianManager m = new MartianManager();
//		RedMartian r1 = new RedMartian(1,1,1); // power=2
//		RedMartian r2 = new RedMartian(2,2,2); // power=4
//		GreenMartian g1 = new GreenMartian(3); // power=1
//		GreenMartian g2 = new GreenMartian(3); // power=1
//		
//		m.addMartian(r1);
//		m.addMartian(r2);
//		m.addMartian(g1);
//		m.addMartian(g2);
//		String expected = "does not contain";
//		System.out.println("expected: " + expected);
//		System.out.println("-->" + m.battle());
//	}
	
	//testBattle_Larger – I’d suggest: 5 martians, 3 invaders, 2 kills.
	public static void 	testBattle_Larger() {
		System.out.println("-->	testBattle_Larger"); 
		MartianManager m = new MartianManager();
		Martian r = new RedMartian(10,10,10);
		m.contains(-10);
		String expected = "does not contain";
		System.out.println("expected: " + expected);
		System.out.println("-->" + m);
	}

}
