import java.io.*;
import java.util.*;

public class BOJ_골드5_2668_숫자고르기 {
	
	static int N;
	static int arr[];
	static boolean visited[];
	
	static int start;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			start = i;
			visited[i] = true;
			DFS(i);
			visited[i] = false;
		}
		
		StringBuilder sb = new StringBuilder();
		Collections.sort(list);
		
		sb.append(list.size()+"\n");
		for(int num : list) {
			sb.append(num + "\n");
		}
		
		System.out.println(sb);
			
	}
	
	static void DFS(int idx) {
		if(start == arr[idx]) list.add(start);
		
		if(!visited[arr[idx]]) {
			visited[arr[idx]] = true;
			DFS(arr[idx]);
			visited[arr[idx]] = false;
		}

	}

}
