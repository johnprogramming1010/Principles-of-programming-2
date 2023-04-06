package prob2;

public class GreenMartian extends Martian implements Teleporter{

	GreenMartian(int id){
		this(id, 1);
	}
	
	GreenMartian(int id, int volume){
		super(id, volume);
	}
	
	@Override
	public String speak() {
		return "id=xxx, Grobldy Grock";
	}
	
	@Override
	public String teleport(String dest) {
		return "id=xxx teleporting to dest";
	}
	
	public String toString() {
		String msg = "Green Martian - ";
		msg += String.format("id=%d, vol=%d", getId(), getVolume());
		return msg;
	}
}
