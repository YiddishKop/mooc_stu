/**
 * 排序练习：插入排序
 * 插入排序有很多好处，最典型的应用是『把一个新的数字插入一个sorted array的正确位置』
 * 这样可以保证整个数组一直是排过序的
 * @author yiddi
 *
 */
public class InsertionSort {
	/*
	 * Precondition:  itemsInArray is the number of items that are
	 *    stored in A.  These items must be in increasing order
	 *    (A[0] <= A[1] <= ... <= A[itemsInArray-1]).
	 *    The array size is at least one greater than itemsInArray.
	 * Postcondition:  The number of items has increased by one,
	 *    newItem has been added to the array, and all the items
	 *    in the array are still in increasing order.
	 * Note:  To complete the process of inserting an item in the
	 *    array, the variable that counts the number of items
	 *    in the array must be incremented, after calling this
	 *    subroutine.
	 */
	static void insert(int[] A, int itemsIntArray, int newItem) {
		int loc = itemsIntArray - 1;
		
		 /* Move items bigger than newItem up one space;
	    Stop when a smaller item is encountered or when the
	    beginning of the array (loc == 0) is reached. */
		
		while (A[loc] > newItem && loc >= 0) {
			A[loc+1] = A[loc];
			loc--;
		}
		A[loc+1] = newItem;
	}
	public static void insertionSort(int[] A) {
		// Sort the array A into increasing order.
		// 	1. 把整个待排序数组分成两个部分，已排序，待排序，给予其边界标记
		// 	2. 不断把待排序的首个元素插入已排序的适当位置中（loc >=0 && temp < A[loc]）
		// 	3. 确定插入元素的位置后，其余已排序部分往后移动一格，恰好可以占用 待排序的第一个元素
		//     也就是正在插入的这个元素
		int itemsSorted;  // 标记已经排序部分的数量，也恰好是当前待排元素在数组的下标index,初始为1.
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
			int temp = A[itemsSorted];  // 缓存当前元素
			int loc = itemsSorted - 1;  // 已排序部分的上界index，也是需要遍历寻找插入位置的渐变标记
			while(loc >=0 && temp < A[loc]) {
				A[loc + 1] = A[loc];    // 只要发现比当前待排元素大，就往后挪一个位置
				loc--;
			}
			A[loc + 1] = temp;          // 经过上面的循环，loc多向前指了一个位置，所以退回来+1，存储待排元素
		}
	}
	/*
	 * 显示数组内容
	 */
	public static void display(int[] A) {
		int i = 0;
		while (i < A.length) {
			System.out.println(A[i] + " ");
			i++;
		}
	}
	/*
	 * 产生一个随机数组,并且把数组最后的位置留出来用作
	 * 检测『插入排序』
	 */
	public static void randArray(int[] A) {
		int i = 0;
		while (i<A.length) {
			A[i] = (int) (Math.random()*100);
			System.out.println(A[i]);
			i++;
		}
	}
	public static void main(String[] args) {
		int[] A = new int[11];
		randArray(A);
		insertionSort(A);
		display(A);
	}
	
}
