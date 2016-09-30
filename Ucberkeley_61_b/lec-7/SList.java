import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.DisplayMode;

public class SList {
	private class SNode {
		public int item;
		public SNode next;

		public SNode(int item, SNode next) {
			this.item = item;
			this.next = next;
		}
		public void insertAfter(int item) {
			next = new SNode(item,next);
		}
	}

	private SNode front;

	public void insertFront(int x) {
		front = new SNode(x, front);
	}
	public int size() {
		int size = 1;
		SNode sn= front;
		while(sn.next != null) {
			size += 1;
			sn = sn.next;
		}
		return size;
	}
	public void display() {
		int num = 0;
		SNode sn = front;
		while (num < size()) {
			System.out.printf("%dth item is: %d\n", num, sn.item);
			sn = sn.next;
			num++;
		}
	}
	public void displayRecursive() {
		/*
		 * 1. 打印当前元素
		 * 2. 把下一个元素 赋值给 front
		 * 3. 再次执行 displayRecursive()
		 */
		if (front.next == null) {
			System.out.println(front.item);
			return;
		}else {
			System.out.println(front.item);
			front = front.next;
			displayRecursive();
		}
	}
	public SNode getTail() {
		SNode sn = front;
		while(sn.next.next != null) {
			sn = sn.next;
		}
		return sn;
	}
	// 倒置SList 不能新建 SNode
	public void reverse() {
		/*
		 * linked list 的倒置，只需要把 next 指向前一个元素即可
		 */
		SNode ah = front;
		SNode tmp = ah.next;
		ah.next = null;
		SNode af = tmp;
		while(af != null) {
			tmp = af.next;
			af.next = ah;
			ah = af;
			af = tmp;
		}
		front = ah;
	}
	
	public void reverseRecursive() {
		if (front.next == null) {
			return;
		}else {
			SNode a = front;
			SNode b = front.next;
			front.next = null;
			front = b;
			reverseRecursive();
			b.next = a;
		}
	}
	// Node计数从1开始，insert(0,1) 就是在 1st node 后插入新节点
	public void insert(int item, int position) {
		/*
		 *  判断postition < 0 -> error; 
		 *               > SList.size -> error
		 *               else 遍历到 position 节点 执行insertAfter(item)
		 */
		int num = 1;         // 位置标记
		SNode sn = front;    // SList游标
		if (position < 0) {
			System.out.println("ERROR, < 0");
		}else if (position > this.size()) {
			System.out.println("ERROR, exceed range!");
		}else if(position == 0){
			front = new SNode(item, front);
		}else{
			while (num < position) {
				sn = sn.next;
				num++;
			}
			sn.insertAfter(item);
		}
	}
	public static void testReverse() {
		System.out.println("testReverse");
		SList sl = new SList();
		sl.insertFront(4);
		sl.insertFront(3);
		sl.insertFront(2);
		sl.insertFront(1);
		sl.insertFront(0);
		sl.display();
//		sl.reverse();
		sl.reverseRecursive();
		sl.display();
	}
	public static void testInsert() {
		System.out.println("testInsert:");
		SList sl = new SList();
		sl.insertFront(4);
		sl.insertFront(3);
		sl.insertFront(2);
		sl.insertFront(1);
		sl.insertFront(0);
		sl.display();
		sl.insert(5, 1);
		sl.display();
	}
	public static void testDisplayRecursive() {
		System.out.println("test displayRecursive:");
		SList sl = new SList();
		sl.insertFront(4);
		sl.insertFront(3);
		sl.insertFront(2);
		sl.insertFront(1);
		sl.insertFront(0);
		sl.display();
		sl.displayRecursive();
	} 
	public static void main(String[] args) {
//		testInsert();
		testReverse();
//		testDisplayRecursive();
	}
}
