import java.io.*;
import java.util.*;

public class BOJ_실버1_2468_안전영역 {
	
	/*
	 * 풀이 시간 : 오후 4시 54분 ~ 오후 5시 23분 
	 * 풀이 방법 : DFS 
	 * 메모리 : 15824KB, 시간 : 204ms 
	 */
	
	static int N;
	static int map[][];
	static boolean visited[][];
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int dc[] = {0, 0, -1, 1}; 

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}
		
		int ans = 0; // 안전 영역의 개수 
    
		// 탐색 시작 
		for(int t=1; t<=max; t++) {
			int cnt = 0;
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] >= t && !visited[i][j]) {
						//System.out.println(i + ", " + j);
						cnt++;
						visited[i][j] = true;
						dfs(i, j, t);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
    
		System.out.println(ans);
	}
	
	public static void dfs(int r, int c, int t) {
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc) && map[nr][nc] >= t && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, t);
			}
		}
	}
	
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < N && 0<= c && c < N) return true;
		return false;
	}
		
}
