import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_실버4_11399_ATM {
	
	/*
	 * 메모리 : 11840KB 시간 : 84ms
	 * 처음에 너무 어렵게 순열로 접근했는데 당연히 시간초과 ... 
	 * 사람이 1000명이니까 당연히 시간초과가 날 수 밖에 없었다.
	 * 근데 그냥 정렬하니까 되었음 .. 쉽게 생각하는 방법을 기르자!! 
	 */
	
	static int N;
	static int time[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		time = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=1; i<=N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		int prefixTime[] = new int[N+1];
		int minT = 0;
		
		for(int i=1; i<=N; i++) {
			prefixTime[i] = prefixTime[i-1] + time[i];
			minT += prefixTime[i];
		}

		System.out.println(minT);
	}




}
