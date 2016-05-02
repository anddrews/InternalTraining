package model;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Eraser implements Runnable {
	
	private Lock lock;
	private boolean isEnd;
	Condition condition;
	
	public Eraser(Lock lock,Condition condition) {
		this.lock = lock;
		this.condition=condition;
	}
	
	public void endWork(){
//		this.isEnd=true;
//		condition.signalAll();
	}

	@Override
	public void run() {
		
		while (!this.isEnd) {
					lock.lock();
				try {	
					System.out.println(this.getClass().getSimpleName()+" start erasing");
					condition.await();				
					Thread.sleep(new Random().nextInt(1500));				
					System.out.println(this.getClass().getSimpleName()+" stop erasing");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					lock.unlock();
				}
			
		}
	}
	
}
