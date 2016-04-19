import bll.LFUCash;

public class Runner {

	public static void main(String[] args) {
		LFUCash<Integer, Integer> cash=new LFUCash<>(5, 0.4);
		
		cash.put(1, 10);
		cash.put(2, 20);
		cash.put(3, 30);
		cash.put(4, 40);
		
		System.out.println(cash);
		cash.get(2);
		cash.get(2);
		cash.get(2);
		cash.get(2);
		cash.get(2);
		cash.get(2);
		cash.get(2);
		cash.get(4);
		cash.get(4);
		cash.get(4);
		cash.get(4);
		cash.get(2);
		cash.get(4);
		System.out.println(cash);
		cash.get(2);
		
		System.out.println(cash);
		cash.put(5, 50);
		System.out.println(cash);
		cash.get(5);
		cash.put(6, 60);
		System.out.println(cash);
		cash.put(7, 70);
		System.out.println(cash);
		cash.put(8, 80);
		System.out.println(cash);
		cash.put(9, 90);
		System.out.println(cash);
		
	}

}
