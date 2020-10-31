package quera.javacup_practice.threads.ir.javacup.thread;

public class Resource {

	private int content;
	
	public synchronized int get() {
		if(content==-1){
			try {
				wait();
			} catch (InterruptedException ignored) { }
		}
		int cache = content;
		content = -1;
		notify();
		return cache;
	}
	
	public synchronized void set(int value) {
			if(value==0) return;
			if(content!=-1){
				try {
					wait();
				} catch (InterruptedException ignored) { }
			}
			content = value;
			notify();
	}
	
}
