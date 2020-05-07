package part01.datastructure.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class queue {
	static Queue<Integer> que;
	public static void main(String[] args) {
		// queue는 LinkedList 클래스로 선언한다.
		que = new LinkedList<Integer>();
		
		// queue 초기화 
		que.clear();
		
		// queue에 데이터 3 삽입
		que.add(3);
		
		// queue에 데이터 30 삽입
		que.add(30);
		
		// queue의 size 출력
		System.out.println("que.size : " + que.size());
		
		// queue 에서 데이터 확인 및 제거
		System.out.println("data : " + que.poll());
		
		// queue 에서 데이터 확인
		System.out.println("data : " + que.peek());
		
		// queue 에서 데이터 확인 및 제거
		que.poll();
		
		// queue 에서 아무것도 없는지 확인
		if(que.isEmpty()) {
			System.out.println("queue is empty");
		}
	}
}
