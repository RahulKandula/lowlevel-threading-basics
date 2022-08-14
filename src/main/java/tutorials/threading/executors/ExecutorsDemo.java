package tutorials.threading.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tutorials.threading.utils.CurrThreadName;

public class ExecutorsDemo {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		executorService.execute(() -> System.out.println(CurrThreadName.v() + " taking random " + Math.random()));
		executorService.execute(() -> System.out.println(CurrThreadName.v() + " taking random " + Math.random()));
		executorService.execute(() -> System.out.println(CurrThreadName.v() + " taking random " + Math.random()));
		executorService.execute(() -> System.out.println(CurrThreadName.v() + " taking random " + Math.random()));
		executorService.execute(() -> System.out.println(CurrThreadName.v() + " taking random " + Math.random()));
		
		executorService.shutdown();
		
		List<Callable<Integer>> callables = Arrays.asList(() -> 1, () -> 2, () -> 3);
		
		executorService = Executors.newSingleThreadExecutor();
		try {
			Integer i = executorService.invokeAny(callables);
			System.out.println(CurrThreadName.v() + " got " + i);
		} catch (InterruptedException | ExecutionException e) {
			// doing nothing and ignoring
		}
		executorService.shutdown();

		executorService = Executors.newSingleThreadExecutor();
		try {
			System.out.println(executorService.invokeAll(callables));
		} catch (InterruptedException e) {
			// doing nothing and ignoring
		}
		executorService.shutdown();
		
	}

}
