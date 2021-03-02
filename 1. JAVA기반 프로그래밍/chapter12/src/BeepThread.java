import java.awt.Toolkit;
//쓰레드는 단일상속밖에 안되서, task처럼 인터페이스화 하는 것이 더 좋다.
		//쓰레드는 다른 클래스의 기능을 상속받을 수 없다.
public class BeepThread extends Thread{

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5;i++) {
			toolkit.beep();
			try {Thread.sleep(500);} catch (Exception e) {} 
		}
	}
}
