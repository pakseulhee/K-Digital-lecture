package emp;

public class PartTime extends Employee implements IBusinessTrip{
	int time;
	int payPerTime;
	
	public PartTime(String id, String name, int time, int payPerTime) {
		super(id, name);
		this.time = time;
		this.payPerTime = payPerTime;
	}
	@Override
	public String info() {
		return super.info()+ ", 급여:"+getPay();
	}

	public int getPay() {
		return time*payPerTime;
	}
	@Override
	public void goBusinessTrip(int day) {
		time += day*24;
	}
	
}
