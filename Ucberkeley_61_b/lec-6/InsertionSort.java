/**
 * 插入排序练习
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
		// 把整个待排序数组分成两个部分，已排序，待排序，给予其边界标记
		int itemsSorted = 0; // itemSorted 是指已经排序的数组元素的数量
		while (itemsSorted < A.length) {
			insert(A, itemsSorted+1, A[itemsSorted]);
			itemsSorted++;
		}
	}
	public static void display(int[] A) {
		int i = 0;
		while (i < A.length) {
			System.out.print(A[i] + " ");
		}
	}
	public static void main(String[] args) {
		int[] A = new int[] {23,3,1,5,9,4,15,35,23,0,4};
		display(A);
		insertionSort(A);
		display(A);
	}
	
}
