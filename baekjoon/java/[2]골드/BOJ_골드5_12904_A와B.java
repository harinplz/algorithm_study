import java.io.*;

public class BOJ_골드5_12904_A와B {
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String S = in.readLine();
		String T = in.readLine();
		
		while(T.length() != S.length()) {
			char lastCh = T.charAt(T.length() - 1);
			T = T.substring(0, T.length()-1);
			if(lastCh == 'B') {
				String reverse = "";
				for(int i=T.length() - 1; i>=0; i--) {
					reverse += T.charAt(i);
				}
				T = reverse;
			}
		}
		
		if(T.equals(S)) System.out.println(1);
		else System.out.println(0);
	}
}
