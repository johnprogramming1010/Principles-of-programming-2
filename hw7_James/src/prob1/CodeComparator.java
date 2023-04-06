package prob1;

import java.util.Comparator;

public class CodeComparator implements Comparator<Product>{
	
	public int compare(Product p1, Product p2) {
	String text1 = p1.getCode(); 
	String text2 = p2.getCode(); 
	
	String[] codeArray1 = text1.split("-");
	String[] codeArray2 = text2.split("-");
	
	if (codeArray1[0].equalsIgnoreCase("QC") && codeArray2[0].equalsIgnoreCase("DA")) {
		return -1;
	}
	
	else if (codeArray1[0].equalsIgnoreCase("QC") && codeArray2[0].equalsIgnoreCase("MZ")) {
		return -1;
	}
	
	else if (codeArray1[0].equalsIgnoreCase("DA") && codeArray2[0].equalsIgnoreCase("QZ")) {
		return -1;
	}
		
	else if (codeArray1[0].equalsIgnoreCase("DA") && codeArray2[0].equalsIgnoreCase("MZ")) {
		return -1;
	}
	
	else if (codeArray1[0].equalsIgnoreCase("MZ") && codeArray2[0].equalsIgnoreCase("QC")) {
		return -1;
	}
	
	else if (codeArray1[0].equalsIgnoreCase("MZ") && codeArray2[0].equalsIgnoreCase("DA")) {
		return -1;
	}
		
		else {
			int diff = Integer.parseInt(codeArray1[1]) - Integer.parseInt(codeArray2[1]);
			if( diff < 0.0) {
				return -1;
			}
			else if( diff < 0.0) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}
}
