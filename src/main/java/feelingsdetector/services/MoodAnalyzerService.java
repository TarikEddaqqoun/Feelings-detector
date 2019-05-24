package feelingsdetector.services;

import feelingsdetector.classes.MoodAnalyzer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MoodAnalyzerService {

	private String keyApi;
	private String text;
	
	private MoodAnalyzer analyzer;
	
	public MoodAnalyzerService()
	{
		
	}
	public MoodAnalyzerService setApiKey(String key)
	{
		this.setKeyApi(key);
		return this;
	}
	public MoodAnalyzerService build()
	{
		analyzer = new MoodAnalyzer(this.keyApi);
		return this;
	}
	public String analyze(String text)
	{
		return analyzer.analyze(text).toString();
		
	}
}
