import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

import bll.SortBigArray;
import bll.Test;




public class Runner {	
	
	public static void main(String[] args) {
				
		Comparator<Integer> comparator=new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				
				return (o1-o2);
			}			
		};
		int len=10_000_000;
		Integer[] array=new Integer[len];
		Integer[] array1=new Integer[len];
		for (int i=0;i<len;i++){
			Random rnd=new Random();
			array[i]=new Integer(rnd.nextInt(100000000));			
		}
		array1=Arrays.copyOf(array,array.length);
		long st1=System.currentTimeMillis();
		Arrays.sort(array1);
		long fin1=System.currentTimeMillis();

		System.out.println("Once thread sort:"+(fin1-st1));
		SortBigArray<Integer> arr=new SortBigArray<>(array, comparator);		
		try {		
			long st=System.currentTimeMillis();
			arr.sort();
			long fin=System.currentTimeMillis();			
			System.out.println("Multithread sort:"+(fin-st));
					} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
