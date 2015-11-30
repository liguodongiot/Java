package Collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@SuppressWarnings("all")
public class Demo02 {
	public static void main(String[] args) {
		//Map map = new Hashtable();
		Map map = new HashMap();
		map.put("习大大", new Wife("彭麻麻"));
		map.put("灰太狼", new Wife("红太狼"));
		map.put("猪八戒", "嫦娥");
		
		Wife wife = (Wife) map.get("灰太狼");
		map.remove("灰太狼");//从容器中移除
		System.out.println(wife.name);
		
		System.out.println(map.containsKey("习大大"));
		System.out.println(map.containsValue("彭麻麻"));
		System.out.println(map.containsValue("嫦娥"));
	}
}

class Wife{
	String name;
	public Wife(String name){
		this.name = name;
	}
}