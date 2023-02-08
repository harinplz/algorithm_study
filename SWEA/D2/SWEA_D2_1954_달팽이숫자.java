package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA_D2_1954_달팽이숫자 {
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0}; 
		
		
		for(int tc = 1;tc<=T;tc++) {
			sb.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(in.readLine());
			
			int[][] map = new int[N+2][N+2];
			boolean[][] chk = new boolean[N+2][N+2];
			
			for(int i = 0;i<N+2;i++) {
				chk[i][0] = true;
				chk[0][i] = true;
				chk[N+1][i] = true;
				chk[i][N+1] = true;
			}
			
			int dirIdx = 0; //방향 변수
			int curX = 1;
			int curY = 1;
			map[curX][curY] = 1;
			chk[curX][curY] = true;
			
			int num = 2;
			
			while(true) {
				if(num>N*N) break;
				int testX = curX + dx[dirIdx];
				int testY = curY + dy[dirIdx];
				if(!chk[testX][testY]) {
					curX = testX;
					curY = testY;
					chk[testX][testY] = true;
					map[testX][testY] = num++;
				}
				else {
					dirIdx = (dirIdx+1) % 4;
				}
			}
			for(int i =1;i<=N;i++) {
				for(int j =1;j<=N;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
}
