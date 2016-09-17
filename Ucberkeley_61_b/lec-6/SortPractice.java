/**
 * ��ϰ�����㷨�� 
 * �����㷨һ��Ҫ�����黮��Ϊ unsorted �� sorted ����
 * ����������ǳ��߽�
 * 1.ð�ݣ����ϰѴ��������С���ִӺ���ǰŲ��sorted��ĩβ
 * 2.���룺���ϰ� unsorted ���׸�Ԫ�ز��� sorted ���ʵ�λ��
 * 3.ѡ�񣺲��ϴ� unsorted ѡ����С���� unsorted ����λ
 * 4.���٣�pivot ������ֳ������������� ����(quicksortStep����pivot�������е�λ��)  5ǧ��int ��ʱ60s
 * 5.�鲢�����϶��֣��ٲ��Ϲ鲢 ����(mergeStep)�� �鲢�������������ģ� 5ǧ��int ��ʱ 10s
 * ----- map2id �ǰ� �㷨 ���� ӳ�䵽 id��Ȼ��ƥ�� switch ������ʹ���ĸ������㷨���������ˣ�
 * ----- ����ͨ�� testSort() ���������Ĵ����������С�����鿴�����㷨������Ч��
 */
public class SortPractice {
	public static void bubbleSort(int[] A) {
		int index = 0;                        // �����α�
//		int tail = A.length - 1;              // TODO һ��ʼtail�ĳ�ʼ������������ǿ϶����Եģ�
		                                      // TODO ��Ϊtail��λ��ÿ�ζ�Ҫ���õ�����β����ʾ��������λ��
		int tmp;
		while(index < A.length) {
			int tail = A.length - 1;
			while(tail > index) {            // TODO ����ı��һ�������� >=,��ֻ���� >������Խ��
				if(A[tail] < A[tail-1]) {
					tmp = A[tail];
					A[tail] = A[tail-1];
					A[tail-1] = tmp;
				}
				tail--;
			}                                // ���ѭ��ִ����ϣ���unsorted����С��Ԫ�ػ���indexλ��
			index++;
		}
	}
	public static void insertSort(int[] A) {                   // unsorted_lo��ǵ��� unsorted ������λ
		int unsorted_lo;                                       // Ĭ��������Ԫ����sorted��
		for (unsorted_lo = 1 ; unsorted_lo < A.length; unsorted_lo++) {
			int tmp = A[unsorted_lo];                          // ���� unsorted ������λ��Ԫ�أ�����֮��Ų��Ԫ��
			int index = unsorted_lo - 1;                       // index�������򲿷ֵĵݼ��α�
			while(index >= 0 && A[index] >= tmp) {             // TODO һ��ʼ���õ��� A[unsorted_lo] ������tmp������A[unsorted_lo]�ᱻ���ǣ�������
				A[index + 1] = A[index];
				index--;
			}                                                  // ���ѭ�����߱Ƚϴ�С����Ų��Ԫ�ء�ִ�н�����
			                                                   // ҪôindexΪ-1��Ҫôindexָ���˵�һ�� С�ڴ�
			                                                   // ��Ԫ�ص�λ��,������Ԫ���Ѿ�����ƶ�һ��,index+1λ���ǿ��пռ�
			A[index + 1] = tmp;
		}
	}
	public static void selectionSort(int[] A) {
		selectionSort(A, 0, A.length-1);
	}
	public static void selectionSort(int[] A, int lo, int hi) {
		int tmp;                                                      // ����������Сֵ������min��lo����Ԫ��
		while(lo < hi) {	
			int index = lo;                                           // ��������������α�
			int min = lo;                                             // TODO ��һ�䵱ʱ����ʱ�������ˣ�����minָ�����
			while(index <= hi) {
				if (A[min] > A[index]) {
					min = index;
				}
				index ++;
			}                                                          // ѭ����minָ���lo��hi֮����С��Ԫ�ص�λ��
			tmp = A[lo];                                               // ����Ҫ�����ǽ���lo��min��ָԪ��
			A[lo] = A[min];
			A[min] = tmp;
			lo ++;
		}
	}
 	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	public static void quickSort(int[] A, int lo, int hi) {            // ͬ����Ҫ�� lo �� hi����Ǵ�������ķ�Χ
		if (lo >= hi) {
			return;
		}else {
			int pivot_index = quickSortStep(A, lo, hi);
			quickSort(A, lo, pivot_index - 1);
			quickSort(A, pivot_index + 1, hi);
		}
		
	}
	public static int quickSortStep(int[] A, int lo, int hi) {
		int pivot = A[lo];                                             // Ĭ��ʹ�ô��������Ԫ����Ϊ PIVOT����ô�����hi��ʼ���м䶷
		                                                               // ��Ϊ lo ����ָ��һ�����пռ䣨pivot��������Ԫ�أ�
		while(lo < hi) {
			while(A[hi] > pivot && lo < hi) {
				hi--;
			}                                                          // hi �����ƶ���ѭ������ͣ�ڵ�һ��С��PIVOT��λ����
			if(hi == lo) break; //TODO ֮ǰ��һ��û���ϣ���������Խ��
			A[lo] = A[hi];                                             // �����Ԫ�ظ�ֵ��lo�Ŀ��пռ䣬����hiָ��Ŀռ������
			lo++;                                                      // ���ڴ�ʱloָ����Ǹղ�hi��ֵ������С��pivot��Ԫ�أ����Բ����жϣ�����1
			while(A[lo] <= pivot && lo < hi) {
				lo++;
			}
			if(hi == lo) break; //TODO ֮ǰ��һ��û���ϣ���������Խ��
			A[hi] = A[lo];
			hi--;
		}                                                              // ������ѭ��ѭ��һ�Σ����� hi �����ƶ�����һ�� < pivot ��λ����
		                                                               // lo �����ƶ�����һ�� > pivot ��λ���ϣ����������е�λ����loָ��
		A[lo] = pivot;          //TODO ��һ��Ҳ�������ˣ��Բ�
		return lo;
	}
	public static void mergeSort(int[] A) {
		int[] tmp = new int[A.length];
		mergeSort(A, tmp, 0, A.length-1);
	}
	public static void mergeSort(int[] A, int[] tmp, int lo, int hi) {  // lo hi ��ǳ��˴����������ķ�Χ���ȶ���
		                                                                // ���ֵ� lo �� hi ָ��һ��Ԫ��ʱ���޷���ϸ��
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
		int k = lo;                             // ��� tmp �������ʼλ��
		int lo_start = lo;                      // ��Ϊ��Ҫ��tmp���������ٿ�����ԭ�����У�����lo�����ƶ�����������
		                                        // �α� lo_start
		int lo_end = mid;
		int hi_start = mid + 1;
		int hi_end = hi;
		while(lo_start <= lo_end && hi_start <= hi_end) {
			if (A[lo_start] <= A[hi_start]) {
				tmp[k++] = A[lo_start++];
			}else {
				tmp[k++] = A[hi_start++];
			}
		}                                       // ���ѭ��ִ����Ϻ�tmp��������õĲ������鵫����������Ҫ����ʣ�µ�
		                                        // ����ִ�����kָ��tmp�е�һ������λ�ã�hi_start �� lo ָ�����ʣ��
		                                        // ��Ҫ�����Ĳ��ֵ��ײ������ǲ�֪����lo�����˻���hi_start�����ˣ�����
		                                        // ��Ҫ�ж�һ��
		while(lo_start <= lo_end) {
			tmp[k++] = A[lo_start++];
		}
		while(hi_start <= hi_end) {
			tmp[k++] = A[hi_start++];
		}                                       // ������ѭ��ִ�����tmp��������������sortedԪ�أ���k hi_start lo ������
		                                        // ����Խ���������Խ�磨+1��״̬��
		while(lo <= hi) {
			A[lo] = tmp[lo];
			lo++;
		}                                       // tmp���鿽��ԭ������
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
		long start=System.currentTimeMillis(); //��ȡ��ʼʱ��
		testSort("mergeSort");
		long end=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 "+(end-start)+"ms"); 
		
		start=System.currentTimeMillis(); //��ȡ��ʼʱ��
		testSort("quickSort");
		end=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("��������ʱ�䣺 "+(end-start)+"ms"); 
		
//		start=System.currentTimeMillis(); //��ȡ��ʼʱ��
//		testSort("selectionSort");
//		end=System.currentTimeMillis(); //��ȡ����ʱ��
//		System.out.println("��������ʱ�䣺 "+(end-start)+"ms"); 
//		
//		start=System.currentTimeMillis(); //��ȡ��ʼʱ��
//		testSort("insertSort");
//		end=System.currentTimeMillis(); //��ȡ����ʱ��
//		System.out.println("��������ʱ�䣺 "+(end-start)+"ms"); 
//		
//		start=System.currentTimeMillis(); //��ȡ��ʼʱ��
//		testSort("bubbleSort");
//		end=System.currentTimeMillis(); //��ȡ����ʱ��
//		System.out.println("��������ʱ�䣺 "+(end-start)+"ms"); 
	}
}
