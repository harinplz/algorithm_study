import java.io.*;
import java.util.*;

public class BOJ_골드4_1253_좋다_2 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)  {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열 오름차순 정렬 
		Arrays.sort(arr);
		
		// 투포인터 방식으로 좋은 수 찾기 
		int ans = 0; // 좋은 수 개수 저장 
		
		// N이 1이거나 2일 경우에는 하나의 수를 다른 두개의 수의 합으로 표현할 수 없으니 0출력하고 종료. 
		if(N == 1 || N == 2) {
			System.out.println("0");
			return;
		}
		
		for(int i=0; i<N; i++) {
			int num = arr[i];
			
			// 투포인터 
			int left = 0;
			int right = N-1;
			
			while(left < right) {
				// 자신을 더할수도 있으니까 자신일 경우 제외하기. 
				if(i == left) {
					left++;
					continue;
				}
				else if(i == right) {
					right--;
					continue;
				}
				
				int sum = arr[left] + arr[right];
				if(sum == num) {
					ans++;
					break;
				}
				
				if(sum < num) {
					left++;
				}
				else if(sum > num) {
					right--;
				}
			}
		}
		
		System.out.println(ans);
		
		
	}
	 
}
