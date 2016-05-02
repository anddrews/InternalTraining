package model;

import java.util.Random;

public class Painter implements Runnable {
	
	private Object syncroObject;
	private boolean isEnd;
	
	public Painter(Object syncroObject) {
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
					System.out.println(this.syncroObject.getClass().getSimpleName()+" start painting");
					Thread.sleep(new Random().nextInt(1500));
					System.out.println(this.syncroObject.getClass().getSimpleName()+" stop painting");					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
