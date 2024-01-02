import java.io.*;
import java.util.*;

public class BOJ_실버4_25192_인사성밝은곰곰이 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int ans = 0;
		Set<String> set = new HashSet<>();
		while(N-->0) {
			String str = in.readLine();
			
			if(str.equals("ENTER")) {
				set.clear();
			}
			else {
				if(!set.contains(str)) {
					set.add(str);
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
