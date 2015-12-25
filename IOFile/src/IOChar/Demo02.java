package IOChar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 纯文件的写出
 * write(char[] cbuf)   写入字符数组。
 * void write(String str)  写入字符串。 
 * abstract  void write(char[] cbuf, int off, int len) 
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "G:/output.txt";
		//创建源
		File dest = new File(path);
		//选择流
		Writer wr = null;
		try {
			//wr = new FileWriter(dest,true);//true表示追加文件  默认是false,覆盖文件。
			wr = new FileWriter(dest);
			//写出
			String msg = "每个人都有青春，\r\n每个青春都有一个故事，\r\n每个故事都有一个遗憾，\r\n每个遗憾却都存在着他的美好。";
			wr.write(msg);
			wr.append("ouye");
			wr.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			if(null!=wr)
			{
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

