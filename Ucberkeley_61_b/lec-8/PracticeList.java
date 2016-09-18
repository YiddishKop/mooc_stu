/**
 * 链表练习： 单向链表，双向链表，带哨兵的双向链表
 * @author yiddi
 *
 */
public class PracticeList {
	public static void main(String[] args) {
		PracticeList pl = new PracticeList();
		SListNode SL_node = pl.new SListNode(4, 
				pl.new SListNode(8, 
						pl.new SListNode(0, 
								pl.new SListNode(2, 
										pl.new SListNode(5)))));
		SList SL = pl.new SList(SL_node);
		SL.disp_SList();
		SL.head.incrList(10);
		SL.disp_SList();
		SList SL2 = pl.new SList(SL.head.incrNewList(SL.head, 20));
		SL2.disp_SList();
	}
	public class SListNode{
		public int item;
		public SListNode next;
		//-------------------------------------
		public SListNode(int value, SListNode ref) {
			this.item = value;
			this.next = ref;
		}
		public SListNode(int value) {
			this.item = value;
			this.next = null;
		}
		//-------------------------------------
		public int size() {                            // SListNode的 size方法只能统计出当下节点之后有几个节点
			if(next == null) {
				return 1;
			}else {
				return next.size() + 1;                // Recursion 有点像 “踢皮球”“推卸责任”
			}
		}
		public int sizeIterative() {
			int node_num = 0;
			while(next != null) {
				node_num ++;
			}
			return node_num;
		}
		public void insertAfterThis(int val) {          // 把item为val的节点，插入当下节点之后
			next = new SListNode(val, next);
		}
		public void deleteAfterThis() {                 // 删除当前节点的下一个节点
			next = this.next.next;
		}
		public void incrList(int incr_num) {            // 在原来List上每个节点的 item增加 incr_num
			if (next == null) {
				item += incr_num;
				return;
			}else {
				item += incr_num;
				next.incrList(incr_num);
			}
		}
		public  SListNode incrNewList(SListNode sl, int incr_num) {    // 新建一个List，每个节点的 item增加 incr_num
			if(sl.next == null) {
				return new SListNode(sl.item + incr_num, null);
			}else {
				return new SListNode(sl.item + incr_num, incrNewList(sl.next, incr_num));
			}
		}
	}
	public class SList{
		private SListNode head;
		public int size;
		//-------------------------------------
		public SList() {
			head = null;
			size = 0;
		}
		public SList(SListNode head_node) {
			head = head_node;
			size = head_node.size();
		}
		//-------------------------------------
		public void addNodeFromHead(SListNode new_node) {
			new_node.next = head;
			head = new_node;
			size++;
		}
		public void delNodeFromHead() {
			head = head.next;
			head.next = null;
			size--;
		}
		public void disp_SList() {
			SListNode sl = head;
			while(sl != null) {
				System.out.println("item: " + sl.item);
				sl = sl.next;
			}
		}
	}
	public class DListNode{
		int item;
		DListNode prev;
		DListNode next;
		//------------------------------
		public DListNode(int val) {
			this.item = val;
			this.prev = null;
			this.next = null;
		}
		public DListNode(int val, DListNode prev_node, DListNode next_node) {
			this.item = val;
			this.prev = prev_node;
			this.next = next_node;
		}
		//------------------------------
	}
	public class DList{
		private DListNode head;
		private DListNode sentinel;
		public int size;
		//------------------------------
		public DList(DListNode dlNode) {
			this.head = dlNode;
			this.sentinel.prev = dlNode;
			this.sentinel.next = dlNode;
			this.size = 0;
		}
		//------------------------------
		
	}
}
