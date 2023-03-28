package ssafy.com.BOJ.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class BOJ_브론즈2_2231_분해합 {
	
	//11분
	//시간초과가 날 줄 알았는데 안난다..!! 근데 살짝 비효율적 같아서 다른 방법도 생각해봐야겠다!
	
	public static void main(String[] args) throws Exception {
		
		//0. 입력 전처리
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 자연수 N 입력
		int N = Integer.parseInt(in.readLine());
		
		// 2. 1부터 자연수 N까지 for 문
		// 2-1. 분해합 구함. 만약 자연수 N과 일치하면 check true로 만들고 break
		boolean check = false;
		for(int i=1; i<=N; i++) {
			int sum = i;
			String str = String.valueOf(i);
			for(int j=0; j<str.length(); j++) {
				sum += str.charAt(j) - '0';
			}
			
			if (sum == N) {
				check = true;
				System.out.println(i);
				break;
			}
		}
		
		
		// 3. check 값 확인. false이면 0을 출력한다.
		if(!check) System.out.println(0);
		
	}
	
}
