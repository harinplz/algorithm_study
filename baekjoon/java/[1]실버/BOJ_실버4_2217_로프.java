import java.io.*;
import java.util.*;

public class BOJ_실버4_2217_로프 {
	
	/*
	 * 풀이 시간 (블참) 
	 * 풀이 방법 : 그리디 / 정렬 / 수학 
	 * 메모리 : 24512KB, 시간 : 352ms
	 */
	
	/*
	 * 첫 시도는 조합으로 N개를 뽑은 다음 그 뽑은 로프에서 최솟값에 * N개 해서 풀었음.
	 * 그러니까 시간 초과남!!! ㄱ- 당연한거임. 
	 * 이 시도에서 뽑은 것에서 최솟값 * 뽑은 개수 라는 식을 이끌어내면 된다는 것은 파악함.
	 * 그런데 어떻게 구현해야할 지 내 머리가 감당하지 못했다 ... 그래서 블참 (ㅠㅠ) 
	 * 그리디는 너무 어렵닷. 식을 구해내는 과정을 연습을 해야겠다. 
	 * 
	 * 일단 내림차순으로 로프가 감당할 수 있는 무게를 정렬한다. 
	 * 최대 중량이 제일 큰 로프를 순서대로 병렬으로 연결한다고 생각하기. 
	 * (예) N이 2이고 로프의 값은 10 15
	 * 1. 내림차순으로 정렬 (15 10)
	 * 2. 일단 첫 번째꺼를 뽑음. 일단 뽑은 rope[i]가 뽑은 것 중에 제일 최소값이고 뽑은 개수는 (i+1)
	 * 3. 이 점화식을 i < N 까지 반복하며 최댓값을 구한다. 
	 */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		Integer rope[] = new Integer[N];
		
		for(int i=0; i<N; i++) {
			rope[i] = Integer.parseInt(in.readLine());
		}
		
		// rope 중량 정렬 
		Arrays.sort(rope, Collections.reverseOrder());
		
		// 하나 뽑으면 하나 뽑은 거에서 x 뽑은 개수 (1)
		// 두개 뽑으면 그 중 작은거에서 x 뽑은 개수 (2)
		// 병렬적으로 로프가 견딜 수 있는 중량을 내림차순으로 
		
		// 답, 로프가 들 수 있는 최대 용량 
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			max = Math.max(max, rope[i] * (i + 1));
		}
		
		System.out.println(max);
	
	}
	
}
