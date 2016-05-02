package model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Elevator implements Runnable {

	private volatile List<Passenger> passendgers;
	private int maxFloor;
	private Lock elevatorLock;
	private Lock personLock;
	private Condition elevatorCondition;
	private Condition personCondition;
	private int currentFloor;
	private volatile int[] waitingExit;

	public Elevator(int capacity, int maxFloor) {
		this.passendgers=new LinkedList<>();
		this.maxFloor=maxFloor;
		this.elevatorLock=new ReentrantLock();
		this.personLock=new ReentrantLock();
		this.elevatorCondition=elevatorLock.newCondition();
		this.personCondition=personLock.newCondition();		
		this.waitingExit=new int[maxFloor];
	}
		

	public Condition getPersonCondition() {
		return personCondition;
	}

	public Condition getCondition() {
		return elevatorCondition;
	}
	
	public Lock getLock() {
		return elevatorLock;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public Lock getPersonLock() {
		return this.personLock;
	}
	
		
	public int[] getWaitingExit() {
		return waitingExit;
	}

	public void loadPerson(Passenger passendger) {
		this.passendgers.add(passendger);
		this.waitingExit[passendger.getStopFloor()]++;
		System.out.println("   elevator load person "+passendger.getName()+" on the floor " + (this.currentFloor+1));
	}

	public int getCurrentAmount() {		
		return this.passendgers.size();
	}


	public void removePassengers(Passenger passengers) {
		this.passendgers.remove(passengers);
	}


	@Override
	public void run() {		
		int index=1;
		int start=0;
		for(int i=start; index*i<this.maxFloor-start; i=i+1*index){
			this.elevatorLock.lock();
			try {
				this.currentFloor=i;
				System.out.println("elevator on the "+ (this.currentFloor+1));
				this.elevatorCondition.signalAll();
				this.elevatorCondition.await();	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				this.elevatorLock.unlock();
			}
			if (i==this.maxFloor-1||(i==0 && index==-1)){
				index*=-1;
				start=i;
			}
		}
	}	
	
}
