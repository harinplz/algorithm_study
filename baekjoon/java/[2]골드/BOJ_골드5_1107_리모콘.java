import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_골드5_1107_리모콘 {
	
	// 메모리 292440KB 간 528ms
	// 브루트포스로 1씩 감소 혹은 1씩 증가 시키며 최소 채널 클릭 수를 찾았다.
	// 근데 중간에 여럿 조건이 많아서 ... 고생했다 
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(in.readLine());
		int wrongCnt = Integer.parseInt(in.readLine());
		
		int ans = Math.abs(target - 100);
		
		if(wrongCnt > 0 && wrongCnt < 10) {
			String[] wrongNum = new String[wrongCnt];
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int i=0; i<wrongCnt; i++) {
				wrongNum[i] = st.nextToken();
			}
			
			Arrays.sort(wrongNum);
			
			boolean noMaxCnt = false;
			if(wrongCnt == 9 && !wrongNum[0].equals("0")) noMaxCnt = true;
			
			// 수 감소 시키면서 찾기
			int minTarget = target;
			while(minTarget!=0) {
				boolean flag = true;
				for(int i=0; i<wrongCnt; i++) {
					if(String.valueOf(minTarget).contains(wrongNum[i])) {
						flag = false;
					}
					if(!flag) break;
				}
				if(flag) break;
				minTarget--;
			}
			if(!(minTarget == 0 && wrongNum[0].equals("0"))) {
				int minTargetCnt = (target - minTarget) + String.valueOf(minTarget).length();
				ans = Math.min(minTargetCnt, ans);
			}

			// 수 증가 시키면서 찾기
			if(!noMaxCnt) {
				int maxTarget = target;
				while(true) {
					boolean flag = true;
					for(int i=0; i<wrongCnt; i++) {
						if(String.valueOf(maxTarget).contains(wrongNum[i])) flag = false;
						if(!flag) break;
					}
					if(flag) break;
					maxTarget++;
				}
				int maxTargetCnt = (maxTarget - target) + String.valueOf(maxTarget).length();
				
				ans = Math.min(ans, maxTargetCnt);
			}
		}
		else if (wrongCnt == 0){
			int lenCnt = String.valueOf(target).length();
			ans = Math.min(lenCnt, ans);
		}
		
		System.out.println(ans);
		
	}

}
