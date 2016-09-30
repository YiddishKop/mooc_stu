import static org.junit.Assert.assertArrayEquals;

import java.util.Iterator;

/*
 * 
 * Write a method that non-destructively inserts item into array x at the given position. The method
should return the resulting array. For example, if x = [5, 9, 14, 15], item = 6, and
position = 2, then the method should return [5, 9, 6, 14, 15]. If position is past
the end of the array, insert item at the end of the array.
 */
public class ArrayInsert {
	
	// non-descructively insert
	public static int[] insert(int[] x, int item, int position) {
		// 创建一个比参数数组大1的数组
		// 将原来的数组分成两部分，0~position-1, position~lenth-1
		int[] array = new int[x.length + 1];
		for(int i = 0; i <= x.length; i++) {
			if(i == position) {
				array[i] = item;
			}else if(i < position){
				array[i] = x[i];
			}else {
				array[i] = x[i - 1];
			}
		}
		return array;
	}
	// reverse the array
	public static void reverse(int[] x) {
		// 首尾两个游标, 交换两个游标的元素后
		// 同时往中间移动
		// 直到 head >= tail 不再移动，程序结束
		int head = 0;
		int tail = x.length - 1;
		while( head < tail) {
			int tmp = x[head];
			x[head] = x[tail];
			x[tail] = tmp;
			head += 1;
			tail -= 1;
		}
	}
	// 用 x[i] 个 x[i] 替换它自己
	public static int[] xify(int[] x) {
		// 统计所有元素的绝对值的和，作为新数组的长度
		// 从原数组头开始读入，循环abs(x[i])次
		int size = 0;
		for(int i : x) {
			size += i;
		}
		int[] array = new int[size];
		int m = 0;
		for(int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i]; j++) {
				array[m] = x[i];
				m += 1;
			}
		}
		return array;
	}
	public static void main(String[] args) {
		int[] array = new int[] {1, 3, 2};
		int[] actual = ArrayInsert.xify(array);
		int[] expected = new int[] {1, 3, 3, 3, 2, 2};
		
	}
	
}
