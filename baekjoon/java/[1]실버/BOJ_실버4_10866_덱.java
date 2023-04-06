import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_실버4_10866_덱 {
	
	// 메모리 18632KB 시간 208ms

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		List<Integer> deque = new ArrayList<Integer>();

		for(int i=0; i<N; i++) {
			String[] split = in.readLine().split(" ");

			if(split.length == 1) {
				String cmd = split[0];

				if(deque.isEmpty()) {
					if(cmd.equals("empty")) sb.append(1).append('\n');
					else if(cmd.equals("size")) sb.append(0).append('\n');
					else sb.append(-1).append('\n');
				}
				else {
					switch(cmd) {
					case "pop_front":
						int num = deque.get(0);
						deque.remove(0);
						sb.append(num).append('\n');
						break;
					case "pop_back":
						int popBackNum = deque.get(deque.size()-1);
						deque.remove(deque.size()-1);
						sb.append(popBackNum).append('\n');
						break;
					case "size":
						sb.append(deque.size()).append('\n');
						break;
					case "empty":
						if(!deque.isEmpty()) sb.append('0').append('\n');
						else sb.append('1').append('\n');
						break;
					case "front":
						int frontNum = deque.get(0);
						sb.append(frontNum).append('\n');
						break;
					case "back":
						int backNum = deque.get(deque.size()-1);
						sb.append(backNum).append('\n');
						break;
					}
				}
			}else if(split.length == 2) {
				String cmd = split[0];
				int x = Integer.parseInt(split[1]);

				switch(cmd) {
				case "push_front":
					deque.add(0, x);
					break;
				case "push_back":
					deque.add(x);
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}