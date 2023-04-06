package prob1;

public abstract class Martian extends Object implements Comparable<Martian> {

	protected int id;
	protected int volume;
	
	public Martian(int id, int volume) {
		this.id=id;
		this.volume=volume;
	}
	
	public int getId() {
		return id;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		this.volume=volume;
	}
	
	public int compareTo(Martian m) {
		int identity = this.id - m.id;
		if(identity>0) 
			return 1;
		else if(identity<0) 
			return -1;
		else
			return 0;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Martian) {
			Martian a = (Martian)o;
			if(this.id == a.id);
			return true;
		}
		return false;
	}

	abstract String speak();

}
