import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int pos[] = new int[M];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<M; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분탐색 시작 
		int min = 1;
		int max = N;
		int ans = 0;
		
		while(min <= max) {
			int mid = (min + max) / 2;

			int left = pos[0] - mid < 0 ? 0 : pos[0] - mid;
			int right = pos[0] + mid - 1 > N ? N : pos[0] + mid;
			
			boolean flag = true;
			for(int i=1; i<M; i++) {
				int newLeft = pos[i] - mid < 0 ? 0 : pos[i] - mid;
				if(newLeft > right) {
					flag = false;
					break;
				}
				
				right = pos[0] + mid - 1 > N ? N : pos[i] + mid;
			}
			
			if(flag) {
				if(left > 0 || right < N) flag = false; 
			}
			
			if(!flag) min = mid + 1;
			else {
				ans = mid;
				max = mid - 1;
			}
		}
		
		System.out.println(ans);
		
	}
	
}
