package innerType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author liguodong
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		System.out.println("------数组排序----------");
		/**
		 * 1、数组排序
		 */
		String[] str = {"a","abd","abcd","def"};
		//从小到大排序		
		Utils01.BubbleSort(str);
		
		Date[] date = new Date[3];
		date[0] = new Date();
		date[1] = new Date(System.currentTimeMillis()-1000*60*60);
		date[2] = new Date(System.currentTimeMillis()+1000*60*60);
		Utils01.BubbleSort(date);
		
		/**
		 * 2、容器排序
		 */
		//存放到容器中
		System.out.println("------容器排序----------");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("abcd");
		list.add("abdd");
		list.add("def");
		Utils01.BubbleSort(list);

		
	}
}
