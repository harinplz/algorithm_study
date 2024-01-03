import java.io.*;
import java.util.*;

public class BOJ_실버1_20529_가장가까운세사람의심리적거리 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(in.readLine());
			
			String[] arr = new String[N];
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = st.nextToken();
			}
			
			int min = Integer.MAX_VALUE;
			
			if(N > 32) {
				sb.append(0).append('\n');
				continue;
			}
			
			for(int i=0; i<N-2; i++) {
				for(int j=i+1; j<N-1; j++) {
					for(int m=j+1; m<N; m++) {
						int ans = 0;
						String str1 = arr[i];
						String str2 = arr[j];
						String str3 = arr[m];
						
						for(int k=0; k<4; k++) {
							if(str1.charAt(k) != str2.charAt(k)) ans++; 
							if(str1.charAt(k) != str3.charAt(k)) ans++;
							if(str2.charAt(k) != str3.charAt(k)) ans++;
						}
						
						min = Math.min(ans, min);
					}
				}
			}
			sb.append(min).append('\n');
		}
		
		System.out.println(sb);
	}
}
