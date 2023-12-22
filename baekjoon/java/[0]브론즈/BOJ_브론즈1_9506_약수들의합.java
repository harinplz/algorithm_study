import java.io.*;
import java.util.*;

public class BOJ_브론즈1_9506_약수들의합 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if(N == -1) break;
			
			List<Integer> list = new ArrayList<>();
			for(int i=1; i<=N/2; i++) {
				if(N%i == 0) list.add(i);
			}
			
			int sum = 0;
			for(int num : list) {
				sum += num;
			}
			
			if(sum == N) {
				sb.append(N + " = ");
				for(int i = 0; i<list.size(); i++) {
					if(i==list.size()-1) {
						sb.append(list.get(i));
					}
					else {
						sb.append(list.get(i) + " + ");
					}
				}
				sb.append('\n');
			}
			else {
				sb.append(N + " is NOT perfect.\n");
			}
		
		}

		System.out.println(sb);
	}
}
