package prob1;

public class Car {
	private double	fuelCapacity;
	private double	fuelEfficiency;
	private double	fuelLevel;
	private double	totalDistance;
	
	Car(double fuelCapacity, double fuelEfficiency){
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
		fuelLevel = 0;
		totalDistance = 0;
	}
	
	Car(double fuelCapacity, double fuelEfficiency, double fuelLevel){
		this.fuelCapacity = fuelCapacity;
		this.fuelEfficiency = fuelEfficiency;
		this.fuelLevel = fuelLevel;
		totalDistance = 0;
	}
	
	public void drive(double time, double rate) {
		double totalD = rate * time;
		double fuelReq = totalD / fuelEfficiency;
		if(fuelReq <= fuelLevel) {
			totalDistance += totalD;
			fuelLevel -= fuelReq;
		}
		else if(fuelReq > fuelLevel){
			totalDistance += fuelLevel * fuelEfficiency;
			fuelLevel = 0;
		}
	}

	public void fillUp(double amount) {
		if((amount+fuelLevel) > fuelCapacity) {
			fuelLevel = fuelCapacity;
		}
		else {
			fuelLevel += amount;	
			}
		
	}
	
	public double getFuelCapacity() {
		return fuelCapacity;
	}
	
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	
	public double getFuelLevel() {
		return fuelLevel;
	}
	
	public double getTotalDistance() {
		return totalDistance;
		
	}
	
	public String toString() {
		String msg = "";
		msg = String.format("fuellevel=%.0f, totalDistance=%.1f, fuelCapacity=%.1f, fuelEffiency=%.1f", getFuelLevel(), getTotalDistance(), getFuelCapacity(), getFuelEfficiency());
		return msg;
	}
	
}
