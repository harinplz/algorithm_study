import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// 친구들 총 M명, 입국심사대 N개 
		// k번 심사대에 앉아있는 심사관이 한 명 심사를 하는데 걸리는 시간은 Tk
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 입국 심사대 개수 
		long M = Integer.parseInt(st.nextToken()); // 친구 

		long T[] = new long[N];
		
		for(int i=0; i<N; i++) {
			T[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(T); // 오름차순 정렬 
		
		long ans = 0;
				
		long min = 0;
		long max = T[N-1] * M;
		
		while(min <= max) {
			long mid = (min + max) / 2;
			long cnt = 0;
			
			for(int i=0; i<N; i++) {
				long c = mid / T[i];
				
				if(cnt >= M) break;
				cnt += c;
			}
			
			if(cnt < M) {
				min = mid + 1;
			}
			else {
				ans = mid;
				max = mid - 1;
			}
		
		}
		
		System.out.println(ans);
		// 상근이와 친구들이 심사를 마치는 데 걸리는 최소 시간 
	}
	
}
