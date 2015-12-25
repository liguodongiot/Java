package innerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo05 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("gdsf");
		list.add("fdsf");
		list.add("vcxvfd");
		System.out.println("方式一");
		Collections.sort(list);
		System.out.println(list);
		System.out.println("方式二");
		Collections.sort(list,new StringComp());
		System.out.println(list);
		
	}
}
