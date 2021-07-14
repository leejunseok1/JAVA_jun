import java.util.Arrays;

public class Arrays_1 {

	public static void main(String[] args) {
		
		int[] Student = {50,60,70,80,90}; // 학생 5명의 점수를 저장할 수 있는 배열을 생성
		
		System.out.println(Arrays.toString(Student)); 
		System.out.println(Student.length);
		
		
		for (int i = 0; i < Student.length; i++) {
			System.out.printf("Student[%d] : %d%n", i, Student[i]);
		} // 순서대로 출력
		
		for (int i = 0; i < Student.length; i++) {
			Student[i] = (int)(Math.random() * Student.length) + 1; // 길이까지 무작위 값 배열에 저장
		}
		for (int i = 0; i < Student.length; i++) {
			System.out.printf("%2d", Student[i]);
		}
		System.out.println();
		
		int sum = 0;
		float avg = 0;
		
		int[] score = {100,90,50,40,80};
			
		for (int i = 0; i < score.length; i++) {
			sum = sum + score[i];  // 총합 구하는 식
		}
		avg = sum / (float)(score.length); // 평균값 구하는 식
		
		
		System.out.println("총합 :" + sum);
		System.out.println("평균 :" + avg); // 합, 평균 구하기
		
		int[] score2 = {79,88,13,55,100,35,64};
		
		int max = score[0];
		int min = score[0];
		
		for (int i = 0; i < score2.length; i++) {
			if(max > score2[i]) {
				max = score2[i];
			}else if (min < score2[i]) {
				min = score2[i];
			}
		}
		System.out.println("최댓값= "+max); 
		System.out.println("최솟값= "+min);
		System.out.println();
		
		
		
		int[] sf = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(sf));
		
		for (int i = 0; i < 100; i++) {
			
			int n = (int)(Math.random()*10); 
			// sf[0]과 sf[n]의 값을 서로 바꿈
			int tmp = sf[0];
			sf[0] = sf[n];
			sf[n] = tmp;
		}
		
		System.out.println(Arrays.toString(sf));
		System.out.println();
		//===================================================
		int [] lotto = new int[45]; // 로또 번호 만들기 식
		
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
		}
		
		for (int i = 0; i < 6; i++) {
			int n = (int)(Math.random()*45);
			int tmp = lotto[i];
			lotto[i] = lotto[n];
			lotto[n] = tmp;
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d번째 공 : %d%n", i+1,lotto[i]);
		}
		
		int[] arr = {9,8,12,45,78,61,2,5};
		int max1 = 0;
		int min1 = 0;
		int j = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[max1] < arr[i]) { // 최대값 구하기
				max1 = i; // 최대값이 있는 자리 i를 max변수에 저장
				j = i; // 최대값이 들어있는 자리를 가리키는 수 i를 j에 저장
			}
				else if (arr[min1]> arr[i]) {
				min1 = i;
				j = i;
				}
		}
		
		System.out.println("최대값 : " + arr[max1]);
		//max에 저장된 수는 최대값이 있는 자리의 수를 의미하기 때문에 arr[max]는 최대값을 출력
		System.out.println((j+1)+ "번째 숫자");
		//j에 저장된 i의 수는 최대값이 저장된 자리의 수이기 떄문에 j를 출력하게 되면
		//최대값이 몇번째 자리에 저장되었는지를 알수있다. 
		System.out.println("최소값 : " + arr[min1]);
		
		System.out.println((j+1) + "번쨰 숫자");
		
		
		
		
		
		
	}

}
