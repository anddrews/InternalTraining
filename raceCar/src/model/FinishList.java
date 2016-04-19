package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import Interface.Vehicle;

public class FinishList {
	private volatile List<Vehicle> cars;
	private volatile Set<Vehicle> discv;
	private volatile boolean isWinner;
	
	public FinishList() {
		cars=new LinkedList<>();
		discv=new HashSet();
	}

	public List<Vehicle> getCar() {
		return cars;
	}
	

	public Set<Vehicle> getDiscv() {
		return discv;
	}
	
	public boolean isWinner() {
		return isWinner;
	}

	public synchronized void setFinisher(Vehicle car) {
		if(!this.isWinner){
			this.isWinner=true;
		}
		this.cars.add(car);
		
	}
	
	public synchronized void setDiscvalification(Vehicle car) {		
		this.discv.add(car);
	}

	@Override
	public String toString() {
		Iterator<Vehicle> iterator=discv.iterator();
		String result="Finish list:\n";
		for(int i=0;i<cars.size();i++){
			result+="place number:"+ (i+1) + " got car "+ cars.get(i).getName()+"\n";
		}
		result+="Discvalification car:\n";		
		while(iterator.hasNext()){
			result+=iterator.next().getName()+"\n";
		}
		return result ;
	}
	
	
	
}
