import java.io.*;
import java.util.*;

public class BOJ_실버2_21736_헌내기는친구가필요해 {
	
	/*
	 * 풀이 시간 : 13분 
	 * 풀이 방법 : BFS 
	 * 메모리 : 25936KB, 시간 280ms 
	 */
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public String toString() {
			return "r : " + r + ", c : " + c;
		}
	}
	
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	
	static int dr[] = {-1, 1, 0, 0}; // 상하좌우 
	static int dc[] = {0, 0, -1, 1}; 
	
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 상하좌우 이동 도연이가 만날 수 있는 사람의 수 출력 
		// X 일때 그 공간으로 이동하지 못함. 
		// 다음이 P일때 값 증가 
		// BFS로 풀기 
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		
		Pos dyPos = new Pos(0, 0);
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') dyPos = new Pos(i, j);
			}
		}
		
		BFS(dyPos);
		
		if(ans > 0) System.out.println(ans);
		else System.out.println("TT");
	}
	
	public static void BFS(Pos pos) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(pos);
		visited[pos.r][pos.c] = true;
		
		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();
			
			if(map[curPos.r][curPos.c] == 'P') ans++;
			
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(isRange(nr, nc)) {
					if(!visited[nr][nc] && map[nr][nc] != 'X') {
						visited[nr][nc] = true;
						queue.offer(new Pos(nr, nc));
					}
				}
			}
		}
		
	}
	
	// r과 c가 범위 안에 있는 지 확인하기 
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < N && 0 <= c && c < M) return true;
		return false;
	}
}
