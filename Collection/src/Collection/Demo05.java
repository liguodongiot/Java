package Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressWarnings("all")
public class Demo05 {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("spack");
		list.add("storm");
		list.add("mahout");
		//通过索引遍历
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}	
		System.out.println();
		
		//通过迭代器遍历
		Iterator iterator01 = list.iterator();
		while(iterator01.hasNext()){
			String string = (String) iterator01.next();
			System.out.print(string+" ");
		}
		System.out.println();
		iterator01.remove();//只能删除刚刚遍历完的对象
		System.out.println(list.size());
		
		Set set = new HashSet();
		set.add("嫦娥1号");
		set.add("嫦娥2号");
		set.add("嫦娥3号");
		for (Object object : set) {
			System.out.print(object + " ");
		}
		
		System.out.println();
		Iterator iterator02 = set.iterator();
		while(iterator02.hasNext())	{
			String string = (String) iterator02.next();
			System.out.print(string+" ");
		}	
		System.out.println();
		
		for (Iterator iterator03 = set.iterator(); iterator03.hasNext();) {
			Object object = (Object) iterator03.next();
			System.out.print(object+" ");			
		}
		System.out.println();
	}

}
