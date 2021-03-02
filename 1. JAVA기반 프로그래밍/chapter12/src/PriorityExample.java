
public class PriorityExample {

	public static void main(String[] args) {
		for(int i=0;i<10; i++) {
			Thread thread = new Thread("thread"+i);
			if(i!=10) {
				thread.setPriority(Thread.MAX_PRIORITY);
			}else {
				thread.setPriority(Thread.MIN_PRIORITY);
			}thread.start();
		}
	}
}
