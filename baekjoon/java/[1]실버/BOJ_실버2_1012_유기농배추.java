import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버2_1012_유기농배추 {
	
	/*
	 * 메모리 13536KB 시간 104ms
	 * 간단한 BFS 문제 !! 
	 */
	
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

	static int N, M, cabCnt;
	static int[][] map;
	
	static boolean [][] isVisited;
	static int dr[] = {-1, 1, 0, 0}; //상 하 좌 우
	static int dc[] = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		//0. 입력
		int T = Integer.parseInt(in.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cabCnt = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			isVisited = new boolean[N][M];
			
			while(cabCnt-- > 0) {
				st = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			int wormCnt = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!isVisited[i][j] && map[i][j] == 1) {
						bfs(new Pos(i, j));
						wormCnt++;
					}
				}
			}
			
			sb.append(wormCnt).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void bfs(Pos pos) {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.offer(pos);
		isVisited[pos.r][pos.c] = true;
		
		while(!queue.isEmpty()) {
			Pos curpos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curpos.r + dr[i];
				int nc = curpos.c + dc[i];
				
				if(0<= nr && nr < N && 0<= nc && nc < M) {
					if(!isVisited[nr][nc] && map[nr][nc] == 1) {
						queue.offer(new Pos(nr, nc));
						isVisited[nr][nc] = true;
					}
				}
			}
		}
		
	}

}
