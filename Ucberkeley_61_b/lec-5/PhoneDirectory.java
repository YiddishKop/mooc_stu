import java.util.Arrays;

/** 
 * 来源： http://math.hws.edu/eck/cs124/javanotes7/c7/s4.html#arrays.4.1
 * Association Lists 练习：实现一个电话本
 *  	a. 要求用动态数组
 *  	b. 要求设计数据结构，实现 name: phone numb 对
 * @author yiddi
 *	
 */
public class PhoneDirectory{
   /**
    * An object of type PhoneEntry holds one name/number pair.
    */
	public class PhoneEntry {
		String name;
		String phoneNum;
	}
	
	private PhoneEntry[] data; // Array that holds the name/number pairs.
	private int dataCount;	   // The number of pairs stored in the array.
	
	/**
	 * Constructor creates an initially empty directory.
	 */
	public PhoneDirectory() {
		data = new PhoneEntry[1];
		dataCount = 0; //
	}
   /**
    * Looks for a name/number pair with a given name.  If found, the index
    * of the pair in the data array is returned.  If no pair contains the
    * given name, then the return value is -1.  This private method is
    * used internally in getNumber() and putNumber().
    */
	private int find(String name) {
		for (int i = 0; i < dataCount; i++) {
			if (data[i].name.equals(name)) { // 对String的比较不能用 == ，这是比较两个ref是否指向同一个Object
				return i;
			}
		}
		return -1;
	}
   /**
    * Finds the phone number, if any, for a given name.
    * @return The phone number associated with the name; if the name does
    *    not occur in the phone directory, then the return value is null.
    */
	public String getNumber(String name) {
		if(find(name) == -1) {
			return null;
		}else {
			return data[find(name)].phoneNum;
		}
	}
   /**
    * Associates a given name with a given phone number.  If the name
    * already exists in the phone directory, then the new number replaces
    * the old one.  Otherwise, a new name/number pair is added.  The
    * name and number should both be non-null.  An IllegalArgumentException
    * is thrown if this is not the case.
    */
	public void putNumber(String name, String number) {
		if(name == null || number == null) {
			throw new IllegalArgumentException("name and number CAN NOT be null!");
		}
		int i = find(name); 
		if (i >= 0) {
			// if entry already exists, modify number 
			// of ith entry with give input number
			data[i].phoneNum = number;
		}else {
			// make sure if the array is full
			// else entry dose not exist
			// add a new entry with given two pair to PhoneEntry[]
			if (data.length == dataCount) {
				// 动态数组 Arrays.copyOf();
				data = Arrays.copyOf(data, 2*data.length);
			}
			PhoneEntry newEntry = new PhoneEntry(); // Create a new Pair
			newEntry.name = name;
			newEntry.phoneNum = number;
			data[dataCount] = newEntry;
			dataCount++;
		}
	}
}
