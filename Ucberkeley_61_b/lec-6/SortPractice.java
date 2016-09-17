/**
 * 练习排序算法： 
 * 排序算法一定要把数组划分为 unsorted 和 sorted 部分
 * 并用索引标记出边界
 * 1.冒泡：不断把待排序的最小数字从后往前挪到sorted的末尾
 * 2.插入：不断把 unsorted 的首个元素插入 sorted 的适当位置
 * 3.选择：不断从 unsorted 选择最小放在 unsorted 的首位
 * 4.快速：pivot 把数组分成左右两个部分 包含(quicksortStep返回pivot在数组中的位置)  5千万int 用时60s
 * 5.归并：不断二分，再不断归并 包含(mergeStep)， 归并毫无疑问是最快的， 5千万int 用时 10s
 * ----- map2id 是把 算法 名字 映射到 id，然后匹配 switch 来决定使用哪个排序算法（整复杂了）
 * ----- 可以通过 testSort() 函数来更改待排序数组大小，来查看各个算法的排序效率
 */
public class SortPractice {
	public static void bubbleSort(int[] A) {
		int index = 0;                        // 数组游标
//		int tail = A.length - 1;              // TODO 一开始tail的初始化放在这里，这是肯定不对的，
		                                      // TODO 因为tail的位置每次都要重置到数组尾部表示数组最后的位置
		int tmp;
		while(index < A.length) {
			int tail = A.length - 1;
			while(tail > index) {            // TODO 这里的标记一定不能是 >=,而只能是 >，否则越界
				if(A[tail] < A[tail-1]) {
					tmp = A[tail];
					A[tail] = A[tail-1];
					A[tail-1] = tmp;
				}
				tail--;
			}                                // 这个循环执行完毕，把unsorted中最小的元素换到index位置
			index++;
		}
	}
	public static void insertSort(int[] A) {                   // unsorted_lo标记的是 unsorted 数组首位
		int unsorted_lo;                                       // 默认数组首元素是sorted的
		for (unsorted_lo = 1 ; unsorted_lo < A.length; unsorted_lo++) {
			int tmp = A[unsorted_lo];                          // 缓存 unsorted 数组首位置元素，方便之后挪动元素
			int index = unsorted_lo - 1;                       // index是已排序部分的递减游标
			while(index >= 0 && A[index] >= tmp) {             // TODO 一开始我用的是 A[unsorted_lo] 而不是tmp，但是A[unsorted_lo]会被覆盖，不能用
				A[index + 1] = A[index];
				index--;
			}                                                  // 这个循环，边比较大小，边挪动元素。执行结束后
			                                                   // 要么index为-1，要么index指向了第一个 小于待
			                                                   // 排元素的位置,且其他元素已经向后移动一格,index+1位置是空闲空间
			A[index + 1] = tmp;
		}
	}
	public static void selectionSort(int[] A) {
		selectionSort(A, 0, A.length-1);
	}
	public static void selectionSort(int[] A, int lo, int hi) {
		int tmp;                                                      // 用来缓存最小值，方便min与lo交换元素
		while(lo < hi) {	
			int index = lo;                                           // 待排序数组递增游标
			int min = lo;                                             // TODO 这一句当时做的时候忘记了，导致min指向错乱
			while(index <= hi) {
				if (A[min] > A[index]) {
					min = index;
				}
				index ++;
			}                                                          // 循环后，min指向从lo到hi之间最小的元素的位置
			tmp = A[lo];                                               // 下面要做的是交换lo和min所指元素
			A[lo] = A[min];
			A[min] = tmp;
			lo ++;
		}
	}
 	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	public static void quickSort(int[] A, int lo, int hi) {            // 同样需要用 lo 和 hi，标记处待处理的范围
		if (lo >= hi) {
			return;
		}else {
			int pivot_index = quickSortStep(A, lo, hi);
			quickSort(A, lo, pivot_index - 1);
			quickSort(A, pivot_index + 1, hi);
		}
		
	}
	public static int quickSortStep(int[] A, int lo, int hi) {
		int pivot = A[lo];                                             // 默认使用待排序的首元素作为 PIVOT，那么必须从hi开始往中间斗
		                                                               // 因为 lo 这里指向一个空闲空间（pivot缓存了首元素）
		while(lo < hi) {
			while(A[hi] > pivot && lo < hi) {
				hi--;
			}                                                          // hi 向左移动，循环结束停在第一个小于PIVOT的位置上
			if(hi == lo) break; //TODO 之前这一句没加上，产生数组越界
			A[lo] = A[hi];                                             // 把这个元素赋值给lo的空闲空间，这样hi指向的空间可用了
			lo++;                                                      // 由于此时lo指向的是刚才hi赋值过来的小于pivot的元素，所以不用判断，自增1
			while(A[lo] <= pivot && lo < hi) {
				lo++;
			}
			if(hi == lo) break; //TODO 之前这一句没加上，产生数组越界
			A[hi] = A[lo];
			hi--;
		}                                                              // 外层这个循环循环一次，就是 hi 向左移动到第一个 < pivot 的位置上
		                                                               // lo 向右移动到第一个 > pivot 的位置上，并且最后空闲的位置由lo指向
		A[lo] = pivot;          //TODO 这一句也给忘记了，卧槽
		return lo;
	}
	public static void mergeSort(int[] A) {
		int[] tmp = new int[A.length];
		mergeSort(A, tmp, 0, A.length-1);
	}
	public static void mergeSort(int[] A, int[] tmp, int lo, int hi) {  // lo hi 标记出了待处理的数组的范围，先二分
		                                                                // 二分到 lo 和 hi 指向一个元素时，无法再细分
		if (lo == hi) {
			return;
		}else {
			int mid = (lo + hi)/2;
			mergeSort(A, tmp, lo, mid);
			mergeSort(A, tmp, mid + 1, hi);
			mergeStep(A, tmp, lo, mid, hi);
		}
	}
	public static void mergeStep(int[] A, int[] tmp, int lo, int mid, int hi) {
		int k = lo;                             // 标记 tmp 数组的起始位置
		int lo_start = lo;                      // 因为还要把tmp数组内容再拷贝回原数组中，所以lo不能移动，这里引入
		                                        // 游标 lo_start
		int lo_end = mid;
		int hi_start = mid + 1;
		int hi_end = hi;
		while(lo_start <= lo_end && hi_start <= hi_end) {
			if (A[lo_start] <= A[hi_start]) {
				tmp[k++] = A[lo_start++];
			}else {
				tmp[k++] = A[hi_start++];
			}
		}                                       // 这个循环执行完毕后，tmp中有排序好的部分数组但不完整，需要拷贝剩下的
		                                        // ，且执行完后，k指向tmp中的一个空闲位置，hi_start 或 lo 指向的是剩下
		                                        // 需要拷贝的部分的首部，但是不知道是lo走完了还是hi_start走完了，所以
		                                        // 需要判定一下
		while(lo_start <= lo_end) {
			tmp[k++] = A[lo_start++];
		}
		while(hi_start <= hi_end) {
			tmp[k++] = A[hi_start++];
		}                                       // 这两个循环执行完后，tmp数组中有完整的sorted元素，且k hi_start lo 都处在
		                                        // “超越本来数组的越界（+1）状态”
		while(lo <= hi) {
			A[lo] = tmp[lo];
			lo++;
		}                                       // tmp数组拷回原数组中
	}
	public static void display(int[] A) {
		for(int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static int map2id(String sortMethod) {
		if(sortMethod == "mergeSort") {
			return 0;
		}else if(sortMethod == "quickSort") {
			return 1;
		}else if(sortMethod == "selectionSort") {
			return 2;
		}else if(sortMethod == "insertSort") {
			return 3;
		}else 
			return 4;
	}
	public static void testSort(String sortMethod) {
		int[] A = new int[20000000];
		for(int i = 0; i<A.length; i++) {
			A[i] = (int)(Math.random()*10000);
		}
		int sort_id = map2id(sortMethod);
		switch(sort_id) {
		case 0:
			System.out.println("This is mergeSort!");
//			display(A);
			mergeSort(A);
//			display(A);
			break;
		case 1:
			System.out.println("This is quickSort!");
//			display(A);
			quickSort(A);
//			display(A);
			break;
		case 2:
			System.out.println("This is selectionSort!");
			display(A);
			selectionSort(A);
			display(A);
			break;
		case 3:
			System.out.println("This is insertSort!");
			display(A);
			insertSort(A);
			display(A);
			break;
		case 4:
			System.out.println("This is bubbleSort!");
			display(A);
			bubbleSort(A);
			display(A);
			break;
			
		}
	}
	public static void main(String[] args) {
		long start=System.currentTimeMillis(); //获取开始时间
		testSort("mergeSort");
		long end=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(end-start)+"ms"); 
		
		start=System.currentTimeMillis(); //获取开始时间
		testSort("quickSort");
		end=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(end-start)+"ms"); 
		
//		start=System.currentTimeMillis(); //获取开始时间
//		testSort("selectionSort");
//		end=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(end-start)+"ms"); 
//		
//		start=System.currentTimeMillis(); //获取开始时间
//		testSort("insertSort");
//		end=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(end-start)+"ms"); 
//		
//		start=System.currentTimeMillis(); //获取开始时间
//		testSort("bubbleSort");
//		end=System.currentTimeMillis(); //获取结束时间
//		System.out.println("程序运行时间： "+(end-start)+"ms"); 
	}
}
