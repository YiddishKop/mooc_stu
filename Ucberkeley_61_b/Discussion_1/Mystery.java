/** ð�����򣨰ѹ��ܶ����ɺ����ǳ��ã�
 * */
public class Mystery {
	/** ����� k λ�� �� ������� ��С����������������*/
	public static int mystery(int[] inputArray, int k) {
		int x = inputArray[k];  // ������� ����ĵ�k��Ԫ�ظ�ֵ��x
		int answer = k; // ��k��ֵ��answer
		int index = k + 1; // ��k+1��ֵ��index
		while (index < inputArray.length) { //
			if (inputArray[index] < x) { 
				x = inputArray[index];
				answer = index;
			}
			index = index + 1;
		}
		System.out.println(answer);
		return answer;
	}
	
	/** 1. �ҳ���i������λ������С������
	 *  2. �뵱ǰ���꽻��
	 *  3. һֱ�ظ������
	 * */
	public static void mystery2(int[] inputArray) {
		int index = 0;
		while (index < inputArray.length) {
			int targetIndex = mystery(inputArray, index);
			int temp = inputArray[targetIndex]; // �����i~������СԪ�ص�λ��
			inputArray[targetIndex] = inputArray[index]; // ���뵱ǰλ�ý���
			inputArray[index] = temp; 
			index = index + 1;
			}
	}
	
	public static void main(String[] args) {
//		System.out.println("Mystery!");
		int[] x = new int[] {1,2,3,4,4,3,2,1};
		mystery(x, 3);
	}
}
