package part01.testcase.auto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadTestCase extends CreateTest {
	public static void main(String[] args) throws FileNotFoundException {
		LoadTestCase obj = new LoadTestCase();
		
//		File file = new File(obj.goTest()());
		File file = new File(obj.getFilePath());
		Scanner sc = new Scanner(file);
		
		while( sc.hasNextInt() ) {
			System.out.println( sc.nextLine() );
		}
		
		sc.close();
	}
}
