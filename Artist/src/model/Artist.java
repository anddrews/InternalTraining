package model;

public class Artist {
	private String name;	
	Eraser erase;
	Painter painter;
	
	public Artist(String name) {
		this.name=name;		
	}
	
	public void startWork(){
		erase=new Eraser(this);
		painter = new Painter(this);
		Thread er=new Thread(erase);
		Thread pain=new Thread(painter);
		er.start();
		pain.start();
	}
	
	public void stopWork(){
		erase.endWork();
		painter.endWork();
	}
}
