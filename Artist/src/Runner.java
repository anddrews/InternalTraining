import model.Artist;
import model.Eraser;
import model.Painter;

public class Runner {

	public static void main(String[] args) {
			Artist  art=new Artist();
			Eraser erase=new Eraser(art);
			Painter painter = new Painter(art);
			Thread er=new Thread(erase);
			Thread pain=new Thread(painter);
			er.start();
			pain.start();		
	}

}
