package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

//使用Collections
public class Demo01 {
	public static void main(String[] args) {
		List<NewsItem> news = new ArrayList<>();
		news.add(new NewsItem("中国人民,生活越来越幸福了",100,new Date()));
		news.add(new NewsItem("国外人民生活在水深火热中",30,new Date(System.currentTimeMillis()+1000*60*60)));
		news.add(new NewsItem("台湾回归，举国同庆", 50, new Date(System.currentTimeMillis()-2000*60*60)));
	
		System.out.println("排序前：\n"+news);		
		//排序
		Collections.sort(news);//默认是升序，想降序自己改
		System.out.println("排序后：\n"+news);
	}
}
