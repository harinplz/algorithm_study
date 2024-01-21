import java.io.*;
import java.util.*;

public class BOJ_실버4_2776_암기왕 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		while(T-->0) {
			int N = Integer.parseInt(in.readLine());
			
			Set<Integer> set = new HashSet<>();
			st = new StringTokenizer(in.readLine());
			
			for(int i=0; i<N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine());
			for(int i=0; i<M; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			
		}
		
		System.out.println(sb);
		
		
	}
		
}
