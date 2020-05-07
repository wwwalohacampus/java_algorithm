package part02.Graph.DFS.solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Volcano {
	static int T, N;
	
	static int MAT[][] = new int[101][101];
	static int dr[] = { 0,1,0,-1 };
	static int dc[] = { 1,0,-1,0 };
	
	static ArrayList<int[]> S = new ArrayList<int[]>();		// 화산 지점의 리스트
	
	static int Answer;
	
	public static void dfs(int now_row, int now_col) {
		// 종료조건
		// 별다른 종료조건이 필요가 없음
		
		// 탐색조건
		for (int i = 0; i < 4; i++) {
			int nxt_row = now_row + dr[i];
			int nxt_col = now_col + dc[i];
			// 격자 범위인지 확인
			if( nxt_row >= 1 && nxt_row <= N && nxt_col >= 1 && nxt_col <= N ) {
				// 다음 지점이 초원이면 
				if( MAT[nxt_row][nxt_col] == 0 ) {
					MAT[nxt_row][nxt_col] = -1;			// 이미 접근한 지점 : -1
					Answer--;							// 초원의 개수 -1
					dfs(nxt_row, nxt_col);
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
	
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();

			// 입력과 동시에 초원/화산을 조사
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					MAT[i][j] = sc.nextInt();
					// 초원인 경우 (화산 폭발 전)
					if( MAT[i][j] == 0 )		
						Answer++;
					// 화산인 경우
					else if( MAT[i][j] == 2 )
						S.add(new int[] { i, j });
				}
			}
			
			// 화산의 개수만큼 화산을 폭발시킨다.
			for (int i = 0; i < S.size(); i++) {
				dfs( S.get(i)[0], S.get(i)[1] );
			}
			
			System.out.println("#"+ test_case + " " + Answer);
			
			
		}
	}
}





