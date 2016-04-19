import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import bll.Analyzer;
import model.AnalyzerResult;
import model.Obj1;

public class Runner {
	
	
	
	public static void main(String[] args) {
		
		final String METHOD_NAME="equalObject";
		final String ERROR_MESSAGE="You have some problem with equal objects";
		Class<?> obj1Class=Obj1.class;
		Class<?> analyzer=Analyzer.class;
		Constructor<?> constructor;
		try {
			
			Class<?>[] typeParameters=new Class[]{int.class,double.class,String.class};
			constructor=obj1Class.getDeclaredConstructor(typeParameters);
			constructor.setAccessible(true);
			String str=new String("123");			
			Object equal=analyzer.newInstance();
			Class<?>[] typeParamForEqual=new Class[] {Object.class,Object.class};
			Method equalObject=analyzer.getDeclaredMethod(METHOD_NAME,typeParamForEqual);
			equalObject.setAccessible(true);
			Object o1=constructor.newInstance(5,6,str);
			Object o2=constructor.newInstance(5,6,"123");
			Object[] objForEquals=new Object[]{o1,o2};
			AnalyzerResult result=(AnalyzerResult) equalObject.invoke(equal, objForEquals);
			System.out.println(result);
		} catch (NoSuchMethodException |
				SecurityException | 
				InstantiationException | 
				IllegalAccessException | 
				IllegalArgumentException | 
				InvocationTargetException e) {
			e.printStackTrace();
			System.err.println(ERROR_MESSAGE);
		}
		
	}
	


	
	
	

}

