package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 분할 정복 문제
 * 메모리 : 14112KB 128ms
 * 어제 수업시간에 풀었던 색종이 만들기 문제와 매우 유사해서 쉽게 풀었음!
 * 괄호 넣는 위치가 조금 헷갈리긴 했는데 재귀를 불러오기 전과 모든 재귀를 부른 후 넣어주니 원하는대로 나옴!
 */

public class BOJ_실버1_1992_쿼드트리 {
	
	private static StringBuilder sb = new StringBuilder();
	
	private static int[][] arr;

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		arr = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		cut(0, 0, N);

		System.out.println(sb);
	}

	private static void cut(int r, int c, int size) {

		int sum = 0;
		
		if(size < 1) {
			return;
		}
		
		
		for(int i=r; i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size*size) {
			sb.append(1);
		}
		else if(sum == 0) {
			sb.append(0);
		}
		else {
			int half = size/2;
			
			sb.append("(");
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			sb.append(")");
		}
	}
	
}