import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *  Test java io package
 * @author yiddi
 * TODO oneNote
 */
public class JavaIO {
	public static void fileIO() throws IOException {
		File path = new File("hello.txt"); // �ڹ���Ŀ¼�£������ǵ�ǰĿ¼
		System.out.println("We got a file: " + path);
		System.out.println("Does it exist? " + path.exists());
		System.out.println("Does it exist? " + path.isDirectory());
		
		try {
			OutputStream oStream = new FileOutputStream(path);
			String s = "hello world!";
			oStream.write(s.getBytes());   // OutputStream ��ֻ�ܽ���byte�ģ�����Ҫͨ��getBytes()ת
			oStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.in.read()); // system.in ���ص���һ��InputStream�����ٵ�����read()����
		
	}
	public static void main(String[] args) throws IOException {
		fileIO();
	}
}
