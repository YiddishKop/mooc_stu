/** Double-linked list
 * @author yiddi
 *
 */
public class DList<Blop> {
	private int size;
	private DListNode head;
	private DListNode sentinel;
	

	public class DListNode{
		public Blop item;
		public DListNode prev;
		public DListNode next;
		
		public DListNode(Blop val, DListNode pre, DListNode nex) {
			
		}
	}
}
