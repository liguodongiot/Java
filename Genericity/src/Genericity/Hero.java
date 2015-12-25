package Genericity;

/**
 * 泛型的擦除情况
 * 1.继承或实现声明不指定类型
 * 2.使用时不指定类型
 * 
 * 统一Object对待
 * 1.编译器的警告  消除警告使用Object
 * 2.不完全等同于Object  编译时不会自动类型检查
 */

public class Hero<T> {
	private T id;
	private T name;
	public Hero() {
	}
	public Hero(T id, T name) {
		super();
		this.id = id;
		this.name = name;
	}
	//泛型声明时不能使用静态属性
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public T getName() {
		return name;
	}
	public void setName(T name) {
		this.name = name;
	}
	
	public static void main(String[] args) {				
		//消除警告使用Object  
		Hero<Object> stu = new Hero<Object>();//不叫擦除
		stu.setName("fds");//以Object对待
		
		Hero stu1 = new Hero();//stu1相当于Object
				
		//test(stu);//不叫擦除，会类型检查，会报错
		
		//擦除  不会类型检查
		//stu1相当于Object 但是不完全等同于Object
		test(stu1);
	
		test1(stu);
		test1(stu1);
	}
	
	//不完全等同于Object,编译时不会自动类型检查	
	public static void test(Hero<Integer> a)	{		
	}	
	
	public static void test1(Hero<?> a)	{		
	}
}
