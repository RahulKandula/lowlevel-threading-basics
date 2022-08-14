package tutorials.threading.threads;

public class BasicsOfThreads {

	
	public static void main(String[] args) {
		// Create thread with a task in constructor
		Thread t = new Thread(() -> {System.out.println("Runnable : " + Thread.currentThread().getId());});
		t.start();
		System.out.println("Main : " + Thread.currentThread().getId());
		
		// Bad way to setup a thread
		new ThreadInAClass().start();
		
		new Thread(new RunThread()).start();
		
	}
	
	
}
