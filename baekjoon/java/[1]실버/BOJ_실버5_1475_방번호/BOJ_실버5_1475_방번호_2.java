import java.io.*;
import java.util.*;

public class BOJ_실버5_1475_방번호_2 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String N = in.readLine();
		
		int[] cnt = new int[10];
		
		for(int i=0; i<N.length(); i++) {
			int num = N.charAt(i) - '0';
			
			if(num == 6 || num == 9) {
				if(cnt[6] > cnt[9]) cnt[9]++;
				else cnt[6]++;
			}
			else cnt[num]++;
		}
		
		int max = 0;
		
		for(int num : cnt) {
			max = Math.max(max, num);
		}
		
		System.out.println(max);
	}
	
}
