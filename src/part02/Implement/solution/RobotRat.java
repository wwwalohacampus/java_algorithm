package part02.Implement.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import part01.testcase.auto.CreateTest;

public class RobotRat extends CreateTest {
	// 북[-1,0] 동[0,1], 남[1,0], 서[0,-1]
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int T;
	static int N, M;
	static int R, C, D;
	static int MAT[][] = new int[51][51];
	
	public static void main(String[] args) throws FileNotFoundException {
		RobotRat obj = new RobotRat();
		File file = new File( obj.goTest(2, 50, 3, 10) );
		
		Scanner sc = new Scanner(file);
//		Scanner sc =new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			D = sc.nextInt();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					MAT[i][j] = sc.nextInt();
				}
			}
			int Answer = 0;
			while(true) {
				MAT[R][C] = 2;
				int next_R = R;		// 다음 행
				int next_C = C;		// 다음 열
				int next_D = D;		// 다음 방향
				for (int i = 1; i <= 4; i++) {
					next_R = R + dr[next_D];
					next_C = C + dc[next_D];
					// 다음 위치로 이동할 수 있는 경우
					if(MAT[next_R][next_C] == 0) {
						break;
					}
					// 다음 위치로 이동할 수 없는 경우 방향 전환
					else {
						next_D = (next_D + 1) % 4;
					}
				}
				// 네 방향 중 이동 가능한 고싱 있는 경우
				if(MAT[next_R][next_C] == 0) {
					R = next_R;
					C = next_C;
					D = next_D;
					Answer++;
				}
				// 네 방향 중 모두 진행이 불가능한 경우
				else {
					// 최초 방향의 반대 방향을 설정
					int prev_D = (D + 2) % 4;
					int prev_R = R + dr[prev_D];
					int prev_C = C + dc[prev_D];
					// 뒤로 이동할 수 있는 경우
					if(MAT[prev_R][prev_C] != 1) {
						R = prev_R;
						C = prev_C;
						Answer++;
					}
					// 뒤로 이동할 수 없는 경우 종료
					else {
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}



















