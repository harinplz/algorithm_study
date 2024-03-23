import java.io.*;
import java.util.*;

public class BOJ_실버3_17484_진우의달여행(Small) {
	
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int dr[] = {1, 1, 1};
	static int dc[] = {-1, 0, 1};
	
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 탐색 시작 
		for(int i=0; i<M; i++) {
			visited[0][i] = true;
			DFS(0, i, -1, map[0][i]);
		}
		
		System.out.println(ans);
	}
	
	static void DFS(int r, int c, int dir, int gas) {
		if(r == N-1) {
			ans = Math.min(ans, gas);
			return;
		}
		
		for(int i=0; i<3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(isRange(nr, nc) && dir != i && !visited[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc, i, gas + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
	
	static boolean isRange(int r, int c) {
		if(0 <= r && r <= N && 0 <= c && c < M) return true;
		return false;
	}
	
}
