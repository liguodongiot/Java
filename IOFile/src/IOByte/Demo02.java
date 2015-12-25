package IOByte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 *  文件的写出
 * 1、建立联系
 * 2、选择流
 * 3、操作 不断写出
 * 4、释放资源
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "g:/oo.txt";
		//1、建立联系
		File dest= new File(path);
		//2、选择文件输出流  OutputStream、FileOutputStream
		OutputStream os = null;		
		try {
			//以追加的形式写出文件为true   覆盖为false  默认是false
			os = new FileOutputStream(dest, true);
			//3、操作  \r\n回车
			String str = "Ladygaga is my nvshen.\r\n";
			//字符集转字符数组
			byte[] data = str.getBytes();
			os.write(data,0,data.length);
			os.flush();//强制刷新出去
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件写出失败");
		}
		finally
		{
			//4、释放资源
			if(null!=os)
			{
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("关闭输出流失败");
				}
			}
		}
	}
}
