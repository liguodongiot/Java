package Genericity;

import java.io.Closeable;

/**
 * 泛型方法<> 返回类型前面
 * 只能访问对象的信息，不能修改信息。
 * @author liguodong
 *
 */
public class Method {
	//泛型方法
	public static <T> void test(T t)
	{
		System.out.println(t);
	}
	//extends <=    T...表示可变参数
	public static <T extends Closeable> void test(T... t)
	{
		System.out.println(t);
		for (T temp : t) {
			try {
				if(null != temp){
					temp.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		test("df");//T-->String   //df
	}
}
