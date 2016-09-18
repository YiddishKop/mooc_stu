/**
 * 用来验证 Inner-class 的访问权限，以及如何创建Inner-class对象
 * 	1. inner-class 和 outter-class 相互可以访问 private fields
 * 	2. 想创建 inner-object,必须先创建 outter-object 
 * 	      而后通过 reference.new 来创建
 * @author yiddi
 *
 */
public class Date {
	private int day;
	private int month;
	private int year;
	
	// 为访问 private 打开一扇窗
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
			d.day = 100;                                               // TODO  设置私有数据成功
			d.setMonth(0); 
			System.out.println("hi, this is EvilTamper: "+d.getDay());
		}
	}
	public static void main(String[] args) {
		Date dt = new Date();
		EvilTamperer et  = dt.new EvilTamperer();                      // TODO 如何创建 Inner-class 对象
		et.tamper(); 							                       // TODO 设置私有数据成功
	}
}
