package part01.datastructure.Search;

import java.util.Arrays;
import java.util.Scanner;

// 이진 검색
public class BinSearchAPI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("개수 : ");
		int N = sc.nextInt();
		int[] a = new int[N];
		
		System.out.println("오름차순으로 입력하세요.");
		System.out.print("a[0] : ");
		a[0] = sc.nextInt();
		
		for (int i = 1; i < N; i++) {
			do {
				System.out.print("a[" + i + "] : ");
				a[i] = sc.nextInt();
			} while(a[i] < a[i-1]);
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		
		int idx = Arrays.binarySearch(a, key);
		
		if( idx < 0 )
			System.out.println("찾는 값의 요소가 없습니다.");
		else
			System.out.println(key + "(은/는) a[" + idx + "]에 있습니다." );
		
		sc.close();
	}
	
}












