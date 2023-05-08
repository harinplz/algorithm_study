import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 메모리 105440KB 시간 612ms
 * 푸는데 걸린 시간 : 40m
 * BFS 
 * 다 풀어놓고 오타 때문에 20분 잡아먹었다 !!! ㅠ.ㅠ 
 */

public class BOJ_골드5_7569_토마토 {
	
	static class Pos {
		int r;
		int c;
		int z;
		
		public Pos(int r, int c, int z) {
			super();
			this.r = r;
			this.c = c;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", z=" + z + "]";
		}
	}
	
	static int M, N; //상자 가로 , 상자 세로
	static int H; // 쌓아올려지는 상자의 수 
	
	//3차원 배열
	static int map[][][]; // 층 수 x 세로 x 가로 
	
	// 인접한 곳 (위, 아래, 왼쪽, 오른쪽, 앞, 뒤)
	static int [] dr = {-1, 1, 0, 0, 0, 0};
	static int [] dc = {0, 0, -1, 1, 0, 0};
	static int [] dz = {0, 0, 0, 0, -1, 1};
	// 방문 체크
	static boolean [][][] isVisited;
	
	static StringTokenizer st;
	
	static Queue<Pos> queue = new ArrayDeque<Pos>();
	static int ans = -1;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		H = Integer.parseInt(st.nextToken()); // 쌓아올려지는 상자의 수 
		
		map = new int[H][N][M];
		isVisited = new boolean[H][N][M];
		
		for(int z=0; z<H; z++) {
			for(int r = 0; r<N; r++) {
				st = new StringTokenizer(in.readLine());
				for(int c =0; c<M; c++) {
					map[z][r][c] = Integer.parseInt(st.nextToken());
					if(map[z][r][c] == 1) {
						queue.offer(new Pos(r, c, z));
						isVisited[z][r][c] = true;
					}
				}
			}
		}
		
		bfs();
		
		// 토마토가 다 익었는 지 확인
		boolean flag = true;
		for(int z=0; z<H; z++) {
			if(!flag) break;
			for(int r=0; r<N; r++) {
				if(!flag) break;
				for(int c=0; c<M; c++) {
					if(!flag) break;
					if(map[z][r][c] == 0) flag = false;
				}
			}
		}
		
		if(!flag) System.out.println(-1);
		else System.out.println(ans);
		
	}

	private static void bfs() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0; i<size; i++) {
				Pos curPos = queue.poll();
				
				for(int d = 0; d<6; d++) {
					int nr = curPos.r + dr[d];
					int nc = curPos.c + dc[d];
					int nz = curPos.z + dz[d];
					
					if(0 <= nr && nr < N && 0 <= nc && nc < M && 0 <= nz && nz < H) {
						if(!isVisited[nz][nr][nc] && map[nz][nr][nc] == 0) {
							isVisited[nz][nr][nc] = true;
							map[nz][nr][nc] = 1;
							queue.offer(new Pos(nr, nc, nz));
						}
					}
				}
			}
			ans++;
		}
		
	}

}
