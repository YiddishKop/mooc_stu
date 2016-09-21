/**
 * lec-10:testing
 * @author yiddi
 *
 */
public class LecTest {
	public static void main(String[] args) {
		String s1 = "Yes";
		String s2 = new String(s1);
		String s3 = s2;
		System.out.println(s1 == s2);
		System.out.println(s3 == s2);
		System.out.println(s1.equals(s2));
		
		
	}
}
