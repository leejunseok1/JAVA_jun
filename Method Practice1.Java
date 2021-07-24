public class One {
	int a; // 객체변수 a
	
public void vartest(One one) {
	one.a++;
	//this.a++;
}

public int vartest(int b) {
	a++;
	return a;
}

	public static void main(String[] args) {
		One myone = new One();
		myone.a = 1;
		myone.vartest(myone);
		System.out.println(myone.a); // 객체변수 a의 값을 1만큼 증가
		
		

		int a = 1;
		One mytwo = new One();
		a = mytwo.vartest(a); 
		System.out.println(a); // 1이 증가 하지 않는식.
	}

}
