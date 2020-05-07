package part01.datastructure.Array.twoD.index0;


// N x M : (2 x 3)
// 배열의 index 는 1이 아닌 0부터 시작한다.
public class Arrays {
	static int arr[][];
	public static void main(String[] args) {
		arr = new int[2][3];
		arr[0][0] = 11;
		arr[0][1] = 12;
		arr[0][2] = 13;
		arr[1][0] = 21;
		arr[1][1] = 22;
		arr[1][2] = 23;
		
		System.out.println("arr[1][1] : " + arr[1][1]);
	}
}
