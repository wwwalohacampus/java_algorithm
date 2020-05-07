package part01.datastructure.List;

import java.util.ArrayList;

public class list {
	static ArrayList<Integer> v;
	public static void main(String[] args) {
		v = new ArrayList<Integer>();
		// arraylist 초기화
		v.clear();
		
		// arraylist 데이터 1 삽입
		v.add(1);
		
		// arraylist 데이터 10 삽입
		v.add(10);
		
		// 첫번째 원소 출력
		System.out.println("v[0] = " + v.get(0));
		
		// 두번째 원소 출력
		System.out.println("v[0] = " + v.get(1));
		
		// arraylist의 원소 개수 출력
		System.out.println("v.size = " + v.size());
		
	}
}
