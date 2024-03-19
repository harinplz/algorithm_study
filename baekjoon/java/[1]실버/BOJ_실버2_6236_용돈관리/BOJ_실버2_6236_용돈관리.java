import java.io.*;
import java.util.*;

public class BOJ_실버2_6236_용돈관리 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		int money[] = new int[N];
		int min = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			money[i] = Integer.parseInt(in.readLine());
			min = Math.max(min, money[i]);
			max += money[i];
		}
		
		int ans = 0;
		int total = 0; // 현재 남은 금액 
		while(min <= max) {
			int mid = (min + max) / 2;
			total = mid;
			boolean flag = true;
			int cnt = 1;
			for(int i=0; i<N; i++) {
				if(money[i] > mid) { // 하루 쓸 돈이 인출한 돈 보다 많다면 쓸 수 없음. 
					flag = false;
					break;
				}
				if(money[i] > total) { // 하루 쓸 돈이 남은 돈 보다 많다면 
					// 돈 뽑아야함 
					cnt++;
					total = mid;
				}
				// 돈 쓰기 
				total -= money[i];
			}
			
			// 돈 뽑는 횟수가 M보다 크거나 flag가 false인 경우에는 
			if(!flag || cnt > M) min = mid + 1;
			else {
				ans = mid; // 인출 금액 저장 
				max = mid - 1;
			}
		}
		
		System.out.println(ans);
		
		
		
	}
	
}
