import java.io.*;
import java.util.*;

public class BOJ_실버4_2847_게임을만든동준이 {
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int arr[] = new int[N];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			if(i==N-1) max = arr[i];
		}
		
		int ans = 0;
		// 점수 내리는 최소 횟수 구하기 
		for(int i=N-2; i>=0; i--) {
			if(max <= arr[i]) {
				ans += (arr[i] - (max - 1));
				max--;
			}
			else {
				max = arr[i];
			}
		}
		
		System.out.println(ans);
		
	}

	 
}
