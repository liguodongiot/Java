package innerType;

import java.util.Arrays;
import java.util.Date;
/**
 * 引用类型冒泡排序
 * @author liguodong
 */

@SuppressWarnings("all")
public class Demo02 {	
	public static void main(String[] args) {
		String[] str = {"a","abd","abcd","def"};
		//从小到大排序		
		int len = str.length;
		BubbleSortThird(str,len);
		
		Date[] date = new Date[3];
		date[0] = new Date();
		date[1] = new Date(System.currentTimeMillis()-1000*60*60);
		date[2] = new Date(System.currentTimeMillis()+1000*60*60);
		BubbleSortThird(date,date.length);

	}
	private static void BubbleSortThird(String[] arr,int len)
	{			
			boolean sorted = true;			
			for(int j=0;j<len-1;j++)
			{
				sorted = true;
				for(int i=0;i<len-1-j;i++)
				{	
					/**
					 * String引用数据类型，需要使用compareTo进行比较。
					 */
					if(((Comparable)arr[i]).compareTo(arr[i+1])>0)
					{
						String temp = arr[i];
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
	
	private static void BubbleSortThird(Date[] arr,int len)
	{			
			boolean sorted = true;			
			for(int j=0;j<len-1;j++)
			{
				sorted = true;
				for(int i=0;i<len-1-j;i++)
				{	
					/**
					 * Date引用数据类型，需要使用compareTo进行比较。
					 */
					if(((Comparable)arr[i]).compareTo(arr[i+1])>0)
					{
						Date temp = arr[i];
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
}


