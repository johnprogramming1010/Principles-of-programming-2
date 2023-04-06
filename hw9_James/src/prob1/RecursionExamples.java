package prob1;

public class RecursionExamples {

	// Problem 1a
	public static double sumSeries(int n) {
		if( n==1) {
			return 1;
		}
		if(n % 2 == 0) {
			return sumSeries(n-1) + 1.0/n;
		}
		else {
			return sumSeries(n-1) - 1.0/n;
		}
	}

	// Problem 1b
	public static void printReverse2(String s) {
        if ((s.length() <= 1))
            System.out.println(s);
         else
         {
             System.out.print(s.charAt(s.length()-1));
             printReverse2(s.substring(0,s.length()-1));
         }
	}
	
	// Problem 1c
	public static void printReverse(String s, int n) {
		
        if ((n >=s.length()-(n+1)))
            System.out.println(s);
         else
         {
             System.out.print(s.charAt(s.length()-1));
             printReverse(s.substring(0,s.length()-1),n);
         }
	}
	
	// Problem 1d
	public static int countVowels(String s) {
		if(s.length() == 0) {
			return 0;
		}
		else if((s.charAt(0) == 'a') || (s.charAt(0) == 'A')) {
			return 1 + countVowels(s.substring(1));
		}
		else if((s.charAt(0) == 'e') || (s.charAt(0) == 'E')) {
			return 1 + countVowels(s.substring(1));
		}
		else if((s.charAt(0) == 'i') || (s.charAt(0) == 'I')) {
			return 1 + countVowels(s.substring(1));
		}
		else if((s.charAt(0) == 'o') || (s.charAt(0) == 'O')) {
			return 1 + countVowels(s.substring(1));
		}
		else if((s.charAt(0) == 'u') || (s.charAt(0) == 'U')) {
			return 1 + countVowels(s.substring(1));
		}
		
		return countVowels(s.substring(1));
	}
	
	// Problem 1e, requires a helper
	public static int countLength(String[] strs) {
		return countLength1(strs, 0);
	}
	
	// Helper
	private static int countLength1(String[] strs, int i) {
		if(strs.length == i) {
			return 0;
		}
		else {
			return strs[i].length() + countLength1(strs, i+1);
		}
	}

	// Problem 1f, requires a helper
	public static int getMax(int[] vals) {
		return getMax1(vals, 0); 
		}
	
	// Helper
	private static int getMax1(int[] vals, int i){
		return i < vals.length ? Math.max(vals[i], getMax1(vals, i+1)) : Integer.MIN_VALUE;
	}


	// Problem 1g, requires a helper
	public static int countCode(String msg, String code ) {
		return countCode1(msg, code, 0);
	}
	
	// Helper
	private static int countCode1(String msg, String code, int pos) {
		if(pos > msg.length() - code.length()) {
			return 0;
		}
		if(pos < msg.length() - code.length()) {
			return 1 + countCode1(msg, code, pos+1);
		}
		else {
			return countCode1(msg, code, pos+1);
		}
	}

}
