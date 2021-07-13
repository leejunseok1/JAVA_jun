import java.util.Scanner;

public class Max {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		int [] a = new int[9]; // 그릇을 생성
		
		int max = 0; // 맥스값
		int cnt = 0; // 몇번째 숫자가 들어갈지 
		
		
		for (int i = 0; i < 9; i++) {
			int tmp = sc.nextInt(); // 임시 변수에 넣어줄 값 생성
			if(tmp > max) { // 입력값이 max 보다 컷을때
			max = tmp; // 입력값이 max값이 됩니다.
			cnt = i+1; // 몇번째 숫자인지는 0부터 값이 시작하기에 +1를 해서 1부터 만들어줍니다.
			}
		System.out.println(max + "\n" + cnt);
	}
}
// ------------------------------------------------------------------
  
  Scanner sc = new Scanner(System.in);
		
		int[] arr = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),
				sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
			
		int count = 0; // 
		int max = 0; // 최댓값 
		int index = 0; // 몇번쨰숫자인ㄱ지
		
		for (int value : arr) {
			count++;
			if(value > max) {
				max = value;
				index = count;
			}
		}
		System.out.println(max + "\n" + index);
		
