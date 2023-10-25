import java.io.*;
import java.util.*;

public class BOJ_골드5_14503_로봇청소기 {

  // 풀이시간 1시간 이상
  // BFS로 풀었는데 BFS로 푸는 게 아니라는걸 깨달았다. DFS로 풀어도 될 것 같은데 반복문으로도 풀릴 것 같아서 반복문으로 풀었다.
  // 나중에 DFS로 다시 풀어봐야겠다.
	
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

    // 입력 
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int [][] map = new int[N][M];
		
		st = new StringTokenizer(in.readLine());
		int robotR = Integer.parseInt(st.nextToken());
		int robotC = Integer.parseInt(st.nextToken());
		int robotD = Integer.parseInt(st.nextToken());

		// 방향 관련 배열 반 시계 방향 북, 동, 남, 서 
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int ans = 0; // 답 : 로봇 청소기 청소하는 칸 개수 

		// map 값 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

    // 종료 조건, 4칸이 모두 청소가 되어있고 후진을 했을 때 벽이라면 종료한다.
		while(true) {
			// 1. 현재 칸 청소 X -> 현재 칸 청소 
			if(map[robotR][robotC] == 0) {
				map[robotR][robotC] = 2;
				ans++;
      }
			
			// 2. 현재 칸 주변 4칸 중 청소 되지 않은 빈칸 X -> 한칸 후진 (후진한 곳이 벽이라면 종료)
			// 2-1. 일단 현재 칸 주변 4칸 중 청소 되지 않은 빈칸이 있는 지 찾는다. 
			boolean isNotClean = false;
			for(int i=0; i<4; i++) {
				int nr = robotR + dr[i];
				int nc = robotC + dc[i];

				if(isRange(nr, nc) && map[nr][nc] == 0) { // 범위에 있고, 인접한 4칸 중 한 칸이 청소가 안 된 칸이라면 isNotClean 값을 true로 변경한다. 
					isNotClean = true;
          break;
				}
			}
			
			if(!isNotClean) { // 주변 4칸 중 청소되지 않은 칸이 없다면 (후진!)
				int bd = (robotD + 2) % 4;
				int br = robotR + dr[bd];
				int bc = robotC + dc[bd];

				if(isRange(br, bc) && map[br][bc] != 1) { // 벽이 아니라면 후진을 한다. 
					robotR = br;
					robotC = bc;
				}
				else { // 벽이라면 종료
					break;
				}
			}
			else { // 주변 4칸 중 청소되지않은 빈 칸이 있다면 
				int nd = (robotD + 3) % 4; 
				int nr = robotR + dr[nd];
				int nc = robotC + dc[nd];
				
				if(isRange(nr, nc) && map[nr][nc] == 0) { // 만약 반시계 방향으로 회전한 후 앞 칸이 청소가 안 된 칸이라면 전진한다.
					robotR = nr;
					robotC = nc;
					robotD = nd;
				}
				else { // 앞 칸이 청소가 된 칸이거나 벽이라면 반시계 방향으로 다시 회전한다. 
					robotD = nd;
				}
			}
			
		}
		System.out.println(ans);
	}


// 범위 체크 함수 
	public static boolean isRange(int r, int c) {
		if(0 <= r && r < N && 0 <= c && c < M) {
			return true;
		}
		return false;
	}

}
