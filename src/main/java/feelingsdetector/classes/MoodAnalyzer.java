package feelingsdetector.classes;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.tone_analyzer.v3.model.ToneOptions;

import lombok.Data;

@Data
public class MoodAnalyzer {

	private IamOptions options;
	private String apiKey;
	
	private NaturalLanguageUnderstanding naturalLanguageUnderstanding;
	private String text="";
	
	private ToneOptions toneOptions;
	private ToneAnalyzer toneAnalyzer;
	
	private ToneAnalysis toneAnalysis;
	
	public MoodAnalyzer(String apiKey)
	{
		this.setApiKey(apiKey);
		this.options= new IamOptions.Builder().apiKey(apiKey).build();
		this.toneAnalyzer = new ToneAnalyzer("2017-09-21");
		this.toneAnalyzer.setIamCredentials(options);
		this.toneAnalyzer.setEndPoint("https://gateway-lon.watsonplatform.net/tone-analyzer/api");	
	}
	public MoodAnalyzer() {
		this.toneAnalyzer = new ToneAnalyzer("2017-09-21");
		this.toneAnalyzer.setIamCredentials(options);
		this.toneAnalyzer.setEndPoint("https://gateway-lon.watsonplatform.net/tone-analyzer/api");
	}
	public Result analyze(String text)
	{
		if(!this.text.equals(text))
		{
			this.setText(text);
			this.toneOptions = new ToneOptions.Builder().text(this.text).build();
			this.toneAnalysis = this.toneAnalyzer.tone(toneOptions).execute().getResult();
		}
		return new Result(this.toneAnalysis);
		
	}
}
