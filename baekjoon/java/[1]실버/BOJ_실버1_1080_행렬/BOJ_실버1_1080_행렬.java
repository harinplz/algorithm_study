import java.io.*;
import java.util.*;

public class BOJ_실버1_1080_행렬 {

	static int N,M;
	static int A[][], B[][];
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				A[i][j] = str.charAt(j) - 48;
			}
		}
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				B[i][j] = str.charAt(j) - 48;
			}
		}
		
		// 문제 풀이 시작 
		int ans = 0;
		for(int i=0; i+3 < N + 1; i++) {
			for(int j=0; j + 3 < M + 1; j++) {
				if(A[i][j] != B[i][j]) {
					ans++;
					change(i, j); // 1을 0으로, 0을 1로 바꾸는 연산 
				}
			}
		}
		
		boolean flag = check(); // A와 B 행렬이 같은 지 확인
		
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}
	
	public static void change(int r, int c) {
		for(int i=r; i<r+3; i++) {
			for(int j=c; j<c+3; j++) {
				if(A[i][j] == 0) A[i][j] = 1;
				else A[i][j] = 0;
			}
		}
	}
	
	public static boolean check() {
		boolean check = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] != B[i][j]) {
					check = false;
					break;
				}
			}
		}
		
		return check;
	}
}
