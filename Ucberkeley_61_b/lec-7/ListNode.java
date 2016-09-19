// ListNode: item, next
public class ListNode<Blop> {
	int item;
	ListNode next;
	
	//	 return the size of list, by recursion
	public int size() {
		if(next == null) {
			return 1;
		}else {
			return 1 + next.size();
		}
	}
	// return the size of list, by iteration
	public int sizeIterative() {
		int size = 1;       // �Լ���һ��
		ListNode ln_temp = this;
		while(ln_temp.next != null) {
			size++;
			ln_temp = ln_temp.next;
		}
		return size;
	}
	// return the ith item in the list, by re
	public int get(int i) {

		if(i == 0) {
			return item;
		}else {
			return next.get(i - 1); // ���ﲻ����i--��ÿ�ζ�����i����--��
		}
	}
	// return the ith item in the list, by iteration
	public int getIterative(int i) {
		if (i >= this.size()) {
			System.out.println("Error: Out of the index of list!");
			return -1;
		}
		ListNode ln_temp = this;
		for (int j = 0; j < i; j++) {
			ln_temp = ln_temp.next;
		}
		return ln_temp.item;
	}
	// �������� CTOR,��һ�ַ��� ����ʽ ��������
	public ListNode(int num) {
		next = null;
		item = num;
	}
	public ListNode(int num, ListNode node) {
		item = num;
		next = node;
	}
	// �ڵ�ǰ�ڵ�����һ����֪itemֵ�Ľڵ�
	public void insert(int item_val) {
		next = new ListNode(item_val, next);
	}
	// �ݹ���ʾ�Ե���nodeΪ�׵�����list
	public void display() {
		// print list with head lnode
		System.out.println("item: " + item);
		if(next != null) {
			next.display();
		}
	}
	/** 
	 * ������һ���µ�LIST��ÿһ���ڵ��ֵ������ x
	 */
	public static ListNode incrList(ListNode L, int x) {
		if(L.next == null) {
			return new ListNode(L.item+x, null);
		}else {
			return (new ListNode(L.item+x, incrList(L.next, x)));
		}
	}
	/** 
	 * ��ԭ��LIST�����ϣ�ÿһ���ڵ��ֵ������ x
	 */
	public static void dincrList(ListNode L, int x) {
		if (L.next == null) {
			L.item += x;
		} else {
			L.item += x;
			dincrList(L.next, x);
		}
	}
	/** Destructively squares each element of the given IntList L.
	* Don��t use ��new��; modify the original IntList.
	* Should be written iteratively. */
	public static ListNode SquareDestructive(ListNode L) {
		if(L.next == null) {
			L.item = L.item * L.item;
			return L;
		}else {
			L.item = L.item * L.item;
			return SquareDestructive(L.next);
		}
	}
	/** Non-destructively squares each element of the given IntList L.
	* Don��t modify the given IntList.
	* Should be written recursively*/
	public static ListNode SquareNonDestructive(ListNode L) {
		if(L.next == null) {
			return new ListNode(L.item * L.item, null);
		}else {
			return new ListNode(L.item * L.item, SquareNonDestructive(L.next));
		}
	}
	// ��Ԫ����
	public static void main(String args[]) {
		ListNode ln = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ln.display();
		ListNode Q = incrList(ln, 3);
		Q.display();
		dincrList(Q, 10);
		Q.display();
		SquareDestructive(Q);
		Q.display();
		ln.display();
		ListNode R = SquareNonDestructive(ln);
		ln.display();
		R.display();
	}
}

