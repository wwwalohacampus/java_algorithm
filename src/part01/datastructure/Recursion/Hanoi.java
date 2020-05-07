package part01.datastructure.Recursion;

import java.util.Scanner;

/*
 	하노이탑
 	1. 작은 원반이 위에, 큰 원반이 아래에 위치
 	2. 1번째 기둥에서 3번째 기둥으로 원반을 이동
 	3. 최소의 횟수
 */
public class Hanoi {
	
	// N개의 원반을 x번 이동해서, y번 기둥에 이동
	static void move(int N, int x, int y) {
		if( N > 1 ) {
			move(N-1, x, 6-x-y);
		}
		// 이동과정
		System.out.println("원반[" + N + "]을 " + x + "기둥에서 " + y + "기둥으로 이동!");
		
		if( N > 1 ) {
			move(N-1, 6-x-y, y);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("하노이탑");
		System.out.print("원반 개수 : ");
		int N = sc.nextInt();
		
		move(N, 1, 3);			// 1번 기둥의 N개의 원반을 3번기둥으로 이동
		
	}
	
}




















