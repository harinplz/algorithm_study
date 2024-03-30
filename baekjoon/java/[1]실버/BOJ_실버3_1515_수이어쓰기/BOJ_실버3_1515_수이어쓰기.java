import java.io.*;
import java.util.*;

public class BOJ_실버3_1515_수이어쓰기 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		
		int var = 0;
		int idx = 0;
		while(true) {
			var++;
			String varString = Integer.toString(var);
			for(int i=0; i<varString.length(); i++) {
				if(varString.charAt(i) == str.charAt(idx)) idx++;
				if(idx == str.length()) {
					System.out.println(var);
					return;
				}
			}
		}
	}
	
}
