/**
 * 排序练习：快速排序
 *  **** QuickSortStep ****
 * 	1. 随便找一个 Pivot
 * 	2. 把大于Pivot的放在数组前面
 * 	3. 把小于Pivot的放在数组后面
 * 	4. 把Pivot放在他们之间，这就是Pivot最终的位置
 * 	注： 1~4 叫做 QuickSortStep， 快排的速度就与此有关
 * @author yiddi
 *
 */
public class QuickSort {
	/**
	 * Apply QuicksortStep to the list of items in locations lo through hi 
	 * in the array A.  The value returned by this routine is the final 
	 * position of the pivot item in the array.
	 */                                                            // 对quicksortStep()的一次调用可以确定一个元素的准确位置
	                                                               // 并把数组分割成两个未确定位置的子数组。
	public static int quicksortStep(int[] A, int lo, int hi) {     // lo ~ hi 之间是 unsorted numbers
		
		int pivot = A[lo];                                         // 默认lo的元素为Pivot，并缓存之，此时lo指向一个可用空间
	    // The numbers hi and lo mark the endpoints of a range
	    // of numbers that have not yet been tested.  Decrease hi  // 往中间斗
	    // and increase lo until they become equal, moving numbers
	    // bigger than pivot so that they lie above hi and moving
	    // numbers less than the pivot so that they lie below lo.
	    // When we begin, A[lo] is an available space, since its   // 因为已缓存，所以空出来一个
	    // value has been moved into the local variable, pivot.
		while (hi > lo) {
			while (hi > lo && A[hi] > pivot) {
	            // Move hi down past numbers greater than pivot.
	            // These numbers do not have to be moved.
				hi--;                                              // 比 pivot 大，又在 pivot 后面的就不用移动了
			}                                                      // hi向左移动停在第一个比 pivot 小的元素的位置上
			if(hi == lo) break;                                    // 如果此时 hi == lo 说明lo所在位置就是最终位置，因为所有大的都在右边，lo是最小
	        // The number A[hi] is less than pivot.  Move it into
	        // the available space at A[lo], leaving an available
	        // space at A[hi].
			A[lo] = A[hi];                                         // 因为hi停在比 pivot 小的元素位置上，把元素放到lo位置上，此时hi指向一个可用空间
			lo++;                                                  // lo 向左（上）进一个位置
			while (hi > lo && A[lo] <= pivot) {
	            // Move lo up past numbers less than pivot.
	            // These numbers do not have to be moved.
				lo++;  // 比pivot 小，又在pivot 前面的就不用移动了
			}                                                      // lo向右移动停在第一个比 pivot 大的元素的位置上
			if(hi == lo) break;
		    // The number A[lo] is greater than pivot.  Move it into
		    // the available space at A[hi], leaving an available
		    // space at A[lo].
			A[hi] = A[lo];                                         // 把比 pivot 大的元素挪到hi指向的空间，lo此时指向一个可用空间
			hi--;                                                  // 上一步hi所指为大于 pivot 的位置，所以左（下）移一格
		} // End while                                             // 这个外层循环每执行一次，lo都指向一个可用空间
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
