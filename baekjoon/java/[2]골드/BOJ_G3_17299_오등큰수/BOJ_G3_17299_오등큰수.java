import java.io.*;
import java.util.*;

public class BOJ_G3_17299_오등큰수 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		int F[] = new int[1000001];
		int NGF[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			F[arr[i]]++;
		}
		
		// 오등큰수 구하기 
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && F[arr[i]] > F[arr[stack.peek()]]) {
				NGF[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		// 오등큰수 못 구한 수는 -1 대입 
		while(!stack.isEmpty()) {
			NGF[stack.pop()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int ans : NGF) {
			sb.append(ans + " ");
		}
		
		System.out.println(sb);
	}
	
}
