package part01.datastructure.Recursion;

import java.util.Scanner;

// 유클리드 호제법으로 최대공약수 구하기
public class EuclidGCD {
	static int gcd(int x, int y) {
		if( y == 0 ) 
			return x;
		else
			return gcd(y, x%y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수의 최대공약수를 구합니다.");
		
		System.out.print("x : ");
		int x = sc.nextInt();
		System.out.print("y : ");
		int y = sc.nextInt();
		
		if( x < y ) {
			int temp = x;
			x = y;
			y = temp;
		}
		
		System.out.println(x + ", " + y + "의 최대공약수 : " + gcd(x, y));
		sc.close();
	}
	
}






