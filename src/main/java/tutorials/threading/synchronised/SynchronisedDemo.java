package tutorials.threading.synchronised;

import java.util.ArrayList;
import java.util.List;

import tutorials.threading.utils.CurrThreadName;

public class SynchronisedDemo {

	private static int counter = 0;
	private static Object lock = new Object();

	private synchronized static void countup() {
		int temp = counter;
		System.out.println(CurrThreadName.v() + " before " + counter);
		temp = temp + 1;
		counter = temp;
		System.out.println(CurrThreadName.v() + " counted upto " + counter);
	}


	private static void countupsecure() {
		System.out.println(CurrThreadName.v() + " before " + counter);
		synchronized(lock) {
			int temp = counter;
			temp = temp + 1;
			counter = temp;
		}
		System.out.println(CurrThreadName.v() + " counted upto " + counter);
	}
	
	public static void main(String[] args) throws InterruptedException {
		List<Thread> ts = new ArrayList<>();
		for(int i =0; i<100; i++) {
			Thread t = new Thread(SynchronisedDemo::countupsecure);
			t.start();
			ts.add(t);
		}
		for(Thread t : ts) {
			t.join();
		}
		System.out.println("Final val " + counter );
	}
	
}
