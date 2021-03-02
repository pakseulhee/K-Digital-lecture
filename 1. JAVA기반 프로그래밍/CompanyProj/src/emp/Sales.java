package emp;

public class Sales extends Permanent implements IBusinessTrip{
	int incentive;
	public Sales(String id, String name, int pay, int incentive) {
		super(id, name, pay);
		this.incentive = incentive;
	}
	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	
	public int getPay() { // 전체급여 올려줌
		return super.getPay()+getIncentive();
	}
	
	@Override
	public void goBusinessTrip(int day) {
		incentive += day*100000;
	}

}
