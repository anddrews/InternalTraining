package model;

import Interface.Vehicle;

public class Car implements Vehicle{
	
	private String name;
	private long friction;

	public Car(String name, long friction) {
		this.name = name;
		this.friction = friction;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFriction() {
		return friction;
	}

	public void setFriction(long friction) {
		this.friction = friction;
	}
	
	
	
	

}
