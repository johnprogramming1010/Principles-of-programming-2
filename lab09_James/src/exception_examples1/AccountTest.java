package exception_examples1;

public class AccountTest {
	public static void main(String[] args) {
		testBalance_Valid();
		testBalance_InValid();
		
	}

	private static void testBalance_Valid() {
		System.out.println("testBalance_Valid()");
		int account=1;
		try {
			System.out.println( inverse(account));
		}
		catch(ArithmeticException e) {
			System.out.println("exception caught");
		}
		finally {
			System.out.println("greater than 0\n");
		}
	}
	
	private static void testBalance_InValid() {
		System.out.println("testBalance_InValid()");
		int account=-5;
		try {
			System.out.println( inverse(account));
		}
		catch(ArithmeticException e) {
			System.out.println("exception caught");
		}
		finally {
			System.out.println("less than zero negative number");
		}
	}
	
	public static int inverse( int account) {
		return 1/account;
	}
}
