import java.io.*;
import java.util.*;

public class BOJ_골드4_3190_뱀 {
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		@Override
		public boolean equals(Object o) {
			Pos pos = (Pos) o;
			return this.r == pos.r && this.c == pos.c;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt")); 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine()); // 사과 개수 
		
		int map[][] = new int[N][N];
		StringTokenizer st;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}
		
		Map<Integer, Character> timeMap = new HashMap<>();
		
		
		int L = Integer.parseInt(in.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(in.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			timeMap.put(time, dir);
			
		}
		
		int dr[] = {0, 1, 0, -1};
		int dc[] = {1, 0, -1, 0};
		
		Deque<Pos> deque = new ArrayDeque<>();
		int curR = 0;
		int curC = 0;
		int curD = 0;
		deque.offer(new Pos(curR, curC));
		
		int time = 0;
		
		while(true) {
			time++;
			int nr = curR + dr[curD];
			int nc = curC + dc[curD];
			
			if(!isRange(nr, nc, N)) break; // 만약 벽에 부딪히면 종료를 해주어요. 
			
			Pos nextPos = new Pos(nr, nc);
			if(deque.contains(nextPos)) break; // 만약 몸에 부딪히면 종료를 해주어요. 
			
			deque.offerFirst(nextPos);
			// 사과가 있는 지 확인해요. 없다면 제일 끝아이를 없애줘요. 
			if(map[nr][nc] == 1) {
				map[nr][nc] = 0;
			}
			else {
				deque.pollLast();
			}

			
			// 시간 검사한 후 방향 전환 
			if(timeMap.containsKey(time)) {
				char dir = timeMap.get(time);
				if(dir == 'D') curD = (curD + 1) % 4;
				else if(dir == 'L') curD = curD - 1 < 0 ? 3 : curD - 1;
			}
			
			curR = nr;
			curC = nc;
		}
		
		System.out.println(time);
	}
	
	static boolean isRange(int r, int c, int N) {
		if(0 <= r && r < N && 0 <= c && c < N) return true;
		return false;
	}
	

}
