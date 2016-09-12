/** ��ϰ��
 * 1. EratosThenes get prime 2~n : O(nloglogn)
 * 		- a. set all mark to TRUE
 * 		- b. from 2 - sqrt(n), set all mark false, if index % SEED = 0
 * 		- c. all the mark array which are true are PRIME
 * 2. TrialDivision get prime 2~n : O(n^2)
 * 		- a. every numb from 2 to n, divided by 2~n
 * 		- b. if remainder is 0, then NOT PRIME
 * 3. PascalTriangle n layers
 * 		- a. pay attention to the order of computation
 * */
public class Practice0 {
	// int -> [print]
	public static void eratosGetprim(int num) {
		boolean[] mark = new boolean[num + 1];
		// ��ÿ����־����ΪTrue�� isPrime
		for (int i = 0; i < mark.length; i++) {
			mark[i] = true;
		}
		// ��2 ��ʼ������sqrt(num),��������seed�ı���Ϊfalse
		// ��Ҫ��seed�����ж�
		for (int i = 2; i <= Math.sqrt(num+1); i++) {
			if (mark[i]==true) {
				for (int j = i*2; j <= num ; j+=i) { // ����ľ�ϸ�����ƣ�������ʵ��
					mark[j] = false;
				}
			}
		}
		for (int i = 2; i < mark.length; i++) {
			if (mark[i]==true) {
				System.out.println(i);
			}
		}
		
	}
	public static void trialDiv(int num) {
		// ��2�� num �ж�ÿ�����֣��Ƿ�ֻ���޷����Լ�֮���������������
		// һ�����־�֤���� composite number
		boolean[] mark = new boolean[num]; // ����Ĭ��Ϊ false
		for (int i = 2; i < num; i++) {
			//�Գ�
			for (int j = 2; j < i; j++) {
				if (i%j == 0) {
					mark[i] = true;  // true ���� ����
					break;
				}
			}
		}
		// ��ӡ
		for (int i = 2; i < mark.length; i++) {
			if (mark[i]==false) {
				System.out.println(i);
			}
		}
	}
	public static void pasTri(int layers) {
		int[][] pas = new int[layers][];
		
		// ��ÿһ�㸳ֵ
		for (int i = 0; i < layers; i++) {
			// ��ʼ��ÿһ�������
			pas[i] = new int[i+1]; // TODO �������һ��ʼû������
			// ��ÿһ������ֵ
			pas[i][0] = 1;
			// ��ÿһ���м丳ֵ
			for (int j = 1; j < i; j++) {
				pas[i][j] = pas[i-1][j-1] + pas[i-1][j];
			}
			// ��ÿһ�����Ҹ�ֵ
			pas[i][i] = 1;
		}
		// ��ӡpascalTriangle
		for (int i = 0; i < pas.length; i++) {
//			System.out.println("pas length��" + pas.length);
			for (int j = 0; j < pas[i].length; j++) {
//				System.out.println("pas " + i + " length" + pas[i].length);
				System.out.print(pas[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		eratosGetprim(121);
		trialDiv(121);
		pasTri(15);
	}
}
