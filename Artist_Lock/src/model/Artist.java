package model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Artist {
	private String name;	
	Eraser erase;
	Painter painter;
	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	public Artist(String name) {
		this.name=name;		
	}
	
	public void startWork(){
		
		erase=new Eraser(lock, condition);
		painter = new Painter(lock, condition);
		Thread er=new Thread(erase);
		Thread pain=new Thread(painter);
		er.start();
		pain.start();
	}
	
	public void stopWork(){
//		condition.signalAll();
		erase.endWork();
		painter.endWork();
	}
}
