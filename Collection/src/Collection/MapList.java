package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class MapList {
	public static void main(String[] args) {
		Map map1 = new HashMap();
		map1.put("id", 1001);
		map1.put("name", "刀妹");
		map1.put("salary", 3050);
		map1.put("department", "项目部");
		map1.put("hireDate", "2007-10");
		
		Map map2= new HashMap();
		map2.put("id", 1002);
		map2.put("name", "战争女神");
		map2.put("salary", 3050);		
		map2.put("department", "教学部");
		map2.put("hireDate", "2006-10");
		
		Map map3 = new HashMap();
		map3.put("id", 1003);
		map3.put("name", "苍井空");
		map3.put("salary", 3050);
		map3.put("department", "外交部");
		map3.put("hireDate", "2009-10");
		
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		printName(list);
	}
	
	public static void printName(List<Map> list){
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i).get("name") + "--" + list.get(i).get("salary"));
		}
	}
}
