import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버3_1966_프린터큐 {
	
	static class Doc{
		int idx;
		int imp;
		
		public Doc(int idx, int imp) {
			super();
			this.idx = idx;
			this.imp = imp;
		}

		@Override
		public String toString() {
			return "Doc [idx=" + idx + ", imp=" + imp + "]";
		}		
		
	}
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			st = new StringTokenizer(in.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			Queue<Doc> queue = new ArrayDeque<Doc>();
			for(int i=0; i<N; i++) {
				int imp = Integer.parseInt(st.nextToken());
				queue.offer(new Doc(i, imp));
			}

			//System.out.println(queue);
			
			int cnt = 1;
			boolean chk = false;
			while(!queue.isEmpty()) {
				
				int size = queue.size();
				
				int maxImp = Integer.MIN_VALUE;
				//System.out.println(queue);
				for(int j=0; j<size; j++) {
					Doc max = queue.poll();
					maxImp = Math.max(maxImp, max.imp);
					queue.offer(max);
				}
				
				for(int i=0; i<size; i++) {
					Doc curDoc = queue.poll();
					if(maxImp != curDoc.imp) {
						queue.offer(curDoc);
					}
					else {
						if(curDoc.idx == target) chk = true;
						break;
					}
				}
				if(chk) break;
				cnt++;

			}
			
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}

}