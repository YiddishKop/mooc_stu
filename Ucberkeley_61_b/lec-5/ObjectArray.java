// 这个类的目的主要是判断，Object数组是否可以混合各种类型，primitive 和 reference
public class ObjectArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] obr1 = new Object[] {1,2,3,4,5,6,7,8};
		Object[] obr2 = new Object[] {new Human("1"),
									  new Human("2"),
									  new Human("3"),
									  new Human("4"),
									  new Human("5"),
									  new Human("6"),
									  new Human("7"),
									  new Human("8")};
		Object[] obr3 = new Object[] {new Human("1"),
									  2,
									  3,
									  new Human("4"),
									  new Human("5"),
									  6,
									  new Human("7"),
									  new Human("8")};
		for (int i = 0; i < obr1.length; i++) {
			System.out.print(" " + obr1[i]);
		}
		
		System.out.println();
		
		for (int i = 0; i < obr2.length; i++) {
			System.out.print(" " + ((Human)obr2[i]).name);
		}
		
		System.out.println();
		System.out.println(obr3[0].getClass());
		for (int i = 0; i < obr3.length; i++) {
			if(obr3[i].getClass() != (new Human()).getClass()) {
				System.out.println(obr3[i]);
			}else {
//				System.out.println(1);
				System.out.println(((Human)obr3[i]).name);
			}
		}
	}
}
