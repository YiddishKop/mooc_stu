/* 用来解决SListNode 中出现的两个问题：
	1. How to represent null list;
	2. insert new node to beginning of list */

public class SList<Blorp> implements List61B<Blorp>{
	// INNER-CLASS: SListNode
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
		//--------------------------------------
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
		public SListNode incrNewList(SListNode sl, int incr_num) {    // 新建一个List，每个节点的 item增加 incr_num
			if(sl.next == null) {
				return new SListNode(sl.item + incr_num, null);
			}else {
				return new SListNode(sl.item + incr_num, incrNewList(sl.next, incr_num));
			}
		}

	}
	// FILEDS
	private SListNode head;
	public int size;
	
	// CTOR
	public SList() {
		size = 0;
		head = null;
	}
	public SList(SListNode head_node) {
		head = head_node;
		size = head_node.size();
	}
	// METHODS
	@Override
	public void insertFront(Blorp x){
		
	}
	@Override
	public Blorp getFront(){
		return null;
	}
	@Override
	public void insertBack(Blorp x){
		
	}
	@Override
	public Blorp getBack(){
		return null;
	}
	@Override
	public Blorp deleteBack(){
		return null;
	}
	@Override
	public int size(){
		return 0;
	}
	@Override
	public Blorp get(int position){
		return null;
	}
	@Override
	public void insert(Blorp item, int position){
		
	}
}
