// ListNode: item, next
public class ListNode {
	int item;
	ListNode next;
	
	// 定义两种 ctor,后一种方便 迭代式 创建对象
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
	
	
	
	
	// 单元测试
	public static void main(String args[]) {
		
		// Build a small list from 1 to 3
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		// display list with l1 as head node
		l1.display();
		// 在末尾插入一个 item = 4 的节点
		l3.insert(4);
		// 插入之后再打印
		System.out.println("Now, new List is :\n");
		l1.display();
		
		
		// BUild a small list from 5 to 7
		ListNode l4 = new ListNode(5, new ListNode(6, new ListNode(7)));
		l4.display();
		// 在末尾插入一个 item = 4 的节点
		l4.insert(4);
		// 插入之后再打印
		System.out.println("Now, new List is :\n");
		l4.display();
	}
}

