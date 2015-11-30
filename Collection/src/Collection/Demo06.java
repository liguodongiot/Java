package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressWarnings("all")
public class Demo06 {
	public static void main(String[] args) {
		Map map =  new HashMap();
		map.put("赵信", "枪出如龙");
		map.put("蛮王", "我的大刀早已饥渴难耐");
		
		//方式一
		Set keys = map.keySet();
		for (Object key : keys) {			
			System.out.println(key+"-->"+map.get(key));
		}
		
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String keyString = (String) iterator.next();
			System.out.println(keyString+"-->"+map.get(keyString));
		}
		
		//方式二
		//注意这个Entry是java.util.Map.Entry，导包不要出现错误。
		Set entrySet = map.entrySet();
		for (Iterator iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry entry = (Entry) iterator.next();
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			System.out.println(key + "----->" + value);
		}
		
		Iterator entryIte = entrySet.iterator();
		while (entryIte.hasNext()) {
			// 通过迭代返回的是一个entry
			Entry entry = (Entry) entryIte.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			System.out.println(key + "----->" + value);
		}
		
	}
}
