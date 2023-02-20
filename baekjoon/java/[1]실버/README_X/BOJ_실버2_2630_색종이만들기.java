package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 분할 정복 문제
 * 메모리 : 15604KB, 시간 : 164ms
 * 어떻게 분할할 것인지 잘 생각해보고 코드 짜기!!
 * 수업시간에 했던 문제랑 완전 똑같음 복습 개념
 */

public class BOJ_실버2_2630_색종이만들기 {
	
	private static StringTokenizer st;
	private static int arr[][];
	
	private static int white = 0;
	private static int blue = 0;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		arr = new int[N][N]; //색종이 배열 생성
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()); //색종이 입력
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
	}


	private static void cut(int r, int c, int size) {
		
		if(size<1) return;
		
		int sum = 0;
		
		//분할한 색종이의 수를 더함
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size * size) {
			blue++;
		}else if(sum == 0) {
			white++;
		}else {
			int half = size/2;
			
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
		}
		
	}
	
}
