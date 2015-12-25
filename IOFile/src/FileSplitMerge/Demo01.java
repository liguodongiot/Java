package FileSplitMerge;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import IOOthers.FileUtil;

/**
 * RandomAccessFile
 * 此类的实例支持对随机访问文件的读取和写入。
 * 
 * 文件分割的思路
 * 1、 分割的块数 size   n块
 * 2、 每一块的大小 blocksize
 *    最后一块:总的文件大小-(n-1)*blockSize
 */

public class Demo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile rnd = new RandomAccessFile(new File("G:/writer.txt"), "r");
		//UTF-8-->英文使用1个字节，中文使用3个字节来编码
		//GBK-->每个字符占用2个字节
		//从第12个读起       这是采用的是UTF-8  
		rnd.seek(12);
		//定义缓冲大小
		byte[] flush = new byte[1024];
		//接收长度
		int len=0;
		
		while(-1!=(len=rnd.read(flush)))
		{
			if(len>=48)
			{
				System.out.println(new String(flush,0,48));
			}	
			else {
				System.out.println(new String(flush,0,len));
			}
		}
		FileUtil.close(rnd);
	}
}



