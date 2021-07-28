import java.util.Scanner;

class Number{ // ex1
	static int getNumber() {
		return 10;
	}
}

class Name{ //  ex2
	String getName() {
		return "홍길동";
	}
}

class Print{
	void showinfo() { //ex3
		System.out.println("인스턴스 메서드 입니다.");
	}
}

class Calc{ // ex4
	static int sum(int num1, int num2) {
		return num1 + num2;
	}
}

class ShowName{ //ex5
	void showName(String name) {
		System.out.println("나는" + name + "입니다.");
	}
}

class MaxMin{
	static int max(int num1, int num2, int num3) {
		int max = num1;
		
		//방법 1
		//if(max < num2) max = num2;
		//if(max < num3) max = num3;
		
		// 방법2
		max = max < num2 ?(num2 < num3 ? num3 : num2) : (max < num3 ? num3 : max);
		
		return max;
	}
	
	static int min(int num1, int num2, int num3) {
		int min = num1;
		// if (min > num2) min = num2;
		// if (min > num3) min = num3;
	min = min > num2 ? (num2 > num3 ? num3 : num2) : (min > num3  ? num3 : min);	
		
	return min;
	}
	static void showinfo1(int num1, int num2, int num3) {
		System.out.println("최대값 : " + max(num1, num2, num3));
		System.out.println("최솟값 : " + min(num1, num2, num3));
	}
}

public class Main3 {
	public static void main(String[] args) {
		
		System.out.println(Number.getNumber()); // ex1
		
		Name myName = new Name();// ex2
		System.out.println(myName.getName());
		
		Print myprint = new Print(); //ex3
		myprint.showinfo();
		
		Scanner sc = new Scanner(System.in); //ex4
		System.out.println("정수 두개를 입력해주세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println("정수의 합 = "+ Calc.sum(num1, num2));
		sc.close();
		
		
		System.out.println("이름을 입력해주세요");
		String name = sc.next();
		
		ShowName myName1 =new ShowName(); //ex5
		myName1.showName(name);
		sc.close();
		
		System.out.println("정수 3개를 입력해주세요");
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		MaxMin.showinfo1(num1, num2, num3);
		sc.close();
		
		
	}

}




































