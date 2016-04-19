

import java.util.ArrayList;
import java.util.List;

import Interface.Vehicle;
import bll.RaceControl;
import model.Car;

public class Runner {

	public static void main(String[] args) {
		List<Vehicle> cars=new ArrayList<>();
		RaceControl race;
		cars.add(new Car("Ferrari",48));
		cars.add(new Car("Maserati", 70));
		cars.add(new Car("BMV", 60));
		cars.add(new Car("Mercedes", 50));
		cars.add(new Car("ZAZ", 90));
		cars.add(new Car("Opel", 65));
		cars.add(new Car("Buggati", 34));
		cars.add(new Car("AZLK", 45));
		cars.add(new Car("Zil", 63));
		
		race=new RaceControl(cars, 10000);
		new Thread(race).start();
	}

}
