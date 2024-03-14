import java.io.*;
import java.util.*;

public class BOJ_실버1_3187_양치기꿍 {
	
	static int R,C;
	static char map[][];
	static boolean visited[][];
	static int sheep, wolf;
	
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1}; 
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int totalSheep = 0;
		int totalWolf = 0;
		
		// DFS 탐색 
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'k')) {
					visited[i][j] = true;
					DFS(i, j);
					if(sheep <= wolf) totalWolf += wolf;
					else totalSheep += sheep;
					
					sheep = 0;
					wolf = 0;
				}
			}
		}
		
		System.out.println(totalSheep + " " + totalWolf);
	}
	
	public static void DFS(int r, int c) {
		if(map[r][c] == 'v') wolf++;
		else if(map[r][c] == 'k') sheep++;
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != '#') {
				visited[nr][nc] = true;
				DFS(nr, nc);
			}
		}
	}
	
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < R && 0 <= c && c < C) return true;
		return false;
	}
	
	
}
