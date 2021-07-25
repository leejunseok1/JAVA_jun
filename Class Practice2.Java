class Circle{
	double radius; // 필드(==인스턴스)변수 선언
	double PI =  3.14;// 원주율
	//생성자
	public Circle(double radius) {
		this.radius = radius;
	}
	//기능
	public double getArea() {
		return radius * radius * PI;
		
	}
}
public class Cylinder {
	Circle cir;
	double height;
	
	public Cylinder(Circle cir, double height) {
		this.cir = cir;
		this.height = height;
	} // 생성자 구현
	
	public double Volum() {
		return cir.getArea() * height; // 반지름과 높이의 곱
	}
	
	public static void main(String[] args) {
		// 반지름이 2.8, 높이가 5.6의 원통의 부피
		Circle ci = new Circle(2.8); 
		Cylinder cd = new Cylinder(new Circle(2.8), 5.6);
		
		//Circle 생성자의 2.8 , Cylinder 5.6
		double height = 5.6;
		
		// 부피 구하는법 : 원의면적 * 높이 
		// 면적은 반지름 + 반지름 + 파이
		
		System.out.println("부피 :" + (ci.getArea()*height));
		System.out.println(cd.Volum());
	}
}


//다음에 구현된 Circle 클래스를 참고로 다음을 만족하는 Cylinder 클래스를 작성하시오.

· //원통을 나타내는 Cylinder 클래스는 Circle형의 원과 실수형의 높이를 필드로 선언

· //메소드 getVolume()은 원통의 부피를 반환

· //Cylinder 클래스의 main() 메소드에서 반지름이 2.8, 높이가 5.6의 원통의 부피를 출력








