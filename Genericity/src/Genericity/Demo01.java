package Genericity;

class A<T>{
	
}
public class Demo01 {
	
	public static void main(String[] args) {
		A<Fruit> a1 = new A<Fruit>();
		A<Fruit> a2 = new A<Apple>();//泛型不能使用多态
		test(new A<Fruit>());
		test(new A<Apple>());
	}	
	//形参使用多态
	public static void test(A<Fruit> f){		
	}	
	//返回类型使用多态
	public static A<Fruit> test2()	{	
		return new A<Apple>();
	}
}

