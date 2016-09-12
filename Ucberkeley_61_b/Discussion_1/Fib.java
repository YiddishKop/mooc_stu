/** Fibonacci list number 0 1 1 2 3 5 8 13 21 ... */
public class Fib {
	/**
	 * Fibonacci Array: use Iteration
	 * @param n
	 * @return An array of Fibonacci numb
	 */
	public static int fib1(int n) {
		int f1 = 0;
		int f2 = 1;
		
		for (int j = 2; j <= n; j++) {
			int temp = f1 + f2;
			f1 = f2;
			f2 = temp;
		}
		return f2;
	}
	/**
	 * Fibonacci Array: use Recursion
	 * @param n
	 * @return An array of Fibonacci numb
	 */
	public static int fib2(int n) {
		if (n ==0 || n == 1) {
			return n;
		}else {
			return fib2(n-1)+fib2(n-2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fib1(6));
		System.out.println(fib2(6));
	}
}
