/**
 * 用来展示 Parameters Passing
 * @author yiddi
 *
 */
public class IntBox {
	
	public int i;
	
	/*
	 * pass by value 不会对 original value
	 * 做任何更改。传过来的只是一个值
	 */
	static void doNoting(int x) {
		x = 2;
	}
	/*
	 * pass by reference 可以对 original value
	 * 做任何更改。传过来的是一个指向 HEAP 的引用
	 * 通过引用可以修改 HEAP 中的数据
	 */
	static void set3(IntBox ib) {
		ib.i = 3;
	}
	/*
	 * 在函数中对传入的 reference 赋值是十分危险
	 * 的， 失去了对原来 HEAP 中数据的跟踪。
	 */
	static void badSet4(IntBox ib) {
		ib = new IntBox();
		ib.i = 4;
	}
	
}
