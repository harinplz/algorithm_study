import java.io.*;
import java.util.*;

public class BOJ_실버2_4963_섬의개수 {
	
	static int W, H;
	static int map[][];
	static boolean visited[][];
	
	static int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상 하 좌 우 (좌상)(우상)(좌하)(우하) 
	static int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		// 	입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(in.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) break;
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						cnt++;
						visited[i][j] = true;
						DFS(i, j);
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void DFS(int r, int c) {
		for(int d=0; d<8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
				visited[nr][nc] = true;
				DFS(nr, nc);
			}
		}
	}
	
	static boolean isRange(int r, int c) {
		if(0 <= r && r < H && 0 <= c && c < W) return true;
		return false;
	}

	 
}
