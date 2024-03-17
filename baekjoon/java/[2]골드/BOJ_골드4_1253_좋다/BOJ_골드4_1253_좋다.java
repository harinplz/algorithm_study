package ssafy.com.BOJ.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_골드4_1253_좋다 {
	
	/**
	 * 메모리 : 14740KB 시간 : 184ms
	 * 잡고있다가 계속 틀려서 결국 책을 참고해서 풀었다 ㅠㅠ
	 * 투포인터가 양쪽에서 올 수도 있지.. 계속 같은 곳에서 시작한다는 고정관념에 잡혀서 못 풀었다!!
	 * 생각의 폭을 늘리자..!! 
	 */
	
	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int nums[] = new int[N]; //숫자 배열
		
		//숫자 값 입력 받기
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		//오름차순 정렬
		Arrays.sort(nums);
		
		int cnt = 0; //좋은 숫자 개수 저장 변수
		
		// 좋은 숫자 구하기 알고리즘
		int startIdx, endIdx; //시작과 끝 인덱스 
		int target; //좋은 수 target 
		
		for(int i=0; i<N; i++) {
			target = nums[i]; //좋은 수 target 뽑기
			startIdx = 0; endIdx = N-1; //시작, 끝 인덱스 정하기
			
			while(startIdx < endIdx) { //시작인덱스와 끝 인덱스가 만날 때 까지
				if(startIdx == i) { //i라면 startIdx++
					startIdx++; continue;
				}
				else if(endIdx == i) { //i라면 endIdx--
					endIdx--; continue;
				}
				//자신을 이용하면 안되기 때문!
				
				int result = nums[startIdx] + nums[endIdx];
				if(result == target) { //더한값이 target과 같으면
					cnt++; //cnt 증가!
					break;
				}
				else if(result > target) endIdx--;
				//result가 target보다 크다면 수를 줄여야하니까 endIdx--
				else if(result < target) startIdx++;
				//result가 target보다 작다면 수를 늘려야하니까 startIdx++ 
			}
		}
		
		System.out.println(cnt);
		
	}

}
