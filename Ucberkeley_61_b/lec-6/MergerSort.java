
import java.util.Arrays;

public class MergerSort
{
	public static void main(String[] args)
	{
		Integer[] a = {2, 6, 3, 5, 1};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void mergeSort(Comparable [ ] a)
	{
		Comparable[] tmp = new Comparable[a.length];           // tmp数组与待排序整个数组保持一样大
		                                                       // 而且tmp数组与待排序数组在递归过程中索引共用
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(Comparable [ ] a, Comparable [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(Comparable[ ] a, Comparable[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left].compareTo(a[right]) <= 0)
                tmp[k++] = a[left++];                  // TODO 一个很常用的组合技，这里的意思是：先对k和left进行处理，而后再各自加1
            else
                tmp[k++] = a[right++];
                                                       // 这个循环结束后，tmp数组中存放的是排序好的元素，但
                                                       // 并不是全部，因为在left或right有一个走到头时，循环就停止了
                                                       // 所以下面要把另一个部分剩下的元素拷贝进tmp数组中
                                                       // 此时 k 指向tmp中的空闲空间，right或者left指向第一个待拷贝进
                                                       // tmp的位置上
        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
    
    public void mergeSort(int[] list) {
    	mergeSort(list, 0, list.length-1);
    }
    public void mergeSort(int[] list, int lowIndex, int highIndex) {
		// 大部分针对数组的都要上下界游标来标志待处理数据
    	// 对 mergesort 和 quicksort 都是利用递归实现
    	// mergesort 是不断均分数组，分到不能再分，开始合并（合并过程包含排序）
    	// quicksort 是随意挑选一个pivot，把大于pivot的放在右边，小于pivot的放
    	//           在左边，如此分成两个子数组，同时最终确定了pivot的位置。
    	if(lowIndex == highIndex) {
    		return;
    	}else {
    		int midIndex = (lowIndex + highIndex)/2;
    		mergeSort(list, lowIndex, midIndex);
    		mergeSort(list, midIndex + 1, highIndex);
    		mergesortStep(list, lowIndex, midIndex + 1, highIndex);
    	}
	}
    public void mergesortStep(int[] list, int lowIndex, int midIndex, int highIndex) {
    	// merge 是用来合并两个待处理子数组，所以需要用 midIndex 作为分界标志
    	// 我这里实现的方式类似插入排序
    	
    }
    
 }