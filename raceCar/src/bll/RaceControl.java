package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Interface.Vehicle;
import model.FinishList;
import model.Refery;

public class RaceControl implements Runnable{
	
	private List<Vehicle> cars;
	private long distanceLength;
	private FinishList finishList;
	private volatile CyclicBarrier start;
	private ExecutorService carsPull;
	
	public RaceControl(List<Vehicle> cars, long distanceLength) {
		this.cars = cars;
		this.distanceLength = distanceLength;
		this.finishList=new FinishList();		
		carsPull = Executors.newCachedThreadPool();
	}
	
	
	@Override
	public void run() {
		List<Thread> race=new ArrayList<>();
		List<VehicleMoving> carRace=new ArrayList<>();
		this.start=new CyclicBarrier(cars.size(),new Refery(carRace));
		
		for (int i=0;i<cars.size();i++){
			carRace.add(i,new VehicleMoving(cars.get(i), distanceLength, finishList, start));		
			race.add(i,new Thread(carRace.get(i)));
			race.get(i).start();
		}		
	
		for (int i=0;i<cars.size();i++){			
			try {
				race.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
		System.out.println(finishList);	
		carsPull.shutdownNow();
		System.out.println("Race finished");

	}
	
	

}
