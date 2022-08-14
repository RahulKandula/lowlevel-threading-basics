package tutorials.threading.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import tutorials.threading.utils.CurrThreadName;

public class SingleExecutor {
	
	private static ExecutorService executor = Executors.newSingleThreadExecutor();

	private static Future<Double> getRandom(int i) {
		return executor.submit(() -> {
			System.out.println(CurrThreadName.v()+ " with i " + i);
			Thread.sleep(1000);
			return Math.random();
		});
	}
	
	
	public static void main(String[] args) {
		Future<Double> d = getRandom(3);
		Double d1 = null;
		try {
			d1 = d.get(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException |  TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(d1);
		executor.shutdown();
	}
	
}
