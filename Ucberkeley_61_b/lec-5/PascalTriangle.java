/* ��˹�������κ���Ч�ı���������ֲ�������������
 * ͬʱ��Ҳ���������������ʽ (x+1)^i ��ϵ��
*/ 
public class PascalTriangle {
	public static int[][] getPsc(int layer) {
		int[][] psc = new int[layer][];
		for (int i = 0; i < layer; i++) {
			psc[i] = new int[i+1]; // ����i+1��ָԪ�ظ�����ǧ�����
			
			/* TODO
			 * �����ⲿ�ִ��뿰�� order of computation �ĵ䷶
			 * forѭ������˼���Ǽ������λԪ�صģ�����ģ�黯˼����Ե���ץ����
			 * 1. ������Ԫ�� ��=1��
			 * 2. �����м�Ԫ��
			 * 3. ����βԪ�� ��=1��
			 * ���㲻��ĳ����Сģ�顱�����ɺ�������д��Сģ�顱֮ǰ����ע�ͳ������⼸��
			 * ����������ʲô */
			
			psc[i][0] = 1;
			
			// ����� i �� �������м�Ԫ��----------
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
//			//����ʾ Pascal triangle ���� :DALAY:
//		}
//	}
	public static void main(String[] args) {

	}
}
