/**
 * ������ϰ�� ð������ ������  ��������� ѡ�����򣬲���ð������
 * 	1. ��������Ԫ�ؿ�ʼ��
 * @author yiddi
 *
 */
public class SelectionSort {
	
	/*
	 * �ҳ� k ~ TAIL ����λ������С����������������
	 */
	public static int min(int[] A, int k) {
		int min = A[k];	      // Ĭ�ϵ���ֵΪ��Сֵ
		int min_index = k;    // ���浱ǰ���꣬Ĭ����Ϊ��Сֵ�±�
		int index = k+1;      // �����α꣬��k+1 �±꿪ʼ
		while (index < A.length) {
			if (min > A[index]) {
				min = A[index];
				min_index = index;
			}
			index++;
		}                     // ���ѭ��ִ����Ϻ���СԪ���±����min_index��
		return min_index;
	}
	/*
	 * ð��������������
	 * 	1. ����������������С��Ԫ������λ�ã�min()������
	 * 	2. �����һ��Ԫ��������
	 * 	3. �ӵڶ��������һ��Ԫ���ظ�1 2
	 * 	4. �ӵ����������һ��Ԫ���ظ�1 2
	 * 	5. ������
	 */
	public static void selectionSort(int[] A) {
		int index = 0; // �����α�,ͬʱָ��δ����СԪ�ش洢��λ��
		while (index < A.length) {
			int temp = A[index];           // ���浱ǰ������Ԫ��
			int min_index = min(A, index); // �����СԪ������λ��
			A[index] = A[min_index];       // �ҳ���index��tail��С��Ԫ�ط���indexλ��
			A[min_index] = temp;           // ��һ��ʼ�����indexָ��Ԫ�أ������ҵ���СԪ��λ��
			index ++;
		}
	}
	/*
	 * ��ʾ��������
	 */
	public static void dispArray(int[] A) {
		int index = 0;  // �����α�
		while (index < A.length) {
			System.out.print(A[index] + " ");
			index++;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A = new int[] {1,3,5,23,2,4,18,9,0,12,11,98};
		dispArray(A);
		selectionSort(A);
		dispArray(A);
	}
	
}
