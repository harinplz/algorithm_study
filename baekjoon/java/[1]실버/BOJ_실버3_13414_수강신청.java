import java.io.*;
import java.util.*;

public class BOJ_실버3_13414_수강신청 {

	/*
	 * 풀이 시간 : 다른 거 하면서 해서 제대로 못 쟀다.
	 * 풀이 방법 : 자료구조
	 * 메모리 : 70736KB, 시간 : 632ms 
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 수강 신청 버튼이 활성화 된 후 
		// 이미 대기열에 들어가 있는 상태에서 다시 수강신청 버튼을 누를 경우 대기목록 맨 뒤로 밀려남. 
		// 대기목록에 가장 앞에 있는 학생부터 자동으로 수강신청 완료. 
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Set<String> set = new LinkedHashSet<String>();
		for(int i=0; i<L; i++) {
			String str = in.readLine();
			if(set.contains(str)) {
				set.remove(str);
				set.add(str);
			}
			else set.add(str);
		}
		
		StringBuilder sb = new StringBuilder();
		Iterator iter = set.iterator();
		int cnt = 0;
		while(iter.hasNext()) {
			if(cnt == K) break;
			cnt++;
			sb.append(iter.next()).append("\n");
		}
		
		System.out.println(sb);	
	}
}
