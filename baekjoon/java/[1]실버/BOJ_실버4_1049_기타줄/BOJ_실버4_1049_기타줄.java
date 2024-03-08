import java.io.*;
import java.util.*;

public class BOJ_실버4_1049_기타줄 {
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int setMin = Integer.MAX_VALUE;
		int eachMin = Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			setMin = Math.min(setMin, Integer.parseInt(st.nextToken()));
			eachMin = Math.min(eachMin, Integer.parseInt(st.nextToken()));
		}
		
		int min = Integer.MAX_VALUE;
		
		// 세트 0개 샀을 때, ... , N/6 + 1 개 샀을 때 까지 반복 
		for(int i=0; i<=N/6 + 1; i++) {
			if(i == N/6 + 1) min = Math.min(min, setMin * i);
			else min = Math.min(min, setMin * i + eachMin * (N - (i*6)));
		}
		
		System.out.println(min);
		
	}

	 
}
