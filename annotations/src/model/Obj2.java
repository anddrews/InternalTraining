package model;

import annotations.Equal;

public class Obj2 {
	
	
	private int valuIntOld=1;
	@Equal(compareBy=CompareBy.REFERENCE)
	private String valuStr="123";
	@Equal(compareBy=CompareBy.VALUE )
	private int valuInt=1;
	@Equal(compareBy=CompareBy.VALUE)
	private double valuDbl=1.0;

}
