package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11720 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String[] input = in.readLine().split("");
		
		int sum=0;
		for(String inp: input) {
			sum += Integer.parseInt(inp);
		}
		
		System.out.println(sum);
		
	}
}
