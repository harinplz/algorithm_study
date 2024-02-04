import java.io.*;
import java.util.*;

public class BOJ_실버3_2852_NBA농구 {
	
	static class time {
		int min;
		int sec;
		
		public time(int min, int sec) {
			this.min = min;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int score1 = 0, score2 = 0;
		int min1 = 0, min2 = 0, sec1 = 0, sec2  = 0;
		
		time[] times = new time[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int winTeam = Integer.parseInt(st.nextToken());
			String[] winTime = st.nextToken().split(":");
			int winMin = Integer.parseInt(winTime[0]);
			int winSec = Integer.parseInt(winTime[1]);
			
			times[i] = new time(winMin, winSec);
			if(i != 0 && score1 != score2){// 비긴 상태였을 때는 계산 안함
				// 이기고 있었던 시간 계산 
				if(times[i].sec < times[i-1].sec) {
					winSec += 60;
					winMin -= 1;
				}
				// 처리 후 이긴 시간 계산 
				int min = winMin - times[i-1].min;
				int sec = winSec - times[i-1].sec;
				// 1팀이 이기고 있었으면 1팀에 더해주고, 2팀이 이기고 있었을 땐 2팀에 더해준다. 
				if(score1 > score2) {
					min1 += min; sec1 += sec;
					if(sec1 > 59) {
						sec1 %= 60; min1++;
					}
				}
				else {
					min2 += min; sec2 += sec;
					if(sec2 > 59) {
						sec2 %= 60; min2++;
					}
				}
			}
			if(winTeam == 1) score1++;
			else score2++;
		}
		
		// 마지막 48분까지 계산하기 
		if(score1 != score2) {
			int min = 48 - times[N-1].min;
			int sec = 0;
			if(times[N-1].sec > 0) {
				sec += 60; min--;
				sec -= times[N-1].sec;
			}
			if(score1 > score2) {
				min1 += min; sec1 += sec;
				if(sec1 > 59) {
					sec1 %= 60; min1++;
				}
			}
			else {
				min2 += min; sec2 += sec;
				if(sec2 > 59) {
					sec2 %= 60; min2++;
				}
			}
		}
		
		System.out.printf("%02d:%02d\n", min1, sec1);
		System.out.printf("%02d:%02d", min2, sec2);
	}

}
