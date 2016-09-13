/**
 * 汉诺塔：用来练习 Recursive Method
 *        move all planes from tower_1 to tower_3
 *        每次都把最大的最底下的当作不存在，它不会对上面的
 *        disk 的移动产生任何影响
 * @author yiddi
 *
 */
public class Hanoi {
	public static void move(int tower_numb, int from, int to, int spare) {
		if(tower_numb == 1) {
			System.out.println("move "+ tower_numb + " from " + from + "to" + to);			
		}else {
			move(tower_numb-1, from, spare, to);
			System.out.printf("Move disk %d from stack %d to stack %d%n",
                    tower_numb, from, to);
			move(tower_numb-1, spare, to, from);
			
		}
	}
	
	public static void main(String[] args) {
		move(3, 1, 3, 2);
	}
}
