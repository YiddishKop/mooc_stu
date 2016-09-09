/* �򵥽��� Eratosthenes �㷨�����ų�������ʾ 2...n ��������
 * O(nloglogn)
* 1. ��2��ʼ��ÿ�������ı������Ϊ������
* 2. һ�������ı�������������ĵȲ����У�
* 3. Eratosthenes �㷨 �ֽ� ����ɸ������ �����Գ��� ����
*/
public class Eratosthenes {
	
	// �����ر�tricky�����ڣ����������±��ʾ��0-n������������������ ��/�� ���
	public static void getPrime(int n) {
		boolean[] mark = new boolean[n+1];
		
		for (int i = 0; i < mark.length; i++) {
			mark[i] = true;   // true ��ʾ������ false ��ʾ����
		}// һ��ʼ�������ֱ��Ϊ����
		
		for (int prime_seed = 2; prime_seed <= Math.sqrt(n+1); prime_seed++) {
			if (mark[prime_seed] == true) {   // ��� prime_seed������
				for (int i = prime_seed*2; i < mark.length; i += prime_seed) {
					mark[i] = false;
				}
			}// ��������������ȫ���Ϊ����
		}
		
		for (int i = 2; i < mark.length; i++) {
			if (mark[i] == true) {
				System.out.println(i);
			} 
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("This is Eratosthenes method!");
		getPrime(1211);
	}
}
