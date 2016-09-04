
public class Human {
	//	these are the fields of Human Class 
	public int age;
	public String name;
	public static int numberOfHumans;
	
	// These are constructors of Human Class
	public Human(){
		numberOfHumans++;
	}
	public Human(String givenName){
		// constructor can omit the return type
		numberOfHumans++;
		age = 12;
		name = givenName;
	}
	
	public void introduce(){
		System.out.println("i'm " + name + " and im " +
				age + " years old~");
	}
	public void copy(Human original){
		age = original.age;
		name = original.name;
			}
	public void change(int age){
		String name = "Change";
		this.age = age;
		this.name = name;
	}
	
	public static void PrintHumans(){
		System.out.println(numberOfHumans);
	}
	public static void main(String args[]){
		Human kayla = new Human();
		kayla.age = 12;
		kayla.name = "Kayla";
		kayla.introduce();
		Human rishi = new Human();
		rishi.copy(kayla);
		rishi.introduce();
		Human yiddi = new Human("yiddi");
		yiddi.introduce();
		yiddi.change(111);
		yiddi.introduce();
		System.out.println("Number of People: " + numberOfHumans);
		yiddi.PrintHumans();
	}
}
