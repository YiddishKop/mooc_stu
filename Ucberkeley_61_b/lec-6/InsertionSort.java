/**
 * ������ϰ����������
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
		// 	1. ����������������ֳ��������֣������򣬴����򣬸�����߽���
		// 	2. ���ϰѴ�������׸�Ԫ�ز�����������ʵ�λ���У�loc >=0 && temp < A[loc]��
		// 	3. ȷ������Ԫ�ص�λ�ú����������򲿷������ƶ�һ��ǡ�ÿ���ռ�� ������ĵ�һ��Ԫ��
		//     Ҳ�������ڲ�������Ԫ��
		int itemsSorted;  // ����Ѿ����򲿷ֵ�������Ҳǡ���ǵ�ǰ����Ԫ����������±�index,��ʼΪ1.
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
			int temp = A[itemsSorted];  // ���浱ǰԪ��
			int loc = itemsSorted - 1;  // �����򲿷ֵ��Ͻ�index��Ҳ����Ҫ����Ѱ�Ҳ���λ�õĽ�����
			while(loc >=0 && temp < A[loc]) {
				A[loc + 1] = A[loc];    // ֻҪ���ֱȵ�ǰ����Ԫ�ش󣬾�����Ųһ��λ��
				loc--;
			}
			A[loc + 1] = temp;          // ���������ѭ����loc����ǰָ��һ��λ�ã������˻���+1���洢����Ԫ��
		}
	}
	/*
	 * ��ʾ��������
	 */
	public static void display(int[] A) {
		int i = 0;
		while (i < A.length) {
			System.out.println(A[i] + " ");
			i++;
		}
	}
	/*
	 * ����һ���������,���Ұ���������λ������������
	 * ��⡺��������
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
