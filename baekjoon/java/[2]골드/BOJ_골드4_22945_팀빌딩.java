import java.io.*;
import java.util.*;

public class BOJ_골드4_22945_팀빌딩 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		//능력치 배열 입력
		int[] stat = new int[N];
		for(int i=0; i<N; i++) {
			stat[i] = Integer.parseInt(st.nextToken());
		}
		
		//투포인터를 사용해서 최대 능력치 계산
		int ans = Integer.MIN_VALUE;

		int startIdx=0; int endIdx=N-1;
		while(startIdx < endIdx) {
			int minStat = Math.min(stat[startIdx], stat[endIdx]);
			ans = Math.max((endIdx - startIdx - 1) * minStat, ans);
			
			if(stat[startIdx] < stat[endIdx]) startIdx++;
			else endIdx--;
		}
		
		System.out.println(ans);
	}

}
