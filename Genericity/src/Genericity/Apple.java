package Genericity;

/**
 * 多态的两种形式
 * 1.形参使用多态
 * 2.返回类型使用多态
 */
class Fruit {
}

public class Apple extends Fruit{
	
	//形参使用多态
	public static void test(Fruit f){		
	}	
	//返回类型使用多态
	public static Fruit test2()	{
		
		return new Apple();
	}
	public static void main(String[] args) {	
		Apple f = new Apple();
		test(f);
		test2();
	}
}


