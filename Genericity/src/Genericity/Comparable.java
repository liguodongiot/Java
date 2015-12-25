package Genericity;

/**
 * 泛型接口:与继承同理
 * 重写方法随父类而定
 * @author liguodong
 */

public interface Comparable<T> {
	void compare(T t);
}

//声明子类指定具体类型
class Comp implements Comparable<Integer>
{
	@Override
	public void compare(Integer t) {	
	}
}

//同时擦除  
class Comp1 implements Comparable
{
	@Override
	public void compare(Object t) {		
	}	
}

//父类擦除子类泛型
class Comp2<T> implements Comparable{
	@Override
	public void compare(Object t) {	
	}	
}

//子类泛型>=父类泛型
class Comp3<T,T1> implements Comparable<T>
{
	@Override
	public void compare(T t) {
	}	
}

//父类泛型，子类擦除 错误  同 声明子类具体类型 区别开
/*class Comp4 implements Comparable<T>
{
	@Override
	public void compare(T t) {	
	}
}
*/
