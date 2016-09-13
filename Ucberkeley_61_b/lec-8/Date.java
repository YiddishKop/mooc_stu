
public class Date {
	private int day;
	private int month;
	private int year;
	
	/** 封闭的房子里开了一扇小窗
	 *  */
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
			d.day = 100;   // Failed to access PRIVATE field
			d.setMonth(0); // Failed again
			 // TODO  为什么设置私有数据成功了？和课程讲的不一样啊
			System.out.println("hi, this is EvilTamper: "+d.getDay());
		}
	}
	public static void main(String[] args) {
		Date dt = new Date();
		EvilTamperer et  = dt.new EvilTamperer();
		et.tamper(); // TODO  为什么设置私有数据成功了？和课程讲的不一样啊
	}
}
