import java.io.*;
import java.util.*;

public class BOJ_실버1_9081_단어맞추기 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(N-->0) {
			String str = in.readLine();
			
			int charNum[] = new int[str.length()];
			
			for(int i=0; i<str.length(); i++) {
				charNum[i] = str.charAt(i);
			}
			
			boolean flag = false; // 바꿀 위치를 찾았는 지 확인하는 변수 
			for(int i=str.length()-2; i>=0; i--) { 
				for(int j=i+1; j<str.length(); j++) {
					if(charNum[i] < charNum[j]) {
						// 남은 수 중에서 제일 작고 현재 i 인덱스의 수보다 큰 수가 i자리에 들어가게 될 것이다. 
						int minIdx = j;
						for(int m=j+1; m<str.length(); m++) {
							if(charNum[i] < charNum[m] && charNum[m] < charNum[minIdx]) minIdx = m;
						}
						
						// 뒤에는 남은 애들끼리 정렬 시켜주기 
						// 일단 0부터 i-1자리까지 문자열 합쳐주기 
						String ans = str.substring(0, i);
						ans += (char)charNum[minIdx];

						List<Character> list = new ArrayList<>();
						// 남은 애들 넣기 
						for(int k=i+1; k<str.length(); k++) {
							if(k==minIdx) list.add((char)charNum[i]); // minIdx의 경우 i자리에 들어갔으니까 minIdx 대신 i를 넣어준다. 
							else list.add((char)charNum[k]);
						}
						Collections.sort(list);
						
						for(char ch : list) {
							ans += ch;
						}
						sb.append(ans);
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			
			if(!flag) sb.append(str); // 못 찾았으면 제일 마지막 단어라는 소리니까 그 단어 그냥 넣기 
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
