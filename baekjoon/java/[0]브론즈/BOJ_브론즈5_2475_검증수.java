package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_브론즈5_2475_검증수 {
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num * num;
		}
		
		System.out.println(sum % 10);
		
	}

}