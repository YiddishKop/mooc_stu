
public class AList<Glorb> {
	private Glorb[] items;
	private int size;
	
	private static int RFACTOR = 2;
	
	public AList() {
		size = 0;
		items =(Glorb[]) new Object[100];
	}
	/** Resize our backing array*/
	private void resize(int capacity) {
		Glorb[] a =(Glorb[]) new Object[capacity];
		System.arraycopy(items, 0, a, 0, items.length);
		items = a;
	}
	public void insertBack(Glorb x) {
		if (size == items.length) {
			resize(size * RFACTOR);
		}
		items[size] = x;  // well done
		size = size + 1;
	}
	public Glorb getBack() {
		int lastActualItemIndex = size - 1;
		return items[lastActualItemIndex];
	}
	public Glorb get(int i) {
		return items[i];
	}
	public int size() {
		return size;
	}
	public Glorb deleteBack() {
		Glorb itemToReturn = getBack();
		items[size - 1] = null;
		size -= 1;
		return itemToReturn;
	}
	public static void main(String[] args) {
		AList<Integer> al = new AList<Integer>();
		int i = 0;
		while (i < 1000) {
			al.insertBack(i);
			i = i + 1;
		}
		System.out.println("DONE!");
	}
}
