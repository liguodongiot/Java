package URL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 获取资源：源代码
 */
public class Demo02 {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");//有时，如果没有资源，主页即是默认资源。	
		//获取资源
		//这种方式会出现乱码出现乱码的情况分别是字节数不够或者编码不统一，这种情况明显是编码不统一。
		//因此可以使用直接将平台的编码改掉，或者使用转换流
		/*InputStream is = url.openStream();
		byte[] flush = new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush)))
		{
			System.out.println(new String(flush,0,len));
		}
		is.close();*/	
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
				
		String msg = null;
		while((msg=br.readLine())!=null)
		{
			System.out.println(msg);
			System.out.println();
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();		
	}
}
