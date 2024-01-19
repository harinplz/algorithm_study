import java.io.*;
import java.util.*;

public class BOJ_실버3_10973_이전순열 {

	public static void main(String[] args) throws Exception {
				// 입력 
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		
		if(previousPermutation(arr)) {
			for(int num : arr) {
				sb.append(num + " ");
			}
		}
		else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	public static boolean previousPermutation(int arr[]) {
		int i = arr.length - 1;
		while(i>0 && arr[i] > arr[i-1]) {
			i--;
		}
		
		if(i==0) return false;
		
		int j = arr.length - 1;
		while(arr[i-1] < arr[j]) {
			j--;
		}
		
		int temp = arr[j];
		arr[j] = arr[i-1];
		arr[i-1] = temp;
		
		j = arr.length - 1;
		while(i<j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}
		
}
