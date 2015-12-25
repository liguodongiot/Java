package SortCollection;

import java.util.Set;
import java.util.TreeMap;

public class Demo03 {
	// Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();
    
	public static void main(String[] args) {
		Person p1 = new Person("一",100);
		Person p2 = new Person("二",1000);
		Person p3 = new Person("三",1200);
		Person p4 = new Person("四",50);
		
		TreeMap<Person, Object> map = new TreeMap<>(
				new  java.util.Comparator<Person>()
				{
					@Override
					public int compare(Person o1, Person o2) {
						return o1.getHandsome()-o2.getHandsome();
					}
					
				}
				);
		map.put(p1, PRESENT);
		map.put(p2, PRESENT);
		map.put(p3, PRESENT);
		map.put(p4, PRESENT);
		
		//查看键
		Set<Person> persons = map.keySet();
		System.out.println(persons);
	}
}
