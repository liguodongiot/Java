package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 1.binarySearch  二分搜索法搜索指定列表，以获得指定对象，必须要容器有序
 * 2.sort(List<T> list)
 *   sort(List<T> list,Comparator<? super T> c)
 * 3.reverse(List<?> list)
 * 4.shuffle(List<?> list)洗牌
 * 5.swap(List<?> list, int i ,int j)
 */

public class Demo01 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		//shuffer洗牌 模拟斗地主
		for(int i=0;i<54;i++)
		{
			list.add(i);
		}
		//洗牌
		Collections.shuffle(list);
		//依次发牌
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		List<Integer> p3 = new ArrayList<Integer>();
		List<Integer> last = new ArrayList<>();
		
		for(int i=0;i<51;i+=3)
		{
			p1.add(list.get(i));
			p2.add(list.get(i+1));
			p3.add(list.get(i+2));
		}
		last.add(list.get(51));
		last.add(list.get(52));
		last.add(list.get(53));
		System.out.println("第一个人："+p1);
		System.out.println("第二个人："+p2);
		System.out.println("第三个人："+p3);
		System.out.println("底牌为："+last);
	}
	//测试反转
	public static void reverse()
	{
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("反转之后："+list);
	}	
}
