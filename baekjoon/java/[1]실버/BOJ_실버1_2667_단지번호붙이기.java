import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BOJ_실버1_2667_단지번호붙이기 {
	
	// 메모리 11668KB, 시간 80ms
	// BFS 탐색을 통해 풀었다. 
	// 2차원 배열의 모든 곳을 탐색하며 방문하지 않았고 1인 곳을 발견하면 해당 위치를 bfs 의 매개변수로 넘겨준다.
	// 그 위치를 시작으로 bfs 탐색. 
	// bfs 탐색이 끝나면 list에 연결된 집의 개수를 추가해주었다.
	// 모든 단지를 다 찾았다면 list를 정렬한 후 오름차순으로 출력해주었다. 
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
	}

	static int N;
	
	static int[][] map;
	
	//BFS
	static boolean[][] isVisited;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};

	static int homeCnt;
	static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		isVisited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isVisited[i][j] && map[i][j] == 1) {
					homeCnt = 1;
					bfs(new Pos(i, j));
					list.add(homeCnt);
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size()).append('\n');
		for(int home : list) {
			sb.append(home).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void bfs(Pos pos) {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.offer(pos);
		isVisited[pos.r][pos.c] = true;
		
		while(!queue.isEmpty()) {
			
			Pos curPos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(0<=nr && nr < N && 0<= nc && nc < N) {
					if(!isVisited[nr][nc] && map[nr][nc] == 1) {
						isVisited[nr][nc] = true;
						queue.offer(new Pos(nr, nc));
						homeCnt++;
					}
				}
			}
		}
		
	}
}
