/**
 * ����չʾ Parameters Passing
 * @author yiddi
 *
 */
public class IntBox {
	
	public int i;
	
	/*
	 * pass by value ����� original value
	 * ���κθ��ġ���������ֻ��һ��ֵ
	 */
	static void doNoting(int x) {
		x = 2;
	}
	/*
	 * pass by reference ���Զ� original value
	 * ���κθ��ġ�����������һ��ָ�� HEAP ������
	 * ͨ�����ÿ����޸� HEAP �е�����
	 */
	static void set3(IntBox ib) {
		ib.i = 3;
	}
	/*
	 * �ں����жԴ���� reference ��ֵ��ʮ��Σ��
	 * �ģ� ʧȥ�˶�ԭ�� HEAP �����ݵĸ��١�
	 */
	static void badSet4(IntBox ib) {
		ib = new IntBox();
		ib.i = 4;
	}
	
}
