package model;

public class Building implements Runnable{
	volatile private Floor[] floors;
	private volatile int[] waitingEnter;
	private int floorAmount;
	private Elevator elevator;
	private int elevatorCapacity;
	private volatile int amountAllperson;

	public Building(int floorAmount, int elevatorCapacity) {
		this.floors = new Floor[floorAmount];		
		for (int i=0;i<floorAmount;i++){
			this.floors[i]=new Floor();
		}		
		this.waitingEnter=new int[floorAmount];
		this.floorAmount=floorAmount;
		this.elevator=new Elevator(elevatorCapacity, floorAmount);
		this.elevatorCapacity=elevatorCapacity;						
	}
	
	public int getFloorAmount() {
		return floorAmount;
	}
		

	public Elevator getElevator() {
		return elevator;
	}

	public void callElevator(Passenger passenger) {
		this.waitingEnter[passenger.getStartFloor()]++;
		this.amountAllperson++;
	}	
		
	public void loadInElevator(Passenger passenger){
		this.floors[passenger.getStartFloor()].getLock().lock();
		try {			
			this.floors[passenger.getStartFloor()].getCondition().await();
			this.elevator.loadPerson(passenger);
			this.waitingEnter[this.elevator.getCurrentFloor()]--;
			this.amountAllperson--;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			this.floors[passenger.getStartFloor()].getLock().unlock();
		}			
		
	}
	
	public void exitFromElevator(Passenger passenger){
		while(this.elevator.getCurrentFloor()!=passenger.getStopFloor()){
			this.elevator.getPersonLock().lock();
			try
			{
				this.elevator.getPersonCondition().await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally
			{
				this.elevator.getPersonLock().unlock();
			}
		}
		this.elevator.removePassengers(passenger);
		this.elevator.getWaitingExit()[this.elevator.getCurrentFloor()]--;		
	}
	
	@Override
	public void run()
	{
		Thread elev=new Thread(this.elevator);// start elevator
		elev.setDaemon(true);
		elev.start();
		while( this.amountAllperson>0 || this.elevator.getCurrentAmount()>0)
		{
			try {
				this.elevator.getLock().lock();
				removePersonFromElevator();
				movePersonInElevator();
				this.elevator.getCondition().signalAll();
				this.elevator.getCondition().await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.elevator.getLock().unlock();
		}		
	}

	

	private void movePersonInElevator() {
		int i=this.elevator.getCurrentAmount();
		while(i<this.elevatorCapacity &&
				this.waitingEnter[this.elevator.getCurrentFloor()]>0){
			this.floors[elevator.getCurrentFloor()].getLock().lock();
			int countWaitingPassenger=this.waitingEnter[this.elevator.getCurrentFloor()];			
			this.floors[this.elevator.getCurrentFloor()].getCondition().signal();			
			i++;
			this.floors[elevator.getCurrentFloor()].getLock().unlock();
			//wait while passenger enter in elevator
			while(this.waitingEnter[this.elevator.getCurrentFloor()]!=countWaitingPassenger-1) 
			{				
			}			
		}
	}
	
	private void removePersonFromElevator() {
		// count passenger in elevator to exit on this floor
		int countPassengerToExit=this.elevator.getWaitingExit()[this.elevator.getCurrentFloor()]; 
		while(countPassengerToExit>0){	
			this.elevator.getPersonLock().lock();
			// wake up all passenger in elevator countPassengerToExit time 	
			this.elevator.getPersonCondition().signalAll();		
			this.elevator.getPersonLock().unlock();
			countPassengerToExit--;			
		}
		while(this.elevator.getWaitingExit()[this.elevator.getCurrentFloor()]!=0){
			//wait while all passenger are exiting from elevator	
		}

	}

	
	
}
