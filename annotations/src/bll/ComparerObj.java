package bll;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

import annotations.Equal;

public class ComparerObj{
	
	public static  boolean comparer(Object obj1, Object obj2)
	{
		boolean result=true;
		int i=0;
		int numberAnnotationField1;
		int numberAnnotationField2;

		Comparator<Field> compareField=new CompareFieldByAnnotation(obj2,obj1);
		Comparator<Field> compareFieldToSort=new CompareFieldByAnnotation(obj2,obj2);

		Class<?> obj1Class= obj1.getClass();
		Class<?> obj2Class=(Class<?>) obj2.getClass();
		
		Field[] fieldsObj1=obj1Class.getDeclaredFields();
		Field[] fieldsObj2=obj2Class.getDeclaredFields();
		numberAnnotationField1=numberOfAnnotation(fieldsObj1, Equal.class);
		numberAnnotationField2=numberOfAnnotation(fieldsObj2, Equal.class);		
						
		if (numberAnnotationField1!=numberAnnotationField2) 
		{
			result=false;			
		}
		else
		{
			Arrays.sort(fieldsObj2, compareFieldToSort);
			for (i = 0; i < fieldsObj1.length && result==true ; i++)
			{
				
				if (fieldsObj1[i].isAnnotationPresent(Equal.class)&&
						Arrays.binarySearch(fieldsObj2, fieldsObj1[i], compareField)<0)						
				{
					result = false;
				}
			} 
		}
		return result;
	}
	
	private static int numberOfAnnotation(Field[] fields, Class<? extends Annotation> annotationClass)
	{
		int result=0;
		int i;
		for(i=0;i<fields.length;i++)
		{
			if(fields[i].isAnnotationPresent(annotationClass))
			{
				result++;
			}
		}
		return result;
	}

}
