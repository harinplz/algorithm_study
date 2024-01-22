import java.io.*;
import java.util.*;

public class BOJ_실버5_14582_오늘도졌다 {
	
	/*
	 * 풀이 시간 : 15분 
	 * 풀이 방법 : 구현 
	 * 메모리 : 11496KB, 시간 : 76ms 
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int jem[] = new int[9];
		int sta[] = new int[9];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<9; i++) {
			jem[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<9; i++) {
			sta[i] = Integer.parseInt(st.nextToken());
		}
		
		int jemSum = 0;
		int staSum = 0;
		
		boolean win = false;
		
		for(int i=0; i<9; i++) {
			jemSum += jem[i];
			if(jemSum > staSum) win = true;
			staSum += sta[i];			
		}
	
		
		if(win) System.out.println("Yes");
		else System.out.println("No");
	}
		
}
