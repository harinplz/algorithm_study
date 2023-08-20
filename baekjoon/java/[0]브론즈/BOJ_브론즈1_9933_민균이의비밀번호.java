import java.io.*;
import java.util.*;

public class BOJ_브론즈1_9933_민균이의비밀번호 {

  /*
    1. 문자열을 입력받는다.
    2. 문자열 하나를 고른 후 문자열 리스트에 있는 모든 문자열을 역순으로 돌려 고른 문자열과 같은지 확인한다.
    3. 같은 문자열이 있으면 민균이의 비밀번호이다.
  */
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String[] strList = new String[N];
		
		for(int i=0; i<N; i++) {
			strList[i] = in.readLine();
		}
		
		String ans = "";
		
		for(int i=0; i<N; i++) {
			String str = strList[i];
			for(int j=0; j<N; j++) {
				String testStr = "";
				for(int k=0; k<strList[j].length(); k++) {
					testStr += strList[j].charAt(strList[j].length() - k - 1);
				}
				if(testStr.equals(str)) {
					ans = str;
					break;
				}
			}
		}
		
		System.out.print(ans.length() + " " + ans.charAt(ans.length()/2));
		
	}

}
