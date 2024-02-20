import java.io.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char lower[] = new char[26];
		char upper[] = new char[26];
		
		// 알파벳 초기화  
		for(int i=0; i<26; i++) {
			lower[i] = (char)(97+i);
			upper[i] =  (char)(65+i);
		}
		
		String str = in.readLine();
		String ans = "";
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			// 소문자인지 확인 
			if('a' <= ch && ch <= 'z') {
				ch = lower[((ch-'a')+13)%26];
			}
			// 대문자인지 확인 
			else if('A' <= ch && ch <= 'Z') {
				ch = upper[((ch-'A')+13)%26];
			}
			
			ans += ch;
		}
		
		System.out.println(ans);

    }
}
