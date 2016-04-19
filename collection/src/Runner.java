import bll.AnalyzeText;

public class Runner {

	public static void main(String[] args) {
		AnalyzeText textAnalyze=new AnalyzeText();
		textAnalyze.setText("ww dd: ,t yy ,..:  i ww dd dd dd dd");
		System.out.println(textAnalyze.percent("ddd"));
		

	}

}
