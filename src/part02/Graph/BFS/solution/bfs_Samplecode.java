package part02.Graph.BFS.solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 
 	(입력예시)
1
7 6
1 7
1 2
2 4
2 5
1 3
3 6
6 7
	
	(그래프 예시)
	    1
	   /  \
	  2    3   
	 / \    \
	4   5    6
             |
             7
 */

public class bfs_Samplecode {
	static int T, N, M, A, B;
	// 정점을 담을 큐 (row, col, cost)
	static Queue<Integer> que = new LinkedList<Integer>();
	
	// 출발지 S, 목적지 E
	static int S, E;
	
	// 인접 행렬
	static int MAT[][] = new int[101][101];
	static int visited[] = new int[101];
	// 방문 횟수
	static int cnt = 0;
	
	public static void bfs() {
//		1. 시작점을 큐에 넣는다.
		que.add(S);
		visited[S] = 1;
		cnt++;
//		5. 큐가 비어있는지 않다면 반복
		while(!que.isEmpty()) {
	//		2. 큐에서 한 점을 꺼내서 기준점으로 삼는다.
			System.out.println("now : " + que.peek());
			int now = que.poll();
			
	//		3. 기준점이 목적지이면 탐색을 종료한다.
			if( now == E )
				break;
			
	//		4. 그렇지 않은 경우 기준점에서 갈 수 있는 다른 정점들을 큐에 넣는다.
			else {
				for (int i = 1; i <= N; i++) {
					// 기존에 방문하지 않고
					// 현재 정점과 연결된 점을 탐색
					if( visited[i] == 0 && MAT[now][i] == 1 ) {
						visited[i] = 1;
						cnt++;
						// 해당 지점을 큐에 넣는다.
						que.add(i);
						System.out.println(i + "번 정점 방문");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// N : 정점의 수
			// M : 간선의 수
			N = sc.nextInt();
			M = sc.nextInt();
			
			// S : 출발지
			// E : 목적지
			S = sc.nextInt();
			E = sc.nextInt();
			
			// visited배열 초기화
			for (int i = 1; i <= N; i++) {
				visited[i] = 0;
			}
			
			// 인접배열 초기화
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = 0;
				}
			}
			
			// 인접배열 정점간의 관계 지정
			for (int i = 1; i <= M; i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				MAT[A][B] = 1;
			}
			
			// 인접배열 출력
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(MAT[i][j] + " ");
				}
				System.out.println();
			}
			
			// 그래프 탐색 - BFS(Breadth First Search)
			bfs();
			
			System.out.println(cnt + "개의 정점 방문");
		}
	}
	
}




















