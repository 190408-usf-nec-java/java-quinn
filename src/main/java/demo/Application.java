package demo;

import models.Todo;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new MyThread();
		
		// This is a thread using runnable the run method of 
		// the runnable will execute in another thread that will be created
		Thread t2 = new Thread(new MyRunnable());
		
		
		Runnable runable = () -> {
			System.out.println("C++");
		};
		Thread t3 = new Thread(runable);
		
		t1.start();
		t2.start();
		t3.start();
		
		
		String title = "things";
		Integer prio = 5;
		Todo t = new Todo(title, prio);
		
		Todo x = new Todo();
		x.setPriority(prio);
		x.setTitle(title);
		
		t1.join();
		t2.join();
		t3.join();
		
		new Todo();
		System.out.println(x);
		
		
	}
}
