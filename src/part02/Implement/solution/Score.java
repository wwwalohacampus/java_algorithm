package part02.Implement.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import part01.testcase.auto.CreateTest;


public class Score extends CreateTest {
	static int score[];
	public static void main(String[] args) throws FileNotFoundException {
		score = new int[6];			// 학생들의 점수
		Score obj = new Score();
		File file = new File( obj.goTest(1, 10, 6, 0, 100) );
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			for (int i = 0; i < 6; i++) {
				score[i] = sc.nextInt();
			}
			int MAX_score = 0;			// 가장 높은 점수
			// 기존의 MAX_score 보다 더 높은 점수를 발견 시 갱신
			for (int i = 0; i < 6; i++) {
				if(MAX_score < score[i]) {
					MAX_score = score[i];
				}
			}
			int MIN_score = 100;		// 가장 낮은 점수
			// 기존의 MIN_score 보다 더  낮은 점수를 발견 시 갱신
			for (int i = 0; i < 6; i++) {
				if(MIN_score > score[i]) {
					MIN_score = score[i];
				}
			}
			int sum = 0;			// 점수의 합
			// 6명의 점수를 모두 합산
			for (int i = 0; i < 6; i++) {
				sum = sum + score[i];
			}
			// 가장 높은 점수와 가장 낮은 점수를 제외
			sum = sum - MAX_score - MIN_score;
			int Answer = sum / 4;			// 이해도 점수 : 답
			System.out.println("#" + test_case + " " + Answer);
		}
	}
}








