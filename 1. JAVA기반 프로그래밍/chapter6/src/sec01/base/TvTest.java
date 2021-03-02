package sec01.base;
class TV{
	String color;
	boolean power;
	int channel;
	
	void power() { //on되어있으면 off, off되어있으면 on 시키는 것
		power = !power;
	}
	void channelUp() {
		channel ++;
	}
	void channelDown() {
		channel --;
	}
}
public class TvTest {

	public static void main(String[] args) {
		TV t = new TV();
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채널은: "+t.channel);
		

	}

}
