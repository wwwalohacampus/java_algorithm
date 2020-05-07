package part01.testcase.auto;

import java.io.Console;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

// (sample case/evaluation case) 
// 실제 시험에서는 sample case 를 통해 솔루션을 검증할 수 있지만,
// 채점용 evaluation case 에는 sample case 에는 없는 '제한조건/예외' 케이스들이 포함되어 있다.

// *(random case) 만들기
// 		: 작성한 코드가 에러 없이 잘 수행 되는지, 예외 케이스에서도 정답을 출력하는지 검증하기 위해서
// 		   스스로 random input 데이터를 만들어서 테스트해 본다면 더 좋은 결과를 얻을 수 있을 것이다.


public class CreateRandomCase {
	// type : 1
	public void dynamicRandom(int type, int T, int N, int min, int max) {
		Random random = new Random();
		// [1, T] 사이의 랜덤 수 생성
		int intputT = random.nextInt(T) + 1;
		System.out.println(intputT);
		
		// T개의 테스트케이스 만큼 생성
		for (int test_case = 1; test_case <= intputT; test_case++) {
			// N개의 랜덤수 지정
			for (int i = 0; i < N; i++) {
				// [min, max] 사이의 랜덤 수를 공백을 두고 출력
				System.out.print(( random.nextInt(max-min+1) + min) + " ");
			}
			// 다음 테스트케이스를 위해 줄바꿈
			System.out.println();
		}
		
	}
	
	// type : 2 (테두리에 벽[1]), 
	// type : 3 (벽 X)
	// 격자 type 테스트케이스
	/*
	 * 	type	: 랜덤 케이스 type
	 *  T		: 테스트케이스 개수
	 *  matMin	: 격자의 최소 크기
	 *  matMax	: 격자의 초대 크기
	 *  r		: 시작 좌표의 행		( matMin ≤ r ≤ matMax ) 
	 *  c		: 시작 좌표의 열		( matMin ≤ r ≤ matMax )
	 *  d		: 시작 방향		( ex. 0[북], 1[동], 2[남], 3[서] )
	 * 
	 */
	public void dynamicRandom(int type, int T, int matMin, int matMax) {
		Random random = new Random();
		// [1, T] 사이의 랜덤 수 생성
		int intputT = random.nextInt(T) + 1;
		System.out.println(intputT);
		
		// T개의 테스트케이스 만큼 생성
		for (int test_case = 1; test_case <= intputT; test_case++) {
			// 1. 격자 정보 (행x열)
			int range = matMax - matMin + 1;			// 격자 크기
			int N = random.nextInt(range) + matMin;		// 격자의 행 
			int M = random.nextInt(range) + matMin;		// 격자의 열
			System.out.println(N + " " + M);
			
			// 2. 시작 좌표 (행,열), 방향
			int inner = (N-2) * (M-2);
			int start = random.nextInt(inner) + 1;
			int row = ((start-1) / (M-2)) + 2;			// (검토해보기)
			int col = ((start-1) % (M-2)) + 2;			// (검토해보기)
			int d = random.nextInt(4);
			System.out.println(row + " " + col + " " + d);
			
			
			int[][] MAT = new int[N][M];
			// 테두리 칸의 개수
			// border = (N x M) - ( (N-2) x (M-2) )
			// inner = (N-2) x (M-2)
			
			// 3. 격자
			if( type == 2 )	{	
				// 테두리가 1로 채워진 랜덤 격자 만들기
				MAT = createMat(MAT, N, M);
				// 시작위치 비워두기
				MAT[row-1][col-1] = 0;
			} else if( type == 2) {
				// 벽X 격자 만들기
				// #####(수정중)#####
			}
			
			for (int[] m1 : MAT) {
				for (int m2 : m1) {
					System.out.print(m2 + " ");
				}
				System.out.println();
			}
			
		}
	}
	
	// 테두리에 벽[1]세우고, 내부에 임의의 개수로 벽 세우기
	public int[][] createMat(int[][] MAT, int N, int M) {
		Random random = new Random();
		// 1. 전체를 1로 채우기
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				MAT[i][j] = 1;
		
		// 2. 내부를 0으로 채우기
		for (int i = 1; i < N-1; i++) 
			for (int j = 1; j < M-1; j++) 
				MAT[i][j] = 0;
		
		// 3. 내부 칸의 개수 (0 ~ ( (N-2) x (M-2) ) 임의의 개수만큼 벽[1] 세우기
		int inner = (N-2) * (M-2);
		int wall = random.nextInt(inner+1);
		
		// 3-1. 중복되지 않게 (wall)개 만큼 난수 생성
		int[] wallMAT = new int[inner];
		for (int i = 0; i < inner; i++) {
			wallMAT[i] = random.nextInt(inner) + 1;
			for (int j = 0; j < i; j++) {
				if( wallMAT[i] == wallMAT[j] )
					i--;
					break;
			}
		}
		
		// 3-1. (wall)개 만큼 MAT격자 내부에 벽 세우기
		for (int i = 0; i < wallMAT.length; i++) {
			int row = ((wallMAT[i]-1) / (M-2)) + 1;
			int col = ((wallMAT[i]-1) % (M-2)) + 1; 
			MAT[row][col] = 1;
		}
		
		return MAT;
	}
	
	public File createTestCase(String path, int type, int T, int N, int min, int max) throws FileNotFoundException {
		// random_input.txt 로 데이터 생성
		File file = new File(path);
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		// file 출력으로 설정 변경
		System.setOut(printStream);
		
		// T : [1~10], N : 6, R : [0~100]
		// dynamicRandom(10, 6, 0, 100); 
		dynamicRandom(type, T, N, min, max);
		
		
		// file 출력 --> console 출력으로 변경
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out))); 
		return file;
	}
	
	public File createTestCase(String path, int type, int T, int matMin, int matMax) throws FileNotFoundException {
		// random_input.txt 로 데이터 생성
		File file = new File(path);
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		// file 출력으로 설정 변경
		System.setOut(printStream);
		
		// T : [1~10], N : 6, R : [0~100]
		// dynamicRandom(10, 6, 0, 100); 
		dynamicRandom(type, T, matMin, matMax);
		
		
		// file 출력 --> console 출력으로 변경
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out))); 
		return file;
	}

}
  















