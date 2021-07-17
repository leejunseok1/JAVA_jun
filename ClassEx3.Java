class Calculator {
	
	final static double PI = 3.14;
	static int base = 0;
	int left, right;
	
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right ) / 2);
	}
}

public class CalculatorDemo2 {
	
	public static void main(String[] args) {
		Calculator c1 = new Calculator();
		c1.setOprands(10, 20);
		c1.sum();
		
		Calculator c2 = new Calculator();
		c2.setOprands(70, 80);
		c2.avg();
		
	
		
		System.out.println(Calculator.PI);
		
		
	}

}
