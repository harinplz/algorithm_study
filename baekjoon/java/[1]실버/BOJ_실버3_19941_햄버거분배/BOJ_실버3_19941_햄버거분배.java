import java.io.*;
import java.util.*;

public class BOJ_실버3_19941_햄버거분배 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[] hamburger = new char[N];
		
		String str = in.readLine();
		for(int i=0; i<N; i++) {
			hamburger[i] = str.charAt(i);
		}
		
		// 햄버거 매칭하기 
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			char ch = hamburger[i];
			
			if(ch == 'P') {
				// 이전 
				boolean isEat = false; 
				for(int k=K; k>=1; k--) {
					if(isRange(i - k, N) && hamburger[i-k] == 'H') {
						isEat = true;
						hamburger[i-k] = 'E';
						ans++;
						break;
					}
				}
				
				if(isEat) continue;
				
				// 이후 
				for(int k=1; k<=K; k++) {
					if(isRange(i + k, N) && hamburger[i+k] == 'H') {
						hamburger[i + k] = 'E';
						ans++;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean isRange(int num, int N) {
		if(0 <= num && num < N) return true;
		return false;
	}

}
