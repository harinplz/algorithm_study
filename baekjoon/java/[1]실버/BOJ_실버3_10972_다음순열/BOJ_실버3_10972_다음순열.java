import java.io.*;
import java.util.*;

public class BOJ_실버3_10972_다음순열 {
	
	/*
	 * 1부터 N까지의 수로 이루어진 순열 
	 * 사전순으로 다음에 오는 순열을 구하는 프로그램 
	 */

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		
		for(int i=N-2; i>=0; i--) {
			for(int j = i + 1; j < N; j++) {
				if(arr[i] < arr[j]) {
					int minIdx = j;
					for(int m = j+1; m < N; m++) {
						if(arr[i] < arr[m] && arr[m] < arr[minIdx]) minIdx = m;
					}
					
					// 뒤에 남는 애들끼리 정렬 
					for(int k=0; k<i; k++) {
						sb.append(arr[k] + " ");
					}
					sb.append(arr[minIdx] + " ");
					
					List<Integer> list = new ArrayList<>();
					for(int k = i+1; k<N; k++) {
						if(k == minIdx) list.add(arr[i]);
						else list.add(arr[k]);
					}
					Collections.sort(list);
					
					for(int num : list) {
						sb.append(num + " ");
					}
					flag = true;
					break;
				}
			}
			
			if(flag) break;
		}

		if(!flag) System.out.println(-1);
		else System.out.println(sb);		
	}
		
}
