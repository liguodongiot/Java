package reference;

/**
 * 实体类
 */
public class Goods {
	
	private String name;//商品名称
	private int price;//价格
	private int fav;//收藏量
	
	public Goods(String name, int price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}
	public Goods() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getFav() {
		return fav;
	}
	public void setFav(int fav) {
		this.fav = fav;
	}
	
	@Override
	public String toString() {
		return "\n商品名："+name+"    收藏量："+this.fav+"    价格："+this.price;
	}
}
