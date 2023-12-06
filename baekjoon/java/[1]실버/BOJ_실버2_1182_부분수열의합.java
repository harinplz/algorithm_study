import java.io.*;
import java.util.*;

public class Main {
	
	/*
	 * 풀이 시간 : 12분 14초 
	 * 풀이 방법 : 조합 
	 * 메모리 : 11880KB, 시간 : 152ms 
	 */
	
	static int N, S; // 변수 
	static int com[]; //숫자를 뽑고나서 보관하는 배열 
	static int ans = 0; // 문제에서 요구하는 답 - 경우의 수의 총 합 
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		int nums[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 숫자를 뽑는다.
		// 순서가 상관 없으니까 조합으로. 근데 뽑는 개수가 계속 달라짐. (1 ~ N개) 
		for(int i=1; i<=N; i++) {
			com = new int[i];
			combi(0, 0, i, nums); // 뽑기를 시작하는 인덱스, 몇 개를 뽑았는 지, 몇 개를 뽑아야하는지, 뽑는 대상이 되는 배열 
		}
		
		System.out.println(ans);
		
		
	}
	
	public static void combi(int start, int cnt, int total, int[] nums) {
		// 다 뽑았을 때 
		if(cnt == total) {
			int sum = 0; // 뽑은 수 합을 저장하는 변수 
			for(int num : com) {
				sum += num;
			}
			if(sum == S) ans++; // 합이 S와 같다면 ans를 1 증가해준다. 
			return;
		}
		
		// 뽑는 과정 
		for(int i = start; i < N; i++) {
			com[cnt] = nums[i];
			combi(i+1, cnt+1, total, nums);
		}
	}
	
}
