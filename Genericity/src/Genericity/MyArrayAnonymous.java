package Genericity;

import java.util.Iterator;

public class MyArrayAnonymous implements java.lang.Iterable<String>{
	
	String[] elem = {"a","b","c","d","e"};
	
	int size = elem.length;
	
	/**
	 * 匿名内部类实现简单迭代器
	 * @return
	 * 
	 * 对比AbstractList类源码
	 */
	public Iterator<String> iterator()
	{
		return new Iterator<String>()
		{
			private int cursor = -1;
			
			public boolean hasNext()
			{
				return cursor+1<size;
			}
			
			public String next()
			{
				cursor++;
				return elem[cursor];
			}		
			public void remove(){			
			}			
		};
	}	
	public static void main(String[] args) {
		MyArrayAnonymous list = new MyArrayAnonymous();
		
		Iterator<String> it = list.iterator();
		while(it.hasNext())
		{
			System.out.print(it.next()+" ");
		}
		System.out.println();
		//增强for，必须实现java.lang.Iterable接口，重写iterator方法。	
		for(String temp:list)
		{
			System.out.print(temp+" ");
		}
	}	
}
