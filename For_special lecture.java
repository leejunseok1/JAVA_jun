package For_T;
/*
 100~70000 사이의 2의 제곱수들을 출력해보세요.
 128 256 512 1024 ... 65536
 */


public class For_ {

	public static void main(String[] args) {
		int a = 0;
		for (int i = 1; i < 70000; i *= 2) {
			if (i > 100) {
				System.out.println(i);
				
			}
		}
	}

}
//--------------------------------------------------------------------------
package For_T;
import java.util.Scanner;

/*
 * 사용자가 범위를 입력하고
 * 개수를 구할 특정한 정수를 하나 입력합니다.
 * 개수를 출력해보세요.
 * */
public class For_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("범위. 두 개의 정수를 입력.");
		int start = sc.nextInt();
		int end = sc.nextInt();
		System.out.println("배수의 개수를 구할 정수를 입력.");
		int number = sc.nextInt();
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (i % number == 0) {
				count++;
			}
		}
		System.out.println(start + "와"+end + "사이의 개수: " + count);
	}

}
//-------------------------------------------------------------------------------
package For_T;
/*
 *Fizz Buzz (3의 배수 -> Fizz, 5의 배수 -> Buzz)
 * 
 *1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 Fizz Buzz 16
 *... 98 Fizz Buzz 101 
 * */
public class For_2 {
	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
			
			
			if (i % 3 ==0 && i % 5 ==0) {
				System.out.println("Fizz Buzz");
			}else if ( i % 3 == 0) {
				System.out.println("Fizz");
			}else if (i % 5 == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}

}

//-----------------------------------------------------------------------

package For_T;
/*
 * 30의 약수들을 큰수에서 작은 수 순서로 출력해보세요.
 * 
 * 30 14 10 6 5 3 2 1
 * 
 * */
public class For_3 {
	public static void main(String[] args) {
		for (int i = 30; i >= 1; i--) {
			if (30 % i == 0) {
				System.out.println(i + "는 약수임");
				
			}
		}
	
	}

}
//------------------------------------------------------------
package For_T;
/*
 * 300에서 700 사이의 15의 배수의 합과 평균.
 * 
 * */
public class For_4 {
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		
		for (int i = 300; i <= 700; i++) {
			if (i % 15 == 0) {
				sum += i;
				count++;
			}
		}
		System.out.println("최종합 :" + sum);
		System.out.println("최종 평균 :" + sum / count);
	}

}
