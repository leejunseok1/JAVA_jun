class Calculator3 {
	
	int left, right;
	public void setOprands(int left, int right) {
		this.left = left;
		this.right = right;
	}
	public void divide() {
		
		try {
			System.out.println("계산결과는 ");
			System.out.println(this.left/this.right);
			System.out.println("입니다.");
		} catch (Exception e) {
			System.out.println("\n\ne.getMessage()\n" + e.getMessage());
			System.out.println("\n\ne.toString()\n" + e.toString());
			System.out.println("\n\ne.printStaclTrace()");
			e.printStackTrace();
		}
	}
}

public class Exception_Test {
	public static void main(String[] args) {
		
		Calculator3 c1 = new Calculator3();
		c1.setOprands(10, 0);
		c1.divide();
	}

}
