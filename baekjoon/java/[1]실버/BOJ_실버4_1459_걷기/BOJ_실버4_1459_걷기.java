import java.io.*;
import java.util.*;

public class BOJ_실버4_1459_걷기 {

	public static void main(String[] args) throws Exception { 
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());

		long ans = Long.MAX_VALUE;
		
		// 평행 이동만 하는 경우 
		long c1 = (x + y) * w;
		
		// 대각선으로만 이동하는 경우 
		long c2 = 0;
		// (1) x + y의 합이 짝수일 때 
		if((x+y) % 2 == 0) c2 = Math.max(x, y) * s;
		else { // (2) x + y의 합이 홀수 일 때 (마지막엔 평행 이동을 한 번 해야한다.) 
			c2 = (Math.max(x, y) - 1) * s + w;
		}
		
		// 대각선 + 평행이동 같이 하는 경우 
		long c3 = (Math.min(x, y) * s + Math.abs(x - y) * w);
		
		ans = Math.min(c1, Math.min(c2, c3));
		
		System.out.println(ans);
	}
}
