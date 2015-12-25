package Enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration使用
 * 1.判断 hasMoreElement()
 * 2.获取 nextElement()
 * 
 * Vector的elements()方法
 */

public class Demo01 {
	public static void main(String[] args) {
		Vector<String> vector = new Vector<>();
		vector.add("javase");
		vector.add("html");
		vector.add("oracle");
		
		//遍历该Vector
		//public Enumeration<E> elements() JDK里该方法使用的匿名内部类对其进行实现
		Enumeration<String> en = vector.elements();
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}
