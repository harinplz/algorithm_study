import java.io.*;
import java.util.*;

public class BOJ_실버2_3085_사탕게임 {
	
	static int N;
	static char arr[][];
	static boolean visited[][];
	
	static int ans = 1;
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		
		// 하나씩 방문하며 인접한 칸 확인하기 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visited[i][j] = true;
				
				for(int d=0; d<4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(isRange(nr, nc) && !visited[nr][nc] &&  arr[i][j] != arr[nr][nc]) {
						//System.out.println(Arrays.deepToString(arr));
						swap(i, j, nr, nc);
						count();
						swap(nr, nc, i, j);
					}
				}
			}
		}
		
		System.out.println(ans);
		
	
	}
	
	static boolean isRange(int r, int c) {
		if(0 <= r && r < N && 0 <= c && c < N) return true;
		else return false;
	}
	
	static void swap(int r, int c, int nr, int nc) {
		char temp = arr[r][c];
		arr[r][c] = arr[nr][nc];
		arr[nr][nc] = temp;
	}
	
		static void count() {
		
		// 행 연속 부분 구하기 
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(arr[i][j] == arr[i][j+1]) {
					cnt++;
					ans = Math.max(cnt, ans);
				}
				else cnt = 1;
			}
		}
		
		// 열 연속 부분 구하기 
		for(int i=0; i<N; i++) {
			int cnt = 1;
			for(int j=0; j<N-1; j++) {
				if(arr[j][i] == arr[j+1][i]) {
					cnt++;
					ans = Math.max(cnt, ans);
				}
				else cnt = 1;
			}
		}
	}

}
