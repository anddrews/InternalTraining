package bll;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class AnalyzeText {
	private final static String SPLIT_WORD="\\s*\\W+\\s*";
	private Map<String,Integer> wordsInText;

	public AnalyzeText() {
		this.wordsInText=new TreeMap<>();
	}
	
	public AnalyzeText(String text)	{
		this();
		setText(text);
	}
	
	public Map<String,Integer> getWordsInText(){
		return this.wordsInText;
	}
	
	public void setText(String text){
		
		text=text.toUpperCase();
		String[] words=text.split(SPLIT_WORD);
		for(String tmp:words){
			int count=0;
			if(this.wordsInText.containsKey(tmp)){
				count=this.wordsInText.get(tmp);				
			}
			count+=1;
			this.wordsInText.put(tmp.trim(), count);			
		}
	}
	
	public boolean isExist(String word){
		boolean isExist=false;
		word=word.toUpperCase();
		if(this.wordsInText.containsKey(word)) {
			isExist=true;
		}
		return isExist;		
	}
	
	public String percent(String word){
		String result;
		if(isExist(word)){
			int allWord=0;
			double persent=0;
			Collection<Integer> wordFreq=this.wordsInText.values();
			for(Integer tmp:wordFreq){
				allWord+=tmp;
			}
			persent=100*this.wordsInText.get(word.toUpperCase())/allWord;
			result="Word "+ word+" is "+ persent +" percent in text";
		}
		else{
			result="Word "+ word+ " wasn't found in text";
		}
		return result;
	}
	
	
	

}
