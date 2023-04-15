import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버1_2178_미로탐색 {
	
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
	
	static int N; //세로 크기
	static int M; //가로 크기
	static int[][] map;
	
	//BFS를 위한 변수 
	static boolean[][] isVisited;
	static int dr[] = {-1, 1, 0, 0}; //상하좌우
	static int dc[] = {0, 0, -1, 1}; 
	
	static int cnt=0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		
		System.out.println(map[N-1][M-1]);
	}

	private static void bfs() {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.offer(new Pos(0, 0));
		isVisited[0][0] = true;
		
		while(!queue.isEmpty()) {
			
			cnt++;
			Pos curPos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(0<=nr && nr < N && 0<= nc && nc<M) {
					if(!isVisited[nr][nc] && map[nr][nc]==1) {
						queue.offer(new Pos(nr, nc));
						isVisited[nr][nc] = true;
						map[nr][nc] = map[curPos.r][curPos.c] + 1;
					}
				}
			}
		}
	}
}
