package prob2;
import java.util.ArrayList;
import java.util.Collections;

public class MartianManager {
	protected ArrayList<Martian> martians = new ArrayList<>();
	protected ArrayList<Teleporter> teleporters = new ArrayList<>();

	public MartianManager() {	
	}
	
	public boolean addMartian(Martian m) {
		if(!martians.contains(m)) {
			martians.add(m);
				if(m instanceof Teleporter) {
				teleporters.add((Teleporter) m);
				}
			return true;
		}
			return false;
		}
	
	public ArrayList<Martian> battle(ArrayList<Martian> invaders){
		ArrayList<Martian> fallen = new ArrayList<>();
		for(Martian i : invaders) {
			int invader = getPower(i);
			for(Martian m : martians) {
				int martians = getPower(m);
				if(invader > martians) {
					fallen.add(m);
				}
			}
		}
			for(Martian x : fallen) {
				removeMartian(x.getId());
		}
		return fallen;
	}
	
// helper method	
	private int getPower(Martian M) {
		int power = 0;
		Martian m = new GreenMartian(10,10);
		if(m instanceof GreenMartian) {
			power += m.getVolume();
		}
			else if(m instanceof RedMartian) {
				power += ((RedMartian) m).getTenacity() + m.getVolume();
			}
		return power;
		}
	
	public boolean contains(int id) {
		Martian M = new GreenMartian(id, 8);
		int pos = martians.indexOf(M);
		if(pos>=0 && pos < martians.size()) {
			return true;
		}
		return false;
	}
	
	public Martian getMartianAt(int i) {
		if (i >= 0 && i < martians.size()) {
			return martians.get(i);
		}
		return null;
	}
	
	public Martian getMartianClosestTo(int id) {
		Martian m = new GreenMartian(id,10);
		for(Martian m1 : martians) {
			if(m.getId() == m1.getId()) {
				m = m1;
			}
			if(m.getId() < m1.getId()) {
				
			}
			if(m.getId() > m1.getId()) {
				
			}
			return m;
		}
		return null;
	}
	
//	public Martian getMartianClosestTo(Martian martian) {
//		Martian m = new GreenMartian(10,10);
//		
//		
//	}
	
	public Martian getMartianWithId(int id) {
		Martian M = new GreenMartian(id, 8);
		int pos = martians.indexOf(M);
		if(pos >= 0 && pos < martians.size()) {
			return M;
		}
	return null;
	}
	
	public int	getNumMartians() {
		return martians.size();
	}
	
	public int getNumTeleporters() {
		return teleporters.size();
	}
	
	public ArrayList<Martian> getSortedMartians(){
		ArrayList<Martian> M = new ArrayList<>(martians);
		Collections.sort(M);
		return M;
	}
	
	public Teleporter getTeleporterAt(int i) {
		if( i>=0 && i<teleporters.size()) {
				return teleporters.get(i);
		}
		return null;		
	}
	
	public String groupSpeak() {
	String msg = "";
	for(Martian m : martians) {
		msg += m.speak() + "\n";
	}
	return msg;
	}
	
	public String groupTeleport(String dest) {
	String msg = "";
	for(Teleporter T : teleporters) {
		msg += T.teleport(dest) + "\n";
	}
	return msg;
	}
	
	public void obliterateTeleporters() {
		teleporters.removeAll(martians);
		teleporters.removeAll(teleporters);
	}
	
	public Martian removeMartian(int id) {
			Martian M = new GreenMartian(id,10);
			int loc = martians.indexOf(M);
			return martians.remove(loc);
	}

	@Override
	public String toString() {
		String msg = "martians:\n";
		for(Martian M : martians) {
			msg += M.toString() + "\n";
		}
		msg += "\nTeleporters\n";
		for(Teleporter t : teleporters) {
			msg += t.toString() + "\n";
		}
		return msg;
	}
}
