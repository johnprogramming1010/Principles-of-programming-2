package prob1;

public class Item {
	protected String name;
	protected double weight;

	public Item(String name, double weight) {
		this.name=name;
		this.weight=weight;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}
	
	public double cost() {
		double cost = weight * 2;
		return cost;
	}

	@Override
	public String toString() {
		String msg = String.format("name=%s, cost=$%.2f, weight=%.2f", getName(), cost(), getWeight());
		return msg;
	}

}
