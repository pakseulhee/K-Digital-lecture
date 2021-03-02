package sec06.exam02_yield;

public class ThreadA extends Thread {
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("스레드A의 작업내용");
			}else{
				Thread.yield();
			}
		}
		System.out.println("스레드A의 작업내용");
	}
}
