/* �������SListNode �г��ֵ��������⣺
	1. How to represent null list;
	2. insert new node to beginning of list */

public class SList<Blop> {
	// FILEDS
	int size;
	ListNode head;
	
	// CTOR
	public SList() {
		size = 0;
		head = null;
	}
	
	// METHODS
	
	
	// UNIT TEST
	public static void main(String[] args) {
		SList usr_1 = new SList();
		SList usr_2 = usr_1;
		
		// usr_1 ��list�����һЩnode
		usr_1.head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3))));
		usr_1.head.display();
		usr_2.head.display();
		
	}
}
