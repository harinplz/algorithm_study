package ssafy.com.BOJ.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_골드3_1600_말이되고픈원숭이 {
	
	static class Monkey {
		int r;
		int c;
		int horseCnt;
		int moveCnt;
		
		public Monkey(int r, int c, int horseCnt, int moveCnt) {
			super();
			this.r = r;
			this.c = c;
			this.horseCnt = horseCnt;
			this.moveCnt = moveCnt;
		}

		@Override
		public String toString() {
			return "Monkey [r=" + r + ", c=" + c + ", horseCnt=" + horseCnt + ", moveCnt=" + moveCnt + "]";
		}
	}
	

	
	static int K;
	
	static int W, H;
	static int arr[][];
	static boolean isVisited[][][];
	
	// 그냥 원숭이가 이동하는 방향 (인접 4방향)
	static int dr [] = {-1, 1, 0, 0}; //상 하 좌 우
	static int dc [] = {0, 0, -1, 1};
	
	// 말이 이동하는 방향
	static int horseDr[] = { 2,2,-2,-2,1,-1,1,-1 };
	static int horseDc[] = { 1,-1,1,-1,2,2,-2,-2 };
	
	// 카운트 저장 변수
	static int minCnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		W = Integer.parseInt(st.nextToken()); //가로 길이
		H = Integer.parseInt(st.nextToken()); //세로 길이
		
		arr = new int[H][W];
		isVisited = new boolean[H][W][K];
		
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<W; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		Monkey monkey = new Monkey(0, 0, K, 0);
		
		bfs(monkey);
		
		if(minCnt==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(minCnt);
			
		}
		
	}

	private static void bfs(Monkey monkey) {
		Queue<Monkey> queue = new ArrayDeque<>();
		
		queue.offer(monkey);
		for(int i=0; i<4; i++) {
			isVisited[monkey.r][monkey.c][monkey.horseCnt] = true;
		}
		
		while(!queue.isEmpty()) {

			Monkey curMonkey = queue.poll();
			
			//System.out.println(curMonkey);
			
			if(curMonkey.r == H-1 && curMonkey.c == W-1) {
				minCnt = Math.min(minCnt, curMonkey.moveCnt);
			}
			
			//isVisited 처리를 .. 먼가 .. 그 첨 시작할 때 그 visited 처리를 다들 별개로 해줘야함 
			
			//그냥 원숭이 처럼 이동
			for(int i=0; i<4; i++) {
				int nr = curMonkey.r + dr[i];
				int nc = curMonkey.c + dc[i];
				
				if(0 <= nr && nr < H && 0 <= nc && nc < W && arr[nr][nc] == 0) {
					if(!isVisited[nr][nc][curMonkey.horseCnt] ) {
						queue.offer(new Monkey(nr, nc, curMonkey.horseCnt, curMonkey.moveCnt+1));
						isVisited[nr][nc][curMonkey.horseCnt]= true;
					}
				}
			}
			
			//말 처럼 이동
			if(curMonkey.horseCnt > 0) {
				for(int i=0; i<8; i++) {
					int nr = curMonkey.r + horseDr[i];
					int nc = curMonkey.c + horseDc[i];
					
					if(0 <= nr && nr < H && 0 <= nc && nc < W && arr[nr][nc] == 0) {
						if(!isVisited[nr][nc][curMonkey.horseCnt - 1] ) {
							//말은 장애물 상관 없음!
							queue.offer(new Monkey(nr, nc, curMonkey.horseCnt - 1, curMonkey.moveCnt + 1));
							isVisited[nr][nc][curMonkey.horseCnt-1] = true;
						}		
					}
				}
			}

		}
		
	}

}
