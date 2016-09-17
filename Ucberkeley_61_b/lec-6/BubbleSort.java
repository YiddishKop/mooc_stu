/**
 * ������ϰ��ð������
 * 	1. ��TAIL�Ƚ������������ִ�С����С���Ƶ����
 * 	2. ֱ����С���ƶ�����ͷ�����һ����λ��ȷ��
 * 	3. �ٴ�TAIL���������ڶ�λ��
 * @author yiddi
 *
 */
public class BubbleSort {
	public static void bubbleSort(int[] A) {
		int index;  //�����α�
		for(index = 0; index < A.length; index++) {
			int bubble_index = A.length-1;  // bubble_index ָ������ĩβ
			                                // ÿ��bubble_index ����ǰ��һ��Ԫ�رȽϴ�С
			while(bubble_index > index) {
				if (A[bubble_index] < A[bubble_index-1]) {
					int tmp = A[bubble_index];
					A[bubble_index] = A[bubble_index-1];
					A[bubble_index-1] = tmp;
				}
				bubble_index--;
			}                               // ���ѭ��ִ����ϣ���ȷ����index��ָ����С��
		}
	}
	public static void display(int[] A) {
		for(int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] A = new int[] {12,1,3,2,9,7,5,10,0};
		display(A);
		bubbleSort(A);
		display(A);
	}
}
