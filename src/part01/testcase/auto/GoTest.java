package part01.testcase.auto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoTest extends CreateTest {
	public static void main(String[] args) throws FileNotFoundException {
		// 작성한 솔루션 코드에서 
		// " Scanner sc = new Scanner(System.in); " 대신 아래 코드를 작성하면,
		// 자동으로 테스트케이스를 만들어 검증할 수 있다.
		GoTest name = new GoTest();
		File file = new File( name.goTest(1, 10, 6, 0, 100) );
		Scanner sc = new Scanner(file);
		// ↑ (자동 테스트케이스) 코드
		
		while( sc.hasNextInt() ) {
			System.out.println( sc.nextLine() );
		}
		
		sc.close();
	}
}
