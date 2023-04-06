import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드5_9205_맥주마시면서걸어가기 {
	
	// 메모리 19732KB 시간 224ms

	static StringTokenizer st;
	static final int INF = 999999;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc<=T; tc++) {
			int n = Integer.parseInt(in.readLine());
			int pos[][] = new int[n+2][2];
			int D[][] = new int[n+2][n+2];
			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(in.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			//거리 계산 D
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					if(i==j) D[i][j] = 0;
					D[i][j] = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
					if(D[i][j] > 1000) D[i][j] = INF;
				}
			}
			
			//경중도
			for(int k=0; k<n+2; k++) {
				for(int i=0; i<n+2; i++) {
					if(i==k) continue;
					
					for(int j=0; j<n+2; j++) {
						if(j==i) continue;
						
						D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
					}
				}
			}
			
			if(D[0][n+1] == INF) {
				sb.append("sad").append('\n');
			} else sb.append("happy").append('\n');
		}
		
		System.out.println(sb);
	}

}