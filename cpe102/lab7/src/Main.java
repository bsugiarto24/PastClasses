
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = new Animal(1);
		Animal b = new Animal(1);
		Animal c = new Animal (2);
		Person d = new Person ("Bob",2);
		Person e = new Person ("Bob",2);
		Person f = new Student (4.3,"Bob",2);
		Person g = new Student (4.3,"Bob",2);
		
		System.out.println(a);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println(d);
		System.out.println(d.equals(e));
		System.out.println(d.equals(c));
		System.out.println(f);
		System.out.println(f.equals(g));
		System.out.println(d.equals(f));
	}
}
