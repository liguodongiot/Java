package Collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class EqualsTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		String s1 = new String("lgd");
		String s2 = new String("lgd");
		list.add(s1);
		list.add(s2);
		System.out.println(list.size());
		
		Map map = new HashMap();
		//key不能重复，通过equals判断，如果重复，对其value进行覆盖。
		map.put(s1, "NB");
		map.put(s1,"SB");
		System.out.println(map.get("lgd"));//判断是否相等，同样依赖于equals。
	}
}
