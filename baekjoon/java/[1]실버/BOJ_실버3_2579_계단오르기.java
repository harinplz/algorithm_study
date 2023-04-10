import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_실버3_2579_계단오르기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int stairs[] = new int[301];
		
		for(int i=1; i<=N; i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		
		//DP 만들기
		int DP[] = new int[301];
		DP[1] = stairs[1];
		DP[2] = Math.max(stairs[2] + DP[0], stairs[2] + DP[1]);
		
		
		for(int i=3; i<=N; i++) {
			DP[i] = Math.max(stairs[i]+DP[i-2], stairs[i]+stairs[i-1] + DP[i-3]);
			//두 계단씩 오를 경우와 한 계단을 밟을 경우 비교 (연속된 세 개 계단 안 밟도록 처리)
		}
		
		System.out.println(DP[N]);
	}

}
