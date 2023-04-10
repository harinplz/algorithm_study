import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_16919_봄버맨2 {
	
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
	
	static int R, C, N;
	static char map[][];
	
	static int dr[] = {-1, 1, 0, 0}; // 상 하 좌 우
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		Queue<Pos> queue = new ArrayDeque<>();
		
		for(int i=0; i<R; i++) {
			String str = in.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int time = 1;
		
		if(N%2==0) {
			//출력
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) sb.append('O');
				sb.append('\n');
			}
		}
		else if(N == 1) {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) sb.append(map[i][j]);
				sb.append('\n');
			}
		}
		else {
			N = N%4==3? 3:5;
			while(true) {
				if(time == N) break;
				// 폭탄 위치 저장
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] == 'O') queue.offer(new Pos(i,j));
					}
				}
				
				//다 폭탄으로 채우기
				time++;
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(map[i][j] != 'O') map[i][j] = 'O';
					}
				}
				
				if(time == N) break;
				
				//폭탄 폭발
				time++;
				while(!queue.isEmpty()) {
					Pos curPos = queue.poll();
					map[curPos.r][curPos.c] = '.';
					
					for(int i=0; i<4; i++) {
						int nr = curPos.r + dr[i];
						int nc = curPos.c + dc[i];
						
						if(0<= nr && nr < R && 0<= nc && nc<C) {
							map[nr][nc] = '.';
						}
					}
				}
			}
			
			//출력
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) sb.append(map[i][j]);
				sb.append('\n');
			}
			
		}
		System.out.println(sb);
	}

}
