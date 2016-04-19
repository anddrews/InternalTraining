package bll;

import java.lang.reflect.Field;
import java.util.Comparator;

import annotations.Equal;
import model.CompareBy;

public class CompareFieldByAnnotation implements Comparator<Field>{
	
		final static private String EXCEPTION_MSG="Some problem in cast class field"; 
	
		private Object obj1;
		private Object obj2;		

		public CompareFieldByAnnotation(Object obj1, Object obj2) {
			this.obj1 = obj1;
			this.obj2 = obj2;
		}


		@Override
		public int compare(Field o1, Field o2) {
			int result=-1;
			try {
				if(!o1.isAnnotationPresent(Equal.class)||
						!o2.isAnnotationPresent(Equal.class))
				{
					result=-1;
				}

				else if(o1.getAnnotation(Equal.class).compareBy().equals(o2.getAnnotation(Equal.class).compareBy()))
				{
					o1.setAccessible(true);
					o2.setAccessible(true);
						if(o1.get(obj1).getClass().equals(o2.get(obj2).getClass()))							
						{
							if(o1.getAnnotation(Equal.class).compareBy()==CompareBy.VALUE)
							{
								if(o1.get(obj1).equals(o2.get(obj2)))
								{
									result=0;
								}
							}
							else
							{
								if(o1.get(obj1)==(o2.get(obj2)))
								{
									result=0;
								}
							}
						}				
				}
				else
				{
					result=1;
				}
				
				return result;
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
					e.printStackTrace();
					throw new RuntimeException(EXCEPTION_MSG);
			}
		}
		
		
	}


