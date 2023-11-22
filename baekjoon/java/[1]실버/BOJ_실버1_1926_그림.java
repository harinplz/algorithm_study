import java.io.*;
import java.util.*;

public class BOJ_실버1_1926_그림 {
	
	/*
	 * 풀이 시간 : 17분 22초 
	 * 풀이 방법 : BFS 
	 */

	
	// BFS 풀이를 위한 변수 생성 
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int n, m;
	static int map[][];
	static boolean isVisited[][];
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우  
	static int dc[] = {0, 0, -1, 1};
	
	static int drawCnt = 0; // 그림 개수 
	static int maxDraw = 0; // 그림 최대 넓이 
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		isVisited = new boolean[n][m];
		
		// 입력 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 배열의 모든 요소에 접근하여 값이 1이거나 방문하지 않은 곳에서 BFS 탐색을 실행한다. 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && !isVisited[i][j]) {
					// 모든 조건을 만족한다면 개수를 증가시키고, BFS 탐색으로 찾아낸 너비 값을 최대 값과 비교하여 값을 갱신한다.
					drawCnt++;
					maxDraw = Math.max(BFS(i, j), maxDraw);
				}

			}
		}
		
		// 출력 
		System.out.println(drawCnt);
		System.out.println(maxDraw);


	}
	
	public static int BFS(int r, int c) {
		int area = 1; // 초기 넓이는 1 
		
		// BFS 탐색을 위한 큐 
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(new Pos(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) { // 큐가 빌 때 까지 반복 
			Pos curPos = queue.poll();
			
			// 상 하 좌 우 방향을 확인하여 인접한 곳에 1이거나 방문하지 않은 곳이 있는지 탐색한다. 
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(isRange(nr, nc)) {
					if(map[nr][nc] == 1 && !isVisited[nr][nc]) { // 발견했다면? 
						// 큐에 넣어주고 방문 처리 
						queue.offer(new Pos(nr, nc));
						isVisited[nr][nc] = true;
						// 그림의 넓이도 1 증가해준다. 
						area++; 
					}
				}
			}
		}
		
		return area;
	}
	
	// 범위 확인 함수 
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < n && 0 <= c && c < m) return true;
		return false;
	}
}
