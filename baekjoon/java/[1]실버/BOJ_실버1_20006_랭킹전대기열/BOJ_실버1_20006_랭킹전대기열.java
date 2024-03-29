import java.io.*;
import java.util.*;

public class BOJ_실버1_20006_랭킹전대기열 {
	
	static class Player implements Comparable<Player> {
		int level;
		String name;
		
		public Player(int level, String name) {
			this.level = level;
			this.name = name;
		}

		@Override
		public int compareTo(Player o) {
			return this.name.compareTo(o.name);
		}
	}

	public static void main(String[] args) throws Exception {
		// 입력 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		List<ArrayList<Player>> list = new ArrayList<>();
	
		while(p-- > 0) {
			// 처음 플레이어 정보 받아 플레이어 생성 
			st = new StringTokenizer(in.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Player player = new Player(level, name);
			
			// list 안에 들어갈 만한 곳이 있는지 확인 
			// 있다면? 그 안에 넣기 
			// 없다면 생성 
			boolean flag = false;
			for(int i=0; i < list.size(); i++) {
				if(list.get(i).size() == m) continue;
				int standardLevel = list.get(i).get(0).level;
				if(standardLevel - 10 <= level && level <= standardLevel + 10) {
					flag = true;
					list.get(i).add(player);
					break;
				}
			}
			
			if(!flag) {
				list.add(new ArrayList<Player>());
				list.get(list.size() - 1).add(new Player(level, name));
			}
			
		}
		
		for(ArrayList<Player> li : list) {
			String str = li.size() == m ? "Started!" : "Waiting!";
			sb.append(str + "\n");
			Collections.sort(li);
			for(Player player : li) {
				sb.append(player.level + " " + player.name + "\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
}
