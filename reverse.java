public class Main {

	public static void main(String[] args) {
		
		int a = 123456;
		
		
			int rev = 0;
			while (a != 0) {
			rev = rev *100;  // 0
			rev = rev + a%100; // 56
			a = a/100; // 1234
						
		}
		System.out.println(rev);
		
			//rev = rev *100;  //   0  //반복하기위해 추가함
			//rev = rev + a%100;  // 56
			//a = a/100;  //1234
    
    //rev = rev *100;   // 5600
			//rev = rev + a%100; // 5634
			//a = a/100;  // 12
    
    //rev = rev *100;  //563400
			//rev = rev + a%100; //563412
			//a = a/100; 	
	}

}
