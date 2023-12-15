import java.io.*;
import java.util.*;

public class BOJ_골드1_1300_K번째수 {

  /*
   * 풀이시간 : 블로그 참고
   * 풀이방법 : 이분탐색 
   * 메모리 : 11652KB, 시간 : 120ms
   */
	
	public static void main(String[] args) throws Exception {
    // 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int k = Integer.parseInt(in.readLine());

    // 이분 탐색 
		long left = 1;
		long right = k;

		while(left <= right) {
			long mid = (left + right) / 2;
			long count = 0;
			
			for(int i=1; i<=N; i++) {
				count += Math.min(mid/i, N);
			}
			
			if(count < k) {
				left = mid + 1;
			}
			else {
				right = mid-1;
			}
			
		}
		
		System.out.println(left);
		
	}
	
}
