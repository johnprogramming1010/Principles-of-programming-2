package prob1;

public class Product {
	private int batch;
	private String code;
	private String date;
	private String plant;
	
	Product(String code){
		this.code = code;
	}
	
	public int getBatch() {
		if(getCode().length() == 13) {
			String s = getCode().substring(11);
			batch = Integer.parseInt(s);	
		}
		
		else if(getCode().length() == 11) {
			String s = getCode().substring(10);
			batch = Integer.parseInt(s);
		}
		
		if(Character.isLetter(getCode().charAt(2))) {
		if(getCode().length() == 12) {
			String s = getCode().substring(11);
			batch = Integer.parseInt(s);
			}
		}
		else {
			String s = getCode().substring(10);
			batch = Integer.parseInt(s);
		}
		return batch;
	}
	
	public String getCode() {
		return code;
	}
		
	public String getDate() {
		if(Character.isLetter(getCode().charAt(2))) {
			date = getCode().substring(3,5) + "/" + getCode().substring(5,7) + "/" + getCode().substring(7,11);
		}
		else {
			date = getCode().substring(2,4) + "/" + getCode().substring(4,6) + "/" + getCode().substring(6,10);
		}
		return date;
	}
	
	public String getPlant() {
		if(Character.isLetter(getCode().charAt(2))) {
			plant = getCode().substring(0,3);
		}
		else {
			plant = getCode().substring(0,2);
		}
		return plant;
	}
	
	public boolean isAfter2000() {
		String s = getDate().substring(6);
		int i = Integer.parseInt(s);
			if(i >= 2000){
				return true;
			}
			
			return false;
	}
	
	public boolean isMonthEqual(int month) {
		String s = getDate().substring(0,2);
		int i = Integer.parseInt(s);
			if(i == month) {
				return true;
			}
			else 
			{
				return false;
			}
	}
	
	public String toString() {
		String msg = String.format("code=%s , plant=%s, date=%s, batch=%d", getCode(), getPlant(), getDate(), getBatch());
		return msg;
	}
}