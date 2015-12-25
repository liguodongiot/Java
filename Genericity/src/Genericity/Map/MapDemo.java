package Genericity.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 定义一个Student类，属性：name 姓名  no班号，score成绩。
 * 现将若干Student对象放入List，请统计出每个班级的总分和平均分，分别打印出来.
 */

public class MapDemo {

	public static void main(String[] args) {
		//学生列表
		List<Student> list = new ArrayList<>();
		//放入学生对象
		exam(list);
		//统计
		Map<String, ClassRoom> rooms = new HashMap<String, ClassRoom>();
		
		count(rooms,list);
		//打印
		printScore(rooms);
	}
	
	/**
	 * 打印平均分
	 * @param rooms
	 * @param list
	 */
	public static void printScore(Map<String, ClassRoom> rooms){
		Set<Map.Entry<String,ClassRoom>>  entrySet = rooms.entrySet();
		Iterator<Map.Entry<String, ClassRoom>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<String, ClassRoom> entry = it.next();
			ClassRoom room = entry.getValue();
			double avg = room.getTotal()/room.getStus().size();
			System.out.println("班号"+room.getNo()+",总分"+room.getTotal()+",平均分"+avg);
		}
	}
	//统计分数
	public static void count(Map<String,ClassRoom> rooms,List<Student> list)	{
		for(Student stu:list)		{
			String no = stu.getNo();//得到学生班号
			double score = stu.getScore();//得到分数
			
			//根据班级编号查看Map是否存在该班级  分拣思路   value= get(Key);
			ClassRoom room = rooms.get(no);
			if(null==room)//第一次
			{
				room = new ClassRoom(no);
				rooms.put(no,room);  //Map   put(key,value)
			}			
			//存储
			room.setTotal(room.getTotal()+score);//加入总分
			//stus已经在构造函数中初始化了，这里直接加入即可。
			room.getStus().add(stu);//加入学生			
		}
	}
	
	//将student放入对象List
	public static void exam(List<Student> list)
	{
		list.add(new Student("a","001",80));
		list.add(new Student("b","002",30));
		list.add(new Student("c","001",40));
		list.add(new Student("d","004",60));
		list.add(new Student("e","005",70));
		
	}
}
