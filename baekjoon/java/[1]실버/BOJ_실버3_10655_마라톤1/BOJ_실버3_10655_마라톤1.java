import java.io.*;
import java.util.*;

public class BOJ_실버3_10655_마라톤1 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int map[][] = new int[N][2];
		
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[i][0] = x;
			map[i][1] = y;
		}
		
		int ans = Integer.MAX_VALUE;
		
		// 처음 모든 거리의 합 구하기 
		int total = 0;
		for(int i=1; i<N; i++) {
			total += manDistance(map[i][0], map[i-1][0], map[i][1], map[i-1][1]);
		}
		
		// 체크포인트 1개를 건너 뛰고 달릴 수 있는 최소 거리 
		for(int i=1; i<N-1; i++) {
			int minus1 = manDistance(map[i][0], map[i-1][0], map[i][1], map[i-1][1]);
			int minus2 = manDistance(map[i][0], map[i+1][0], map[i][1], map[i+1][1]);
			int plus = manDistance(map[i-1][0], map[i+1][0], map[i-1][1], map[i+1][1]);
			
			int distance = total - minus1 - minus2 + plus;
			ans = Math.min(ans, distance);
		}

		System.out.println(ans);
	}
	
	public static int manDistance(int x1, int x2, int y1, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1 - y2);
	}
	
}
