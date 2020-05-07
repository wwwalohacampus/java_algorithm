package part01.datastructure.Search;

import java.util.Scanner;

public class SeqSearch {
	// 1. 검색할 값을 발견하지 못하고 검색이 끝나는 경우
	// 2. 검색할 값을 발견한 경우
	
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		while(true) {
			if( i == n )
				return -1;
			if(a[i] == key)
				return i;
			i++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("개수  : ");
		int N = sc.nextInt();
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int key = sc.nextInt();
		int idx = seqSearch(a, N, key);
		
		if( idx == -1 )
			System.out.println("찾는 값의 요소가 없습니다.");
		else
			System.out.println(key + "(은/는) a[" + idx + "]에 있습니다." );
		
		
	}
	
	
}













