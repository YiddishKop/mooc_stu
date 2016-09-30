/*
 * JUnit Test of ArrayInsert
 */
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
public class TestArrayInsert {
	@Test
	public void testInsert() {
		int[] arry = new int[] {1, 3, 5, 7, 9};
		int[] actual = ArrayInsert.insert(arry, 0, 0);
		int[] expected = new int[] {0, 1, 3, 5, 7, 9};
		assertArrayEquals(expected, actual);
	}
	@Test
	public void testReverse() {
		int[] actual = new int[] {1, 3, 5, 7, 9};
		ArrayInsert.reverse(actual);
		int[] expected = new int[] {9, 7, 5, 3, 1};
		assertArrayEquals(expected, actual);
	}
	@Test
	public void testXifY() {
		int[] array = new int[] {1, 3, 2};
		int[] actual = ArrayInsert.xify(array);
		int[] expected = new int[] {1, 3, 3, 3, 2, 2};
		assertArrayEquals(expected, actual);
	}
}
