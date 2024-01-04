import java.io.*;
import java.util.*;

public class BOJ_골드4_14500_테트로미노 {
	
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int ans = Integer.MIN_VALUE;
	
	static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int[] dc = {0, 0, -1, 1}; 
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		
		// 테트로미노는 이어진 모양 4개와 DFS로 구하지 못하는 모양 1개가 존재한다.
		// 이어진 모양은 DFS로 구할 수 있기 때문에 DFS로 구해주고 
		// 나머지 1개는 따로 fiveShape()라는 함수를 만들어 따로 구해준다. 
		// fiveShape()로 구할 수 있는 모양은 ㅏ ㅓ ㅗ ㅜ 이다.
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				visited[r][c] = true;
				DFS(r, c, 1, map[r][c]);
				visited[r][c] = false;
				fiveShape(r, c);
			}
		}
	
		
		System.out.println(ans);
		
	}
	
	static void DFS(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			ans = Math.max(ans,  sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(isRange(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc, cnt+1, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}	
	}
	
	static void fiveShape(int r, int c) {
		// ㅏ 모양 
		if(r + 2 < N && c + 1 < M) {
			ans = Math.max(ans, map[r][c] + map[r+1][c] + map[r+2][c] + map[r+1][c+1]);
		}
		// ㅓ 모양 
		if(r+2 < N && c - 1 >= 0) {
			ans = Math.max(ans, map[r][c] + map[r+1][c] + map[r+2][c] + map[r+1][c-1]);
		}
		// ㅜ 모양 
		if(r + 1 < N && c + 2 < M) {
			ans = Math.max(ans, map[r][c] + map[r][c+1] + map[r][c+2] + map[r+1][c+1]);
		}
		// ㅗ 모양 
		if(r -1 >= 0 && c + 2 < M) {
			ans = Math.max(ans, map[r][c] + map[r][c+1] + map[r][c+2] + map[r-1][c+1]);
		}
	}
	
	// 범위를 구하는 함수 
	static boolean isRange(int r, int c) {
		if(0 <= r && r < N && 0 <= c && c < M) return true;
		return false;
	}
}
