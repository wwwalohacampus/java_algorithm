package part02.Graph.BFS.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	// 정점을 담을 큐
	static Queue<int[]> que = new LinkedList<int[]>();
	
	// 격자
	static int MAT[][] = new int[1001][1001];
	
	// 동남서북 순서롤 탐색할 배열
	static int dr[] = { 0, 1, 0, -1 };
	static int dc[] = { 1, 0, -1, 0 };
	
	// T, N, M, 시작점, 도착점
	static int T, N, M, S_r, S_c, E_r, E_c;
	// 최소 이동횟수
	static int Answer;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 격자 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			// 큐 초기화
			que.clear();
			
			N = sc.nextInt();
			M = sc.nextInt();
			S_r = sc.nextInt();
			S_c = sc.nextInt();
			E_r = sc.nextInt();
			E_c = sc.nextInt();
			
			// 격자 입력
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = sc.nextInt();
				}
			}
			
			// 시작점(S_r, S_c, 이동횟수 0) 삽입
			que.add(new int[] { S_r, S_c, 0 } );
			MAT[S_r][S_c] = 1;
			
			
			
			// 탈출구에 도달하지 못하면 -1
			Answer = -1;
			while(!que.isEmpty()) {
				int now[] = que.poll();
				int now_row = now[0];				// 시작점이 행
				int now_col = now[1];				// 시작점의 열
				int now_cost = now[2];				// 이동횟수
				
				// 종료조건
				if( now_row == E_r && now_col == E_c ) {
					Answer = now_cost;
					break;
				}
				
				// 탐색조건
				else {
					for (int i = 0; i < 4; i++) {
						int nxt_row = now_row + dr[i];
						int nxt_col = now_col + dc[i];
						int nxt_cost = now_cost + 1;
						// 이동지점이 격자 안에 있는 경우
						if( nxt_row >= 1 && nxt_row <= N
								&& nxt_col >= 1 && nxt_col <= M) {
							// 이동지점이 이동 가능한 곳일 경우
							if(MAT[nxt_row][nxt_col] == 0) {
								MAT[nxt_row][nxt_col] = 1;
								que.add(new int[] { nxt_row, nxt_col, nxt_cost });
							}
						}
					}
				}
				
			}
			System.out.println("#" + test_case + " " + Answer);
			
		}
	}
}

















