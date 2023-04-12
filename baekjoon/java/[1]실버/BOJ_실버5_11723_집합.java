import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_실버5_11723_집합 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		
		int M = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		while(M-->0) {
			st = new StringTokenizer(in.readLine());
			
			String cmd = st.nextToken();
			int num;
			
			switch(cmd) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				set.add(num);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) set.remove(num);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) sb.append(1).append('\n');
				else sb.append(0).append('\n');
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) set.remove(num);
				else set.add(num);
				break;
			case "all":
				set.clear();
				for(int i=1; i<=20; i++) set.add(i);
				break;
			case "empty":
				set.clear();
				break;
			}
		}
		System.out.println(sb);
	}

}
