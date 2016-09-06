
// give parameters 111 222 333 when compiling source code
public class ArgsSum {

	public static void main(String[] args) {
		int index = 0;
		int sum = 0;
		while (index < args.length) {
			sum += Integer.parseInt(args[index]);
			index ++;
		}
		System.out.println("Sum of args: " + sum);
	}

}
