package part01.datastructure.Search;

import java.util.Scanner;

// 이진 검색
public class BinSearch {
	static int binSearch(int[] a, int n, int key) {
		int pl = 0;				// 검색 범위의 첫 인덱스
		int pr = n - 1;			// 검색 범위의 끝 인덱스
		
		do {
			int pc = (pl + pr) / 2;		// 중앙 요소의 인덱스
			if(a[pc] == key)
				return pc;				// 검색 성공!
			else if(a[pc] < key)
				pl = pc + 1;			// 검색 범위를 뒤쪽 절반으로 좁힘
			else
				pr = pc - 1;			// 검색 범위를 앞쪽 절반으로 좁힙
			
		} while(pl <= pr);
		
		return -1;						// 검색 실패!
	}
	
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
		
		int idx = binSearch(a, N, key);
		
		if( idx == -1 )
			System.out.println("찾는 값의 요소가 없습니다.");
		else
			System.out.println(key + "(은/는) a[" + idx + "]에 있습니다." );
	}
	
}












