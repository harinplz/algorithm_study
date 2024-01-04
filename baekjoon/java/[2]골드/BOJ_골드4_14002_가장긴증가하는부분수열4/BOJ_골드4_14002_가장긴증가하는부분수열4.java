import java.io.*;
import java.util.*;

public class BOJ_골드4_14002_가장긴증가하는부분수열4 {
	
	public static void main(String[] args) throws Exception {
    // 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

    // dp[k] 배열에는 k자리 까지 가장 긴 증가하는 부분 수열의 길이를 저장한다. 
		int dp[] = new int[N+1];
		int maxLen = 1;
		dp[1] = 1;
		for(int i=2; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<=i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(maxLen + "\n");

    // 역추적하여 가장 긴 증가하는 부분 수열 출력 
		Stack<Integer> stack = new Stack<>();
		
		for(int i=N; i>=1; i--) {
			if(maxLen == dp[i]) {
				stack.push(arr[i]);
				maxLen--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb);
	}
}
