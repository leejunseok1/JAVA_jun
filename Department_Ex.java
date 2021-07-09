import java.util.Scanner;
public class Department_Ex {

	private static final int ROWS = 7; // > 입력자료수
	private static final int DEPTROWS = 5; // > 부서수만큼 : 출력줄 수

	private static String[] empName = new String[7]; // 근로자명
	private static String[] inDeptId = new String[7]; // 부서 번호
	private static String[] sal = new String[7]; // 월급

	private static String[] outDeptId = new String[7]; // 부서 번호
	private static String[] depName; // 부서 이름
	private static int sumSal = 0; // 월급함
	private static int minSal = 0; // 최저월급
	private static int maxSal = 0; // 최고 월급
	private static String minSalName; // 최저 월급자
	private static String maxSalName; // 최고 월급자

	public static void main(String[] args) {
		input();
		process();
		output();

	}
//	10,김철수,230
//	10,나봉선,270
//	20,다람이,250
//	30,강아지,220
//	40,김세모네모,300
//	10,오세훈,170
//	20,박병철,290
	/*
	 * 입력 : 부서번호, 이름, 월급
	 */
	private static void input() {

		Scanner in = new Scanner(System.in);
		System.out.println("입력 : 부서번호,이름,월급 : ");
		for (int i = 0; i < ROWS; i++) {
			String line = in.nextLine();

			String[] li = line.trim().split(",");

			inDeptId[i] = li[0].trim();
			empName[i] = li[1].trim();
			sal[i] = li[2].trim();
		}
	}

	// 부서번호를 통해서 부서명과 월급함을 출력하고, 최저/최고 월급과 그에 해당하는 월급자들을 뽑아낼 것
	private static void process() {
		int idx = 0;
		for (int i = 0; i < ROWS; i++) {
			String [] depName = { "인사", "총무", "자재", "연구개발", "생산" };
			switch (inDeptId[i]) {
			case "10":
				idx = 0;
				break; // String 으로 잡았기 때문에
			case "20":
				idx = 1;
				break;
			case "30":
				idx = 2;
				break;
			case "40":
				idx = 3;
				break;
			case "50":
				idx = 4;
				break;
			}
			outDeptId[i] = depName[idx];
		}

		for (int i = 0; i < ROWS; i++) {
			sumSal += Integer.parseInt(sal[i]);
			if (i == 0) {
				minSal = Integer.parseInt(sal[0]);
				minSalName = empName[0];
			} else if (Integer.parseInt(sal[i]) < minSal) {
				minSal = Integer.parseInt(sal[i]);
				minSalName = empName[i]; // 순서는 똑같으니깐 같이 i 번째 사람 = 최저 월급에 최저 월급자의 이름 출력됨
			}
			if (Integer.parseInt(sal[i]) > maxSal) {
				maxSal = Integer.parseInt(sal[i]);
				maxSalName = empName[i];
			}
		}

	}

//	출력 : 부서번호, 부서명, 월급함, 최저월급, 최고월급, 최저월급자, 최고월급자
//	outDeptId, depName, sumSal, minSal, maxSal, minSalName, maxSalName
	private static void output() {
		System.out.println("월급합   최저월급   최고월급     최저월급자     최고월급자");
		System.out.printf("%5d     %5d      %5d        %4s      %4s\n", sumSal, minSal, maxSal, minSalName,
				maxSalName);

	}

}
