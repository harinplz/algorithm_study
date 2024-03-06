import java.io.*;
import java.util.*;

public class BOJ_실버5_1789_수들의합 {
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(in.readLine());
		
		long ans = 0;
		long i = 1;
		while(num >= 0) {
			num -= i++;
			ans++;
		}
		
		System.out.println(ans - 1);
	}

	 
}
