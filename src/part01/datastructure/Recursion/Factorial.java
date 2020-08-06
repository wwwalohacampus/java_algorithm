package part01.datastructure.Recursion;

import java.util.Scanner;

// 팩토리얼을 재귀으로 구현
public class Factorial {
	
	static int factorial(int n) {
		// 재귀조건
		if( n > 0 )
			return n * factorial(n-1);
		// 종료조건
		else
			return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		
		System.out.println("n! = " + factorial(n) );
	}
	
}
