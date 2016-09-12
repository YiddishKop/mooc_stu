/** 练习：
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
		// 把每个标志都置为True： isPrime
		for (int i = 0; i < mark.length; i++) {
			mark[i] = true;
		}
		// 从2 开始遍历到sqrt(num),并标记这个seed的倍数为false
		// 需要对seed进行判断
		for (int i = 2; i <= Math.sqrt(num+1); i++) {
			if (mark[i]==true) {
				for (int j = i*2; j <= num ; j+=i) { // 代码的精细化控制，才是真实力
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
		// 从2到 num 判定每个数字，是否只能无法被自己之外的所有数字整除
		// 一旦发现就证明是 composite number
		boolean[] mark = new boolean[num]; // 数组默认为 false
		for (int i = 2; i < num; i++) {
			//试除
			for (int j = 2; j < i; j++) {
				if (i%j == 0) {
					mark[i] = true;  // true 代表 合数
					break;
				}
			}
		}
		// 打印
		for (int i = 2; i < mark.length; i++) {
			if (mark[i]==false) {
				System.out.println(i);
			}
		}
	}
	public static void pasTri(int layers) {
		int[][] pas = new int[layers][];
		
		// 给每一层赋值
		for (int i = 0; i < layers; i++) {
			// 初始化每一层的数组
			pas[i] = new int[i+1]; // TODO 这条语句一开始没想起来
			// 给每一层最左赋值
			pas[i][0] = 1;
			// 给每一层中间赋值
			for (int j = 1; j < i; j++) {
				pas[i][j] = pas[i-1][j-1] + pas[i-1][j];
			}
			// 给每一层最右赋值
			pas[i][i] = 1;
		}
		// 打印pascalTriangle
		for (int i = 0; i < pas.length; i++) {
//			System.out.println("pas length：" + pas.length);
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
