import java.io.*;
import java.util.*;

public class BOJ_실버1_1743_음식물피하기 {
	
	static int map[][];
	static boolean visited[][];
	static int N, M;
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int dc[] = {0, 0, -1, 1};
	
	static int ans = 0;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			map[r][c] = 1; // 음식물 쓰레기 있는 곳 
		}
		
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					cnt = 0;
					visited[i][j] = true;
					DFS(i, j);
					ans = Math.max(cnt, ans);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void DFS(int r, int c) {
		cnt++;
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				DFS(nr, nc);
			}
		}
	}
	
	static boolean isRange(int r, int c) {
		if(0 <= r && r < N && 0 <= c && c < M) return true;
		return false;
	}

	 
}
