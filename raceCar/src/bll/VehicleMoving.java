package bll;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Logger;

import Interface.Vehicle;
import model.FinishList;

public class VehicleMoving implements Runnable {
        Logger log = Logger.getLogger(getClass().toString());
        private long distanceLength; 
        private FinishList finishList;        
        private Vehicle vehicle;
        private CyclicBarrier start;
        private boolean isDiscv;
        
        public VehicleMoving(Vehicle car, long distanceLength, FinishList finishList, CyclicBarrier start) {
            this.vehicle=car;
            this.finishList=finishList;
            this.distanceLength=distanceLength;
            this.start=start;
        }
        
        public void discvalify(){
        	this.isDiscv=true;       	
        }
                
		@Override
        public void run() {
            try {
            	long currentPosition=0;
               	this.start.await();
                while (!Thread.currentThread().isInterrupted() && currentPosition < this.distanceLength) {
                    Thread.sleep(this.vehicle.getFriction());
                    currentPosition += 100;
                    if(this.isDiscv){
                    	Thread.currentThread().interrupt();
                    }
//                    log.info(name + " " + distance);
                }
                if(!Thread.currentThread().isInterrupted() && currentPosition>=this.distanceLength){
                	this.finishList.setFinisher(vehicle);
                }
                else{
                	this.finishList.setDiscvalification(vehicle);
                }
            } catch (InterruptedException | BrokenBarrierException e) {
//                log.info(e.getMessage());
            }
        }		      
    }

