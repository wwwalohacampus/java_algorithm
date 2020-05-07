package part01.testcase.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

// (sample case/evaluation case) 
// 실제 시험에서는 sample case 를 통해 솔루션을 검증할 수 있지만,
// 채점용 evaluation case 에는 sample case 에는 없는 '제한조건/예외' 케이스들이 포함되어 있다.

// *(random case) 만들기
// 		: 작성한 코드가 에러 없이 잘 수행 되는지, 예외 케이스에서도 정답을 출력하는지 검증하기 위해서
// 		   스스로 random input 데이터를 만들어서 테스트해 본다면 더 좋은 결과를 얻을 수 있을 것이다.



public class TestCase {
	public static void main(String[] args) throws FileNotFoundException {
		
		// random_input.txt 로 데이터 생성
		File file = new File("random_input.txt");
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		System.setOut(printStream);
		Random random = new Random();
		
		// [1, 10] 사이의 랜덤 수 생성
		int T = random.nextInt(10) + 1;
		System.out.println(T);
		
		// T개의 테스트케이스 만큼 생성
		for (int test_case = 0; test_case < T; test_case++) {
			// [1, 100] 사이의 랜덤 수 생성
			int N = random.nextInt(100) + 1;
			System.out.println(N); 				// N출력
			for (int i = 0; i < N; i++) {
				// [0, 100] 사이의 랜덤 수를 공백을 두고 출력
				System.out.print(random.nextInt(101) + " ");
			}
			// 다음 테스트케이스를 위해 줄바꿈
			System.out.println();
		}
		printStream.close();
	}
}
















