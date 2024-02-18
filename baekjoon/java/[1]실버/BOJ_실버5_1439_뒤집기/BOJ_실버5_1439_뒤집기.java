import java.io.*;
import java.util.*;

public class BOJ_실버5_1439_뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		
		int oneCnt = 0;
		int zeroCnt = 0;
		boolean flag = false;
		
		if(str.charAt(0) == '1') oneCnt++;
		else zeroCnt++;
		
		for(int i=0; i<str.length()-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) flag = true;
			else flag = false;
			
			if(!flag && str.charAt(i+1) == '1') oneCnt++;
			else if(!flag && str.charAt(i+1) == '0') zeroCnt++;
		}

		System.out.println(Math.min(oneCnt, zeroCnt));
	
	}
	

}
