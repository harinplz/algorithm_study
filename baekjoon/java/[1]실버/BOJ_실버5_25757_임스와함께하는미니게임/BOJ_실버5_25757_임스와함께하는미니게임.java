import java.io.*;
import java.util.*;

public class BOJ_실버5_25757_임스와함께하는미니게임 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		char ch = st.nextToken().charAt(0);
		
		int num = 0;
		if(ch == 'Y') num = 1;
		else if(ch == 'F') num = 2;
		else if(ch == 'O') num = 3;
		
		// Set에 이름 입력받기
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(in.readLine());
		}
		
		// 사이즈 / 개수 
		System.out.println(set.size() / num);
		
	}

	 
}
