import java.io.*;
import java.util.*;

public class BOJ_실버3_19637_IF문좀대신써줘 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] style = new String[N];
		int[] powers = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			style[i] = st.nextToken();
			powers[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		//System.out.println(map);
		
		while(M-->0) {
			int power = Integer.parseInt(in.readLine());

			int left = 0;
			int right = N-1;
			
			while(left <= right)  {
				int mid = (left + right) / 2;
				
				if(powers[mid] < power) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
			sb.append(style[left] + "\n");
		}
		
		System.out.println(sb);
	}
	
}
