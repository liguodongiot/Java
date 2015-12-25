package IOOthers;

/**
 * 空接口只是一个标识,标识可以序列化。
 */
@SuppressWarnings("all")
public class Employee implements java.io.Serializable{
	//不需要序列化
	private transient String name;
	private double salary;
	public Employee(){
	}
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
