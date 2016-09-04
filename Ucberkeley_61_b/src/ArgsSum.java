
public class ArgsSum {

	public static void main(String[] args) {
		// DONE Auto-generated method stub
		int index = 0;
		int total = 0;
		
		while (index < args.length) {
			total = total + Integer.parseInt(args[index]);
			index += 1;
		}
		System.out.println(total);
	}

}
