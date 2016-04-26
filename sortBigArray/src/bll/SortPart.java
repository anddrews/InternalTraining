package bll;

import java.util.Arrays;
import java.util.Comparator;

public class SortPart<T extends Object> extends Thread {
	
	Comparator<T> comparator;
	T[] arrayToSort;
	int startIndex;
	int stopIndex;
	
	public SortPart( T[] arrayToSort,int startIndex,int stopIndex,Comparator<T> comparator) {
		this.comparator = comparator;
		this.arrayToSort = arrayToSort;
		this.startIndex=startIndex;
		this.stopIndex=stopIndex;		
	}
	public void run() {
		Arrays.sort(arrayToSort, startIndex, stopIndex, comparator);
//		System.out.println(Arrays.toString(arrayToSort));
	}	

}
