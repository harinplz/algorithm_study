import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_실버4_10845_큐 {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		List<Integer> q = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			String[] split = in.readLine().split(" ");
			
			String cmd = split[0];
		
			
			if(q.isEmpty()) { //큐가 비어있다면 .. 
				if(cmd.equals("empty")) sb.append('1').append('\n');
				else if(cmd.equals("size")) sb.append(0).append('\n');
				else if(cmd.equals("push")) {
					int x = Integer.parseInt(split[1]);
					q.add(x);
				}
				else sb.append(-1).append('\n');
			}
			else {
				switch(cmd) {
				case "push":
					int x = Integer.parseInt(split[1]);
					q.add(x);
					break;
				case "pop":
					int num = q.get(0);
					q.remove(0);
					sb.append(num).append('\n');
					break;
				case "size":
					sb.append(q.size()).append('\n');
					break;
				case "empty":
					sb.append(0).append('\n');
					break;
				case "front":
					int frontNum = q.get(0);
					sb.append(frontNum).append('\n');
					break;
				case "back":
					int backNum = q.get(q.size()-1);
					sb.append(backNum).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}

}