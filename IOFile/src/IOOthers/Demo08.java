package IOOthers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * 封装输入   类似于Scanner的操作
 */
public class Demo08 {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;//字节流
		//InputStreamReader 是字节流通向字符流的桥梁    转换流
		//字符流--转换流--字节流    使用了新增方法不能使用多态
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		System.out.println("请输入：");
		String msg = br.readLine();//处理一行
		System.out.println(msg);
	}
}
