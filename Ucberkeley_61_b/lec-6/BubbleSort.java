/**
 * 排序练习：冒泡排序
 * 	1. 从TAIL比较相邻两个数字大小，把小的移到左边
 * 	2. 直到最小的移动到开头，如此一来首位置确定
 * 	3. 再从TAIL。。。到第二位置
 * @author yiddi
 *
 */
public class BubbleSort {
	public static void bubbleSort(int[] A) {
		int index;  //数组游标
		for(index = 0; index < A.length; index++) {
			int bubble_index = A.length-1;  // bubble_index 指向数组末尾
			                                // 每次bubble_index 都与前面一个元素比较大小
			while(bubble_index > index) {
				if (A[bubble_index] < A[bubble_index-1]) {
					int tmp = A[bubble_index];
					A[bubble_index] = A[bubble_index-1];
					A[bubble_index-1] = tmp;
				}
				bubble_index--;
			}                               // 这个循环执行完毕，就确定了index所指是最小的
		}
	}
	public static void display(int[] A) {
		for(int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A = new int[] {12,1,3,2,9,7,5,10,0};
		display(A);
		bubbleSort(A);
		display(A);
	}
}
