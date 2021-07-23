import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Test { // 클래스 메소드
	String a = "가나초콜릿"; // 호출할 문자열
	String b = "맛있다";
	int c = 432; 
}

public class Main {
	 void jp(String a, String b) throws IOException {
		
		FileWriter fw = new FileWriter("File"); // File 이라는 파일에 입력해준다.
		fw.write(a); // a를 입력해준다.
		fw.write(b);
		fw.close();
		
//		System.out.println(a);
//		System.out.println(b);
	}

	 void jw() throws IOException {
		 BufferedReader fr = new BufferedReader(new FileReader("File")); //FileReader만 썻을때는 char만 읽을수 있으므로 
		 																 //문자열을 읽을수 있는 bufferedreader로 감싸준다.
		 String read =  fr.readLine(); // 한줄을 읽어주는 변수 read라는 이름을 만들어준다.
		 
		 System.out.println(read); 
		 fr.close();
	 }
	
	
	public static void main(String[] args) throws IOException {
		
		String a = "가나초콜릿";
		String b = "맛";
		
		Main j = new Main(); // Main의 j이라는 인스턴스를 만들어준다
		
		j.jp(a, b); // 인스턴스 j에 jp의 메서드를 생성한뒤 String 값이 있는 a,b를 호출
		
		
		Test t = new Test(); // Test클래스의 t를 생성해준다.
		System.out.println(t.a); // t라는 인스턴스에서 a를 호출
		System.out.println(t.b);
		System.out.println(t.c);
		
		
		j.jw(); // 이미 메인의 j를 생성 했으므로 j의 jw를 바로 메서드호출을 할수있음.
		
		
	}

}
