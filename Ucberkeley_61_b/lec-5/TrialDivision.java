// 最容易理解、最普通、最慢的 试除法
// O(n^2)
public class TrialDivision {
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void getPrime(int n) {
		for (int i = 2; i <= n ; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This is trial division!");
		getPrime(121);
	}
}
	