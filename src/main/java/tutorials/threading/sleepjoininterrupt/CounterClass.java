package tutorials.threading.sleepjoininterrupt;

import tutorials.threading.utils.CurrThreadName;

public class CounterClass implements Runnable {

	@Override
	public void run() {

		System.out.println(CurrThreadName.v() + " starting the count");
		for (int i = 0; i < 10; i++) {
			
			if(Thread.currentThread().isInterrupted()) {
				System.out.println(CurrThreadName.v() + " interrupted will stop counting");
				break;
			}
			
			System.out.println(String.format(CurrThreadName.v() + " counted to : %d", i));
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(CurrThreadName.v() + " interrupted in sleep ");
				Thread.currentThread().interrupt();
			}
			
		}

	}

}
