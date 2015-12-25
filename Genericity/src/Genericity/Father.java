package Genericity;

/**
 * 父类为泛型类 
 * 1.属性
 * 2.方法
 * 要么同时擦除，要么子类大于父类的类型
 * 不能子类擦除，父类泛型
 * 1.属性类型
 * 在父类中，随父类而定
 * 在子类中，随子类而定
 * 2.方法重写
 * 全部随父类而定
 * */
public abstract class Father<T,T1>
{
	T t;
	public abstract void test(T t);
}

/**
 * 子类声明时指定具体类型 
 * 属性类型为具体类型
 * 方法类型也为具体类型
 */
class Child1 extends Father<String,Integer>
{
	Integer t1;
	@Override
	public void test(String t1){
		this.t = t1;//t->String
		this.t1 = 100; //t1->int
	}
}

/**
 * 子类为泛型,类型在使用时确定 
 * 要么同时擦除，要么子类大于父类的类型（顺序可以交换）
 */
class Child2<T1,T> extends Father<T,T1>
{
	T t2;
	@Override
	public void test(T t2)
	{		
	}
}

/**
 * 子类为泛型类，父类不指定类型->泛型的擦除,使用Object替换，此时Father为Object类型
 */
class child3<T1,T2> extends Father
{
    T1 abc;
	@Override
	public void test(Object t) {
	}	
}


/**
 * 子类与父类同时擦除,使用Object替换,此时Father为Object类型
 */
class Child4 extends Father{
	String t4;
	@Override
	public void test(Object t4) {	
	}
}

/**
 *错误： 子类擦除，父类使用泛型
 */
/*class Child5 extends Father<T>
{
	@Override
	public void test(T t5) {	
	}	
}*/
