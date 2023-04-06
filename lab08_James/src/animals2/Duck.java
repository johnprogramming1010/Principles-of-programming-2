package animals2;

public class Duck implements Swimmer, Flyer {

	@Override
	public String fly() {
		return "duck flying";
	}

	@Override
	public String swim() {
		return "duck swimming";
	}

	@Override
	public String dive() {
		return "duck diving";
	}
	
	public static void main(String[] args) {
	Duck duck = new Duck();
	System.out.println(duck.fly() + ", " + duck.swim() + ", " + duck.dive());
	}
}

