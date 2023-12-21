import java.io.*;
import java.util.*;

public class BOJ_실버1_1325_효율적인해킹 {

  /*
   * 풀이 참고 : https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1325-%ED%9A%A8%EC%9C%A8%EC%A0%81%EC%9D%B8-%ED%95%B4%ED%82%B9-JAVA
   * 풀이 방법 : DFS 
   * DFS로 푸는 방법은 똑같은데 클래스 선언으로 시간 초과가 난다 .. 예전엔 시간 초과가 안났던 블로그 코드들도 다 시간초과 뜸 ㅠㅠ 
   * 흠 일단 DFS 로직을 복습했다는 것에 만족. 왜 시간 초과가 그렇게 계속 났는지는 분석해봐야겠다 ... 
   */
  
	static class Computer {
		int idx;
		ArrayList<Computer> adj;
		
		public Computer(int idx) {
			this.idx = idx;
			this.adj = new ArrayList<>();
		}
	}
	
	static Computer[] list;
	static boolean isVisited[];
	static int N;
	static int[] computer;
	
	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 관계를 위한 배열 생성 
		list = new Computer[N+1];
		
		// 리스트 초기화 
		for(int i=1; i<=N; i++) {
			list[i] = new Computer(i);
		}
		
		// 관계 입력 A B 형식, "A가 B를 신뢰한다."
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list[B].adj.add(list[A]);
		}
		
		// DFS로 확인 
		computer = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			isVisited = new boolean[N+1];
			isVisited[i] = true;
			DFS(i, i);
		}

    int max = Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, computer[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			if(computer[i] == max) sb.append(i + " ");
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int start, int num) {
		for(Computer comNum : list[num].adj) {
			if(!isVisited[comNum.idx]) {
				isVisited[comNum.idx] = true;
				DFS(start, comNum.idx);
				computer[start]++;
			}
		}
	}
}
