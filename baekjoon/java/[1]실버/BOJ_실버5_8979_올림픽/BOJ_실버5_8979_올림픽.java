import java.io.*;
import java.util.*;

public class BOJ_실버5_8979_올림픽 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int medal[][] = new int[N+1][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int nationNo = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<3; j++) {
				medal[nationNo][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// rank 계산하기 
		int rank = 1;
		
		// 금메달 비교하기 
		for(int i=1; i<=N; i++) {
			if(medal[i][0] > medal[K][0]) rank++;
		}
		
		// 은메달 비교하기 
		for(int i=1; i<=N; i++) {
			if(medal[i][0] == medal[K][0] && medal[i][1] > medal[K][1]) rank++;
		}
		
		// 동메달 비교하기 
		for(int i=1; i<=N; i++) {
			if(medal[i][0] == medal[K][0] && medal[i][1] == medal[K][1] 
					&& medal[i][2] > medal[K][2]) rank++;

		}
		
		System.out.println(rank);
	}

	
}
