package feelingsdetector.classes;

import lombok.Data;

@Data
public class Tone {

	private Double score;
	private String name;
	
	public Tone(Double score, String name)
	{
		this.score=score;
		this.name=name;
	}
	@Override
	public String toString() {
		return (int)(score*100)+"% "+name;
	}
	public int compareTo(Tone tone) {
		return this.score >= tone.getScore() ? -1 : 0;
	}
	
}
