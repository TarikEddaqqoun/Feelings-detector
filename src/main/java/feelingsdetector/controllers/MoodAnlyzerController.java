package feelingsdetector.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import feelingsdetector.services.MoodAnalyzerService;

@RestController
public class MoodAnlyzerController {
	
	private MoodAnalyzerService analyzer=new MoodAnalyzerService();
	@PostMapping("/")
	public String nouveauClient(@RequestBody String text,
								@RequestHeader("api-key") String apiKey)
	{
		analyzer.setApiKey(apiKey).build();
		return analyzer.analyze(text).toString(); // Change it with what do u want to return
	}
	
}
