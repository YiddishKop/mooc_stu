/* 帕斯卡三角形很有效的表明了数组分步声明的特征；
 * 同时，也可以用来处理多项式 (x+1)^i 的系数
*/ 
public class PascalTriangle {
	public static int[][] getPsc(int layer) {
		int[][] psc = new int[layer][];
		for (int i = 0; i < layer; i++) {
			psc[i] = new int[i+1]; // 这里i+1是指元素个数，千万别搞混
			
			/* TODO
			 * 下面这部分代码堪称 order of computation 的典范
			 * for循环的意思就是计算非首位元素的，根据模块化思想可以单独抓出来
			 * 1. 计算首元素 （=1）
			 * 2. 计算中间元素
			 * 3. 计算尾元素 （=1）
			 * 即便不把某个“小模块”独立成函数，在写“小模块”之前把他注释出来，这几条
			 * 语句的作用是什么 */
			
			psc[i][0] = 1;
			
			// 计算第 i 行 的所有中间元素----------
			for (int j = 1; j < i; j++) {
				psc[i][j] = psc[i-1][j-1] + psc[i-1][j];
			}
			//---------------------------------
			
			psc[i][i] = 1;
		}
		return psc;
	}
	
//	public static void disPsc(int layer) {
//		for (int i = 0; i < layer; i++) {
//			//想显示 Pascal triangle 内容 :DALAY:
//		}
//	}
	public static void main(String[] args) {

	}
}
