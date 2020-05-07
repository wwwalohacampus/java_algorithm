package part02.Graph.DFS.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import part01.testcase.auto.CreateTest;

public class Permutation extends CreateTest{
	static int T, N;
	// i번째 숫자를 이미 선택했는지 여부를 체크할 배열
	// i숫자를 이미 선택한 경우 visited[i] = 1
	// i숫자를 아직 선택 하지 않은 경우 visited[i] = 0
	static int visited[] = new int[7];
	static int Answer[] = new int[7];
	
	public static void dfs(int depth) {
		// 종료조건
		if( depth == N + 1) {
			for (int i = 1; i <= N; i++) {
				System.out.print(Answer[i] + " ");
			}
			System.out.println();
		}
		// 탐색조건
		else {
			for (int i = 1; i <= N; i++) {
				// 아직 선택하지 않은 숫자 i를 고른다.
				if(visited[i] == 0) {
					visited[i] = 1;
					Answer[depth] = i;
					dfs(depth + 1);
					// 탐색이 끝나면 숫자i를 선택하기 전 상황으로 원복
					visited[i] = 0;
					Answer[depth] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
//		Permutation obj = new Permutation();
//		File file = new File(obj.goTest(1, 5, 1, 3, 6));
		
//		Scanner sc = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			// visited배열 초기화
			for (int i = 1; i <= N; i++) {
				visited[i] = 0;
			}
			System.out.println("#" + test_case);
			dfs(1);
		}
	}
}




