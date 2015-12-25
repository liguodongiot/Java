package Genericity;



/**
 * 没有泛型数组
 * 声明可以使用，但是创建失败
 */

@SuppressWarnings("all")
public class Array {
	public static void main(String[] args) {
		Integer[] integer = new Integer[4];		
		//Hero<String>[] arr01 = new Hero<String>[10];//报错  不能使用泛型数组
		//Hero<?>[] arr02 = new Hero<Object>[10];//报错
		Hero<?>[] hero = new Hero[10];//声明可以使用，但是没啥意义
		
		MyArrayList<String> strArrayList = new MyArrayList<String>();
		strArrayList.add(0, "a");
		String string  = strArrayList.getElem(0);
		System.out.println(string);//a
		
		MyArrayList<Integer> intArrayList = new MyArrayList<Integer>();
		intArrayList.add(1, 1001);
		int data  = intArrayList.getElem(1);
		System.out.println(data);//1001
	}
}

class MyArrayList<E>
{
	Object[] cap = new Object[10];
	
	public void add(int index,E e)
	{
		cap[index] = e;
	}
	
	@SuppressWarnings("unchecked")
	public E[] getAll()
	{
		return (E[]) cap;
	}
	
	@SuppressWarnings("unchecked")
	public E getElem(int index)
	{
		return (E) cap[index];
	}
}
