package model;

public class Result {
	private boolean result;
	private CompareBy compare;
	private String fieldName;
	
	
	public Result()
	{
		this.result=false;
		this.compare=null;
		this.fieldName="";
	}
	
	public Result(boolean result, CompareBy compare,String name)
	{
		this.result=result;
		this.compare=compare;
		this.fieldName=name;
	}
	
	

	public boolean isResult() {
		return result;
	}



	public void setResult(boolean result) {
		this.result = result;
	}



	public CompareBy getCompare() {
		return compare;
	}



	public void setCompare(CompareBy compare) {
		this.compare = compare;
	}
	
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String toString() {
		return "Compare by "+compare.toString()+" fields "+fieldName+ " is "+result;
	}
	
	
	

}
