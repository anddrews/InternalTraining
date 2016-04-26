package model;

import java.util.Random;

public class Eraser implements Runnable {
	
	private Object syncroObject;
	
	
	public Eraser(Object syncroObject) {
		this.syncroObject = syncroObject;
	}


	@Override
	public void run() {
		
		while (true) {
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
