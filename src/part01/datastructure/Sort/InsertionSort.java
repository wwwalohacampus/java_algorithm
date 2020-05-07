package part01.datastructure.Sort;

import java.util.Scanner;

public class InsertionSort {
	
	// 삽입 정렬
	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int key = a[i];
			for (j = i; j > 0 && a[j-1] > key; j--) {
				a[j] = a[j-1];
			}
			a[j] = key;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("삽입 정렬");
		System.out.print("개수  : ");
		int N = sc.nextInt();
		int[] a = new int[N];
		
		for (int i = 0; i < N; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}
		
		insertionSort(a, N);
		
		System.out.println("오름차순 정렬했습니다.");
		for (int i = 0; i < N; i++) {
			System.out.println("a[" + i + "] : " + a[i]);
		}
		sc.close();
	}
}
