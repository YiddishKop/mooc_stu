
public class Label {
	public static void main(String[] args) {
		int x = 0;
		int[] z = {1, 2, 3};
		int i = 0;
		test:
			if(x == 0) {
				loop:
					while(i<9) {
						stuff:{
							switch(z[i]){
								case 0: break; // break out of switch block
								case 1: break stuff; // break out of stuff block
								case 2: break loop;
								case 3: break test;
								case 4: continue; // back to begin, do next cycle
								default: continue loop;
								}
						System.out.println("I'm in loop!");
				}
			}
		}
	}
}
