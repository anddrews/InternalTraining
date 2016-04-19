package model;

import annotations.Equal;



public class Obj1 {
	
	private int valuIntOld=1;	
	@Equal(compareBy=CompareBy.VALUE)
	private int valuInt=1;	
	@Equal(compareBy=CompareBy.VALUE)
	private double valuDbl=1.0;
	@Equal(compareBy=CompareBy.VALUE)
	private String valuStr="123";
	
	private Obj1(int valuInt, double valuDbl, String valuStr) {
		this.valuInt = valuInt;
		this.valuDbl = valuDbl;
		this.valuStr = valuStr;
	}
	
	
}
