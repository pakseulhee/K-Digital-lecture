package sec07.exam01_deamon;

public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용을 저장함");
	}

	@Override
	public void run() {
		while(true) {	
			try {
				Thread.sleep(3000);
			}catch (InterruptedException e) {
				break;
			}
		}
	}
}
