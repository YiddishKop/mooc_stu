/**
 * 排序练习： 冒泡排序 ！！！  这个好像是 选择排序，不是冒泡排序
 * 	1. 从数组首元素开始，
 * @author yiddi
 *
 */
public class SelectionSort {
	
	/*
	 * 找出 k ~ TAIL 数组位置中最小的数，返回其索引
	 */
	public static int min(int[] A, int k) {
		int min = A[k];	      // 默认当下值为最小值
		int min_index = k;    // 缓存当前坐标，默认其为最小值下标
		int index = k+1;      // 数组游标，从k+1 下标开始
		while (index < A.length) {
			if (min > A[index]) {
				min = A[index];
				min_index = index;
			}
			index++;
		}                     // 这个循环执行完毕后，最小元素下标存在min_index中
		return min_index;
	}
	/*
	 * 冒泡排序整个数组
	 * 	1. 从整个数组中找最小的元素所在位置（min()方法）
	 * 	2. 并与第一个元素做交换
	 * 	3. 从第二个到最后一个元素重复1 2
	 * 	4. 从第三个到最后一个元素重复1 2
	 * 	5. 。。。
	 */
	public static void selectionSort(int[] A) {
		int index = 0; // 数组游标,同时指向未来最小元素存储的位置
		while (index < A.length) {
			int temp = A[index];           // 缓存当前待交换元素
			int min_index = min(A, index); // 存放最小元素所在位置
			A[index] = A[min_index];       // 找出从index到tail最小的元素放在index位置
			A[min_index] = temp;           // 把一开始缓存的index指向元素，放在找到最小元素位置
			index ++;
		}
	}
	/*
	 * 显示整个数组
	 */
	public static void dispArray(int[] A) {
		int index = 0;  // 数组游标
		while (index < A.length) {
			System.out.print(A[index] + " ");
			index++;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A = new int[] {1,3,5,23,2,4,18,9,0,12,11,98};
		dispArray(A);
		selectionSort(A);
		dispArray(A);
	}
	
}
