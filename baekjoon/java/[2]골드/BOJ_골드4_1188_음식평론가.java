import java.io.*;
import java.util.*;

public class BOJ_골드4_1188_음식평론가 {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int gcd = gcd(N, M);
		
		System.out.println(M - gcd);
	}
	
	public static int gcd(int N, int M) {
		if(M == 0) return N;
		return gcd(M, N % M);
	}

}
