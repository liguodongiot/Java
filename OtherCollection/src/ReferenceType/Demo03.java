package ReferenceType;

import java.util.IdentityHashMap;
/**
 * IdentityHashMap 只比较地址    键比较  地址去重
 * @author liguodong
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<>();
		//常量池中的"a"   
		map.put("a", "a1");
		map.put("a", "a2");
		System.out.println(map.size());
		
		map.put(new String("a"), "a3");
		map.put(new String("a"), "a4");
		System.out.println(map.size());
	}
}
