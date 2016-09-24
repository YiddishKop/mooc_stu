public class Sort {
	/*
	 * Returns the index of the smallest string statring with k
	 */
	public static int indexOfSmallest(String[] inputs, int k) {
		int minDex = k;
		for (int i = k; i < inputs.length; i++) {
			int cmp = inputs[i].compareTo(inputs[minDex]);
			if (cmp < 0) {
				minDex = i;
			}
		}
		return minDex;
	}
	private static void swap(String[] input, int a , int b) {
		String temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	/** 
	 * 还记得之前说过的，“最好把递归写成一个单独的helper—func”
	 * @param inputs
	 * @param k
	 * @return
	 */
	private static String[] sort(String[] inputs, int k) {
		if (k == inputs.length) {
			return inputs;
		}
		// find smallest item
		int minDex = indexOfSmallest(inputs, k);
		// move smallest item to front
		swap(inputs, k , minDex);
		// sort rest of the stuff
		return sort(inputs, k + 1);
	}
	public static String[] sort(String[] inputs) {
		return sort(inputs, 0);
	}
	public static void print(String[] inputs) {
		
	}
	/* Print out the args in order */
	public static void main(String[] args) {
		int i = 0;
		while (i < args.length) {
			System.out.println(args[i]);
			i += 1;
		}
	}
}
