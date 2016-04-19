package bll;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class SortBigArray<T extends Object> {
	T[] array;
	Comparator<T> comparator;
	
	public SortBigArray(T[] array, Comparator<T> comparator) {
		this.array = array;
		this.comparator = comparator;
	}
	
	public T[] sort() throws Exception {
		SortPart<T> firstTread=new SortPart<T>(array,0,array.length/2,comparator);
		SortPart<T> secondThread=new SortPart<T>(array,array.length/2,array.length,comparator);		
		
		firstTread.start();
		secondThread.start();
		firstTread.join();		
		secondThread.join();
		return mergeArray(array,array.length/2);	
	}
	
	@SuppressWarnings("unchecked")
	private T[] mergeArray(T[] array, int middlPoint) {
		int indexFirst=0;
		int indexSecond=middlPoint;
		int indexMain=0;
		T[] result=(T[])new Object[array.length];
		while(indexFirst<middlPoint || indexSecond<array.length){				
			if(indexFirst==middlPoint){
				result[indexMain]=array[indexSecond];
				indexSecond++;
			}				
			else if(indexSecond==array.length){
				result[indexMain]=array[indexFirst];
				indexFirst++;
			}
			else{
				int compare=comparator.compare(array[indexFirst], array[indexSecond]);
				if(compare<=0){
					result[indexMain]=array[indexFirst];
					indexFirst++;
				}
				else{
					result[indexMain]=array[indexSecond];
					indexSecond++;	
				}				
			}
			indexMain++;
		}
		return result;
	}
	
	
}
