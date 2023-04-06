package prob1;

public class RefrigeratedItem extends Item {
	private double temperature;
	
	public RefrigeratedItem(String name, Double weight, double temperature) {
		super(name, weight);
		this.temperature=temperature;
	}
	
	public RefrigeratedItem(Item item, double temperature) {
		this(item.getName(), item.getWeight(), temperature);
	}

	public double getTemperature() {
		return temperature;
	}
	
	@Override
	public double cost() {
		double cost = (2*getWeight()) + ((100 - temperature)*(0.1));
		return cost;
	}
	
	@Override
	public String toString() {
		String msg = String.format("name=%s, cost=$%.2f, weight=%.2f, temp=%.2f degrees", getName(), cost(), getWeight(), getTemperature());
		return msg;
	}
}