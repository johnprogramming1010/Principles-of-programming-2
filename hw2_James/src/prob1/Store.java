package prob1;

import emps.Employee;

public class Store {
	private Employee[] emps = new Employee[100];
	private int numEmps = 0;

	public Store() {
	}

	public void addEmployee(Employee e) {
		if (numEmps <= emps.length) {
			emps[numEmps++] = e;
		}
	}

	public Employee getEmployee(int i) {
		if (i >= 0 && i < numEmps)
			return emps[i];
		return null;
	}
	
	public Employee getEmployeeWithName(String findName) {
		Employee returnEmp = new Employee(findName, 10);
		for (int i = 0; i < numEmps; i++) {
			if (returnEmp.getName().equals(emps[i].getName())) {
				returnEmp = emps[i];
				return returnEmp;
			}
		}
		return null;

	}
	
	public int getNumEmployees() {
		return numEmps;
	}

	public double getTotalHours() {
		double total = 0.0;
		for(int i = 0; i< numEmps; i++) {
			total += emps[i].getTotalHours();
		}
		return total;
	}

	public double getTotalPay() {
		double total = 0.0;
		for( int i = 0; i< numEmps; i++) {
			total += emps[i].getPay();
		}
		return total;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Employee e = new Employee("Will", 22.33);

	}

	public Employee removeEmployee(int i) {
		if(i>=0 && i<numEmps) {
			Employee e = emps[i];
			for(int j=i+1; j<numEmps; j++) {
				emps[j-1] = emps[j];
			}
			numEmps--;
			return e;
		}
		return null;
	}
	
	@Override	
	public String toString() {
	String msg = "Payroll Report\n\n";
	msg += String.format("Num Employees:%d, total hrs:%.2f, total pay=$%.2f\n\n", getNumEmployees(), getTotalHours(), getTotalPay());
	for(int i = 0; i<numEmps; i++){
		msg += "Pay Stub\n--------";
		msg += String.format("Name:%s, Pay Rate $%.2f\n", emps[i].getName(), emps[i].getPayRate());
		msg += String.format("Hours:Mon:%.2f, Tue:%.2f, Wed:%.2f, Thu:%.2f, Fri:%.2f, Sat:%.2f, Sun:%.2f\n", emps[i].getHours(0), emps[i].getHours(1), emps[i].getHours(2), emps[i].getHours(3), emps[i].getHours(4), emps[i].getHours(5), emps[i].getHours(6));
		msg += String.format("Days worked:%d, Total Hours:%.2f\n", emps[i].getNumDaysWorked(), emps[i].getTotalHours());
		msg += String.format("Weekday hours:%.2f, Weekend hours:%.2f\n", emps[i].getWeekdayHours(), emps[i].getWeekendHours());
		msg += String.format("Total pay: $%.2f\n", emps[i].getPay());
	}
	return msg;
	}
}

