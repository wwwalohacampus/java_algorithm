package part02.DP.solution;

// 막대 자르기
public class RodCutting {
	/*
	 	길이 i의 막대를 양의 정수 크기로 잘라 얻을 수 있는 최대 판매 가격을 '분할 정복'을 이용하여 계산한다.
	 	입력: i - 막대의 길이
	 	출력: 최대 판매 가격
	 */
	
	static int cutRod_DC(int price[], int i) {
		int j, maxSell;
		if( i == 0 ) return 0;
		maxSell = 0;
		
		for (j = 1; j <= i; j++) {
			maxSell = Math.max(maxSell, price[j-1] + cutRod_DC(price, i-j));
		}
		return maxSell;
	}
	
	/*
	 	길이 n의 막대를 양의 정수를 크기로 잘라 얻을 수 있는 최대 판매 가격을 '동적 계획'을 이용하여 계산한다.
	 	입력: n - 막대의 길이 n
	 	출력: 최대 판매 가격
	 */
	static int cutRod_DP(int price[], int n) {
		int maxSell[] = new int[n+1];
		maxSell[0] = 0;
		
		// 배열 maxSell[]을 쉬운 문제부터 시작하여 점점 어려운 문제를 풀어 구한다.
		// maxSell[n]이 구하는 값이다
		for (int j = 1; j <= n; j++) {
			int max_val = 0;
			
			for (int k = 1; k <= j; k++) {
				max_val = Math.max(max_val, price[k-1] + maxSell[j-k]);
			}
			maxSell[j] = max_val;
		}
		return maxSell[n];
	}
	
	public static void main(String[] args) {
		int[ ] A = new int[ ] {2,5,9,10};
		int size = A.length;
		System.out.println("분할 정복을 이용하여 구한 최대 판매 금액: " + cutRod_DC(A, size));
		System.out.println("동적 계획을 이용하여 구한 최대 판매 금액: " + cutRod_DP(A, size));
	}
}












