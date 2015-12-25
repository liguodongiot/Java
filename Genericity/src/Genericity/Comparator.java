package Genericity;
/**
 * 接口中泛型类型字母只能使用在方法中，不能使用在全局变量中
 * @author liguodong
 *
 * @param <T>
 */
public interface Comparator<T> {
	//T a = 2;  xxx   java接口中属性：final static
	void compare(T t);
}
