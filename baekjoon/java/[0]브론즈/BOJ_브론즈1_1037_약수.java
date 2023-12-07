import java.io.*;
import java.util.*;

public class BOJ_브론즈1_1037_약수 {
	
	/*
	 * 풀이 시간 : 6분 20초
	 * 풀이 방법 : 정렬 / 수학 
	 * 메모리 : 11588KB, 시간 : 76ms 
	 */
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine()); // N의 진짜 약수의 개수 
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 진짜 약수 저장 배열 
		int measure[] = new int[N];
		for(int i=0; i<N; i++) {
			measure[i] = Integer.parseInt(st.nextToken());
		}
		
		// 약수를 오름차순으로 정렬한다. 
		Arrays.sort(measure);
		
		// 정렬한 배열에서 가장 작은 값과 가장 큰 값을 곱해준다. 
		System.out.println(measure[0] * measure[N-1]);
	}
}
