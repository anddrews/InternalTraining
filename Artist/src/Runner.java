import model.Artist;
import model.Eraser;
import model.Painter;

public class Runner {

	public static void main(String[] args) {
			
			try {
				Artist  art=new Artist("Picasso");
				art.startWork();
				Thread.sleep(5000);
				art.stopWork();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
