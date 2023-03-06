package ssafy.com.SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_1238_Contact {
	
	/**
	 * 메모리 : 18764kb 실행시간 : 122ms
	 * 문제 접근 방식은 맞았으나 ㅎ 뒤에 처리를 이상하게 해서 시간을 많이 잡아먹었다.
	 * 확실히 구현 생각하고 코드를 작성하자 !!!
	 * 그리고 BFS 구조 확실히 기억하기 ~~ 
	 */

	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static ArrayList<Integer>[] adjList;
	static int start; //시작점

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		//테케는 10개

		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(in.readLine());
			//데이터 길이, 시작점
			int dataLen = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			//인접 리스트 생성 (1부터 시작)
			adjList = new ArrayList[101];
			for(int i=1;i<=100;i++) {
				adjList[i] = new ArrayList<Integer>();
			}

			//데이터 길이/2 만큼 반복하며 비상 연락망 입력 받음.
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<dataLen/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjList[from].add(to);
			}

			//System.out.println(Arrays.toString(adjList));

			int last = bfs();
			sb.append(last).append('\n');
		}

		System.out.println(sb);
	}

	private static int bfs() {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		boolean[] isVisited = new boolean[101];
		isVisited[start] = true;

		int current = 0;
		int lastNum = -1;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			int max = -1;
			
			for(int i=0;i<queueSize;i++) {
				current = queue.poll();
				
				for(int num : adjList[current]) {
					if(!isVisited[num]) {
						queue.offer(num);
						isVisited[num] = true;
						max = Math.max(max, num);
					}
				}	
			}
			
			if(max>0) lastNum = max;
		}
		
		return lastNum;
	}

}

