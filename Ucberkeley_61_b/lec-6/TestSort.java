import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSort {
	/** Tests the Sort.sort method*/
	@Test
	public  void testSort() {
		String[] inputs = {"milvia", "zero", "josh", "trump"};
		String[] expected = {"josh", "milvia", "trump", "zero"};
		String[] actual = Sort.sort(inputs);
		
		System.out.println("Before run junit test!");
		org.junit.Assert.assertArrayEquals(expected, actual);
		System.out.println("After run junit test!");
	}
	@Test
	public  void testIndexOfSmallest() {
		String[] inputs = {"milvia", "zero", "josh", "trump"};
		int expected = 2;
		int actual = Sort.indexOfSmallest(inputs, 2);
		assertEquals(expected, actual);
		expected = 3;
		actual = Sort.indexOfSmallest(inputs, 3);
		assertEquals(expected, actual);
	}
	
//	public static void main(String[] args) {
//		
//		testSort();
//		testIndexOfSmallest();
//	}
}
/* 	We are reinventing wheel.
 * 
  		if (expected.length != actual.length) {
			System.out.println("Lenths did not match.");
			System.out.println("Expected: " + expected.length);
			System.out.println("Actual: " + actual.length);
		}
		
		for (int i = 0; i < expected.length; i++) {
			if (expected[i].equals()) {
			...
			}
		}
*/
