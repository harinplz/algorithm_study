import java.io.*;
import java.util.*;

public class BOJ_골드5_2293_동전1 {

	/*
	 * 블로그 참고 : (https://lotuslee.tistory.com/113)
	 * 2원 짜리 동전으로 금액을 나타내는 경우를 생각해보겠다. 
	 * 만약 k(금액)가 1인 경우, 2원짜리 동전보다 작은 금액이므로 2원짜리 동전으로 나타낼 수 없다. 
	 * 즉, k >= coin[i]일 때에만 dp[k]의 값이 변하게 된다.
	 * 
	 * 만약 k가 3인 경우, 
	 * 1원짜리 동전으로만 나타냈을 때 경우의 수는 dp[3] = 1 이었다. 
	 * 3원을 만들기 위해 2원짜리 동전을 사용하는 경우의 수는 k = 1(dp[1])일때의 경우의 수와 같다. 
	 * 왜냐하면, k = 1(dp[1])일때 경우에서 2원짜리 동전만 추가해주면 되기 때문이다. 
	 * 
	 * 따라서
	 * 금액 3원을 1원, 2원짜리 동전으로 표현한 경우의 수는 
	 * 기존의 1원짜리로 3원을 표현한 경우의 수 + k=1 일때, 3원에서 2원을 뺐을 때의 경우의 수이다. 
	 * 즉 dp[3] = dp[3] + dp[1 = 3 - 2(coin[1])]] 이고
	 * 점화식으로 표현하면,
	 * k>=coin[i]일 때, dp[k] = dp[k] + dp[k - coin[i]]로 표현할 수 있다. 
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[n];
		for(int i=0; i<n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int dp[] = new int[k+1];
		
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j >= coin[i]) dp[j] = dp[j] + dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
