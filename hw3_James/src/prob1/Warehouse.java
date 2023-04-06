package prob1;

public class Warehouse {
	protected Item[] items = new Item[10];
	private int numItems = 0; 
	
	public Warehouse() {
	}
	
	public void addItem(Item item) {
		if(numItems<items.length) {
			items[numItems++] = item;
		}
	}
	
	public Item getItem(int i) {
		if(i>=0 && i<numItems) {
			return items[i];
		}
		return null;
	}
	
	public Item getItem(String name) {
		Item I = new Item(name, 10.0);
		for(int i = 0; i<numItems; i++) {
			if(I.getName().equals(items[i].getName())){
				return items[i];
			}
		}
		return null;
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public double getAverageTemp() {
		int count = 0;
		double average = 0.0;
		for(int i = 0; i<numItems; i++) {
			if(items[i] instanceof RefrigeratedItem) {
				average += ((RefrigeratedItem) items[i]).getTemperature();
				count++;
			}
		}
		average /= count;
		return average;
	}
	
	public RefrigeratedItem[] getRefrigeratedItems() {
		RefrigeratedItem[] r = new RefrigeratedItem[getNumRefrigeratedItems()];
		int j = 0;
		for(int i = 0; i<numItems; i++) {
			Item I = items[i];
			if(I instanceof RefrigeratedItem) {
				r[j] = (RefrigeratedItem)I;
				j++;
			}
		}
		return r;
	}
	
	public int getNumRefrigeratedItems() {
		int count = 0;
		for(int i = 0; i<numItems; i++) {
			if(items[i] instanceof RefrigeratedItem) {
				count++;
			}
		}
		return count;
	}
	
	public double getTotalCost() {
		double cost = 0.0;
		for(int i = 0; i<numItems; i++) {
			if(items[i] instanceof Item) {
				cost += items[i].cost();
			}
		}
			return cost;
	}
	
	public double getTotalCostRefrigerated() {
		double cost = 0.0;
		for(int i = 0; i<numItems; i++) {
			if(items[i] instanceof RefrigeratedItem) {
				cost += items[i].cost();
			}
		}
			return cost;
	}
	
	public Item removeItem(int i) {
		if(i>=0 && i<numItems) {
			Item r = items[i];
			for(int j = i+1; j<numItems; j++) {
				items[j-1] = items[j];
			}
			numItems--;
			return r;
		}
		return null;
	}
	
	public Item removeItem(String name) {
		Item I = new Item(name, 10.0);
		for(int i = 0; i<numItems; i++) {
			if(I.getName().equals(items[i].getName())) {
				for(int j = i+1; j<numItems; j++) {
				items[j-1] = items[j];
			}
			numItems--;
			return I;
		}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String msg = "";
		for(int i = 0; i < numItems; i++) {
				msg += "\n" + items[i].toString();
		}
		return msg;	
	}
}
