import java.io.*;
import java.util.*;

public class BOJ_실버4_1235_학생번호 {
	
	/*
	 * 풀이 시간 : 오후 2시 43분 ~ 2시 55분 
   * 풀이 방법 : 문자열 
   * 메모리 : 14368KB, 시간 : 96ms 
	 */
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		String arr[] = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = in.readLine();
		}
		
		int len = arr[0].length(); // 번호의 길이 
		
		int K = 0; // 모든 학생들의 학생 번호를 서로 다르게 만들 수 있는 최소 K 
		for(int i=1; i<=len; i++) {
			boolean flag = true; // 중복 여부를 검사할 boolean 변수 
			Set<String> set = new HashSet<>(); // 중복 여부를 검사할 SET
			for(int j=0; j<N; j++) { // N부터 확인 
				String str = arr[j].substring(len - i); // 문자열 뒤에서부터 자르기 
				if(set.contains(str)) { // 만약 set에 중복된 요소가 있으면? K길이 늘리기 
					flag = false;
					break;
				}
				else set.add(str);
			}
			if(flag) {
				K = i;
				break;
			}
		}
		
		System.out.println(K);
	}
		
}
