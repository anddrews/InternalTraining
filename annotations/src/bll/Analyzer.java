package bll;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import annotations.Equal;
import model.AnalyzerResult;
import model.CompareBy;
import model.Result;

public class Analyzer {
	private final static String EXCEPTION_MSG="Some problem in iqual";
	
	@SuppressWarnings("unused")
	private AnalyzerResult equalObject(Object o1,Object o2)
	{		
		Class<?> o1Class=o1.getClass();
		Class<?> o2Class=o2.getClass();
		try {
			boolean isEqual=true;
			List<Result> results=new ArrayList<>();
			AnalyzerResult result=new AnalyzerResult();
			if(o1Class.equals(o2Class))
			{				
				Field[] o1Fields=o1Class.getDeclaredFields();
				Field[] o2Fields=o2Class.getDeclaredFields();
				
				for(int i=0;i<o1Fields.length;i++) {					
					if(o1Fields[i].isAnnotationPresent(Equal.class)) {						
						boolean compareResult;
						o1Fields[i].setAccessible(true);
						o2Fields[i].setAccessible(true);
						CompareBy methodCompare=o1Fields[i].getAnnotation(Equal.class).compareBy();						
						if(methodCompare==CompareBy.VALUE) {
							compareResult=o1Fields[i].get(o1).equals(o2Fields[i].get(o2));
						}
						else {
							compareResult=o1Fields[i].get(o1)==(o2Fields[i].get(o2));							
						}
						isEqual&=compareResult;
						Result compareField=new Result(compareResult,methodCompare,o1Fields[i].getName());
						results.add(compareField);
					}					
				}
				result.setResult(isEqual);
			}
			else {
				result.setResult(false);
			}			
			result.setCompareFields(results);
			return result;
		} 
		catch (IllegalArgumentException | IllegalAccessException e) 
		{
			e.printStackTrace();
			throw new RuntimeException(EXCEPTION_MSG);				
		}		
	}
	

}

