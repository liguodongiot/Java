package Genericity;

public class Demo02<T> 
{
	T hero;
	public static void main(String[] args) {
		//泛型的嵌套
		Demo02<Hero<String>> demo02= new Demo02<Hero<String>>();
		
		//从外到内拆分
		demo02.hero = new Hero<String>();
		
		Hero<String> student = demo02.hero;	
		student.setName("盲僧");
		String name  = student.getName();
		System.out.println(name);
	}
}
