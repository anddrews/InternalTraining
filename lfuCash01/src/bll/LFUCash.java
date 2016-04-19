package bll;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCash<K extends Object, V extends Object> {
	
	private class Entry{
		public V value;
		public int freq;
		public K key;
		
		public Entry( K key, V value, int freq) {
			this.value = value;
			this.freq = freq;
			this.key = key;
		}
		
		
	}
	
	private final String EVICTION_PROBLEM="Illegal value for eviction";
	private Map<K,Entry> cash;			//is main repository of data 
	private List<Entry>[] frequency;	//is array of lists which is saving priority of reading
	private int minFrequency;			// is minimum priority of reading now
	private int numberToErase;			// is quantity of element which will be cleared when cash is filled 
	private int cashSize;				// is maximum size of cash
		
	@SuppressWarnings("unchecked")
	public LFUCash(int cashSize, double evictionFactor) {
		this.cashSize = cashSize;
		this.cash=new HashMap<>(this.cashSize);
		this.frequency=new List[this.cashSize];
		this.minFrequency=0;
		if(evictionFactor>0 && evictionFactor<=1){
			this.numberToErase=(int)(evictionFactor*cashSize);	// 
		}
		else{
			throw new IllegalArgumentException(EVICTION_PROBLEM);
		}
		frequencyInitial();
	}
	
	/** Put element in cash, if cash size is max it will be cleared**/
	public void put(K key, V value){
		Entry entry=this.cash.get(key);
		if(entry!=null){
			entry.value=value;
		}
		else{
			if(this.cash.size()==this.cashSize){
				cleanCash();				
			}
			Entry newElement=new Entry(key, value, 0);
			this.cash.put(key, newElement);
			this.frequency[0].add(newElement);
			this.minFrequency=0;
		}
	}
	/** Return element from cash by key**/
	public V get(K key){
		V value=null;
		Entry entry=this.cash.get(key);
		if(entry!=null){			
			value=entry.value;
			moveValue(entry);
		}
		return value;
		
	}
	
	
	/**all cash element by string **/
	@Override
	public String toString() {
		String result = "";		
		for(int i=0;i<this.cashSize;i++){
			for(int j=0;j<this.cashSize;j++){
				if(this.frequency[j].size()>i){
					result+=this.frequency[j].get(i).value;
				}
				else{
					result+="-";
				}
			}
			result+="\n";
		}
		return result;
	}

	/**Initialize each List of frequency in array**/
	private void frequencyInitial(){
		for(int i=0;i<this.cashSize;i++){
			this.frequency[i]=new LinkedList<>();
		}
	}
	/**Clean cash's element where cash is full and method put is called**/
	private void cleanCash(){
		int deletedElement=0;
		for(int i=this.minFrequency; i<this.cashSize && deletedElement<this.numberToErase;i++){
			if(this.frequency[i].size()<(this.numberToErase-deletedElement)){
				deletedElement=this.frequency[i].size();
				for(Entry tmp:this.frequency[i]){
					this.cash.remove(tmp.key);
				}
				this.frequency[i].clear();
				recalcMinFrequency();
			}
			else{
				 Iterator<Entry> iterator=this.frequency[i].iterator();
				 while(iterator.hasNext() && deletedElement<this.numberToErase){
					 Entry entry=iterator.next();
					 this.cash.remove(entry.key);
					 iterator.remove();
					 deletedElement++;
				 }
			}
		}	
	}

	/** Is calculated minimum frequency by element each moment of time**/
	private void recalcMinFrequency() {
		this.minFrequency=0;
		while(this.minFrequency<this.cashSize && this.frequency[this.minFrequency].isEmpty()){
			this.minFrequency++;
		}
	}
	
	/**move element from lower frequency list to higher when method get is called**/
	private void moveValue(Entry entry){
		int currentFrequensy=entry.freq;
		int newFrequency=currentFrequensy;
		if(currentFrequensy!=this.cashSize-1){
			newFrequency++;			
		}
		this.frequency[currentFrequensy].remove(entry);
		recalcMinFrequency();		
		this.frequency[newFrequency].add(entry);
		this.cash.get(entry.key).freq=newFrequency;
	}
	
	
	
	
	
}
