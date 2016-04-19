import java.util.Comparator;

import bll.LFUCash;

public class Runner {

	public static void main(String[] args) {
		
		Comparator<String> comparerStr=new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				if(arg0!=null && arg1!=null ){
					return arg0.compareTo(arg1);
				}
				else{
					return -1;
				}
			}
		};
		
		LFUCash<String> cash=new LFUCash<>(5, 0.6, comparerStr);
		cash.put("a");
		cash.put("b");
		cash.get("a");
		cash.get("a");
		cash.put("c");
		cash.put("d");
		
		
		cash.get("a");
		cash.get("a");
		cash.get("a");
		cash.get("c");
		cash.get("a");
		cash.get("d");
		cash.get("d");
		cash.put("e");
		cash.get("b");
		cash.get("b");
		cash.get("c");
		cash.put("y");
		
		
		System.out.println(cash);
		
	}

}
