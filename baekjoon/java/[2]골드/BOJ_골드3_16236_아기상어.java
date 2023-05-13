import java.io.*;
import java.util.*;

public class BOJ_골드3_16236_아기상어 {
	
	/*
	 * 메모리 12064KB 시간 84ms
	 * BFS
	 * 우선순위 큐를 쓰면 더 좋은 코드를 만들 수 있을 것 같다.
	 * 문제를 확실히 잘 읽어야 하는 걸 깨달은 문제...
	 * 아기상어 크기가 2인 걸 모른거랑
	 * 아기상어가 자신의 크기보다 큰 애로는 이동을 하지 못하기 떄문에 시간을 최단 거리로 구하면 안된다는 것!!
	 * 그래도 블참안하고 풀어서 뿌듯하다 ㅎㅎ
	 */

	static int N;
	static int map[][];

	static int time = 0; //물고기 먹는 시간
	static int eatCnt = 0; //물고기 먹은 개수
	static int sharkSize = 2;

	// 물고기 클래스
	static class Fish {
		int r;
		int c;
		int distance;

		public Fish(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}	
	}

	static Fish babyShark;

	//BFS 인접 배열 이동 위함
	static int dr[] = {-1, 1, 0, 0}; //상하좌우
	static int dc[] = {0, 0, -1, 1};


	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		for(int i=0; i<N; i++) { //입력
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babyShark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}

		BFS();

		System.out.println(time);
	}


	private static void BFS() {
		Queue<Fish> goShark = new ArrayDeque<Fish>();
		Queue<Fish> eatFish = new ArrayDeque<Fish>();
		boolean visited[][] = new boolean[N][N];
		goShark.offer(babyShark);
		visited[babyShark.r][babyShark.c] = true;

		Fish sharkPos = new Fish(babyShark.r, babyShark.c, 0);

		while(!goShark.isEmpty()) {
			int goSize = goShark.size();

			while(goSize-->0) {
				Fish curShark = goShark.poll();

				for(int i=0; i<4; i++) {
					int nr = curShark.r + dr[i];
					int nc = curShark.c + dc[i];

					if(0 <= nr && nr < N && 0 <= nc && nc < N) {
						if(!visited[nr][nc] && map[nr][nc] <= sharkSize) {
							if(map[nr][nc] > 0 &&  map[nr][nc] < sharkSize) {
								visited[nr][nc] = true;
								// 상어가 물고기 잡아 먹음!!
								eatFish.offer(new Fish(nr, nc, curShark.distance + 1));
							}
							else { //물고기가 아예 없고 그냥 이동 가능할 때
								goShark.offer(new Fish(nr, nc, curShark.distance + 1));
								visited[nr][nc] = true;
							}
						}
					}
				}
			}

			if(eatFish.size() > 0) {
				goShark.clear();
				visited = new boolean[N][N];
				eatCnt++;
				int size = eatFish.size();
				Fish confirmShark = eatFish.poll();
				

				if(size > 1) {
					for(int s = 1; s < size; s++) {
						Fish nextShark = eatFish.poll();
						if(nextShark.r < confirmShark.r) {
							confirmShark = nextShark;
						}
						else if(nextShark.r == confirmShark.r) {
							if(nextShark.c < confirmShark.c) confirmShark = nextShark;
						}
					}
				}

				if(eatCnt == sharkSize) {
					sharkSize++;
					eatCnt = 0;
				}
				sharkPos = new Fish(confirmShark.r, confirmShark.c, 0);
				goShark.offer(sharkPos);
				visited[sharkPos.r][sharkPos.c] = true;
				map[sharkPos.r][sharkPos.c] = 0;
				time += confirmShark.distance;
			}

		}

	}

}
