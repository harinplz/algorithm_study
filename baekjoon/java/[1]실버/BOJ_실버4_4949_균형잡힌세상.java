import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_실버4_4949_균형잡힌세상 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = in.readLine();
			if(str.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ch == '[' || ch == '(') {
					stack.push(ch);
				}
				else if (ch == ']' || ch == ')') {
					if(!stack.isEmpty())
						if((ch == ']' && stack.peek() == '[') || (ch==')' && stack.peek() == '(') ) stack.pop();
						else {
							sb.append("no\n");
							break;
						}
					else {
						sb.append("no\n");
						break;
					}
				}
				else if(i==str.length() - 1) {
					if(ch != '.') sb.append("no\n");
					else {
						if(stack.isEmpty()) sb.append("yes\n");
						else sb.append("no\n");
					}
				}
			}
		}
		System.out.println(sb);
	}

}