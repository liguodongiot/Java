package ReferenceType;

import java.util.EnumMap;

/**
 * Enum要求键为枚举
 * @author liguodong
 */

public class Demo04 {

	public static void main(String[] args) {
		EnumMap<Season, String> map = new EnumMap<>(Season.class);
		//存放值
		map.put(Season.SPRINT, "春天");
		map.put(Season.SUMMER, "夏天");
		map.put(Season.AUTUMN, "秋天");
		map.put(Season.WINTER, "冬天");
		System.out.println("gc运行后："+map.size());
	}
}
//季节
enum Season
{
	SPRINT,SUMMER,AUTUMN,WINTER
}
