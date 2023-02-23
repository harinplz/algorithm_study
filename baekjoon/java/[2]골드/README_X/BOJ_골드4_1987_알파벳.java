package ssafy.com.BOJ.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_골드4_1987_알파벳 {
	
	/**
	 * DFS 그래프 탐색 문제
	 * 메모리 : 15040KB, 시간 : 856ms 
	 * 그렇게 어려운 문제는 아니었지만 DFS 구조가 정확히 기억이 안나서
	 * DFS 구조를 참고하고 풀었다 ㅎㅎ BFS 구조랑 DFS 구조는 외워두자!! 
	 */
	
	private static int R;
	private static int C;
	
	private static char arr[][];
	
	private static int max = Integer.MIN_VALUE;
	private static boolean isVisited[] = new boolean[26];
	
	private static int dr[] = {-1, 1, 0, 0}; //상 하 좌 우
	private static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String split[] = in.readLine().split(" ");
		
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		
		arr = new char[R][C];
		
		//입력
		for(int i=0;i<R;i++) {
			String str = in.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int num = arr[0][0] - 65;
		isVisited[num] = true;
		
		dfs(0, 0, 1);
		
		
		System.out.println(max);
		
	}

	private static void dfs(int r, int c, int cnt) {
		
		max = (max<cnt) ? cnt : max;
		
		for(int i=0;i<4;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];;
			
			if((0 <= nr && nr < R) && (0<= nc && nc < C)) {
				int no = arr[nr][nc] - 65;
				if(!isVisited[no]) {
					isVisited[no] = true;
					dfs(nr, nc, cnt+1);
					isVisited[no] = false;
				}
			}
		}

		
	}
	
}
