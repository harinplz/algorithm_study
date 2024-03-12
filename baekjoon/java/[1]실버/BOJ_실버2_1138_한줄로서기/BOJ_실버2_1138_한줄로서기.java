import java.io.*;
import java.util.*;

public class BOJ_실버2_1138_한줄로서기 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int tall[] = new int[N+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			tall[i] = Integer.parseInt(st.nextToken());
		}
		
		int arr[] = new int[N];
		
		// 초기화 
		arr[tall[1]] = 1;
		
		for(int i=2; i<=N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(arr[j] == 0) {
					if(cnt == tall[i]) {
						arr[j] = i;
						break;
					}
					cnt++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num : arr) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
		
	}
	
}
