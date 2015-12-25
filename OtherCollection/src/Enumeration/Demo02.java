package Enumeration;

import java.util.StringTokenizer;

/**
 * Enumeration子类
 * StringTokenizer与String的split()方法相类似，用于字符串分割
 * StringTokenizer不支持正则表达式，split()支持正则表达式
 */
public class Demo02 {
	public static void main(String[] args) {
		String emailStr = "liguodong@163.com;liguodong@qq.com;liguodong@sohu.com";		
		//遍历获取
		//public class StringTokenizerextends Object implements Enumeration<Object>
		StringTokenizer token = new StringTokenizer(emailStr,";");
		while(token.hasMoreElements())
		{
			System.out.println(token.nextElement());
		}		
	}	
}
