import java.io.*;
import java.util.*;

public class BOJ_실버1_2529_부등호 {
	
	/*
	 * 풀이시간 : 32분 
	 * 풀이 방법 : 자료구조 스택 사용 
	 * 메모리 : 11572KB, 시간 : 76ms
	 */
	
	/*
	 * 스택을 사용해서 완전 구현을 했는데 이 풀이 방식이 맞는 지 모르겠다. 
	 * 최댓값일 때와 최솟값일 때를 나눠서 생각했다.
	 * 최댓값일때는 '>' 부등호가 나왔을 땐 숫자가 내림차순으로 정렬되고 '<' 부등호가 나왔을 땐 숫자가 오름차순으로 정렬된다.
	 * 오름차순으로 정렬하기 위해 스택을 사용해서 숫자를 저장했다. 
	 * 스택은 선입 후출 구조라서 이를 구현하기에 적절한 자료구조라고 생각! 
	 * 최솟값일때는 이 방식과 정반대로 구현하면 된다. 
	 */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int k = Integer.parseInt(in.readLine());
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		char inequality[] = new char[k]; // 부등호 저장 배열 
		
		for(int i=0; i<k; i++) {
			inequality[i] = st.nextToken().charAt(0);
		}
		
		List<Integer> max = new ArrayList<>(); // 최댓값 저장 리스트 
		List<Integer> min = new ArrayList<>(); // 최솟값 저장 리스트 
		
		// 최댓값 구하기 
		Stack<Integer> stack = new Stack<>();
		int num = 9;
		for(int i=0; i<k; i++) {
			if(inequality[i] == '>') {
				max.add(num--);
				while(!stack.isEmpty()) {
					max.add(stack.pop());
				}
				if(i==k-1) max.add(num);
			}
			else {
				stack.push(num--);
				if(i==k-1) stack.push(num);
			}
		}
		while(!stack.isEmpty()) {
			max.add(stack.pop());
		}
		
		for(int maxNum : max) {
			sb.append(maxNum);
		}
		sb.append('\n');
		
		// 최솟값 구하기 
		num = 0;
		for(int i=0; i<k; i++) {
			if(inequality[i] == '<') {
				min.add(num++);
				while(!stack.isEmpty()) {
					min.add(stack.pop());
				}
				if(i==k-1) min.add(num);
			}
			else {
				stack.push(num++);
				if(i==k-1) stack.push(num);
			}
		}
		while(!stack.isEmpty()) {
			min.add(stack.pop());
		}
		for(int minNum: min) {
			sb.append(minNum);
		}
		
		System.out.println(sb);
	}
}
