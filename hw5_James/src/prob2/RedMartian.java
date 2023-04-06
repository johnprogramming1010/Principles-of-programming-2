package prob2;

public class RedMartian extends Martian {
	private int tenacity;
	
	public RedMartian(int id, int tenacity) {
		this(id, 1, tenacity);
	}
	
	public RedMartian(int id, int volume, int tenacity) {
		super(id, volume);
		this.tenacity = tenacity;
	}
	
	public int getTenacity() {
		return tenacity;
	}
	
	public String speak() {
		return "id=xxx, Rubldy Rock";
	}
	
	public String toString() {
		String msg = "Red Martian - ";
		msg += String.format("id=%d, vol=%d, ten=%d", getId(), getVolume(), getTenacity());
		return msg;
	}
}
