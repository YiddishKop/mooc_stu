
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
		Comparable[] tmp = new Comparable[a.length];           // tmp������������������鱣��һ����
		                                                       // ����tmp����������������ڵݹ��������������
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
                tmp[k++] = a[left++];                  // TODO һ���ܳ��õ���ϼ����������˼�ǣ��ȶ�k��left���д��������ٸ��Լ�1
            else
                tmp[k++] = a[right++];
                                                       // ���ѭ��������tmp�����д�ŵ�������õ�Ԫ�أ���
                                                       // ������ȫ������Ϊ��left��right��һ���ߵ�ͷʱ��ѭ����ֹͣ��
                                                       // ��������Ҫ����һ������ʣ�µ�Ԫ�ؿ�����tmp������
                                                       // ��ʱ k ָ��tmp�еĿ��пռ䣬right����leftָ���һ����������
                                                       // tmp��λ����
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
		// �󲿷��������Ķ�Ҫ���½��α�����־����������
    	// �� mergesort �� quicksort �������õݹ�ʵ��
    	// mergesort �ǲ��Ͼ������飬�ֵ������ٷ֣���ʼ�ϲ����ϲ����̰�������
    	// quicksort ��������ѡһ��pivot���Ѵ���pivot�ķ����ұߣ�С��pivot�ķ�
    	//           ����ߣ���˷ֳ����������飬ͬʱ����ȷ����pivot��λ�á�
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
    	// merge �������ϲ����������������飬������Ҫ�� midIndex ��Ϊ�ֽ��־
    	// ������ʵ�ֵķ�ʽ���Ʋ�������
    	
    }
    
 }