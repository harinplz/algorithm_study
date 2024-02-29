import java.io.*;
import java.util.*;

public class BOJ_골드5_1011_FlymetotheAlphaCentauri {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(T-->0) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			y -= x;
			x -= x;
			
			int max = (int)Math.sqrt(y); // 최대 이동 거리 
			
			int count;
			if(Math.sqrt(y) == max) count = max * 2 - 1;
			else if(y <= max*max + max) count = max * 2;
			else count = max * 2 + 1;
			
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
		
	}
	

}
