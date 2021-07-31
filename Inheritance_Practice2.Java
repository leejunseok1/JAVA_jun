
public class Inheritance_Test2 extends Inheritance_Test{
	public void multipication() {
		System.out.println(this.left * this.right);
	}
	public static void main(String[] args) {
		
		Inheritance_Test2 c1 = new Inheritance_Test2();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		c1.multipication();
		
	}

}
