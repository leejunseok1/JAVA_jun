class MyPoint3 extends Object{
	int x;
	int y;
//	String getLocation() {
//		return "x:" + x + ", y:" + y;
//		public String toString() {
//			return "x:" + x + ", y:"+y;
//	}
	MyPoint3(int x, int y){
		this.x = x;
		this.y = y;
	}
	// Object클래스의 toString()을 오버라이딩
	public String toString() {
		return "x:"+x + "y:"+y;
	}
}

//class MyPoint3D extends MyPoint3{
//	int z;
//	//조상의 geLocation()을 오버라이딩
//	String getLocation() {
//		return "x:" + x + ", y :" +y + ",z :" + z;
//	}
//}

public class OverrideTest {
	public static void main(String[] args) {
//		MyPoint3D p = new MyPoint3D();
//		p.x = 3;
//		p.y = 5;
//		p.z = 7;
//		System.out.println(p.getLocation());
		
//		MyPoint3 p = new MyPoint3();
//		p.x = 3;
//		p.y = 5;
//		System.out.println("p.x="+ p.x);
//		System.out.println("p.y="+ p.y);
		
//		System.out.println(p.toString());
//		System.out.println(p);
		
		MyPoint3 p = new MyPoint3(3, 5);
		System.out.println(p);
	}

}


//오버라이딩의 조건
// 1.선언부가 조상 클래스의 메서드와 일치해야한다.
// 2.접근제어자를 조상클래스의 메서드보다 좁은 범위로 변경할수없다
// 3. 예외는 조상클래스의 메서드보다 많이 선언할수 없다.

//오버로딩 기존에 없는 새로운 메서드를 정의하는것(new)
//오버라이딩 상속받은 메서드의 내용을 변경하는것
// ex ) change, modify
