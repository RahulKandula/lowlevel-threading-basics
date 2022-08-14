package tutorials.threading.threads;

public class ThreadInAClass extends Thread {

	@Override
	public void run() {
		System.out.println("You can move an entire house in a spearate thread as a task.");
	}
	
}
