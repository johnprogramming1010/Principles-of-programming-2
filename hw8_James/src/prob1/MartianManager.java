package prob1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MartianManager {
	protected Map<Integer, Martian> martians = new HashMap<>();
	protected Map<Integer, Martian> teleporters = new HashMap<>();
	
	public MartianManager() {	
	}
	
	public boolean addMartian(Martian m) {
		int Id = m.getId();
		if(!martians.containsKey(Id)) {
			martians.put(Id,m);
				if(m instanceof Teleporter) {
				teleporters.put(Id,m);
				}
			return true;
		}
			return false;
		}
	
	public ArrayList<Martian> battle(ArrayList<Martian> invaders){
		ArrayList<Martian> fallen = new ArrayList<>();
		for(Martian i : invaders) {
			int invader = getPower(i);
			for(Martian m : martians.values()) {
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
		int pos = martians.containsValue(id));
		if(pos>=0 && pos < martians.size()) {
			return true;
		}
		return false;
	}
	
	
	public Martian getMartianClosestTo(int id) {
		Martian m = new GreenMartian(id,10);
		for(Martian m1 : martians.values()) {
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
	
	public Martian getMartian(int id) {
		if(martians.containsKey(id)) {
		return martians.get(id);
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
		ArrayList<Martian> M = new ArrayList<>(martians.values());
		Collections.sort(M);
		return M;
	}
	
	public Teleporter getTeleporter(int id) {
		if(teleporters.containsKey(id)) {
		return (Teleporter) teleporters.get(id);
	}
	return null;
}
	
	public String groupSpeak() {
	String msg = "";
	for(Martian m : martians.values()) {
		msg += m.speak() + "\n";
		}
		return msg;
	}
	
	public String groupTeleport(String dest) {
	String msg = "";
	for(Teleporter T : teleporters.values()) {
		msg += T.teleport(dest) + "\n";
		}
		return msg;
	}
	
	public void obliterateTeleporters() {
		teleporters.remove(martians);
		teleporters.remove(teleporters);
	}
	
	public Martian removeMartian(int id) {
		if(martians.containsKey(id)) {
			Martian m = martians.get(id);
			martians.remove(id);
			if(m instanceof Teleporter) {
				teleporters.remove(id);
			}
			return m;
		}
		return null;
	}

	@Override
	public String toString() {
		String msg = "martians:\n";
		msg += "\nTeleporters\n";
		for(Integer t : teleporters.keySet()) {
			msg += t.toString() + "\n";
		}
		return msg;
	}
}