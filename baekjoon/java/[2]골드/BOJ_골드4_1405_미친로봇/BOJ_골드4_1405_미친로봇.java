import java.io.*;
import java.util.*;

public class BOJ_골드4_1405_미친로봇 {
	
	static int N;
	static int[] dr = {0, 0, 1, -1}; // 동 서 남 북 
	static int[] dc = {1, -1, 0, 0}; // 동 서 남 북 
	static double ratDirections[];
	static boolean visited[][] = new boolean[30][30];
	
	static double ans = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		
		ratDirections = new double[4];
		
		for(int i=0; i<4; i++) {
			ratDirections[i] = Double.parseDouble(st.nextToken()) * 0.01;
		}
		
		visited[15][15] = true;
		robotMove(15, 15, 0, 1.0);
		
		System.out.println(ans);
		
	}
	
	public static void robotMove(int r, int c, int cnt, double rat) {
		if(cnt == N) {
			ans += rat;
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				robotMove(nr, nc, cnt + 1, rat * ratDirections[d]);
				visited[nr][nc] = false;
			}
		}
	}
}
