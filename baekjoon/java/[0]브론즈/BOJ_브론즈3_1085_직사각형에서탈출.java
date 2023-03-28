package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_브론즈3_1085_직사각형에서탈출 {
	
	//5분

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		//최솟값 구하기
		int min = Math.min(x, Math.min(y, Math.min(w-x, h-y)));
		
		System.out.println(min);
		
	}
	
}
