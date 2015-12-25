package ReferenceType;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 引用的分类：强、软、弱、虚
 * 强与弱的引用
 */

public class Demo01 {
	public static void main(String[] args) {		
		//弱引用管理  但是字符串常量不能管理
		testString();				
		//弱引用
		testString2();		
		//软引用
		testString3();
		
	}
		
	public static void testString()
	{
		//字符串常量池 共享 不能回收
		String str = "baby  is  very  good!";
		
		//弱引用管理对象
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("--弱引用--常量池");
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str = null;	
		
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+wr.get());
	}
	
	public static void testString2()
	{
		//弱引用运行垃圾回收机制，都会被回收。
		String str = new String("coco  is  very  good!");
		
		WeakReference<String> wr = new WeakReference<String>(str);
		System.out.println("--弱引用--");
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str = null;	
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+wr.get());
	}
	
	public static void testString3()
	{
		String str = new String("baby  is  very  good!");
		
		SoftReference<String> wr = new SoftReference<String>(str);
		System.out.println("--软引用--");
		System.out.println("gc运行前："+wr.get());
		//断开引用
		str = null;		
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后："+wr.get());
	}
	
}



