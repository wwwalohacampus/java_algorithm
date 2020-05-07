package part02.Implement.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import part01.testcase.auto.CreateTest;

public class LoL extends CreateTest {
	static int T;
	// A와 B의 값이 int를 초과할 수 있으므로 long을 사용
	static long A, B; 
	public static void main(String[] args) throws FileNotFoundException {
		LoL autoTest = new LoL();
		File file = new File( autoTest.goTest(1, 10, 2, 1, 5000) );
		
		Scanner sc = new Scanner(file);
//		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T ;test_case++) {
			A = sc.nextInt();
			B = sc.nextInt();
			// 가장 오랜 시간이 걸리는 케이스 ( A : 5000, B : 1 ) 
			// ( 5000 X 2^22 = 20,297,520,000 ≤ 1 X 3^22 = 31,381,059,609 )
			// ==> 22일이 가장 오래걸리는  일 수이다.
			for (int i = 1; i <= 22; i++) {
				A = A * 2;
				B = B * 3;
				if( A < B ) { 		// 채린이의 점수가 성호의 점수보다 크다면
					System.out.println("#" + test_case + " " + i);
					break;
				}
			}
		}
	}
}
