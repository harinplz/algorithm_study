import java.io.*;
import java.util.*;

public class BOJ_실버4_1822_차집합 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new TreeSet<>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num)) set.remove(num);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(set.size() + "\n");
		
		for(int num : set) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);
	}

}
