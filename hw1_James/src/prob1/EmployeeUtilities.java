package prob1;

public class EmployeeUtilities {

	public EmployeeUtilities() {
	}
	
	public Employee getEmployeeWithMostHours(Employee[] emps) {
		Employee max = emps[0];
		for(int i = 0; i < emps.length; i++) {
			if(emps[i].getTotalHours() > max.getTotalHours()) {
				max =  emps[i];
			}
	
		}
		return max;
	}
	
	public double[] getHoursArray(Employee[] emps) {
		double[] hours = new double[emps.length];
		for(int i = 0; i < emps.length; i++) {
			hours[i] = emps[i].getTotalHours();
		}
		return hours;
	}
	
	public double getTotalPay(Employee[] emps) {
		double totalPay = 0.0;
		for(int i = 0; i<emps.length; i++) {
			totalPay += emps[i].getPay();
		}
		return totalPay;
	}

}