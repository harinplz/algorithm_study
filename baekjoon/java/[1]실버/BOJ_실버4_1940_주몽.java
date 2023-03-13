package ssafy.com.BOJ.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_실버4_1940_주몽 {
	
	/**
	 * 230313
	 * 메모리 : 20296 KB 시간 : 556ms
	 * 재료의 번호를 입력 받은 후 내림차순으로 정렬 뒤
	 * startIdx와 endIdx를 변경해가며 M과 같은지 판단 후 같다면 cnt++ 해준다.
	 * 
	 * Integer 내림차순 정렬 방법
	 * Arrays.sort(배열, Collections.reverseOrder());
	 */
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		Integer material [] = new Integer[N];
		
		//재료 넣기
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			material[i] = Integer.parseInt(st.nextToken());
		}
		
		//재료 번호 내림차순 정렬
		Arrays.sort(material, Collections.reverseOrder());
		
		int startIdx, endIdx;
		
		int cnt = 0; //가지수 더하는 변수
		boolean flag = false; //for문을 중단시키기 위한 boolean 변수
		
		for(startIdx = 0; startIdx<N-1; startIdx++) {
			for(endIdx = startIdx+1; endIdx < N; endIdx++) {
				int result = material[startIdx] + material[endIdx];
				if(endIdx == startIdx + 1) {
					//이때 두 값의 합이 M보다 작으면 break. 종료
					flag = result < M ? true : false;
					if(flag) break;
				}
				if(result == M) { //M과 result 값이 같다면 cnt 증가
					cnt++;
					break;
				}
				if(flag) break;
			}
		}
		
		System.out.println(cnt);
		
		
	}
	

}
