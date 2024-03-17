import java.io.*;
import java.util.*;

public class BOJ_실버3_12847_꿀아르바이트 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int salary[] = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++)  {
			salary[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초기 슬라이딩 윈도우
		long sum = 0;
		for(int i=0; i<m; i++) {
			sum += salary[i];
		}
		
		long max = sum;
		
		for(int i=0; i+m<n; i++) {
			sum -= salary[i];
			sum += salary[i+m];
			if(max < sum) max = sum;
		}
		
		System.out.println(max);
	}
	
	
		
}
