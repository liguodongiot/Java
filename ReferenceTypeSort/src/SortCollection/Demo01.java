package SortCollection;

import java.util.TreeSet;

/**
 * 解耦方式实现业务排序类
 */

public class Demo01 {
	public static void main(String[] args) {
		Person p1 = new Person("一",100);
		Person p2 = new Person("二",1000);
		Person p3 = new Person("三",1200);
		Person p4 = new Person("四",50);
		
		//依次存放到TreeSet容器中，使用排序的业务类(匿名内部类)
		TreeSet<Person> persons = new TreeSet<>(
				new  java.util.Comparator<Person>()
				{
					@Override
					public int compare(Person o1, Person o2) {
						return o1.getHandsome()-o2.getHandsome();
					}
					
				}
				);
		//TreeSet 在添加数据时排序
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);		
		System.out.println(persons);		
		//改变数据   数据不会更改原来的顺序，并且数据可能重复,修改数据不会有任何的顺序变化。
		System.out.println("修改数据之后：");
		p3.setHandsome(-100);		
		System.out.println(persons);
	}
}
