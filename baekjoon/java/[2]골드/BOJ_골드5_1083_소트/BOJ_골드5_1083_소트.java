import java.io.*;
import java.util.*;

public class BOJ_골드5_1083_소트 {
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		List<Integer> a = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		for(int i=0; i<N; i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		
		int S = Integer.parseInt(in.readLine()); // 교환 최대 가능 횟수 
		
		int moveCnt = 0, changeIdx = 0;
		while(moveCnt <= S && changeIdx < N-1) {
			int max = a.get(changeIdx);
			int maxIdx = changeIdx;
			
			for(int idx = changeIdx + 1, count = 1; idx < N && moveCnt + count <=S; idx++, count++) {
				if(a.get(idx) > max) {
					max = a.get(idx);
					maxIdx = idx;
				}
			}
			
			if(maxIdx != changeIdx) {
				a.remove(maxIdx);
				a.add(changeIdx, max);
				moveCnt += maxIdx - changeIdx;
			}
			
			changeIdx++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num : a) {
			sb.append(num + " ");
		}
		
		System.out.println(sb);

	}

}
