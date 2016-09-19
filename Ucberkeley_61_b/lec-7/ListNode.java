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
		int size = 1;       // 自己算一个
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
			return next.get(i - 1); // 这里不可用i--，每次都返回i，再--。
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
	// 定义两种 CTOR,后一种方便 迭代式 创建对象
	public ListNode(int num) {
		next = null;
		item = num;
	}
	public ListNode(int num, ListNode node) {
		item = num;
		next = node;
	}
	// 在当前节点后插入一个已知item值的节点
	public void insert(int item_val) {
		next = new ListNode(item_val, next);
	}
	// 递归显示以当下node为首的整个list
	public void display() {
		// print list with head lnode
		System.out.println("item: " + item);
		if(next != null) {
			next.display();
		}
	}
	/** 
	 * 拷贝出一个新的LIST，每一个节点的值都增加 x
	 */
	public static ListNode incrList(ListNode L, int x) {
		if(L.next == null) {
			return new ListNode(L.item+x, null);
		}else {
			return (new ListNode(L.item+x, incrList(L.next, x)));
		}
	}
	/** 
	 * 在原有LIST基础上，每一个节点的值都增加 x
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
	* Don’t use ’new’; modify the original IntList.
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
	* Don’t modify the given IntList.
	* Should be written recursively*/
	public static ListNode SquareNonDestructive(ListNode L) {
		if(L.next == null) {
			return new ListNode(L.item * L.item, null);
		}else {
			return new ListNode(L.item * L.item, SquareNonDestructive(L.next));
		}
	}
	// 单元测试
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

