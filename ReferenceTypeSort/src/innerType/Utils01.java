package innerType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 工具类
 * @author liguodong
 *
 */
@SuppressWarnings("all")
public class Utils01 {
	
	public static void BubbleSort(Object[] arr)
	{			
		boolean sorted = true;
		int len = arr.length;
		for(int j=0;j<len-1;j++)
		{
			sorted = true;
			for(int i=0;i<len-1-j;i++)
			{	
				/**
				 * 引用数据类型，需要使用compareTo进行比较。
				 */
				if(((Comparable)arr[i]).compareTo(arr[i+1])>0)
				{
					Object temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}		
			if(sorted)
			{
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	/**
	 * 数组排序<泛型>
	 */
	public static<T extends Comparable<T>> void BubbleSort(T[] arr)
	{
		boolean sorted = true;
		int len = arr.length;
		for(int j=0;j<len-1;j++)
		{
			sorted = true;
			for(int i=0;i<len-1-j;i++)
			{				
				if(((Comparable)arr[i]).compareTo(arr[i+1])>0)
				{
					T  temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					sorted = false;
				}
			}			
			if(sorted)
			{
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 容器排序<使用泛型>
	 */
	public static <T extends Comparable<T>> void BubbleSort(List<T> list)
	{
		//第一步：转成数组
		Object [] arr = list.toArray();
		 BubbleSort(arr);
		//第二步：改变容器中对应的值
		for(int i=0; i<arr.length; i++)
		{
			list.set(i, (T)(arr[i]));
		}
	}
	
}
