package Genericity.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 每个单词存储的次数
 * Key:string
 * Value:自定义类型
 * 
 * "分拣"思路
 * 1. 为所有的key创建容器，之后容器中存放对应value
 * 2. 第一次创建容器，并存放值
 * 	     第二次直接使用容器存放值
 */

public class Demo01 {
	public static void main(String[] args) {		 
		test1();
	}
	
	//思路一
	public static void test1()
	{
		String str= "this is a cat and that is a mice and where is the food";
		//分割字符串
		String[] strArray = str.split(" ");
		Map<String, Letter> letters = new HashMap<>();
		
		/*for(String temp:strArray)
		{
			//1.为所有的key创建容器，之后容器中存放对应value
			if(!letters.containsKey(temp))
			{
				letters.put(temp,new Letter());
			}
		}
		for(String temp:strArray)
		{
			Letter col = letters.get(temp);//直接使用容器
			col.setCount(col.getCount()+1);
			//col.setName(temp);
		}*/		
		//上面合并在一起
		for(String temp:strArray)
		{
			//1.为所有的key创建容器，
			if(!letters.containsKey(temp))
			{
				letters.put(temp,new Letter());
			}
			//2.之后容器中存放对应value
			Letter col = letters.get(temp);//直接使用容器
			col.setCount(col.getCount()+1);
		}
		//输出Map的值
		Set<String> keys = letters.keySet();
		for (String key:keys) {
			Letter col = letters.get(key);
			System.out.println("字母"+key+",次数"+col.getCount());
		}
		
	}
	
	//思路二
	public static void test2()
	{
		String str= "this is a cat and that is a mice and where is the food";
		//分割字符串
		String[] strArray = str.split(" ");
		Map<String, Letter>  letters  = new HashMap<>();
				
		for(String temp:strArray)
		{
			/*
			//1.为所有的key创建容器，
			if(!letters.containsKey(temp))
			{
				Letter col = new Letter();
				col.setCount(1);//存放第一次的值
				letters.put(temp,col);
			}
			else {
				//2第二次直接使用容器中存放对应value
				Letter col = letters.get(temp);//直接使用容器
				col.setCount(col.getCount()+1);
			}*/		
			
			Letter col = null;
			if(null==(col =letters.get(temp)))
			{
				col = new Letter();
				col.setCount(1);
				letters.put(temp,col);
			}
			else {
				col.setCount(col.getCount()+1);
			}
		}	
		//输出Map的值
		Set<String> keys = letters.keySet();
		for (String key:keys) {
			Letter col = letters.get(key);
			System.out.println("字母"+key+",次数"+col.getCount());
		}
		
	}	
}
