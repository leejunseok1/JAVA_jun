
public class Ex6_1 {

	public static void main(String[] args) {
		Tv t; // tv 인스턴스를 참조하기 위한 변수 t선언
		t= new Tv(); // tv인스턴스 생성
		t.channel = 7; // tv인스턴스의 멤버변수 channel의 값을 7로 
		t.channelDown(); 
		System.out.println("현재 채널은" + t.channel + "입니다.");
		
		System.out.println("--------------------------");
		
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		System.out.println("t1의 channel값은"+t1.channel + "입니다.");
		System.out.println("t2의 channel값은"+t2.channel + "입니다.");
		
		t1.channel = 7;
		System.out.println("t1의 channel값을 7로 변경하였습니다.");
		
		t2 =t1; // 참조변수 t1의 값의 t2에 저장.
		System.out.println("t1의 channel값은" + t1.channel+"입니다.");
		System.out.println("t2의 channel값은" + t2.channel+"입니다.");
	}

}

class Tv {
	String color;
	boolean power;
	int channel;
	
	void power() { power = !power;}
	void channelUp() { ++channel;}
	void channelDown() { --channel;}
}
