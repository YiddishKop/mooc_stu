// ListNode: item, next
public class ListNode {
	int item;
	ListNode next;
	
	// �������� ctor,��һ�ַ��� ����ʽ ��������
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
	
	
	
	
	// ��Ԫ����
	public static void main(String args[]) {
		
		// Build a small list from 1 to 3
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		// display list with l1 as head node
		l1.display();
		// ��ĩβ����һ�� item = 4 �Ľڵ�
		l3.insert(4);
		// ����֮���ٴ�ӡ
		System.out.println("Now, new List is :\n");
		l1.display();
		
		
		// BUild a small list from 5 to 7
		ListNode l4 = new ListNode(5, new ListNode(6, new ListNode(7)));
		l4.display();
		// ��ĩβ����һ�� item = 4 �Ľڵ�
		l4.insert(4);
		// ����֮���ٴ�ӡ
		System.out.println("Now, new List is :\n");
		l4.display();
	}
}

