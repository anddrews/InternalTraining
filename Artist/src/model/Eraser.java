package model;

import java.util.Random;

public class Eraser implements Runnable {
	
	private Object syncroObject;
	private boolean isEnd;
	
	public Eraser(Object syncroObject) {
		this.syncroObject = syncroObject;
	}
	
	public void endWork(){
		this.isEnd=true;
	}

	@Override
	public void run() {
		
		while (!this.isEnd) {
			synchronized (this.syncroObject){		
				try {					
					System.out.println(this.syncroObject.getClass().getSimpleName()+" erasing");					
					Thread.sleep(new Random().nextInt(1500));									
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
