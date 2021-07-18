class Data_1{
	int value;
// Data_1(){} // 기본생성자 생략해도됨
}

class Data_2{
	int value;
	
	Data_2() {} // 기본생성자
	Data_2(int x) { // 매개변수가 있는 생성자라 기본생성자를 생성해줘야함
		value = x;
	}
}

public class Data_Ex1 {
	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
		Data_2 d2 = new Data_2(); 
		
	}

}
