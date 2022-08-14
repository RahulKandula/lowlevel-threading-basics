package tutorials.threading.sleepjoininterrupt;

public class PlainInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			int i = 0;
			while(true) {
				if(Thread.currentThread().isInterrupted()) {
					break;
				}
				System.out.println(i++);
			}
		});
		
		t.start();
		
		Thread.sleep(1000);
		
		t.interrupt();
	}
	
}
