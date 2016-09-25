/* �������SListNode �г��ֵ��������⣺
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
		public int size() {                            // SListNode�� size����ֻ��ͳ�Ƴ����½ڵ�֮���м����ڵ�
			if(next == null) {
				return 1;
			}else {
				return next.size() + 1;                // Recursion �е��� ����Ƥ�򡱡���ж���Ρ�
			}
		}
		public int sizeIterative() {
			int node_num = 0;
			while(next != null) {
				node_num ++;
			}
			return node_num;
		}
		public void insertAfterThis(int val) {          // ��itemΪval�Ľڵ㣬���뵱�½ڵ�֮��
			next = new SListNode(val, next);
		}
		public void deleteAfterThis() {                 // ɾ����ǰ�ڵ����һ���ڵ�
			next = this.next.next;
		}
		public void incrList(int incr_num) {            // ��ԭ��List��ÿ���ڵ�� item���� incr_num
			if (next == null) {
				item += incr_num;
				return;
			}else {
				item += incr_num;
				next.incrList(incr_num);
			}
		}
		public SListNode incrNewList(SListNode sl, int incr_num) {    // �½�һ��List��ÿ���ڵ�� item���� incr_num
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
