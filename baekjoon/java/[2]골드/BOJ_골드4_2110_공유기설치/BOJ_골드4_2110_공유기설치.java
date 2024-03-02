import java.io.*;
import java.util.*;

public class BOJ_골드4_2110_공유기설치 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1];
		
		while(left < right) {
			int mid = (left + right) / 2; // 최소 거리 설정 
			
			int pos = 0; // 공유기를 설치하는 최소 위치 
			int cnt = 1;
			for(int i=1; i<N; i++) {
				if(arr[i] - arr[pos] >= mid) {
					pos = i;
					cnt++;
				}
			}
			
			if(cnt < C) {
				right = mid;
				continue;
			}
			
			left = mid + 1;
		}
		
		System.out.println(left - 1);
	}
	

}
