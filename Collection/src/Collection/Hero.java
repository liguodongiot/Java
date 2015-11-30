package Collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//JavaBean实体类
public class Hero {
	private int id;
	private String name;
	private int price;
	private String tag;
	private Date ontime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return price;
	}
	public void setSalary(int price) {
		this.price = price;
	}
	public String getDepartment() {
		return tag;
	}
	public void setDepartment(String tag) {
		this.tag = tag;
	}
	public Date getHiretime() {
		return ontime;
	}
	public void setHiretime(Date ontime) {
		this.ontime = ontime;
	}
	public Hero(int id, String name, int price, String tag,
			String ontime) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.tag = tag;
		
		DateFormat format = new SimpleDateFormat("yyyy-MM");
		try {
			this.ontime=format.parse(ontime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public Hero() {
		super();
	}	
}
