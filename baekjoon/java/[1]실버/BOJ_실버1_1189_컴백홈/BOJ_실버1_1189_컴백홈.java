import java.io.*;
import java.util.*;

public class BOJ_실버1_1189_컴백홈 {
	
	/*
	 * 시작 : 5시 27분 -> 종료 : 5시 56분 
	 */
	
	static int R, C;
	static int K;
	static char map[][];
	static boolean visited[][];
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우
	static int dc[] = {0, 0, -1, 1};
	
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited[R-1][0] = true;
		DFS(R-1, 0, 1);
		
		System.out.println(ans);
		
	}
	
	public static void DFS(int r, int c, int dis) {
		if(r == 0 && c == C-1 && dis == K) {
			ans++;
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc)) {
				if(map[nr][nc] != 'T' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					DFS(nr, nc, dis+1);
					visited[nr][nc] = false;
				}
			}
		}
		
	}
	
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < R && 0 <= c && c < C) return true;
		return false;
	}
	

}
