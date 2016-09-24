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
		File path = new File("hello.txt"); // 在工程目录下，而不是当前目录
		System.out.println("We got a file: " + path);
		System.out.println("Does it exist? " + path.exists());
		System.out.println("Does it exist? " + path.isDirectory());
		
		try {
			OutputStream oStream = new FileOutputStream(path);
			String s = "hello world!";
			oStream.write(s.getBytes());   // OutputStream 是只能接受byte的，所以要通过getBytes()转
			oStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.in.read()); // system.in 返回的是一个InputStream对象，再调用其read()函数
		
	}
	public static void main(String[] args) throws IOException {
		fileIO();
	}
}
