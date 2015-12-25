package innerType;

/**
 * 引用数据类型
 * 1.内置类
 * 整数、小数Integer Float Double 直接比较数据类型的大小
 * 2.字符：比较的Unicode码之差
 * 3.字符串
 * 1)如果其中一个是另一个起始开始的子串，返回长度之差
 * 2)否则返回第一个不相等的unicode码之差
 * 4.java.util.Date 根据日期的长整型比较
 */
@SuppressWarnings("all")
public class Demo01 {
	public static void main(String[] args) {
		Integer a;//根据基本数据类型大小
		Character ch;//根据Unicode编码顺序
		
		String str="abc";
		String str2 = "abcdegfdsf32";
		System.out.println(str.compareTo(str2));
		
		String str3="abcde";
		String str4 = "abd";
		System.out.println(str3.compareTo(str4));
	}
}

