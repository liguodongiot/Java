package Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@SuppressWarnings("all")
public class Demo01 {	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		list.add("dds");
		list.add(new Date());
		list.add(new Dog());
		list.add(324);//包装类的自动装箱
		System.out.println(list.size());
		System.out.println(list.isEmpty());		
		list.remove("dds");
		System.out.println(list.size());
		System.out.println("---------------");
		
		List list2 = new ArrayList();
		list2.add("dsaf");
		list2.add("fdsf");
		
		list.add(list2);
		System.out.println(list.size());
		System.out.println("---------------");
		
		String string;		
		for(int i=0;i<list.size();i++)
		{
			string=(String) list.get(i).toString();
			System.out.println(string);
		}
	}
}

class Dog{
	Dog(){
	}
}
