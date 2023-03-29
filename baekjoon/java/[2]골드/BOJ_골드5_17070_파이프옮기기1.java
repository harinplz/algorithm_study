package ssafy.com.BOJ.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드5_17070_파이프옮기기1 {
	
	static int cnt = 0;
	
	static int arr[][];
	static int N;
	
	static int dr[] = {0, 1, 1}; //가로 세로 대각선 순. 근데 가->세는 안된다!! 
	static int dc[] = {1, 0, 1}; 
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		dfs(1, 2, 0);
		
		System.out.println(cnt);
		
	}

	private static void dfs(int r, int c, int dir) {
		
		if(r==N && c==N) {
			cnt++;
			return;
		}
		
		if(arr[r][c] != 1)
		switch(dir) {
		case 0: //다음에 가로 혹은 대각선으로 갈 수 있음
			//가로로 가는 경우
			if(r + dr[0] <= N && c + dc[0] <= N && arr[r+dr[0]][c+dc[0]] != 1) dfs(r+dr[0], c+dc[0], 0);
			if(r+dr[2] <= N && c + dc[2] <=N 
					&& arr[r+dr[2]][c+dc[2]] != 1 &&arr[r+dr[0]][c+dc[0]] != 1 && arr[r+dr[1]][c+dc[1]] != 1 ) dfs(r+dr[2], c+dc[2], 2);
			break;
		case 1:
			//세로로 가는 경우
			if(r + dr[1] <= N && c + dc[1] <= N && arr[r+dr[1]][c+dc[1]] != 1) dfs(r+dr[1], c+dc[1], 1);
			//대각선으로 가는 경우
			if(r+dr[2] <= N && c + dc[2] <=N 
					&& arr[r+dr[2]][c+dc[2]] != 1 &&arr[r+dr[0]][c+dc[0]] != 1 && arr[r+dr[1]][c+dc[1]] != 1 ) dfs(r+dr[2], c+dc[2], 2);
			break;
		case 2:
			//대각선으로 가는 경우
			if(r+dr[2] <= N && c + dc[2] <=N 
			&& arr[r+dr[2]][c+dc[2]] != 1 &&arr[r+dr[0]][c+dc[0]] != 1 && arr[r+dr[1]][c+dc[1]] != 1 ) dfs(r+dr[2], c+dc[2], 2);
			//가로로 가는 경우
			if(r+dr[0] <= N && c+dc[0] <= N && arr[r+dr[0]][c+dc[0]] != 1) dfs(r+dr[0], c+dc[0], 0);
			//세로로 가는 경우
			if(r+dr[1] <= N && c+dc[1] <= N  && arr[r+dr[1]][c+dc[1]] != 1) dfs(r+dr[1], c+dc[1], 1);
			break;
		}
		
		
	}

	
}