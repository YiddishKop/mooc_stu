/** 冒泡排序（把功能独立成函数非常好）
 * */
public class Mystery {
	/** 求出从 k 位置 到 数组最后 最小的数，返回其索引*/
	public static int mystery(int[] inputArray, int k) {
		int x = inputArray[k];  // 把输入的 数组的第k个元素赋值给x
		int answer = k; // 把k赋值给answer
		int index = k + 1; // 把k+1赋值给index
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
	
	/** 1. 找出第i到最后的位置中最小的坐标
	 *  2. 与当前坐标交换
	 *  3. 一直重复到最后
	 * */
	public static void mystery2(int[] inputArray) {
		int index = 0;
		while (index < inputArray.length) {
			int targetIndex = mystery(inputArray, index);
			int temp = inputArray[targetIndex]; // 缓存从i~最后的最小元素的位置
			inputArray[targetIndex] = inputArray[index]; // 并与当前位置交换
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
