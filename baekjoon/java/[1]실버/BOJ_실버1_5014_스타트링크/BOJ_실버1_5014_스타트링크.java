import java.io.*;
import java.util.*;

public class BOJ_실버1_5014_스타트링크 {
	
	static int F, S, G, U, D;
	static int ans = Integer.MAX_VALUE;
	static boolean visited[];
	
	static class Floor {
		int floor;
		int cnt;
		
		public Floor (int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
		
		@Override
		public String toString() {
			return "floor: " + floor + " ,cnt: " + cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 전체 층 수 
		S = Integer.parseInt(st.nextToken()); // 강호 위치 
		G = Integer.parseInt(st.nextToken()); // 스타트링크 위치 
		U = Integer.parseInt(st.nextToken()); // up 버튼 움직이는 이동 거리 
		D = Integer.parseInt(st.nextToken()); // down 버튼 움직이는 이동 거리
		
		visited = new boolean[F + 1];
		visited[0] = true;
		BFS(new Floor(S, 0));
		
		if(ans == Integer.MAX_VALUE) System.out.println("use the stairs");
		else System.out.println(ans);
	}
	
	public static void BFS(Floor floor) {
		visited[floor.floor] = true;
		Queue<Floor> queue = new ArrayDeque<>();
		queue.offer(floor);
		
		while(!queue.isEmpty()) {
			Floor curFloor = queue.poll();
			
			if(curFloor.floor == G) ans = Math.min(curFloor.cnt, ans);
			
			
			if(isPossible(curFloor.floor, U) && !visited[curFloor.floor + U]) {
				visited[curFloor.floor + U] = true;
				queue.offer(new Floor(curFloor.floor + U, curFloor.cnt + 1));
			}
			
			if(isPossible(curFloor.floor, -D) && !visited[curFloor.floor - D] ) {
				visited[curFloor.floor - D] = true;
				queue.offer(new Floor(curFloor.floor - D, curFloor.cnt + 1));
			}
		}
	}
	
	public static boolean isPossible(int floor, int move) {
		if(1 <= floor + move && floor + move <= F) return true;
		return false;
	}

}
