

import java.util.ArrayList;
import java.util.List;

import Interface.Vehicle;
import bll.RaceControl;
import model.Car;

public class Runner {

	public static void main(String[] args) {
		List<Vehicle> cars=new ArrayList<>();
		RaceControl refery;
		cars.add(new Car("Ferrari",48));
		cars.add(new Car("Maserati", 70));
		cars.add(new Car("BMV", 60));
		cars.add(new Car("Mercedes", 50));
		cars.add(new Car("Lada", 90));
		
		refery=new RaceControl(cars, 10000);
		new Thread(refery).start();
	}

}
