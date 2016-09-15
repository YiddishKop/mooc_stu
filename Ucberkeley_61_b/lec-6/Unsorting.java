/**
 * ������ϰ�� �����򣨴��ҡ�ϴ�ƣ�
 * @author yiddi
 *
 */
public class Unsorting {
	/*
	 *  1. ���ϰ�һ�� 0 ~ TAIL-1 ���λ���ϵ�Ԫ���� TAIL Ԫ�ؽ���
	 *  2. ���ϰ�һ�� 0 ~ TAIL-2 ���λ���ϵ�Ԫ���� TAIL - 1Ԫ�ؽ���
	 *  3. ��������
	 */
	public static void shuffle (int[] A) {
		int index;  // �����α�
		for (index = A.length-1; index > 0 ; index--) {
			int temp = A[index];      // �����α���ָԪ��
			int rand_index = (int)(Math.random()*(index+1));   // ������Head��Index���λ��
			System.out.println("Random location is : " + rand_index);
			A[index] = A[rand_index];
			A[rand_index] = temp;     // ���λ����indexԪ�ؽ��� 
		}
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		SelectionSort.dispArray(A);
		shuffle(A);
		SelectionSort.dispArray(A);
	}
}
