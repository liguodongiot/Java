package Collection;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("all")
public class Demo03 {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("aaa");
		set.add("bbb");
		set.add(new String("aaa"));
		System.out.println(set.size());
		for (Object object : set) {
			System.out.println(object);
		}
		System.out.println(set.contains("bbb"));
	}
}
