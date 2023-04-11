import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드5_7576_토마토 {

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

	static int N, M; //N: 세로 M: 가로
	static int box[][];

	//BFS 위한 변수
	static boolean isVisited[][];
	static int dr[] = {-1, 1, 0, 0}; //상하좌우
	static int dc[] = {0, 0, -1, 1};
	static Queue<Pos> queue = new ArrayDeque<Pos>();

	static int ans = -1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		isVisited = new boolean[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					queue.offer(new Pos(i, j));
					isVisited[i][j] = true;
				}
			}
		}

		bfs();

		//출력
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) System.out.print(box[i][j]);
//			System.out.println();
//		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					ans = -1;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}

	private static void bfs() {

		while(!queue.isEmpty()) {

			int size = queue.size();
			ans++;

			for(int s = 0; s < size; s++) {
				Pos curPos = queue.poll();

				for(int d=0; d<4; d++) {
					int nr = curPos.r + dr[d];
					int nc = curPos.c + dc[d];

					if(0<= nr && nr < N && 0 <= nc && nc < M) {
						if(!isVisited[nr][nc] && box[nr][nc]==0) {
							box[nr][nc] = 1;
							queue.offer(new Pos(nr, nc));
							isVisited[nr][nc] = true;
						}
					}
				}
			}
		}
	}

}
