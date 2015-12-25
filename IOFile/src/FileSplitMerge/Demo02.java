package FileSplitMerge;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import IOOthers.FileUtil;

public class Demo02 {
	
	
	//文件的路径
	private String filePath;
	//块数
	private int size;
	//每块的大小
	private long blocksize;
	//文件名
	private String fileName;
	//文件大小
	private long length;
	//分割后的存放目录
	private String destBlockPath;
	//每块的名称
	private List<String> blockPath;
	
	
	public Demo02() {
		blockPath = new ArrayList<String>() ;
	}	
	public Demo02(String filePath,String destBlockPath) {
		this(filePath,1024, destBlockPath);
	}
	
	public Demo02(String filePath, long blocksize,String destBlockPath) {
		this();
		this.filePath = filePath;
		this.destBlockPath = destBlockPath;
		this.blocksize = blocksize;
	}
	
	
	/**
	 * 初始化操作 计算块数、确定文件名
	 */
	public void init()
	{
		File src = null;
		//健壮性    创建成功就会得到构造方法初始化的值
		if(null==filePath || !(src=new File(filePath)).exists())
		{
			return;
		}
		if(src.isDirectory())
		{
			return;
		}
		
		//文件名    g:/writer.txt的 writer.txt
		this.fileName = src.getName(); 
		//文件的大小
		this.length = src.length();
		
		//修正    每块的大小
		if(this.blocksize>length) //如果每块的大小大于文本的长度，则每块的大小=长度
		{
			this.blocksize = length;
		}
		
		//确定块数        ceil最小(最接近负无穷大)浮点值，该值大于等于该参数，并等于某个整数。
		size = (int) Math.ceil(length*1.0/this.blocksize);
		
		//确定文件的路径
		initPathName();
	}
	
	private void initPathName()
	{
		for(int i=0;i<size;i++)
		{
			//List容器里面增加每一块的路径
			this.blockPath.add(destBlockPath+"/"+this.fileName+".part"+i);
		}
	}
	
	
	
}
