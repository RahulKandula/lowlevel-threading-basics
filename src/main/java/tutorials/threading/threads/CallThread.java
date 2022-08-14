package tutorials.threading.threads;

import java.util.concurrent.Callable;

public class CallThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("I have been CALLLLEEDD !!!");
		return 42;
	}
	
}
