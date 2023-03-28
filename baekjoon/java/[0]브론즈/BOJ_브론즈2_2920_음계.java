package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_브론즈2_2920_음계 {
	
	/*
	 * 구현
	 * 메모리 : 14208KB 시간 120ms
	 */
	
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[8];
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		boolean asc = false;
		boolean desc = false;
		
		int diff = 0;
		
		String ans = "";
		
		for(int i=0; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				if(1 < arr[i] && arr[i] < 8) {
					ans = "mixed";
					break;
				}
				else if(arr[i] == 1) asc = true;
				else if(arr[i] == 8) desc = true;
				continue;
			}
			if(asc) {
				diff = arr[i] - arr[i-1];
				if(diff != 1) {
					ans = "mixed";
					asc = false;
					break;
				}
			}
			else if(desc) {
				diff = arr[i] - arr[i-1];
				if(diff != -1) {
					ans = "mixed";
					desc = false;
					break;
				}
			}
		}
		
		if(asc) ans="ascending";
		else if(desc) ans ="descending";
		
		System.out.println(ans);
	}
	
}