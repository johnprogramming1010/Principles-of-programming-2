package prob1;

// makeCake and blend methods so that they can not be overridden.

public abstract class Cake {
	protected String cakeMix;

	public Cake(String cakeMix) {
		this.cakeMix = cakeMix;
	}

	public String makeCake() {
		String cake = blend() + pour() + bake();
		return cake;
	}

	public String bake() {
		return "Bake at 350 degrees F 30 minutes";
	}

	public String getCakeMix() {
		return cakeMix;
	}
	public String getLiquid() {
		return "1 cup of water";
	}
	
	public String getOil() {
		return "3/4 of vegetable oil";
	}
	
	public String getEggs() {
		return "2 eggs";
	}
	
	private String blend() {
		String cake = "Blend:(";
		cake += getCakeMix() + ", ";
		cake += getLiquid() + ", ";
		cake += getOil() + ", ";
		cake += getEggs() + ")\n";
		return cake;
	}

	public String pour() {
		return "Pour mix into pan\n";
	}
}

