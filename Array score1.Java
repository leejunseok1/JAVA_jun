
public class Java {

	public static void main(String[] args) {
		int[][] score = {
				{100,100,20} // 00 01 02
			   ,{20,20,20} // 10 11 12
			,{30,30,30} // 20 21 22
			,{40,40,40} // 30 31 32
			,{50,50,50} // 41 42 43
		};
		int korTotal = 0, engTotal = 0, mathTotal = 0; // 국어 영어 수학의 총점
		
		System.out.println("번호 국어 영어 수학 총점 평점"); 
		System.out.println("--------------------");
		
		
		for (int i = 0; i < score.length; i++) { // i부터 score의 길이만큼 증감
			int sum = 0; //개인별 총점
			float avg = 0.0f; // 개인별 평균 // 평균점수이니 실수로 초기화
			
			korTotal += score[i][0]; // i는 현재 0이니 첫번쨰 행의 0열을 다 더해준 값 이 korTotal 
			engTotal += score[i][1];
			mathTotal += score[i][2];
			System.out.printf("%3d",i+1); 

			for (int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			
			avg = sum/(float)score[i].length; 
			
		}		

	}

}
