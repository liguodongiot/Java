package SortCollection;

/**
 * 实体类实现Compatable接口
 */

public class Worker implements java.lang.Comparable<Worker>{
	private final String name;
	private final double salary;
	
	public Worker() {
		name = null;
		salary = 0;
	}
	public Worker(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	/*public void setName(String name) {
		this.name = name;
	}*/
	public double getSalary() {
		return salary;
	}
	/*public void setSalary(double salary) {
		this.salary = salary;
	}*/

	@Override
	public int compareTo(Worker o) {
		return this.salary>o.salary?1:((this.salary==o.salary)?0:-1);//升序
	}

	@Override
	public String toString() {
		return "\n工种："+this.name+" 工资："+this.salary;
	}
}
