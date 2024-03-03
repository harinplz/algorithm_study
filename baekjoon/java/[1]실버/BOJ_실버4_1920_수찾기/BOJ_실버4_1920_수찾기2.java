import java.io.*;
import java.util.*;

public class BOJ_실버4_1920_수찾기2 {
	
	static int arr[];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt")); 
		// 입력 
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬 
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(in.readLine());
		
		st = new StringTokenizer(in.readLine());
		while(M-->0) {
			int target = Integer.parseInt(st.nextToken());
			
			if(binarySearch(0, N-1, target)) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static boolean binarySearch(int left, int right, int target) {
		if(left <= right) {
			int mid = (left + right) / 2;
			
			if(arr[mid] == target) return true;
			else if(arr[mid] < target) return binarySearch(mid + 1, right, target);
			else if(arr[mid] > target) return binarySearch(left, mid-1, target);
		}
		return false;
	}
	

}
