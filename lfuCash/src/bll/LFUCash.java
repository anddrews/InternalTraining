package bll;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LFUCash<T extends Object> {
	
	private int maxLevel;
	private int numberOfElement;
	private int currentLevel;
	private int eviction;
	private Comparator<T> comparer;
	private List<T>[] cash;	
		

	@SuppressWarnings("unchecked")
	public LFUCash(int maxLevel, double eviction, Comparator<T> comparer) {
		this.numberOfElement=0;
		this.currentLevel=0;
		
		this.maxLevel = maxLevel;
		this.comparer = comparer;
		if(maxLevel*eviction>1){
			this.eviction=(int) (maxLevel*eviction);
		}
		else{
			this.eviction=1;
		}		
		this.cash=new List[maxLevel];
		for(int i=0;i<this.maxLevel;i++){
			this.cash[i]=new LinkedList<>();
		}		
	}
	
	public boolean put(T entity) {
		boolean isPut=false;
		if(this.numberOfElement==this.maxLevel){
			clear();
		}
		if(cash[0].add(entity)){
			this.numberOfElement++;
			isPut= true;
		}
		return isPut;		
	}
		
	private void clear() {
		int numberDel=this.eviction;
		int freq=0;
		while(numberDel>0){
			if(cash[freq].size()>=numberDel){
				for(int i=0;i<numberDel;i++){
					cash[freq].remove(cash[freq].size()-1);
				}
				numberDel=0;					
			}
			else{
				numberDel-=cash[freq].size();
				cash[freq].clear();
			}
			freq++;
		}
	}
	
	public T get(T entity) {
		T result = null;
		if(this.numberOfElement>0){
			int freq=this.currentLevel;
			for(int i=this.currentLevel;i>=0 && this.comparer.compare(result, entity)!=0;i--){
				Iterator<T> iterator=this.cash[i].iterator();
				while(iterator.hasNext()){
					T tmp=iterator.next();
					if(this.comparer.compare(tmp, entity)==0){
						result=tmp;
						freq=i;
					}
				}						
			}	
			if(result!=null){
				moveElement(result,freq);
			}
		}		
		return result;
	}

	private void moveElement(T element, int freq) {
		this.cash[freq].remove(element);
		if((freq+1)!=this.maxLevel){
			freq++;			
		}
		this.currentLevel=freq;
		this.cash[this.currentLevel].add(0, element);				
	}
	
	@Override
	public String toString() {
		String result = "";		
		for(int i=0;i<this.maxLevel;i++){
			for(int j=0;j<this.maxLevel;j++){
				if(this.cash[j].size()>i){
					result+=this.cash[j].get(i);
				}
				else{
					result+="-";
				}
			}
			result+="\n";
		}
		return result;
	}

}
