package part01.datastructure.Sort;

import java.util.Scanner;

// 버블 정렬(버전 1)
/*
(input)
7
22
5
11
32
120
68
70
 */
public class BubbleSort02 {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n-1; i++) {
			int flag = 0;
			for (int j = 0; j < n-1-i ; j++) {
				if( a[j] > a[j+1] ) {			
					swap(a, j, j+1);
					flag++;
				}	
			}
			if( flag == 0 ) break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("버블 정렬(버전 2)");
		System.out.print("개수  : ");
		int N = sc.nextInt();
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}
		
		bubbleSort(a, N);
		
		System.out.println("오름차순 정렬했습니다.");
		for (int i = 0; i < N; i++) {
			System.out.println("a[" + i + "] : " + a[i]);
		}
		sc.close();
	}
	
	
}










