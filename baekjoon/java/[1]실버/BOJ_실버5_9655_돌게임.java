import java.io.*;
import java.util.*;

public class BOJ_실버5_9655_돌게임 {
	
	/*
	 * 풀이 시작 : 오전 12시 57분 ~ 
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		boolean skWin = false;
		while(N>0) {
			if(N < 3) N-=1;
			else N-=3;
			skWin = !skWin;
		}
		
		String ans = skWin ? "SK" : "CY";
		System.out.println(ans);
		
	}
}
