package feelingsdetector.classes;

import java.util.ArrayList;

import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;

import lombok.Data;

@Data
public class Result {

	private String resultString="";
	private ArrayList< Tone > resultList;
	
	public Result(ToneAnalysis toneAnalysis)
	{
		resultList=new ArrayList<Tone>();
		for(int i=0;i<toneAnalysis.getDocumentTone().getTones().size();i++)
		{
			this.resultList.add(new Tone(toneAnalysis.getDocumentTone().getTones().get(i).getScore(), toneAnalysis.getDocumentTone().getTones().get(i).getToneName()));
		}
	}
	public String toString()
	{
		
		if(this.resultList.isEmpty()) return "No feelings detected";
		if(resultString!="") return resultString;
		String res=this.resultList.get(0).toString();
		for(int i=1;i<resultList.size()-1;i++)
		{
			res+=", "+this.resultList.get(i).toString();
		}
		if(resultList.size()>1)res+=" and "+this.resultList.get(resultList.size()-1).toString();
		res+=".";
		this.resultString=res;
		return res;
	}
	
}
