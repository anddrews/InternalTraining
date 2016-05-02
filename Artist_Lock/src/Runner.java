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
			
			
//	int max=5;
//	int index=1;
//	int start=0;
//	for(int i=start; index*i<max-start; i=i+1*index){
//		
//		System.out.println(i);
//		if (i==max-1||(i==0 && index==-1)){
//			index*=-1;
//			start=i;
//		}
//	}	
			
	}

	
	
	
}
