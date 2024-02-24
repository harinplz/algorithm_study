import java.io.*;
import java.util.*;

public class BOJ_골드5_19598_최소회의실개수 {
	
	static class Time implements Comparable<Time>{
		int start;
		int end;
		
		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o) {
			if(this.start == o.start) return this.end - o.end;
			return this.start - o.start;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<Time> meetings = new ArrayList<>();
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetings.add(new Time(start, end));
		}
		
		// 정렬 
		Collections.sort(meetings);
		
		// 진행 중인 회의
		int cnt = 1;
		ArrayList<Integer> procMeetings = new ArrayList<>();
		
		Time firstMeeting = meetings.get(0);
		procMeetings.add(firstMeeting.end);
		
		for(int i=1; i<meetings.size(); i++) {
			// 진행할 미팅 꺼내기 
			int start = meetings.get(i).start;
			int end = meetings.get(i).end;
			boolean flag = false; // 현재 존재하는 회의실에 들어나는 것이 가능한지 확인하기 
			
			for(int j=0; j<procMeetings.size(); j++) {
				int procMeeting = procMeetings.get(j);
				if( start >= procMeeting) {
					flag = true;
					procMeetings.remove(j);
					procMeetings.add(end);
					break;
				}
			}
			
			if(!flag) { // 들어갈 회의실이 없다면 
				cnt++;
				procMeetings.add(end);
			}
		}
		
		System.out.println(cnt);
	}

}
