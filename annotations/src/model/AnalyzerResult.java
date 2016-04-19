package model;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerResult {
	
	private boolean isEqual;
	private List<Result> compareFields;
	
	public AnalyzerResult() {
		this.isEqual = false;
		this.compareFields = new ArrayList<>();
	}

	public boolean isResult() {
		return isEqual;
	}

	public void setResult(boolean result) {
		this.isEqual = result;
	}

	public List<Result> getCompareFields() {
		return compareFields;
	}

	public void setCompareFields(List<Result> compareFields) {
		this.compareFields = compareFields;
	}

	@Override
	public String toString() {
		String resultString;
		resultString="Objects inputed equal is "+ isEqual+"\n";
		for(Result tmp:compareFields)
		{
			resultString+=("   "+tmp+"\n");
		}
		return resultString;
	}

	
	

}
