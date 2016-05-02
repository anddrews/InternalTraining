package model;

public class Passenger implements Runnable{
	private String name;
	private int startFloor;
	private int stopFloor;
	private Building building;
	
	public Passenger(String name, int startFloor, int finishFloor,Building building) {
		this.name = name;
		this.startFloor = startFloor-1;
		this.stopFloor = finishFloor-1;	
		this.building=building;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public int getStartFloor() 
	{
		return startFloor;
	}
	
	public int getStopFloor()
	{
		return stopFloor;
	}

	@Override
	public void run() 
	{		
		this.building.callElevator(this);
		this.building.loadInElevator(this);
		this.building.exitFromElevator(this);		
		System.out.println("       "+name +" is stop"+ " on the floor " +
					(this.building.getElevator().getCurrentFloor()+1));
	}
	
	
	

}
