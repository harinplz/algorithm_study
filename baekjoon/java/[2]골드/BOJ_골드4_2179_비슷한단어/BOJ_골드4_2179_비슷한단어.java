import java.io.*;
import java.util.*;

public class BOJ_골드4_2179_비슷한단어 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		String arr[] = new String[N+1];
		for(int i=0; i<N; i++) {
			arr[i] = in.readLine();
		}
		
		int str1Idx = 0;
		int str2Idx = 1;
		int maxCnt = Integer.MIN_VALUE;
		
		// 두 문자열을 뽑아 서로 비교한다. 
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				// 이 두 문자열의 공통 길이를 구해본다.
				String A = arr[i];
				String B = arr[j];
				
				int minLen = A.length() >= B.length() ? B.length() : A.length();
				int cnt = 0;
				
				for(int k = 0; k < minLen; k++) {
					if(A.charAt(k) == B.charAt(k)) cnt++;
					else break;
				}
				
				if(cnt > maxCnt) {
					maxCnt = cnt;
					str1Idx = i;
					str2Idx = j;
				}
			}
		}
		
		
		System.out.println(arr[str1Idx] + "\n" + arr[str2Idx]);
	
	}


}
