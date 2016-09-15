/**
 * 排序练习： 逆排序（打乱、洗牌）
 * @author yiddi
 *
 */
public class Unsorting {
	/*
	 *  1. 不断把一个 0 ~ TAIL-1 随机位置上的元素与 TAIL 元素交换
	 *  2. 不断把一个 0 ~ TAIL-2 随机位置上的元素与 TAIL - 1元素交换
	 *  3. 。。。。
	 */
	public static void shuffle (int[] A) {
		int index;  // 数组游标
		for (index = A.length-1; index > 0 ; index--) {
			int temp = A[index];      // 缓存游标所指元素
			int rand_index = (int)(Math.random()*(index+1));   // 产生从Head到Index随机位置
			System.out.println("Random location is : " + rand_index);
			A[index] = A[rand_index];
			A[rand_index] = temp;     // 随机位置与index元素交换 
		}
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		SelectionSort.dispArray(A);
		shuffle(A);
		SelectionSort.dispArray(A);
	}
}
