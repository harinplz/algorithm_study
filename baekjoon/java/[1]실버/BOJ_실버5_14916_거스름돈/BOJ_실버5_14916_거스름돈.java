import java.io.*;
import java.util.*;

public class BOJ_실버5_14916_거스름돈 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		boolean flag = false; // 되는지 확인하는 변수 
		int ans = 0; // 답 변수 
		
		for(int i=N/5; i>=0; i--) {
			int cal = N - i*5;
			if(cal % 2 == 0) {
				flag = true;
				ans = i + (cal/2);
				break;
			}
		}
		
		if(flag) System.out.println(ans);
		else System.out.println(-1);
	}

}
