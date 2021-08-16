package JUNGOL_1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // 키
		int b = sc.nextInt(); // 몸무게
		
		int c = b + 100 - a; 
		
		if (c > 0) {
			System.out.println(c);
			System.out.println("Obesity");
		}
		
	}

}
//--------------------------------------------------------------------
package JUNGOL_1;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		
		if (A > 20) {
			System.out.println("adult");
		} else {
			System.out.println(20 - A + " years later");
		}
	}
}
//-------------------------------------------------------------------

package JUNGOL_1;

import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double A = sc.nextDouble();
		
		if (A > 88.45) {
			System.out.println("Heavyweight");
		}else if(A > 72.57) {
			System.out.println("Cruiserweight");
		}else if (A > 61.23) {
		System.out.println("Middleweight");
		}else if (A > 50.80) {
			System.out.println("Lightweight");
		}else
			System.out.println("Flyweight");
	}

}
//---------------------------------------------------------------

package JUNGOL_1;

import java.util.Scanner;

public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Double x = sc.nextDouble();
		Double y = sc.nextDouble();
		
		if (x >= 4.0 && y >= 4.0) {
			System.out.println("A");
		}else if (x >= 3.0 && y >= 3.0) {
			System.out.println("B");
		}else
			System.out.println("C");
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int age = sc.nextInt();
		
		if (s.equals("F") && age >=18) {
			System.out.println("WOMAN");
		}else if (s.equals("F") && age < 18 ) {
			System.out.println("GIRL");
		}else if (s.equals("M") && age >= 18) {
			System.out.println("MAN");
		}else if (s.equals("M") && age < 18  ) {
			System.out.println("BOY");
		}
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main7 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String x = sc.next();
		
		if (x.equals("A")) {
			System.out.println("Excellent");
		}else if(x.equals("B")) {
			System.out.println("Good");
		}else if(x.equals("C")) {
			System.out.println("Usually");
		}else if(x.equals("D")) {
			System.out.println("Effort");
		}else if(x.equals("F")) {
			System.out.println("Failure");
		}else 
			System.out.println("error");
	}

}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main8 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		float avg = sc.nextFloat(); // 평점
		switch ((int)avg) {
		case 4:
			System.out.print("scholarship");
		break;
		
		case 3:
			System.out.print("next semester");
			break;
			
		case 2:
			System.out.print("seasonal semester");
			break;
			
		default:
			System.out.print("retake");
			break;
		}
		
	}

}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int min = 0;
		
		min = (A < B) ? A : B;

		if (min < C) {
			System.out.println(min);
		}else
			System.out.println(C);
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if (A > B) {
			System.out.println(A-B);
		}else if(B > A) {
			System.out.println(B-A);
		}
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		
		if (A > 0) {
			System.out.println("plus");
		}else if (A < 0) {
			System.out.println("minus");
		}else
			System.out.println("zero");
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		
		if (A % 400 == 0 || (A % 4==0 && A % 100 != 0) ) {
			System.out.println("leap year");
		}else
			System.out.println("common year");
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Nunmer? ");
		
		int number = sc.nextInt();
		
		switch (number) {
		case 1 : System.out.print("dog");
		break;
		case 2 : System.out.print("cat");
		break;
		case 3 : System.out.print("chick");
		break;
		default :
			System.out.print("I don't know.");
			break;
		}
	}
}
//---------------------------------------------------------------
package JUNGOL_1;

import java.util.Scanner;

public class Main14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		
		if ( A == 1 || A == 3 || A== 5 || A == 7 || A == 8||
				A == 10 || A == 12) {
			System.out.print("31");
		}else if (A == 2) {
			System.out.print("28");
		}else if (A == 4 || A == 6 || A== 9 || A ==11) {
			System.out.print("30");
		}
	}
}

