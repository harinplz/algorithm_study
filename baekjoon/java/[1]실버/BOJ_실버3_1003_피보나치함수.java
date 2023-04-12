import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_실버3_1003_피보나치함수 {
	
	//메모리 11516KB 시간 72ms 

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int DP[][] = new int [41][2];
		
		DP[0][0] = 1;
		DP[0][1] = 0;
		DP[1][0] = 0;
		DP[1][1] = 1;
		
		for(int i=2; i<=40; i++) {
			DP[i][0] = DP[i-1][0] + DP[i-2][0];
			DP[i][1] = DP[i-1][1] + DP[i-2][1];
		}

		int num;
		while(T-->0) {
			num = Integer.parseInt(in.readLine());
			sb.append(DP[num][0]).append(" ").append(DP[num][1]).append('\n');
		}
		
		System.out.println(sb);
	}
	
}
