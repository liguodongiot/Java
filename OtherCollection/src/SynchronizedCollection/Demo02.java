package SynchronizedCollection;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 只读设置
 * emptyXxx()  空的不可变的集合
 *  	emptyMap
 * 		emptyList
 *     	emptySet  
 * singletonXxx() 一个元素的容器  不可变的集合
 *  	sington(T o)
 *      singtonList(T o)
 *      singtonMap(K key,V value)      
 * unmodifiableXxx 不可变容器
 *  	unmodifiableList(List<? extends T> list) 
 *  	unmodifiableSet(Set<? extends T> s) 
 *  	unmodifiableMap(Map<? extends K,? extends V> m)
 */
@SuppressWarnings("all")
public class Demo02 {
	private static final int String = 0;
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();	
		map.put("test","test");
		map.put("baby", "baby");
		
		//只读控制
		Map<String, String> map2 = Collections.unmodifiableMap(map);
		//map2.put("a", "a");//不能操作
		System.out.println(map2.size());
		
		//一个元素的容器
		List<String> list = Collections.singletonList(new String("fsda"));
		//list.add("fsaf");
		//list.add("dsaf");//只能包含一个元素的容器	不被支持
		System.out.println(list);	
		
		Set<String> set = new HashSet<>();
		set.add("123");
		System.out.println(set);	
		set = null;
		System.out.println(oper(set));
		
	}
	
	public static Set<String> oper(Set<String> set)
	{
		if(null==set)
		{
			return Collections.EMPTY_SET;//外部获取避免NullPointerException
		}
		//操作
		return set;
	}
}
