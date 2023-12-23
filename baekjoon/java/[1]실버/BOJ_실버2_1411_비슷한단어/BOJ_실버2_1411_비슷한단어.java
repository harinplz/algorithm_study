import java.io.*;
import java.util.*;

public class BOJ_실버2_1411_비슷한단어 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		String strArr[] = new String[N];
		for(int i = 0; i < N; i++) {
			strArr[i] = in.readLine();
		}
	
		int ans = 0; // 정답이 될 비슷한 단어 쌍의 수 
		int alpha[]; // 알파벳의 값을 저장할 배열 
		
		// strArr에 있는 문자열을 서로 비교하여 값을 비슷한 단어인지 확인한다. 
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				boolean flag = true; // 비슷한 단어인지 확인하는 변수 
				alpha = new int[27]; // 알파벳 값 저장 배열 초기화 
				for(int k = 0; k < strArr[i].length(); k++) { // strArr[i]의 길이만큼 한 단어씩 확인 
					if(alpha[strArr[i].charAt(k) - 97] == 0) { // 만약 알파벳 배열의 값이 0이면 
						alpha[strArr[i].charAt(k) - 97] = strArr[j].charAt(k); //strArr[j]의 값을 넣어준다.
					}
					else {
						// 만약 0이 아니라면 값이 저장되었다는 뜻이고, 저장된 값과 현재 확인한 strArr[j]와 값이 다다면 .. ?
						// 이는 비슷한 단어가 아니므로 flag = true를 해준다. 
						if(!(alpha[strArr[i].charAt(k) - 97] == strArr[j].charAt(k))) {
							flag = false;
							break;
						}
					}
				}
				
				//중복값 방지
				for(int m=0; m<26; m++) {
					for(int n=m+1; n<27; n++) {
						if(alpha[m] != 0 && alpha[n] != 0) {
							if(alpha[m] == alpha[n]) {
								flag = false;
								break;
							}
						}
					}
				}
				
				if(flag) { // flag가 true면 비슷한 단어이므로 ans 추가 
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
