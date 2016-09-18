/**
 * ������֤ Inner-class �ķ���Ȩ�ޣ��Լ���δ���Inner-class����
 * 	1. inner-class �� outter-class �໥���Է��� private fields
 * 	2. �봴�� inner-object,�����ȴ��� outter-object 
 * 	      ����ͨ�� reference.new ������
 * @author yiddi
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;
	
	// Ϊ���� private ��һ�ȴ�
	public int getDay() {
		return this.day;
	}
	
	private void setMonth(int m) {
		month = m;
	}
	public Date() {
		
	}
	public Date (int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	
	public class EvilTamperer{
		public void tamper() {
			Date d = new Date(1, 1, 2006);
			d.day = 100;                                               // TODO  ����˽�����ݳɹ�
			d.setMonth(0); 
			System.out.println("hi, this is EvilTamper: "+d.getDay());
		}
	}
	public static void main(String[] args) {
		Date dt = new Date();
		EvilTamperer et  = dt.new EvilTamperer();                      // TODO ��δ��� Inner-class ����
		et.tamper(); 							                       // TODO ����˽�����ݳɹ�
	}
}
