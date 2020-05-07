package part01.testcase.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("random_input.txt");
		Scanner sc = new Scanner(file);
		
		while( sc.hasNextInt() ) {
			System.out.println( sc.nextLine() );
		}
	}
}
