import java.io.*;
import java.util.*;

public class Main {
	
	static int L, C;
	static char alphabet[];
	static char password[];
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);
		
		// 조합으로 경우의 수 전부 뽑고 조건 확인 후 추가 
		password = new char[L];
		combi(0, 0);
		
		System.out.println(sb);
	}
	
	static void combi(int start, int cnt) {
		if(cnt == L) {
			int moCnt = 0;
			int jaCnt = 0;
			for(char ch : password) {
				if(isMoeum(ch)) moCnt++;
				else jaCnt++;
			}
			
			if(moCnt >= 1 && jaCnt >=2) {
				for(char ch : password) {
					sb.append(ch);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			password[cnt] = alphabet[i];
			combi(i+1, cnt+1);
		}
	}
	
	static boolean isMoeum(char ch) {
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return true;
		return false;
	}
	
}
