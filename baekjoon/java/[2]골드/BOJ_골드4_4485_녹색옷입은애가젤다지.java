import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_4485_녹색옷입은애가젤다지 {
	
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
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] arr;
	static int[][] rupee;
	static boolean[][] isVisited;
	
	static int min;
	static int tc = 0;
	
	// 이동 위한 배열
	static int dr[] = {-1, 1, 0, 0}; //상 하 좌 우
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			N = Integer.parseInt(in.readLine());
			if(N==0) break;
			
			arr = new int[N][N];
			rupee = new int[N][N];
			isVisited = new boolean[N][N];
			
			// 값 입력받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(i==0 && j==0) {
						rupee[i][j] = arr[i][j];
					}
					else rupee[i][j] = Integer.MAX_VALUE;
				}
			}
			
			bfs(new Pos(0, 0));
			
			sb.append("Problem " + ++tc + ": " + rupee[N-1][N-1]+"\n");
			
		}
		
		System.out.println(sb);

	}

	private static void bfs(Pos pos) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.offer(pos);
		
		while(!queue.isEmpty()) {
			Pos curPos = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = curPos.r + dr[i];
				int nc = curPos.c + dc[i];
				
				if(0<= nr && nr < N && 0 <= nc && nc < N) {
					//nr nc 에 있는 곳이 
					if(rupee[nr][nc] > rupee[curPos.r][curPos.c] + arr[nr][nc]) {
						rupee[nr][nc] = rupee[curPos.r][curPos.c] + arr[nr][nc];
						queue.offer(new Pos(nr, nc));
					}
				}
			}
		}
		
	}



	
}