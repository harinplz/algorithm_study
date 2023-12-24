import java.io.*;
import java.util.*;

public class BOJ_실버1_14940_쉬운취단거리 {
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int n, m;
	static int[][] map;
	static int[][] ans;
	static boolean[][] visited;
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우 
	static int dc[] = {0, 0, -1, 1}; 
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		ans = new int[n][m]; // 거리 저장 배열 
		visited = new boolean[n][m];
		
		int startR = 0, startC = 0;

    // 처음에는 각각의 위치를 시작으로 좌표의 값이 2인 값에 접근할 때까지 얼만큼의 거리가 걸리나 측정했다.
    // 하지만, 메모리 초과가 발생함. 
    // 그래서 역으로 시작 좌표를 2인 값으로 설정하고, 각 좌표까지의 거리를 측정함. 
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) { 
					startR = i;
					startC = j;
				}
			}
		}
		
		BFS(startR, startC);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && map[i][j] == 1) { // 방문한 적 없지만, map의 값이 1일 땐 -1로 출력 
					sb.append("-1 ");
				}
				else {
					sb.append(ans[i][j] + " ");
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

  // 최단 거리 측정 
	public static void BFS(int r, int c) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(isRange(nr, nc)) {
					if(!visited[nr][nc] && map[nr][nc] != 0) {
						visited[nr][nc] = true;
						queue.offer(new Pos(nr, nc));
						ans[nr][nc] = ans[curPos.r][curPos.c] + 1;
					}
				}
			}
			
		}
	}

  // 범위 확인 함수 
	public static boolean isRange(int r, int c) {
		if(0<= r && r < n && 0 <= c && c < m) return true;
		return false;
	}
}
