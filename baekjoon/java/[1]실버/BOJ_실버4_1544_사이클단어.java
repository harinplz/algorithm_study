import java.io.*;
import java.util.*;

public class BOJ_실버4_1544_사이클단어 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		String[] list = new String[N];
		boolean[] check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			list[i] = in.readLine();
		}
		
		int ans = 0; // 서로 다른 단어의 개수 저장 
		for(int i=0; i<N; i++) {
			if(check[i]) continue;
			ans++;
			// 일단 문자열을 재조합하고
			// 남은 문자열에서 같은 게 있는 지 확인하기 
			
			// 맨 첫번째 문자를 뒤로 보내서 합친다. 
			for(int j=0; j<list[i].length(); j++) {
				list[i] = list[i].substring(1) + list[i].charAt(0);
				for(int k=i+1; k<N; k++) {
					if(list[i].equals(list[k])) {
						check[k] = true;
					}
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
}
