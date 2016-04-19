package model;



import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import bll.VehicleMoving;

public class Refery implements Runnable{
	
	List<VehicleMoving> vehicleList;
	CyclicBarrier start;
	
	public Refery(List<VehicleMoving> vehicleList, CyclicBarrier start) {
		this.vehicleList = vehicleList;
		this.start=start;
	}
	
	@Override
	public void run() {
		try {
			this.start.await();
			Random rnd=new Random();
			int listSize=vehicleList.size();		
			Thread.sleep(5000);
			for(int i=0;i<rnd.nextInt(listSize);i++){
				this.vehicleList.get(rnd.nextInt(listSize)).discvalify();			
			}
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

}