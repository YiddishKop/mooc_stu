
/**
 * 使用 JUnit 测试SList 新方法 insert(item, position)
 * @author yiddi
 *
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class SListTest {
//	@Test
//	public void insertTest() {
//		SList expected = new SList();
//		expected.insertFront(3);
//		expected.insertFront(2);
//		expected.insertFront(1);
//		expected.insertFront(0);
//		SList actual = new SList();
//		actual.insertFront(2);
//		actual.insertFront(1);
//		actual.insertFront(0);
//		actual.insert(3, 3);
//		assertEquals(expected, actual);
//		expected.insertFront(-1);
//		actual.insert(-1, 0);
//		assertEquals(expected, actual);
//		
//	}
	@Test
	public void sizeTest() {
		int expected = 4;
		SList sl = new SList();
		sl.insertFront(3);
		sl.insertFront(2);
		sl.insertFront(1);
		sl.insertFront(0);
		int actual = sl.size();
		assertEquals(expected, actual);
	}
	@Test
	public void insertBackTest() {
		
	}
}
