import java.io.*;
import java.util.*;

public class BOJ_실버5_1094_막대기 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(in.readLine());
		
		int num = 64;
		int ans = 0;
		
		while(X != 0) {
			if(X >= num) {
				X -= num;
				ans++;
			}
			num /= 2;
		}
		
		System.out.println(ans);
		
	}
	
}
