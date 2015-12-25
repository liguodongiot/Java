package Genericity;

import java.util.Iterator;

/**
 * 迭代器原理
 * @author liguodong
 */

@SuppressWarnings("all")
public class MyArray {
	private String[] arr = {"a","b","c","d","d","e","e","f","g"};
	
	private int size = arr.length;
	
	public static void main(String[] args) {
		MyArray list = new MyArray();
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	private class MyIt implements Iterator<String>{
		private int cursor = -1;
		
		/**
		 * 判断是否存在下一个元素
		 * @return
		 */
		public boolean hasNext(){
			return cursor+1<size;
		}
		
		/**
		 * 获取下一个元素
		 */
		public String next(){
			cursor++;//移动一次
			return arr[cursor];
		}
		
		/**
		 * 删除元素
		 */
		public void remove(){
			//没有实现
		}	
	}
	
	public Iterator<String> iterator(){
		return new MyIt();
	}
	
}
