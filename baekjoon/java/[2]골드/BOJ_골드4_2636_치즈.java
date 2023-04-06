import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드4_2636_치즈 {

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
	static StringTokenizer st;

	static int cheese[][]; //치즈 배열
	static int H;
	static int W; 

	//BFS 탐색을 위한 배열
	static int dr[] = {0, 1, -1, 0}; //우 하 상 좌
	static int dc[] = {1, 0, 0, -1};
	static boolean isVisited[][];

	static int hour = 0;
	
	static boolean finish = false;
	static int cheeseCnt = 0;
	static int originCnt = 0;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


		//0. 입력
		st = new StringTokenizer(in.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		cheese = new int[H][W];
		isVisited = new boolean[H][W];

		for(int i=0; i<H; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<W; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] != 0) originCnt++;
			}
		}


		while(true) {
			isVisited = new boolean[H][W];
			hour++;
			bfs(new Pos(0, 0));
			
			finish = true;
			int cnt = 0;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(cheese[i][j] != 0) {
						finish = false;
						cnt++;
					}
				}
			}
			
			if(hour==1 && finish) cheeseCnt = originCnt;
			
			if(finish) break;
			cheeseCnt = cnt;
		}

		System.out.println(hour);
		System.out.println(cheeseCnt);



	}

	private static void bfs(Pos pos) {
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.offer(pos);
		isVisited[pos.r][pos.c] = true;

		while(!queue.isEmpty()) {
			int size = queue.size();

			//System.out.println(size);
			for(int s = 0; s<size; s++) {

				Pos curPos = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nr = curPos.r + dr[i];
					int nc = curPos.c + dc[i];

					if(0<= nr && nr < H && 0<= nc && nc < W) {
						if(!isVisited[nr][nc]) {
							if(cheese[nr][nc] == 0) {
								isVisited[nr][nc] = true;
								queue.offer(new Pos(nr, nc));
							}
							else if(cheese[nr][nc] == 1) {
								isVisited[nr][nc] = true;
								cheese[nr][nc] = 0;
							}
						}
					}
				}

			}
		}

	}

