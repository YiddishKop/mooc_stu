import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeybdInput {
	
 	public static void main(String[] args) throws Exception{
 		BufferedReader keybd = 
 				new BufferedReader(
 						new InputStreamReader(System.in));
 		String s = keybd.readLine();
 		if(s.length()>0) {
 			System.out.println("go on !");
 			s = keybd.readLine();
 		}
 		System.out.println(keybd.readLine());
 	}
 
}

