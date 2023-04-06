package prob1;

public class Employee {
	private double[] hours = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	private String name;
	private double payRate;
	
	public Employee (String name, double payRate) {
		this.name = name;
		this.payRate = payRate;
	}

	public double getHours(int day) {
		return hours[day];
	}
	
	public String getName( ) {
		return name;
		}
	
	public int getNumDaysWorked() {
		int daysWorked = 0;
		for(int i = 0; i < 7; i++) {
			if(hours[i] >= 1) {
			daysWorked++;
			}
		}	
		return daysWorked;
	}
	
	public double getPay() {
		double pay = 0.0;
		if(getWeekdayHours()>40) {
			pay += 40*payRate + (getWeekdayHours()-40)*payRate*1.5;
		} else if(getWeekdayHours()<=40) {
			pay += getWeekdayHours()*payRate;
		}
		if(getWeekendHours()>0) {
			pay += getWeekendHours()*payRate*2;
		}
		if(getNumDaysWorked() == 7) {
			pay += 50;
		}
		return pay;
	}

	public double getPayRate() {
		return payRate;
	}
	
	public double getTotalHours() {
		double hoursWorked = 0.0;
		for(int i=0;i<7;i++) {
			hoursWorked += hours[i];
		}
		return hoursWorked;
	}
	
	public double getWeekdayHours() {
		double hoursWorked = 0.0;
		for(int i=0;i<5; i++) {
			hoursWorked += hours[i];
		}
		return hoursWorked;
	}
	
	public static void main(String[] args) {
	}
	
	public void mergeEmployee(Employee e) {
		for(int i=0;i<7;i++) {
		this.hours[i] += e.getHours(i);
		}
	}
	
	public void newWeek() {
		for(int i=0;i<7;i++) {
			hours[i] = 0.0;
		}
	}
	
	public void setHours(int day, double hoursWorked) {
		this.hours[day] = hoursWorked;
	}

	public double getWeekendHours() {
		double hoursWorked = 0.0;
		for(int i=5;i<7; i++) {
			hoursWorked += hours[i];
			}
			return hoursWorked;
		}
	
	public String toString() {
		String msg = "Pay Stub\n--------\n";
		msg += String.format("Name:%s, Pay Rate $%.2f\n", getName(), payRate);
		msg += String.format("Hours: Mon:%.2f, Tue:%.2f, Wed:%.2f, Thu:%.2f, Fri:%.2f, Sat:%.2f, Sun:%.2f\n", getHours(0), getHours(1), getHours(2), getHours(3), getHours(4), getHours(5), getHours(6));
		msg += String.format("Days worked: %d, Total Hours:%.2f\n", getNumDaysWorked(), getTotalHours());
		msg += String.format("Weekday hours: %.2f, Weekend hours:%.2f\n", getWeekdayHours(), getWeekendHours());
		msg += String.format("Total pay: $%.2f", getPay());
		return msg;
	}
}