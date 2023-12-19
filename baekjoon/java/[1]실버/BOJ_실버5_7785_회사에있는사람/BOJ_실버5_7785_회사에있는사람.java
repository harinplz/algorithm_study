import java.io.*;
import java.util.*;

public class BOJ_실버5_7785_회사에있는사람 {

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		// 자료구조 Set 사용 
		
		Set<String> set = new TreeSet<>(Collections.reverseOrder());
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String cmd = st.nextToken();
			if(cmd.equals("enter")) {
				set.add(name);
			}
			else if(cmd.equals("leave")) {
				set.remove(name);
			}
		}
		
		// 사전 순의 역순으로 한 줄에 한 명씩 출력한다. 
		StringBuilder sb = new StringBuilder();
		
		for(String name: set) {
			sb.append(name).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	
}
