package ssafy.com.BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_골드3_10986_나머지합 {
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 메모리 : 112744KB, 시간 : 488ms
		 * 자료형 주의!!! 혹시 모르면 그냥 long으로 풀기..
		 */
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); //수 N개
		int M = Integer.parseInt(st.nextToken()); //나누는 수 M, M으로 나눠 떨어지는 구간을 구해야한다.
		
		int preSum=0; //이전까지의 누적합을 %M 한 수
		int curSum=0; //현재까지의 누적합을 %M 한 수
		
		/**
		 * i부터 j까지의 누적합은 preSum[j] - preSum[i-1]
		 * M으로 나눠 떨어지는 구간의 개수를 구해야하기 때문에 (preSum[j] - preSum[i-1]) % M == 0 을 만족하는 구간을 구해야한다.
		 * preSum[j] - preSum[i-1] = 0 은 preSum[j] == preSum[i-1]로 변환할 수 있다.
		 * 즉 preSum[j] % M == preSum[i-1] % M인 애들 중에서 2개를 조합으로 뽑아(구간이니까) 개수를 구하면 된다. 
		 * 개수는 cnt[누적합%M] 배열에 저장하며 풀어나간다.
		 * N이 10^6이기 때문에 long 배열을 써야한다.
		 */
		long cnt[] = new long[M]; 
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N;i++) {
			preSum = curSum;
			curSum = (preSum + Integer.parseInt(st.nextToken())) % M;
			cnt[curSum]++;
		}
		
		long result = 0;
		result += cnt[0]; //%M이 0이라면 1 1, 2 2 이런 시작 구간과 끝 구간이 같은 경우도 포함하기 때문에 result에 cnt[0] 값은 한 번 추가하고 시작한다.
		for(int i=0; i<M;i++) {
			result += cnt[i] * (cnt[i]-1) / 2; //nC2 조합으로 2개 뽑는 경우의 수를 result에 추가해준다.
		}
		
		System.out.println(result);
		
	}
	
}