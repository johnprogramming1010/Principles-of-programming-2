package prob1;

public class BasketballPlayer {

	private int freeThrowsAttempted;
	private int freeThrowsMade;
	private String name;
	private int threePointersAttempted;
	private int threePointersMade;
	private int	twoPointersAttempted;
	private int	twoPointersMade;
	
	public BasketballPlayer(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void shootFreeThrow(boolean isMade) {
		freeThrowsAttempted++;
		if(isMade) {
			freeThrowsMade++;
		}
	}
	
	public int getFreeThrowsMade() {
		return freeThrowsMade;
	}
	
	public int getFreeThrowsAttempted() {
		return freeThrowsAttempted;
	}
	
	public double getFreeThrowPercent() {

		double freeThrowPercent = (double)freeThrowsMade / freeThrowsAttempted * 100.0;
		return freeThrowPercent;
	}

	public void shootTwoPointer(boolean isMade) {
		twoPointersAttempted++;
		if(isMade) {
			twoPointersMade++;
		}
	}
	public int getTwoPointersAttempted() {
		return twoPointersAttempted;
	}
	
	public int getTwoPointersMade() {
		return twoPointersMade;
	}
	
	public double getTwoPointerPercent() {

		double twoPointersPercent = (double)twoPointersMade / twoPointersAttempted * 100.0;
		return twoPointersPercent;
	}

	public void shootThreePointer(boolean isMade) {
		threePointersAttempted++;
		if(isMade) {
			threePointersMade++;
		}
	}
	
	public int getThreePointersAttempted() {
		return threePointersAttempted;
	}
	
	public int getThreePointersMade() {
		return threePointersMade;
	}
	
	public double getThreePointerPercent() {

		double threePointersPercent = (double)threePointersMade / threePointersAttempted * 100.0;
		return threePointersPercent;
	}
	
	public int getTotalPoints() {
		int totalPoints = ((freeThrowsMade*1) + (twoPointersMade*2)+(threePointersMade*3));
		return totalPoints;
	}
	
	public String toString() {
		String msg = "Player:" + getName() + ", points:" + getTotalPoints() + "\n";
		msg += String.format("   Free Throws: made:%d, attempted:%d, percent:%.1f\n", getFreeThrowsMade(), getFreeThrowsAttempted(), getFreeThrowPercent());
		msg += String.format("    2 Pointers: made:%d, attempted:%d, percent:%.1f\n", getTwoPointersMade(), getTwoPointersAttempted(), getTwoPointerPercent());
		msg += String.format("Three Pointers: made:%d, attempted:%d, percent:%.1f\n", getThreePointersMade(), getThreePointersAttempted(), getThreePointerPercent());
		return msg;
	}
		
	}
