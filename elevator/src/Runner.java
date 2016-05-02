
import model.Building;
import model.Passenger;

public class Runner {

	public static void main(String[] args) {
		Building build=new Building(7,1);
			
		Passenger vasia1=new Passenger("vasia 1", 1, 7, build);
		Passenger vasia2=new Passenger("vasia 2", 2, 7, build);
		Passenger vasia3=new Passenger("vasia 3", 2, 7, build);
		Passenger vasia4=new Passenger("vasia 4", 2, 1, build);
		Passenger vasia5=new Passenger("vasia 5", 3, 2, build);
		Passenger vasia6=new Passenger("vasia 6", 4, 3, build);
		Passenger vasia7=new Passenger("vasia 7", 5, 1, build);
		Passenger vasia8=new Passenger("vasia 8", 6, 2, build);
		Passenger vasia9=new Passenger("vasia 9", 6, 5, build);
		Thread pass1=new Thread(vasia1);
		Thread pass2=new Thread(vasia2);
		Thread pass3=new Thread(vasia3);
		Thread pass4=new Thread(vasia4);
		Thread pass5=new Thread(vasia5);
		Thread pass6=new Thread(vasia6);
		Thread pass7=new Thread(vasia7);
		Thread pass8=new Thread(vasia8);
		Thread pass9=new Thread(vasia9);
		
		pass1.start();
		pass2.start();
		pass3.start();
		pass4.start();
		pass5.start();
		pass6.start();
		pass7.start();
		pass8.start();
		pass9.start();
		Thread building=new Thread(build);
		building.start();
		
	}

}
