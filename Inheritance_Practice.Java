class Calculator2{
	int left, right;
	
	public void setOprands(int left, int right) {
		
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left+this.right)/2);
	}
	
	
}
public class Inheritance_Test extends Calculator2 {
	public void substract() {
		System.out.println(this.left - this.right);
	}
	public static void main(String[] args) {
		
		Inheritance_Test c1 = new Inheritance_Test();
		c1.setOprands(10, 20);
		c1.sum();
		c1.avg();
		c1.substract();
		
	}

}
