import java.io.*;
import java.util.*;

public class BOJ_골드4_1987_알파벳 {
	
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int dc[] = {0, 0, -1, 1}; // 상 하 좌 우 
	
	static int ans = 0;
	static boolean alphabet[] = new boolean[26];
	
	public static void main(String[] args) throws Exception {
		
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[R][C];
		alphabet[(int)map[0][0] - 65] = true;
		
		DFS(0, 0, 1);
		
		System.out.println(ans);
	
	}
	
	public static void DFS(int r, int c, int cnt) {
		ans = Math.max(ans, cnt);
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
		
			if(isRange(nr, nc) && !visited[nr][nc] && !alphabet[(int)map[nr][nc] - 65]) {
				visited[nr][nc] = true;
				alphabet[(int)map[nr][nc] - 65] = true;
				DFS(nr, nc, cnt + 1);
				visited[nr][nc] = false;
				alphabet[(int)map[nr][nc] - 65] = false;
			}
		}
	}
	
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < R && 0 <= c && c < C) return true;
		return false;
	}
	


}
