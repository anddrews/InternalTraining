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
					System.out.println(this.syncroObject.getClass().getSimpleName()+" start erasing");	
					Thread.sleep(new Random().nextInt(1500));				
					System.out.println(this.syncroObject.getClass().getSimpleName()+" stop erasing");					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
