package Genericity.Map;
/**
 * 学生
 * @author liguodong
 *
 */
public class Student {
	private String name;//姓名
	private String no;//班号
	private double score;//分数
	public Student(String name, String no, double score) {
		super();
		this.name = name;
		this.no = no;
		this.score = score;
	}
	public Student() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student [name=" + name +  ", no="+ no+", score="+score+"]";
	}
}
