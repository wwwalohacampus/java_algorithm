package part02.DP.solution;

import java.util.Scanner;

public class StepStone {
	
	static int T, N;
	static int Answer;
	static int S[] = new int[10001];
	static int dp[][] = new int[10001][3];
	/*
	 	dp[i][1] 	: 마지막에 한 칸 건너 i지점 도착했을 때 최대점수
	 					즉, 다음 번에 반드시 두 칸을 거너야 하는 경우
	 					i-1번째 징검돌 -> i번째 징검돌로 이동한 경우
	 					
	 	dp[i][2]		: 마지막에 두 칸 건너 i지점에 도착했을 때 최대점수
	 					즉, 다음번에 한 칸을 건너든 두 칸을 던너든 상관 없는 겨우
	 					i-2번째 징검돌 -> i번째 징검돌로 이동한 경우
	 					시작점 -> 1,2번째 징검돌로 이동한 경우
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			for (int i = 1; i <= N; i++) {
				S[i] = sc.nextInt();
			}
			// 시작점의 누적점수는 0
			dp[0][1] = dp[0][2] = 0;
			// 1번돌을 밟았을 때
			dp[1][2] = S[1];
			// 2번돌부터 N번돌 까지 탐색
			for (int i = 2; i <= N; i++) {
				// i-1 -> i로 이동한 경우
				dp[i][1] = dp[i-1][2] + S[i];
				// i-2 -> i로 이동한 경우
				dp[i][2] = Math.max(dp[i-2][1], dp[i-2][2]) + S[i];
			}
			Answer = Math.max(dp[N][1], dp[N][2]);
			System.out.println("#" + test_case + " " + Answer);
		}
		
		sc.close();
		
	}
}




















