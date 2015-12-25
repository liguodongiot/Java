package NoGenericity;

public class Student {
	private Object  englishScore;
	private Object  mathsScore;
	
	public Object getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(Object englishScore) {
		this.englishScore = englishScore;
	}
	public Object getMathsScore() {
		return mathsScore;
	}
	public void setMathsScore(Object mathsScore) {
		this.mathsScore = mathsScore;
	}
	public Student(Object englishScore, Object mathsScore) {
		super();
		this.englishScore = englishScore;
		this.mathsScore = mathsScore;
	}
	public Student() {
		super();
	}
}
