package part01.datastructure.Sort;

import java.util.Scanner;

public class SelectionSort {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// 선택 정렬
	static void selectionSort(int[] a, int n) {
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if(a[i] > a[j])
					swap(a, i, j);
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("선택 정렬");
		System.out.print("개수  : ");
		int N = sc.nextInt();
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}
		
		selectionSort(a, N);
		
		System.out.println("오름차순 정렬했습니다.");
		for (int i = 0; i < N; i++) {
			System.out.println("a[" + i + "] : " + a[i]);
		}
		sc.close();
	}
}













