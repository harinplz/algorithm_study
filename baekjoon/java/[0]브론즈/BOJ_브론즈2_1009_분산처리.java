import java.io.*;
import java.util.*;

public class BOJ_브론즈2_1009_분산처리 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int ans = 1;
			while(b-->0) {
				ans = (ans*a) % 10;
			}
			if(ans == 0) ans = 10;
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}

}
