package reference;

/**
 * 按照价格排序的业务类(降序)
 */
public class GoodsPriceComp implements java.util.Comparator<Goods>{
	public int compare(Goods o1,Goods o2)
	{
		return -(o1.getPrice()-o2.getPrice()>0?1:(o1.getPrice()==o2.getPrice()?0:-1));
	}
}

