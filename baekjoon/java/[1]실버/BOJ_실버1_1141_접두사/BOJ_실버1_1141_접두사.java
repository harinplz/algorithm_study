import java.io.*;
import java.util.*;

public class BOJ_실버1_1141_접두사 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> ans = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			list.add(in.readLine());
		}
		
		Collections.sort(list, new Sort());
		
		for(int i=0; i<N-1; i++) {
			String str = list.get(i);
			
			for(int j=i+1; j<N; j++) {
				String nextStr = list.get(j);
				
				if(str.equals(nextStr.substring(0, str.length()))) {
					ans.add(str);
					break;
				}
			}
		}
		
		for(String str : ans) {
			list.remove(str);
		}
		
		System.out.println(list.size());
		
	}
	
	
	static class Sort implements Comparator<String> {
		
		@Override
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}

}
