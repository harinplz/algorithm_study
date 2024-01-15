import java.io.*;
import java.util.*;

public class BOJ_실버3_11478_서로다른부분문자열의개수 {
    
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		Set<String> set = new HashSet<>();
		
		int len = str.length();
		
		for(int l = 1; l <= len; l++) {
			for(int i = 0; i<=len-l; i++) {
				set.add(str.substring(i, i+l));
			}
		}
		
		System.out.println(set.size());
	}
}
