/* 简单介绍 Eratosthenes 算法，用排除法来显示 2...n 所有素数
 * O(nloglogn)
* 1. 从2开始，每个素数的倍数标记为合数；
* 2. 一个素数的倍数，是这个数的等差数列；
* 3. Eratosthenes 算法 又叫 素数筛法，与 素数试除法 区别开
*/
public class Eratosthenes {
	
	// 这里特别tricky的在于，保持数组下标表示从0-n的整数，数组内容是 质/素 标记
	public static void getPrime(int n) {
		boolean[] mark = new boolean[n+1];
		
		for (int i = 0; i < mark.length; i++) {
			mark[i] = true;   // true 表示素数， false 表示合数
		}// 一开始所有数字标记为素数
		
		for (int prime_seed = 2; prime_seed <= Math.sqrt(n+1); prime_seed++) {
			if (mark[prime_seed] == true) {   // 如果 prime_seed是素数
				for (int i = prime_seed*2; i < mark.length; i += prime_seed) {
					mark[i] = false;
				}
			}// 将素数的整倍数全标记为合数
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
