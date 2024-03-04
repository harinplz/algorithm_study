import java.io.*;
import java.util.*;

public class BOJ_실버4_1269_대칭차집합 {
	
	public static void main(String[] args) throws Exception {

		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<aSize; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<bSize; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int ans = 0;
		
		// A 체크 
		Iterator iter = A.iterator();
		
		while(iter.hasNext()) {
			if(!B.contains(iter.next())) ans++;
		}
		
		// B 체크
		iter = B.iterator();
	
		while(iter.hasNext()) {
			if(!A.contains(iter.next())) ans++;
		}
		
		System.out.println(ans);
	}
	
}
