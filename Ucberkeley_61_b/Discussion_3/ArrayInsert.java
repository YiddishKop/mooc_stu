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
		// ����һ���Ȳ��������1������
		// ��ԭ��������ֳ������֣�0~position-1, position~lenth-1
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
		// ��β�����α�, ���������α��Ԫ�غ�
		// ͬʱ���м��ƶ�
		// ֱ�� head >= tail �����ƶ����������
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
	// �� x[i] �� x[i] �滻���Լ�
	public static int[] xify(int[] x) {
		// ͳ������Ԫ�صľ���ֵ�ĺͣ���Ϊ������ĳ���
		// ��ԭ����ͷ��ʼ���룬ѭ��abs(x[i])��
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
