package ssafy.com.BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_실버3_15650_N과M2 {

	private static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[] numbers;
	private static boolean[] chk;
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		chk = new boolean[n+1]; 
		
		comb(0, 1);
		
		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		//기저 부분
		if(cnt == m) {
			for(int num:numbers) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//유도 부분
		for(int i = start;i<=n;i++) {
			
			if(chk[i] == true) continue;
			
			chk[i] = true;
			numbers[cnt] = i;
			comb(cnt+1, i+1);
			chk[i] = false;
		}
		
	}
	
}
