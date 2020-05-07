package part01.datastructure.Sort;

import java.util.Scanner;

// 버블 정렬(버전 1)
public class BubbleSort01 {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// 버블 정렬
	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1-i ; j++) {
				if( a[j] > a[j+1] )			
					swap(a, j, j+1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("버블 정렬(버전 1)");
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










