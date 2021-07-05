class Test{
	long sum(int[] a) {
		long sum = 0;	 // a 배열 정수 합 변수
		
		for(int i=0; i<a.length; i++ ) {
			sum += a[i];
		}
		return sum; // a배열에 저장되어있는 정수들을 더하여 long형으로 리턴시켜줘야함.
	}
}
