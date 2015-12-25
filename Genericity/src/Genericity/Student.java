package Genericity;
/**
 *
 * 泛型类：声明时使用泛型
 * 字母：
 * T 表示类型Type。 
 * K V分别代表键值中的Key Value。
 * E 代表Element。
 * 
 * 使用时确定类型
 * 注意泛型只能是引用类型，不能使基本类型。
 * 泛型声明时 不能使用在静态类型或静态方法上。
 * 	
 * @author liguodong
 *
 * @param <T>
 */
public class Student<T1,T2> {
	private T1 id;
	private T2 name;
	public T1 getId() {
		return id;
	}
	public void setId(T1 id) {
		this.id = id;
	}
	public T2 getName() {
		return name;
	}
	public void setName(T2 name) {
		this.name = name;
	}
	
	
	public Student(T1 id, T2 name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {
	}
	public static void main(String[] args) {
		//使用时指定类型（引用类型）
		Student<Integer, String> student01 = new Student<Integer, String>(1001, "德玛西亚");
		
		Student<Integer,String> student02 = new Student<>();
		//1、安全：类型检查(编译时)
		student02.setId(1003);
		student02.setName("堕落天使");
		//2、省心：类型转换
		int id = student01.getId();//自动拆箱
		System.out.println(id);
	}

}
