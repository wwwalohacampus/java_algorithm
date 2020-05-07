package part01.datastructure.Stack;

import java.util.Stack;

public class stack {
	static Stack<Integer> stk;
	public static void main(String[] args) {
		stk = new Stack<Integer>();
		
		// stack 초기화
		stk.clear();
		
		// stack 데이터 2 삽입
		stk.add(2);
		
		// stack 데이터 20 삽입
		stk.add(20);
		
		// stack의 size 출력
		System.out.println("stk.size : " + stk.size());
		
		// stack에서 데이터 확인 및 제거
		System.out.println("data : " + stk.pop());
		
		// stack에서 데이터 확인
		System.out.println("data : " + stk.peek());
		
		// stack에 아무것도 없는지 확인
		if(stk.isEmpty()) {
			System.out.println("stack is empty");
		}
		
		
	}
}
