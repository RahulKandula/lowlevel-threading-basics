package tutorials.threading.utils;

public class CurrThreadName {

	public static String v() {
		return String.format("Thread id %d", Thread.currentThread().getId());
	}
	
}
