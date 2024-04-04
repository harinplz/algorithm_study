import java.io.*;
import java.util.*;

public class BOJ_실버3_22858_원상복구(small) {

	public static void main(String[] args) throws Exception {

		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int S[] = new int[N];
		int D[] = new int[N];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		int P[] = new int[N];
		while(K-->0) {
			for(int i=0; i<N; i++) {
				P[D[i]-1] = S[i]; 
			}
			
			for(int i=0; i<N; i++) {
				S[i] = P[i];
			}
			
			// S값 P로 업데이트 
			// S = P; // 정답 코드 보고 따라해봤는데 값 업데이트가 아니라 그냥 아예 똑같아짐
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(S[i] + " ");
		}
		
		System.out.println(sb);
	}
	
}
