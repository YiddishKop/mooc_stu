/**
 * ������ϰ����������
 *  **** QuickSortStep ****
 * 	1. �����һ�� Pivot
 * 	2. �Ѵ���Pivot�ķ�������ǰ��
 * 	3. ��С��Pivot�ķ����������
 * 	4. ��Pivot��������֮�䣬�����Pivot���յ�λ��
 * 	ע�� 1~4 ���� QuickSortStep�� ���ŵ��ٶȾ�����й�
 * @author yiddi
 *
 */
public class QuickSort {
	/**
	 * Apply QuicksortStep to the list of items in locations lo through hi 
	 * in the array A.  The value returned by this routine is the final 
	 * position of the pivot item in the array.
	 */                                                            // ��quicksortStep()��һ�ε��ÿ���ȷ��һ��Ԫ�ص�׼ȷλ��
	                                                               // ��������ָ������δȷ��λ�õ������顣
	public static int quicksortStep(int[] A, int lo, int hi) {     // lo ~ hi ֮���� unsorted numbers
		
		int pivot = A[lo];                                         // Ĭ��lo��Ԫ��ΪPivot��������֮����ʱloָ��һ�����ÿռ�
	    // The numbers hi and lo mark the endpoints of a range
	    // of numbers that have not yet been tested.  Decrease hi  // ���м䶷
	    // and increase lo until they become equal, moving numbers
	    // bigger than pivot so that they lie above hi and moving
	    // numbers less than the pivot so that they lie below lo.
	    // When we begin, A[lo] is an available space, since its   // ��Ϊ�ѻ��棬���Կճ���һ��
	    // value has been moved into the local variable, pivot.
		while (hi > lo) {
			while (hi > lo && A[hi] > pivot) {
	            // Move hi down past numbers greater than pivot.
	            // These numbers do not have to be moved.
				hi--;                                              // �� pivot ������ pivot ����ľͲ����ƶ���
			}                                                      // hi�����ƶ�ͣ�ڵ�һ���� pivot С��Ԫ�ص�λ����
			if(hi == lo) break;                                    // �����ʱ hi == lo ˵��lo����λ�þ�������λ�ã���Ϊ���д�Ķ����ұߣ�lo����С
	        // The number A[hi] is less than pivot.  Move it into
	        // the available space at A[lo], leaving an available
	        // space at A[hi].
			A[lo] = A[hi];                                         // ��Ϊhiͣ�ڱ� pivot С��Ԫ��λ���ϣ���Ԫ�طŵ�loλ���ϣ���ʱhiָ��һ�����ÿռ�
			lo++;                                                  // lo �����ϣ���һ��λ��
			while (hi > lo && A[lo] <= pivot) {
	            // Move lo up past numbers less than pivot.
	            // These numbers do not have to be moved.
				lo++;  // ��pivot С������pivot ǰ��ľͲ����ƶ���
			}                                                      // lo�����ƶ�ͣ�ڵ�һ���� pivot ���Ԫ�ص�λ����
			if(hi == lo) break;
		    // The number A[lo] is greater than pivot.  Move it into
		    // the available space at A[hi], leaving an available
		    // space at A[lo].
			A[hi] = A[lo];                                         // �ѱ� pivot ���Ԫ��Ų��hiָ��Ŀռ䣬lo��ʱָ��һ�����ÿռ�
			hi--;                                                  // ��һ��hi��ָΪ���� pivot ��λ�ã��������£���һ��
		} // End while                                             // ������ѭ��ÿִ��һ�Σ�lo��ָ��һ�����ÿռ�
	    // At this point, lo has become equal to hi, and there is
	    // an available space at that position.  This position lies
	    // between numbers less than pivot and numbers greater than
	    // pivot.  Put pivot in this space and return its location.
		A[lo] = pivot;                                             
		return lo;
	} // End quicksortStep
	
	/**
	 * Apply quicksort to put the array elements between
	 * position lo and position hi into increasing order.
	 */
	public static void quicksort(int[] A, int lo, int hi) {
		if (hi <= lo) {
		    // The list has length one or zero.  Nothing needs
		    // to be done, so just return from the subroutine.
		    return;
		 }
		 else {
		    // Apply quicksortStep and get the new pivot position.
		    // Then apply quicksort to sort the items that
		    // precede the pivot and the items that follow it.
		    int pivotPosition = quicksortStep(A, lo, hi);
		    quicksort(A, lo, pivotPosition - 1);
		    quicksort(A, pivotPosition + 1, hi);
		 }
	}
	
	
}
