import java.io.*;
import java.util.*;

public class BOJ_실버1_20922_겹치는건싫어 {

  /*
    투포인터 문제 ..
    투포인터 문제는 왜 이렇게 풀릴 듯 하면서 안 풀릴까 ..?
    내가 잘 못하고 있다는거겠지 ... 투포인터 좀 많이 풀어야겠음!!! 
  */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N]; // 배열 생성
		
		// 배열 입력 받기
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int startIdx = 0;
		int endIdx = 0;
		int length = 0;
		int ans = Integer.MIN_VALUE;
		int cnt[] = new int[100001]; // 원소 수 세는 배열 
		
		while(startIdx <= endIdx) {
			
			// 원소 수가 K개 미만이라면 
			if(endIdx <= N-1 && cnt[arr[endIdx]] < K) {
				cnt[arr[endIdx]]++;
				endIdx++;
			}
			// 원소 수가 K개라면 
			else if(cnt[arr[endIdx]]==K){
				cnt[arr[startIdx]]--;
				startIdx++;
			}
			
			length = endIdx - startIdx;
			ans = length > ans ? length : ans;
			
			if(endIdx == N) break;
		}
		
		System.out.println(ans);
		
	}

}
