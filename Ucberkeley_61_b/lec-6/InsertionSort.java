/**
 * ����������ϰ
 * ���������кܶ�ô�������͵�Ӧ���ǡ���һ���µ����ֲ���һ��sorted array����ȷλ�á�
 * �������Ա�֤��������һֱ���Ź����
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
		// ����������������ֳ��������֣������򣬴����򣬸�����߽���
		int itemsSorted = 0; // itemSorted ��ָ�Ѿ����������Ԫ�ص�����
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
