import java.io.*;
import java.util.*;

public class BOJ_실버5_10431_줄세우기 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(P-->0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int testCase = Integer.parseInt(st.nextToken());
			
			int arr[] = new int[20];
			for(int i=0; i<20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int ans = 0; // 뒤로 물러서는 횟수 
			
			for(int i=0; i<20; i++) {
				for(int j=0; j<i; j++) {
					if(arr[j] > arr[i]) ans++;
				}
			}
			
			sb.append(testCase + " " + ans + "\n");

		}
		
		System.out.println(sb);

	}

}
