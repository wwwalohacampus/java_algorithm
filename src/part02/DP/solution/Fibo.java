package part02.DP.solution;

import java.util.Scanner;

public class Fibo {
	static int N;
	static long dp[] = new long[91];
	
	public static long fibo(int num) {
		// 한 번도 계산한 적이 없다면 재귀함수롤 계산
		if( dp[num] == -1 ) {
			dp[num] = fibo(num - 1) + fibo(num - 2);
		}
		return dp[num];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 메모이제이션 배열의 초기값을 -1 로 세팅
		for (int i = 0; i <= 90; i++) {
			dp[i] = -1;
		}
		dp[1] = 1;
		dp[2] = 1;
		
		N = sc.nextInt();
		System.out.println(fibo(N));
		
		
		
		sc.close();
	}
}











