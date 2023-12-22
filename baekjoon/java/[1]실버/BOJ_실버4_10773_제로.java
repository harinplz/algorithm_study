import java.io.*;
import java.util.*;

public class BOJ_실버4_10773_제로 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(in.readLine());
		
		Stack<Integer> stack = new Stack<>(); // 스택 생성 
		while(K-- > 0) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0 && !stack.isEmpty()) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}
		
		int sum = 0;
		for(int num : stack) {
			sum += num;
		}
		
		System.out.println(sum);
	}
	

	
	
}
