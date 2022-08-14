package tutorials.threading.sleepjoininterrupt;

import tutorials.threading.utils.CurrThreadName;

public class SleepAndInterrupt {
	
	public static void main(String[] args)  {
		
		Thread t = new Thread(new CounterClass());
		Thread t2 = new Thread(new CounterClass());
		
		t.start();
		
		t2.start();
		
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				System.out.println(CurrThreadName.v() + " interrupting t");
				t.interrupt();
			} catch (InterruptedException e) {
				// ignoring this interrupt
			}
		}).start();
		
		try {
			t.join();
		} catch (InterruptedException e1) {
			System.out.println("t interrupted?");
		}
	


	}
	
}
